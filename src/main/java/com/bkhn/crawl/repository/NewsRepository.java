package com.bkhn.crawl.repository;

import com.bkhn.crawl.repository.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long>  {
}
