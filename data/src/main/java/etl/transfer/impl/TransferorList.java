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
    private List<Transferor> transferors;



    @Override
    public Context tranfer(Context oldContext) throws Exception {

        if(transferors == null){
            System.out.println("[TransferorList-tranfer] warn : transferorList is NULL! so Skipped!");
            return oldContext;
        }

        Context passedContext = oldContext;
        for(Transferor transferor : transferors){
            passedContext = transferor.tranfer(passedContext);
        }
        return passedContext;
    }

    public List<Transferor> getTransferors() {
        return transferors;
    }

    public void setTransferors(List<Transferor> transferors) {
        this.transferors = transferors;
    }
}
