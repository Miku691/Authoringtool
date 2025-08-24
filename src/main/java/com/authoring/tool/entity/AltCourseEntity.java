package com.authoring.tool.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class AltCourseEntity {

	@Id
	@Column(name="ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name ="TITLE")
	private String title;
	@Column(name ="DESC")
	private String desc;
	@Column(name ="AUTHOR")
	private String author;
	@Column(name ="CREATED_ON")
	private LocalDate createdOn;
	
	
	@OneToMany(mappedBy = "course")
	private List<AltSlidesEntity> slides;
	
	
}
