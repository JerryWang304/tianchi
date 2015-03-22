package domain.neo4j;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * Created by yangtao.lyt on 2015/03/22 11:56
 */
@NodeEntity
public class User {
    @GraphId
    private Long id;
    /**
     * 用户id
     */
    @Indexed(indexType = IndexType.LABEL, indexName = "userid_index")
    private Long userId;

    public User(){}

    public User(Long userId){
        this.userId = userId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
