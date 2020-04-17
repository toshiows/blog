package com.spring.wsblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.wsblog.model.Post;
import com.spring.wsblog.service.WsblogService;

@Controller
public class WsblogController {

	
	@Autowired
	WsblogService wsblogService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = wsblogService.findAll();
		mv.addObject("posts", posts);
		
		return mv;
	}
}
