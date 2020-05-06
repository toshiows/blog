package com.spring.wsblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.wsblog.model.Post;
import com.spring.wsblog.service.WsblogService;

@Controller
public class WsblogController {

	
	@Autowired
	WsblogService wsblogService;
	LocalDate dataPost;
	
	@GetMapping("/posts")
	public String mostraPagina(Model model, @RequestParam(defaultValue="0") int page) {
		model.addAttribute("posts", wsblogService.findAll(PageRequest.of(page, 5)));
		model.addAttribute("currentPage", page);
		return "posts";
	}
	
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDatails");
		Post post = wsblogService.findById(id); //impl pode usar o metodo
		mv.addObject("post", post);
		
		return mv;
	}
	
	@GetMapping("/postagens")
	public String listaPostagens(Model model, @RequestParam(defaultValue="") String texto) {
		model.addAttribute("posts", wsblogService.findByTexto(texto));
		model.addAttribute("palavraChave", texto);
		return "/postagens";
	}
	
	@RequestMapping(value = "/sobre", method = RequestMethod.GET)
	public String paginaSobre() {
		return "/sobre";
	}

	
	/*Metodos para admin*/
	@RequestMapping(value="/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "ghost/postForm";
	}
	
	@RequestMapping(value="/postar", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios (*) estão preenchidos");
			return "redirect:/newpost";
		}
		
		post.setData(LocalDate.now());
		wsblogService.save(post);
		return "redirect:/posts";
	}
	
	@RequestMapping(value="ghost/admin", method = RequestMethod.GET)
	public ModelAndView admin() {
		
		ModelAndView mv = new ModelAndView("ghost/admin");
		List<Post> posts = wsblogService.findAll(); //impl pode usar o metodo
		mv.addObject("posts", posts);
		
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView getUpdPostForm(@PathVariable("id") long id) {
		
		ModelAndView mv = new ModelAndView("ghost/editPost");
		Post post = wsblogService.findById(id); //impl pode usar o metodo
		mv.addObject("post", post);
		
		dataPost = post.getData();
		return mv;
		
	}
	
	@RequestMapping(value="/atualizarpost", method = RequestMethod.POST)
	public String updatePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios (*) estão preenchidos");
			return "redirect:/newpost";
		}
		
		post.setData(dataPost);
		wsblogService.save(post);
		return "redirect:/posts";
	}
	
	
	@RequestMapping("ghost/deletePost")
	public String delete(Post post) {
		wsblogService.delete(post);
		return "redirect:/ghost/admin";
	}
	
}
