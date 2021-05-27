package com.bkhn.crawl.outgate.ssi;

import com.bkhn.crawl.outgate.ssi.request.NewsReqModel;
import com.bkhn.crawl.outgate.ssi.response.ListLikeResp;
import com.bkhn.crawl.outgate.ssi.response.NewsResp;
import com.bkhn.crawl.outgate.ssi.response.SingleStockModel;
import com.bkhn.crawl.outgate.ssi.request.*;
import com.bkhn.crawl.outgate.ssi.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Client", url = "${url.fundamental.host}")
public interface Client {

    @GetMapping("${url.endpoint.defaultallstock}")
    ListLikeResp<SingleStockModel> getAllStock();

    @PostMapping("${url.endpoint.news}")
    NewsResp getAllNews(
            @RequestBody NewsReqModel newsReqModel
    );

}
