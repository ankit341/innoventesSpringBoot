package com.innoventes.test.app.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;

	private String companyName;

	private String email;

	private Integer strength;
	
	private String webSiteURL;

	private String companyCode;
}
