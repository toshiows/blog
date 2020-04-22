package com.spring.wsblog.service;

import java.util.List;

import com.spring.wsblog.model.Post;

public interface WsblogService {

	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
	void delete(Post post);

}
