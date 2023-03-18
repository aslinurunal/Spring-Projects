package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Post;
import com.example.demo.service.PostService;

@RestController //Rest API
@RequestMapping("/api/v1/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	@RequestMapping("{id}")
	public Post get(@PathVariable int id){
		return service.idIleGetir(id);
	}
	
	@GetMapping
	public List<Post> list(){
		return service.getir();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Post create(@RequestBody final Post post) {
		return service.ekle(post);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Post update(@PathVariable int id, @RequestBody final Post post) {
		
		Post currentPost = service.idIleGetir(id);
		
		currentPost = Post.builder()
		.id(post.getId())
		.body(post.getBody())
		.title(post.getTitle())
		.userId(post.getUserId())
		.build();
		
		//BeanUtils.copyProperties(post, currentPost, "id");
		
		return service.guncelle(currentPost);
	}

}
