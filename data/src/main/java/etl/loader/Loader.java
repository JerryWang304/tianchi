package etl.loader;

import framework.Context;

/**
 * Created by yangtao.lyt on 2015/03/21 14:26
 */
public interface Loader {

    Context load(String filePath) throws Exception;

}
