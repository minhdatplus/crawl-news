package com.bkhn.crawl.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface CrawlSsiService {

    CompletableFuture<Void> crawlNews();

}
