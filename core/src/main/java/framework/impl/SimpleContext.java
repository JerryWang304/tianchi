package framework.impl;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import domain.Behavior;
import domain.Item;
import domain.User;
import framework.Context;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Map;
import java.util.Set;

/**
 * Created by yangtao.lyt on 2015/03/21 15:53
 */
public class SimpleContext implements Context{
    /**
     * 上下文名称
     */
    private String name;
    /**
     * 商品集合
     */
    private Map<Long, Item> itemMap = Maps.newHashMap();
    /**
     * 用户集合
     */
    private Map<Long, User> userMap = Maps.newHashMap();
    /**
     * 所有购买行为集合
     */
    private Set<Behavior> allBuyBehavior = Sets.newHashSet();
    /**
     * 所有浏览行为集合
     */
    private Set<Behavior> allClickBehavior = Sets.newHashSet();
    /**
     * 所有收藏行为
     */
    private Set<Behavior> allCollectBehavior = Sets.newHashSet();
    /**
     * 所有添加购物车行为
     */
    private Set<Behavior> allShoppingCartBehavior = Sets.newHashSet();
    /**
     * 错误解析数据行数
     */
    private Integer errorParseLineCount = 0;
    /**
     * 正确解析数据行数
     */
    private Integer correctedParseLineCount = 0;


    @Override
    public User getOrCreateGetUser(Long userId) {
        if(userMap.containsKey(userId)){
            return userMap.get(userId);
        }else{
            User user = new User();
            user.setUserId(userId);
            userMap.put(userId, user);
            return user;
        }
    }

    @Override
    public Item getOrCreateGetItem(Long itemId) {
        if(itemMap.containsKey(itemId)){
            return itemMap.get(itemId);
        }else{
            Item item = new Item();
            item.setItemId(itemId);
            itemMap.put(itemId,item);
            return item;
        }
    }

    @Override
    public void increErrorParseLineCount() {
        errorParseLineCount++;
    }

    @Override
    public void increCorrectedParseLineCount() {
        correctedParseLineCount++;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
