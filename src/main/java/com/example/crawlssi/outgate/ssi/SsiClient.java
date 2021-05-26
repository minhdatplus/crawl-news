package com.example.crawlssi.outgate.ssi;

import com.example.crawlssi.outgate.ssi.request.*;
import com.example.crawlssi.outgate.ssi.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ssiClient", url = "${url.fundamental.host}")
public interface SsiClient {

    @GetMapping("${url.endpoint.defaultallstock}")
    ListLikeResp<SingleStockModel> getAllStock();

    @PostMapping("${url.endpoint.news}")
    NewsResp getAllNews(
            @RequestBody NewsReqModel newsReqModel
    );

}
