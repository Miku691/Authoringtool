package com.authoring.tool.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ATL_COURSE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtlCourse {

	@Id
	@Column(name="ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	@NotBlank(message="Title should not empty")
	@Column(name ="TITLE")
	private String title;
	@NotEmpty(message="Provide some description about Title")
	@Column(name ="DESC")
	private String desc;
	@NotBlank(message="Provide the Author Name")
	@Column(name ="AUTHOR")
	private String author;
	@FutureOrPresent
	@Column(name ="CREATED_ON")
	private Date createdOn;
	
	@Column(name ="UPDATE_ON")
	private Date updatedOn;
	@Column(name ="STATUS")
	private char status;
	
}
