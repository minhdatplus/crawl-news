package com.bkhn.crawl.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "AD_NEWS")
public class News implements Serializable {

    private static final long serialVersionUID = -6667234377826965949L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CR_CREATED_TIME")
    private Date crCreatedTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CR_MODIFIED_TIME")
    private Date crModifiedTime;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "SYMBOL", unique = true)
    private String symbol;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "SHORT_CONTENT")
    private String shortContent;

    @Column(name = "FULL_CONTENT")
    private String fullContent;

    @Column(name = "NEWS_SOURCE")
    private String newsSource;

    @Column(name = "SOURCE_CODE")
    private String sourceCode;

    @Column(name = "NEWS_SOURCE_LINK")
    private String newsSourceLink;

}
