package com.innoventes.test.app.entity;

import javax.persistence.*;

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

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name")
	@NonNull
	private String companyName;

	@Column(name = "email")
	@NonNull
	private String email;
	
	@Column(name = "strength")
	@Nullable
	private Integer strength;
	
	@Column(name = "website_url")
	@Nullable
	private String webSiteURL;

	@Column(name = "company_code", unique = true)
	private String companyCode;
}
