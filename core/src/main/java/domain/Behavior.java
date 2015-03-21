package domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Created by yangtao.lyt on 2015/03/21 16:04
 */
public class Behavior {
    /** 点击 */
    public final static Integer CLICK = 1;
    /** 收藏 */
    public final static Integer COLLECT = 2;
    /** 购物车 */
    public final static Integer SHOPPING_CART =3;
    /** 购买 */
    public final static Integer BUY = 4;

    /**
     * 用于唯一标示对象
     */
    private static Long GLOBAL_ID = 1L;

    /**
     * 内部唯一id，用于唯一标示behavior对象
     */
    private Long bid;
    /**
     * 行为类型
     */
    private Integer type;
    /**
     * 时间
     */
    private Date time;
    /**
     * 用户
     */
    private User user;
    /**
     * 商品
     */
    private Item item;
    /**
     * 经纬度
     */
    private String userGeoHash;
    /**
     * 商品所属类目（这个类目应该是指操作商品时，商品所在类目，还不知道与另一个表的类目是否一致）
     */
    private Long categoryId;


    public Behavior(){
        this.bid = GLOBAL_ID++;
    }

    public Long getBid() {
        return bid;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setUserGeoHash(String userGeoHash) {
        this.userGeoHash = userGeoHash;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getType() {

        return type;
    }

    public Date getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public String getUserGeoHash() {
        return userGeoHash;
    }

    public Long getCategoryId() {
        return categoryId;
    }


    public static Integer getTypeByCode(String code){
        if(code.trim().equals("1")){
            return Behavior.CLICK;
        }else if(code.trim().equals("2")){
            return Behavior.COLLECT;
        }else if(code.trim().equals("3")){
            return Behavior.SHOPPING_CART;
        }else if(code.trim().equals("4")){
            return Behavior.BUY;
        }else{
            throw new IllegalArgumentException("[Behavior-getTypeByCode] error : code=" + code);
        }
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
