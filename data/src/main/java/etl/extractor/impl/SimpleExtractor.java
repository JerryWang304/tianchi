package etl.extractor.impl;

import com.google.common.base.Splitter;
import domain.Behavior;
import domain.Item;
import domain.User;
import etl.extractor.Extractor;
import framework.Context;
import framework.impl.SimpleContext;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaoxiao on 2015/3/21.
 *
 * 用于第二届天池大数据竞赛数据抽取
 *
 * 目前只用于抽取了行为数据
 *
 * sample:
 *  user_id,    item_id,    behavior_type,  user_geohash,   item_category,  time
    99512554,37320317,3,94gn6nd,9232,2014-11-26 20
    9909811,266982489,1,,3475,2014-12-02 23
     98692568,27121464,1,94h63np,5201,2014-11-19 13
    96089426,114407102,1,949g5i3,836,2014-11-26 07
    90795949,402391768,1,94h6dlp,3046,2014-12-09 21
    96363456,379126815,1,,10732,2014-12-07 23
    95993830,78579528,1,,5027,2014-12-10 10
 *
 *  经纬度可能为null
 *
 */
public class SimpleExtractor extends AbstractExtractor{

    /**
     * 字符串分隔符
     */
    private static final String SEPARATOR = ",";
    /**
     * 时间格式
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式器
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    /**
     * 补足的时间尾部
     */
    private static final String DATE_POST_STRING = ":00:00";


    @Override
    protected void parseLineData(Context context, String lineData) {
        List<String> temp = Splitter.on(SEPARATOR).trimResults().splitToList(lineData);

        if(temp.size() != 6){
            System.out.println("[SimpleExtractor-parseLineData]  size!=6   lineData=" + lineData + "  --> skipped");
            context.increErrorParseLineCount();
        }

        //获取用户
        User user = context.getOrCreateGetUser(Long.parseLong(temp.get(0)));
        //获取商品对象
        Item item = context.getOrCreateGetItem(Long.parseLong(temp.get(1)));
        /*
         *  构建行为对象
         */
        Behavior behavior = new Behavior();
        behavior.setUser(user);
        behavior.setItem(item);
        behavior.setUserGeoHash(temp.get(3));
        behavior.setCategoryId(Long.parseLong(temp.get(4)));
        try {
            behavior.setType(Behavior.getTypeByCode(temp.get(2)));
            Date date = sdf.parse(temp.get(5) + DATE_POST_STRING);
            behavior.setTime(date);
        } catch (ParseException e) {
            /*
             * 允许失败，解析异常则抛弃该行数据
             */
            System.out.println("[SimpleExtractor-parseLineData] ParseException: lineData=" + lineData + "  --> skipped");
            context.increErrorParseLineCount();
        }catch (IllegalArgumentException e){
            /*
             * 允许失败，解析异常则抛弃该行数据
             */
            System.out.println("[SimpleExtractor-parseLineData] IllegalArgumentException: lineData=" + lineData + "  --> skipped");
            context.increErrorParseLineCount();
        }

        user.addBehavior(behavior);
        item.addBehavior(behavior);

        context.increCorrectedParseLineCount();
    }
}
