package com.bkhn.crawl.schedulers;

import com.bkhn.crawl.service.CrawlSsiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class NewsCrawlSchedule {

    private final CrawlSsiService crawlSsiService;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public NewsCrawlSchedule(
            CrawlSsiService crawlSsiService
    ) {
        this.crawlSsiService = crawlSsiService;
    }

    @Scheduled(cron = "${crawl.cron}")
    public void crawlEach12Hour() {
        LocalDateTime now = LocalDateTime.now();
        log.info("Start crawl news at {} ", dtf.format(now));
        crawlSsiService.crawlNews().join();
        log.info("Done crawl news at {} ", dtf.format(now));
    }

}
