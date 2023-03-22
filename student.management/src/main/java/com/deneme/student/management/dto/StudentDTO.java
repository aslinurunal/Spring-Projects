package com.deneme.student.management.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.deneme.student.management.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
	@NotBlank(message = "Ad Boş Geçilemez!")
	private String name;
	@NotBlank(message = "Soyad Boş Geçilemez!")
	private String surname;
	@Min(0)
	@Max(4)
	private Double grade;
	@Email(message = "Hatalı Email!")
	private String email;
}
