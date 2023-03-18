package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.models.Post;
import com.example.demo.repository.PostRepository;


//Business logic layer
@Component
public class PostService {
	
	@Autowired // IoC
	private PostRepository repo;
	
	public List<Post> getir(){
		return repo.findAll();
	}
	
	public Post ekle(Post post) {
		
		repo.saveAndFlush(post);
		return post;
	}

	public Post idIleGetir(Integer id) {
		return repo.getReferenceById(id);
	}
	
	public Post guncelle(Post post) {
		return repo.saveAndFlush(post);
	}

}
