package etl.transfer.impl;

import etl.transfer.Transferor;
import framework.Context;

import java.util.List;

/**
 * Created by yangtao.lyt on 2015/03/21 14:50
 */
public class TransferorList implements Transferor{
    /**
     * 实际的数据转换器
     */
    private List<Transferor> transferorList;



    @Override
    public Context tranfer(Context oldContext) throws Exception {
        Context passedContext = oldContext;
        for(Transferor transferor : transferorList){
            passedContext = transferor.tranfer(passedContext);
        }
        return passedContext;
    }
}
