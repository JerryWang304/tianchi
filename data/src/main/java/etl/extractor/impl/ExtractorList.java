package etl.extractor.impl;

import etl.extractor.Extractor;
import framework.Context;

import java.util.List;

/**
 * Created by yangtao.lyt on 2015/03/21 18:40
 */
public class ExtractorList implements Extractor{
    /**
     * 内含实际的数据抽取器（链）
     */
    private List<Extractor> extractors;

    @Override
    public void buildContext(Context context) throws Exception {
        for(Extractor extractor : extractors){
            extractor.buildContext(context);
        }
    }

    public void setExtractors(List<Extractor> extractors) {
        this.extractors = extractors;
    }

    public List<Extractor> getExtractors() {

        return extractors;
    }
}
