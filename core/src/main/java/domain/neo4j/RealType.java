package domain.neo4j;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by yangtao.lyt on 2015/3/22.
 */
public enum RealType implements RelationshipType{
    /**
     * ���
     */
    CLICK(1),
    /**
     * �ղ�
     */
    COLLECT(2),
    /**
     * ��ӹ��ﳵ
     */
    SHOPPING_CART(3),
    /**
     * ����
     */
    BUY(4),
    /**
     * ���ڣ���Ʒ������Ŀ��
     */
    BELONG_TO(100)

    ;


    /**
     * ����code
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
