package com.spring.wsblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.wsblog.model.Post;

public interface WsblogRepository extends JpaRepository<Post, Long>{

	List<Post> findByTextoLike(String texto);
//implementa metodos do jpa
}
