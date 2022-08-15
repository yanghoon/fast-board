package com.fast.fastboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fast.fastboard.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
