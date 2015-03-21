package etl.extractor;

import framework.Context;

/**
 * Created by yangtao.lyt on 2015/03/21 14:18
 *
 * 用于从数据源生成上下文
 *
 */
public interface Extractor {

    Context extract(String filePath) throws Exception;


}
