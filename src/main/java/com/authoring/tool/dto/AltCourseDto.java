package com.authoring.tool.dto;



import java.time.LocalDate;

import com.authoring.tool.utility.Today;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AltCourseDto {

	
	@NotBlank(message="Title should not empty")
	private String title;
	@NotEmpty(message="Provide some description about Title")
	private String desc;
	@NotBlank(message="Provide the Author Name")
	private String author;
	@FutureOrPresent
	private LocalDate createdOn;
	
}
