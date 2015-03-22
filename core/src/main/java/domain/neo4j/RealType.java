package domain.neo4j;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by yangtao.lyt on 2015/3/22.
 */
public enum RealType implements RelationshipType{
    /**
     * 浏览
     */
    CLICK(1),
    /**
     * 收藏
     */
    COLLECT(2),
    /**
     * 添加购物车
     */
    SHOPPING_CART(3),
    /**
     * 购买
     */
    BUY(4),
    /**
     * 属于（商品所属类目）
     */
    BELONG_TO(100)

    ;


    /**
     * 类型code
     */
    private Integer code;

    private RealType(Integer code){
        this.code = code;
    }


    public static RealType getTypeByCode(Integer code){
        if(code == null){
            throw new NullPointerException("[BehaviorType-getTypeByCode] error: code is NULL");
        }
        for(RealType realType : values()){
            if(realType.getCode().equals(code)){
                return realType;
            }
        }

        throw new IllegalArgumentException("[BehaviorType-getTypeByCode] error: code is invalid ! code=" + code);

    }

    public Integer getCode() {
        return code;
    }

}
