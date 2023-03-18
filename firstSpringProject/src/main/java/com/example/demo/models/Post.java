package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="posts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Post{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String body;
	private Integer userId;
	
}
