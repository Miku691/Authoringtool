package com.authoring.tool.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtlMediaAssestsDto {
	private Long id;
	private String fileName;
	private String fileUrl;
	private String fileType;
	private String uploadedBy;
	private LocalDate uploadedOn;
}
