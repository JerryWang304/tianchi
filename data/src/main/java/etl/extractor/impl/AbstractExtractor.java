package etl.extractor.impl;

import etl.extractor.Extractor;
import framework.Context;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by yangtao.lyt on 2015/03/21 17:36
 */
public abstract class AbstractExtractor implements Extractor{
    /**
     * 文件路径
     */
    protected String filepath;

    @Override
    public void buildContext(Context context) throws Exception {
        System.out.println("[SimpleExtractor-buildContext] warn : build Context START");
        if(filepath == null){
            throw new NullPointerException("[SimpleExtractor-buildContext] error : filePathList is Null!");
        }

        BufferedReader in = new BufferedReader(new FileReader(filepath));
        String line = null;
        while((line = in.readLine()) != null){
            parseLineData(context, line);
        }

        in.close();

        System.out.println("[SimpleExtractor-buildContext] warn : build Context END");
    }



    protected abstract void parseLineData(Context context, String lineData);


}
