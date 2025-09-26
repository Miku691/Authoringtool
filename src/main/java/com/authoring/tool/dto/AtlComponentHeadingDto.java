package com.authoring.tool.dto;



import com.authoring.tool.entity.AtlSlides;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtlComponentHeadingDto {

	private Long Id;
	private String title;
	
	private AtlSlides slide;
}
