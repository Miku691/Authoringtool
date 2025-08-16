package com.authoring.tool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ALT_SLIDES")
public class AltSlidesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID",nullable = false)
	private String id;
	@Column(name="COURSE_ID")
	private String courseId;
	@Column(name="TITLE")
	private String title;
	@Column(name="DESC")
	private String desc;
	@Column(name="ORDER_INDEX")
	private int orderIndex;
}
