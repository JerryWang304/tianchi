package domain;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

/**
 * Created by yangtao.lyt on 2015/03/21 13:42
 */
public class Item {
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 商品经纬度（hash值）
     */
    private String itemGeohash;
    /**
     * 类目id
     */
    private Long categoryId;
    /**
     * 商品所有被操作行为
     */
    private List<Behavior> allBehavior = Lists.newArrayList();


    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemGeohash(String itemGeohash) {
        this.itemGeohash = itemGeohash;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getItemId() {

        return itemId;
    }

    public String getItemGeohash() {
        return itemGeohash;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setAllBehavior(List<Behavior> allBehavior) {
        this.allBehavior = allBehavior;
    }

    public List<Behavior> getAllBehavior() {
        return allBehavior;
    }

    public boolean addBehavior(Behavior behavior){
        return allBehavior.add(behavior);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
