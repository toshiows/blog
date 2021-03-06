package com.spring.wsblog.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Override
	public void delete(Post post) {
		 wsblogRepository.delete(post);
	}

	@Override
	public List<Post> findByTexto(String texto) {
		// TODO Auto-generated method stub
		return wsblogRepository.findByTextoLike("%" +texto+ "%");
	}

	@Override
	public Page<Post> findAll(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return wsblogRepository.findAll(pageRequest);
	}
	
	

}
