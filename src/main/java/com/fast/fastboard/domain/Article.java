package com.fast.fastboard.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Table(indexes = {
    @Index(columnList = "title", name = "idx_title"),
    @Index(columnList = "tags", name = "idx_tags"),
    @Index(columnList = "createdAt", name = "idx_createdAt"),
    @Index(columnList = "createdBy", name = "idx_createdBy")
})
@Entity
public class Article extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title;
    @Setter
    @Column(nullable = false, length = 10000)
    private String content;
    @Setter
    private String tags;

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<Comment> comments = new LinkedHashSet<>();

    protected Article() {}

    private Article(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public static Article of(String title, String content, String tags) {
        return new Article(title, content, tags);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Article)) return false;
        Article article = (Article) obj;
        return id != null && id.equals(article.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }

}
