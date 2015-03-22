package domain.neo4j;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.support.index.IndexType;

import java.util.Set;

/**
 * Created by yangtao.lyt on 2015/03/22 11:27
 */
@NodeEntity
public class Item {
    @GraphId
    private Long id;
    /**
     * 商品itemid
     */
    @Indexed(indexType = IndexType.LABEL, indexName = "itemid_index")
    private Long itemId;
    /**
     * 商品所属类目set
     */
    @RelatedTo(type = "BELONG_TO", direction = Direction.OUTGOING)
    private @Fetch Set<Category> categorySet;
    /**
     *
     */
    @RelatedToVia
    private Set<User> userSet;


}
