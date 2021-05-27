package com.bkhn.crawl.controller;


import com.bkhn.crawl.service.CrawlSsiService;
import com.bkhn.crawl.factory.resfact.GeneralResponse;
import com.bkhn.crawl.factory.resfact.ResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@Slf4j
@RestController
@RequestMapping(path = "/external/crawler/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class CrawlController {

    private final CrawlSsiService crawlSsiService;

    @Autowired
    public CrawlController(
            CrawlSsiService crawlSsiService
    ) {
        this.crawlSsiService = crawlSsiService;
    }

    @GetMapping("/crawl-news")
    public ResponseEntity<GeneralResponse<Object>> crawlNewsControl() {
        crawlSsiService.crawlNews();
        return ResponseFactory.success();
    }

}
