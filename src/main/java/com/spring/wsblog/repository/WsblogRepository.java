package com.spring.wsblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.wsblog.model.Post;

public interface WsblogRepository extends JpaRepository<Post, Long>{
//implementa metodos do jpa
}
