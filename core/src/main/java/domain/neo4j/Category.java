package domain.neo4j;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * Created by yangtao.lyt on 2015/03/22 11:37
 */
@NodeEntity
public class Category {
    @GraphId
    private long id;
    /**
     * 类目id
     */
    @Indexed(indexType = IndexType.LABEL, indexName = "catagoryid_index")
    private Long categoryId;

    public Category(){}

    public Category(Long categoryId) {
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
