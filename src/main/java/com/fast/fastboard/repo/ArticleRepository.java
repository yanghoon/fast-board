package com.fast.fastboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fast.fastboard.domain.Article;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}
