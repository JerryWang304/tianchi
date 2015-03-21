package etl.loader.impl;

import etl.extractor.Extractor;
import etl.loader.Loader;
import etl.transfer.Transferor;
import etl.transfer.impl.TransferorList;
import framework.Context;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

/**
 * Created by yangtao.lyt on 2015/03/21 14:34
 */
public abstract class AbstractLoader implements Loader{

    /**
     * 文件路径
     */
    protected List<String> filePathList;
    /**
     * 数据提取器
     */
    protected Extractor extractor;
    /**
     * 数据转换器链  （数据预处理）
     */
    protected TransferorList transferorList;


    public Context load() throws Exception{

        if(filePathList == null || filePathList.size() == 0){
            throw new NullPointerException("Loader need a filepath parameter!");
        }
        if(extractor == null){
            throw new NullPointerException("Loader need a Extrator!");
        }

        //数据抽取
        Context context = extractor.extract(filePathList);
        //数据转换
        if(transferorList != null){
            context = transferorList.tranfer(context);
        }

        return context;
    }




    public void setExtractor(Extractor extractor) {
        this.extractor = extractor;
    }

    public void setTransferorList(TransferorList transferorList) {
        this.transferorList = transferorList;
    }

    public List<String> getFilePathList() {
        return filePathList;
    }

    public void setFilePathList(List<String> filePathList) {

        this.filePathList = filePathList;
    }

    public Extractor getExtractor() {
        return extractor;
    }

    public TransferorList getTransferorList() {
        return transferorList;
    }
}