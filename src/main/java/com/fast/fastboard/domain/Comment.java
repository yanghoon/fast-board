package main.java.com.fast.fastboard.domain;

import java.math.BigInteger;
import java.time.OffsetDateTime;

public class Comment {

    private Long id;
    private Article article;
    private String content;

    private OffsetDateTime createdAt;
    private String createdBy;
    private OffsetDateTime modifiedAt;
    private String modifiedBy;

}
