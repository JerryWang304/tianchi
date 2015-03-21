package domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Created by yangtao.lyt on 2015/03/21 13:41
 */
public class User {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 行为类型
     */
    private Integer behaviorType;
    /**
     * 用户经纬度
     */
    private String userGeoHash;
    /**
     * 商品所属类目
     */
    private String itemCategoryId;
    /**
     * 行为时间
     */
    private Date time;


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setBehaviorType(Integer behaviorType) {
        this.behaviorType = behaviorType;
    }

    public void setUserGeoHash(String userGeoHash) {
        this.userGeoHash = userGeoHash;
    }

    public void setItemCategoryId(String itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getUserId() {

        return userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Integer getBehaviorType() {
        return behaviorType;
    }

    public String getUserGeoHash() {
        return userGeoHash;
    }

    public String getItemCategoryId() {
        return itemCategoryId;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.reflectionToString(this);
    }

}
