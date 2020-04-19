package com.spring.wsblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.wsblog.model.Post;
import com.spring.wsblog.service.WsblogService;

@Controller
public class WsblogController {

	
	@Autowired
	WsblogService wsblogService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = wsblogService.findAll(); //impl pode usar o metodo
		mv.addObject("posts", posts);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDatails");
		Post post = wsblogService.findById(id); //impl pode usar o metodo
		mv.addObject("post", post);
		
		return mv;
	}
	
	@RequestMapping(value="/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value="/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios (*) estão preenchidos");
			return "redirect:/newpost";
		}
		
		post.setData(LocalDate.now());
		wsblogService.save(post);
		return "redirect:/posts";
	}
	
	
	
}
