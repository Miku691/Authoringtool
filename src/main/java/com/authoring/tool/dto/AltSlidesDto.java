package com.authoring.tool.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor	
public class AltSlidesDto {

	private Long Id;
	private String courseId;
	@NotNull
	private String title;
	@NotEmpty
	private String desc;
	private int orderIndex;
}
