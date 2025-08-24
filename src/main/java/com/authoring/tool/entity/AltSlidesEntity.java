package com.authoring.tool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ATL_SLIDES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AltSlidesEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(name="COURSE_ID",referencedColumnName = "ID")
	private AltCourseEntity course;
	@Column(name="TITLE")
	private String title;
	@Column(name="DESC")
	private String desc;
	@Column(name="ORDER_INDEX")
	private int orderIndex;
	
	
	

}
