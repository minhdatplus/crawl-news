package com.example.crawlssi.service.impl;

import com.example.crawlssi.outgate.ssi.SsiClient;
import com.example.crawlssi.outgate.ssi.request.NewsReqModel;
import com.example.crawlssi.outgate.ssi.response.*;
import com.example.crawlssi.repository.*;
import com.example.crawlssi.repository.entity.*;
import com.example.crawlssi.service.CrawlSsiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class CrawlSsiServiceImpl implements CrawlSsiService {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private final SsiClient ssiClient;
    private final NewsRepository newsRepository;


    @Autowired
    public CrawlSsiServiceImpl(
            SsiClient ssiClient,
            NewsRepository newsRepository
    ) {
        this.ssiClient = ssiClient;
        this.newsRepository = newsRepository;
    }

    private void saveNewsToDb(NewsModel newsModel) {
        News news = new News();
        BeanUtils.copyProperties(newsModel, news);

        try {
            newsRepository.save(news);
        } catch (Exception e) {
            log.info("Failed to save news to DB --> {} -{}", e.getMessage(), e.getCause());
        }
    }

    private void crawlAndSaveNews(String symbol) {
        NewsReqModel newsReqModel = new NewsReqModel();
        newsReqModel.setSymbol(symbol);
        try {
            newsReqModel.setFromDate(simpleDateFormat.format(new Date(System.currentTimeMillis())));
            newsReqModel.setToDate(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        } catch (Exception e) {
            log.info("Error when convert String to Object");
        }
        newsReqModel.setOffset(1);
        newsReqModel.setSize(1000000);

        NewsResp newsResp = ssiClient.getAllNews(newsReqModel);

        newsResp.getData().getNews().getDataList().forEach(this::saveNewsToDb);
    }

    @Override
    public CompletableFuture<Void> crawlNews() {
        return CompletableFuture.runAsync(() -> {
            List<SingleStockModel> listSingleStock = ssiClient.getAllStock().getData();
            listSingleStock.forEach(item -> crawlAndSaveNews(item.getCode()));
        });
    }

}
