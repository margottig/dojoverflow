package com.example.dojooverflow.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="respuestas")
public class Respuestas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 65535, columnDefinition = "text")
	private String respuesta;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="question_id")
	private Preguntas pregunta;
	
	
	
	//Constructor
	public Respuestas() {
		
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
