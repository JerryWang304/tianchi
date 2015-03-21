package etl.loader.impl;

import etl.extractor.Extractor;
import etl.extractor.impl.ExtractorList;
import etl.loader.Loader;
import etl.transfer.Transferor;
import etl.transfer.impl.TransferorList;
import framework.Context;
import framework.impl.SimpleContext;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

/**
 * Created by yangtao.lyt on 2015/03/21 14:34
 */
public abstract class AbstractLoader implements Loader{
    /**
     * 数据提取器
     */
    protected ExtractorList extractorList;
    /**
     * 数据转换器链  （数据预处理）
     */
    protected TransferorList transferorList;
    /**
     * 上下文
     */
    protected Context context;


    public Context load() throws Exception{

        if(extractorList == null){
            throw new NullPointerException("Loader need a extractorList!");
        }

        /*
         * 数据抽取
         */
        System.out.println("[AbstractLoader-load] data extract start!");
        extractorList.buildContext(context);
        System.out.println("[AbstractLoader-load] data extract end!");
        /*
         * 数据转换
         */
        System.out.println("[AbstractLoader-load] data transfer start!");
        if(transferorList != null){
            context = transferorList.tranfer(context);
        }
        System.out.println("[AbstractLoader-load] data transfer end!");

        return context;
    }


    public void setExtractorList(ExtractorList extractorList) {
        this.extractorList = extractorList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ExtractorList getExtractorList() {

        return extractorList;
    }

    public Context getContext() {
        return context;
    }

    public void setTransferorList(TransferorList transferorList) {
        this.transferorList = transferorList;
    }

    public TransferorList getTransferorList() {
        return transferorList;
    }
}
