package etl.transfer;

import framework.Context;

/**
 * Created by yangtao.lyt on 2015/03/21 14:37
 */
public interface Transferor {

    public Context tranfer(Context oldContext) throws Exception;

}
