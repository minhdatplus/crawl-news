package com.bkhn.crawl.outgate.ssi.response;

import lombok.Data;

import java.util.List;

@Data
public class ListLikeResp<T> {
    private List<T> data;
}
