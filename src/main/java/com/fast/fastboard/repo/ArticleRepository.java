package com.fast.fastboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fast.fastboard.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}
