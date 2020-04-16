package com.spring.wsblog.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.wsblog.model.Post;
import com.spring.wsblog.repository.WsblogRepository;
import com.spring.wsblog.service.WsblogService;


@Service
public class WsblogServiceImpl implements WsblogService{

	@Autowired
	WsblogRepository wsblogRepository;
	
	@Override
	public List<Post> findAll() {
		return wsblogRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return wsblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return wsblogRepository.save(post);
	}

}
