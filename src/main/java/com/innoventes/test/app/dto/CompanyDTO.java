package com.innoventes.test.app.dto;

import com.innoventes.test.app.constraint.CompanyCode;
import com.innoventes.test.app.constraint.EvenNumberOrZero;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;

	@NotBlank
	@NonNull
	private String companyName;

	@NonNull
	@NotBlank
	@Email
	private String email;

	@Nullable
	@PositiveOrZero
	@EvenNumberOrZero
	private Integer strength;

	private String webSiteURL;

	@CompanyCode
	private String companyCode;
}
