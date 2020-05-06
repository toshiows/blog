package com.spring.wsblog.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.spring.wsblog.model.Post;

public interface WsblogService {

	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
	void delete(Post post);
	List<Post> findByTexto(String texto);
	Page<Post> findAll(PageRequest pageRequest);
	
}
