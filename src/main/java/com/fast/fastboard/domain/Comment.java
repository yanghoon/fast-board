package com.fast.fastboard.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
    @Index(columnList = "content", name = "idx_content"),
    @Index(columnList = "createdAt", name = "idx_createdAt"),
    @Index(columnList = "createdBy", name = "idx_createdBy")
})
@Entity
public class Comment extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false) // ??
    private Article article;
    @Setter
    @Column(nullable = false, length = 500)
    private String content;

    private Comment(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    private static Comment of(Article article, String content) {
        return Comment.of(article, content);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Comment)) return false;
        Comment comment = (Comment) obj;
        return id != null && id.equals(comment.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
