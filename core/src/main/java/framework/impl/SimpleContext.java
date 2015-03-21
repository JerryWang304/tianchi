package framework.impl;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import domain.Behavior;
import domain.Item;
import domain.User;
import framework.Context;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangtao.lyt on 2015/03/21 15:53
 */
public class SimpleContext implements Context{
    /**
     * 上下文名称
     */
    protected String name;
    /**
     * 上下文描述
     */
    protected String desc;
    /**
     * 商品集合
     */
    protected Map<Long, Item> itemMap = Maps.newHashMap();
    /**
     * 用户集合
     */
    protected Map<Long, User> userMap = Maps.newHashMap();
    /**
     * 所有行为集合
     */
    protected Set<Behavior> allBehavior = Sets.newHashSet();












}
