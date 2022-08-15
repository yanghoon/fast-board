package com.fast.fastboard.repo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.fast.fastboard.config.JpaConfig;
import com.fast.fastboard.domain.Article;

@ActiveProfiles("test")
@DisplayName("JPA Operation Test")
@Import(JpaConfig.class)
@DataJpaTest
public class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public JpaRepositoryTest(
        @Autowired ArticleRepository articleRepository,
        @Autowired CommentRepository commentRepository) {
            this.articleRepository = articleRepository;
            this.commentRepository = commentRepository;
    };

    @DisplayName("Select Test")
    @Test
    void select_test() {
        // @Autowired ArticleRepository articleRepository,
        // @Autowired CommentRepository commentRepository) {

        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // Then
        Assertions.assertThat(articles)
            .isNotNull()
            .hasSize(123);
    }

    @DisplayName("Insert Test")
    @Test
    void insert_test() {
        // Given
        final long insertBeforeCount = articleRepository.count();
        Article newArticle = Article.of("new article", "new content", "new tags");

        // When
        Article saved = articleRepository.save(newArticle);
        final long insertAfterCount = articleRepository.count();

        // Then
        Assertions.assertThat(insertAfterCount).isEqualTo(insertBeforeCount + 1);
        Assertions.assertThat(saved).hasFieldOrPropertyWithValue("id", insertAfterCount);
        // Assertions.assertThat(saved).matches((s) -> s.getId() == insertAfterCount);
        // Assertions.assertThat(saved).returns(insertAfterCount, (s) -> s.getId());
    }

    @DisplayName("Update Test")
    @Test
    void update_test() {
        // Given
        final String modifiedTags = "#boot";
        final Article article = articleRepository.findById(1L).orElseThrow();
        article.setTags(modifiedTags);

        // When
        articleRepository.save(article);
        final Article saved = articleRepository.saveAndFlush(article);
        // final Article saved = articleRepository.save(article);
        // articleRepository.flush();

        // Then
        Assertions.assertThat(saved).isEqualTo(article);
        Assertions.assertThat(saved).hasFieldOrPropertyWithValue("tags", modifiedTags);
    }

    @DisplayName("Delete Test")
    @Test
    void delete_test() {
        // Given
        final long id = 1L;
        final long deleteBeforeCount = articleRepository.count();
        final long deleteBeforeCommentCount = commentRepository.count();
        final Article article = articleRepository.findById(id).orElseThrow();
        final long deletedCommentCount = article.getComments().size();

        // When
        articleRepository.delete(article);
        final long deleteAfterCount = articleRepository.count();
        final long deleteAfterCommentCount = commentRepository.count();
        final Optional<Article> deleted = articleRepository.findById(id);

        // Then
        Assertions.assertThat(deleteAfterCount).isEqualTo(deleteBeforeCount - 1);
        Assertions.assertThat(deleteAfterCommentCount).isEqualTo(deleteBeforeCommentCount - deletedCommentCount);
        Assertions.assertThat(deleted.orElse(null)).isNull();
        // Assertions.assertThat(saved).hasFieldOrPropertyWithValue("id", insertAfterCount);
        // Assertions.assertThat(saved).matches((s) -> s.getId() == insertAfterCount);
        // Assertions.assertThat(saved).returns(insertAfterCount, (s) -> s.getId());
    }
}
