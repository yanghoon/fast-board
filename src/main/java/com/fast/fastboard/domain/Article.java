package main.java.com.fast.fastboard.domain;

import java.math.BigInteger;
import java.time.OffsetDateTime;

public class Article {

    private Long id;
    private String title;
    private String content;
    private String tags;

    private OffsetDateTime createdAt;
    private String createdBy;
    private OffsetDateTime modifiedAt;
    private String modifiedBy;

}
