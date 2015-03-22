package domain.neo4j;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import java.util.Date;

/**
 * Created by yangtao.lyt on 2015/03/22 11:58
 */
@RelationshipEntity
public class Behavior {
    @GraphId
    private Long id;
    /**
     * 行为类型
     */
    private Integer type;
    /**
     * 发生时间
     */
    private Date time;
    /**
     * 发生地点（经纬度-加密）
     */
    private String geoHash;

    @StartNode
    private User user;
    @EndNode
    private Item item;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getGeoHash() {
        return geoHash;
    }

    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash;
    }
}
