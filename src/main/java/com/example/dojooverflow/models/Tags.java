package com.example.dojooverflow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tags")
public class Tags {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=255)
	private String subject;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="tags_questions",
	joinColumns= @JoinColumn(name="tag_id"), 
	inverseJoinColumns = @JoinColumn(name="question_id"))
	private List<Preguntas> preguntas;
	
	//Constructor
	public Tags() {
		
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


}
