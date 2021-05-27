package com.bkhn.crawl.outgate.ssi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NewsDataListWrapper {

    @JsonProperty(value = "dataList")
    List<NewsModel> dataList;

}
