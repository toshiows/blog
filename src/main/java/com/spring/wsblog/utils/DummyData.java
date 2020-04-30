package com.spring.wsblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.wsblog.model.Post;
import com.spring.wsblog.repository.WsblogRepository;

@Component
public class DummyData {
//classe para popular o blog para testes
	
	@Autowired
	WsblogRepository wsblogRepository;
	
	//@PostConstruct
	public void savePosts() {
		
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("Toshio Watanabe");
		post1.setData(LocalDate.now());
		post1.setTitulo("Teste");
		post1.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eget est lorem ipsum dolor sit amet consectetur adipiscing elit. Sed tempus urna et pharetra pharetra massa massa ultricies. Sagittis purus sit amet volutpat. Morbi tincidunt ornare massa eget egestas purus viverra accumsan. Ac felis donec et odio pellentesque diam volutpat commodo. Pharetra convallis posuere morbi leo urna. Convallis tellus id interdum velit laoreet id. Nibh praesent tristique magna sit. Leo urna molestie at elementum eu. Tellus orci ac auctor augue mauris augue. Purus semper eget duis at tellus at urna condimentum mattis. Nibh praesent tristique magna sit amet purus gravida quis. Turpis massa sed elementum tempus. Tortor pretium viverra suspendisse potenti nullam ac. Nisl nisi scelerisque eu ultrices vitae auctor eu. Sodales ut eu sem integer vitae justo eget. Tincidunt dui ut ornare lectus sit amet est placerat in. Ipsum dolor sit amet consectetur.");
	
		
		Post post2 = new Post();
		post2.setAutor("Toshio Watanabe");
		post2.setData(LocalDate.now());
		post2.setTitulo("Lorem ipsum");
		post2.setTexto("Est sit amet facilisis magna. Volutpat maecenas volutpat blandit aliquam etiam erat velit scelerisque in. Dolor sit amet consectetur adipiscing elit ut aliquam purus. Id cursus metus aliquam eleifend mi in. Purus faucibus ornare suspendisse sed nisi. In massa tempor nec feugiat nisl pretium. Varius sit amet mattis vulputate enim nulla aliquet porttitor lacus. Diam ut venenatis tellus in metus vulputate eu. Tellus rutrum tellus pellentesque eu. Lacus luctus accumsan tortor posuere ac ut consequat.");
		
		postList.add(post1);
		postList.add(post2);
		
		for(Post post : postList) {
			Post postSaved = wsblogRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}
}
