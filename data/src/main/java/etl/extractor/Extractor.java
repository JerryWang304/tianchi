package etl.extractor;

import framework.Context;

import java.util.List;

/**
 * Created by yangtao.lyt on 2015/03/21 14:18
 *
 * 用于从数据源生成上下文
 *
 */
public interface Extractor {

    public void buildContext(Context context) throws Exception;


}
