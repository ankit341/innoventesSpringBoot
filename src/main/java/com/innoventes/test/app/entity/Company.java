package com.innoventes.test.app.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.innoventes.test.app.constraint.CompanyCode;
import com.innoventes.test.app.constraint.EvenNumberOrZero;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	// Task 1 and Task 2 here with all the constraints.
	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name")
	@NonNull
	@NotBlank
	@Size(min = 5)
	private String companyName;

	@Column(name = "email")
	@NonNull
	@Email
	private String email;
	
	@Column(name = "strength")
	@Nullable
	@PositiveOrZero
	@EvenNumberOrZero
	private Integer strength;
	
	@Column(name = "website_url")
	@Nullable
	private String webSiteURL;

	@Column(name = "company_code", unique = true)
	@CompanyCode
	private String companyCode;
}
