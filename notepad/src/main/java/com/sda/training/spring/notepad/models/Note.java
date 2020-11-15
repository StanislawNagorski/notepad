package com.sda.training.spring.notepad.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String title;
	@NotEmpty
	@Length(min = 10, message = "Długość powinna być większa niż 10")
	private String content;
	@CreationTimestamp
	private LocalDateTime creationTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;

	@JsonIgnore // bo inaczej to Jsona odpowiedzi wpadnie pole na podstawie tej metody 0_o
	@AssertTrue(message = "Tytuł musi zaczynać się z Wielkiej litery. Jak np Kazimierz Wielki")
	public boolean isTitleStartingWithCapitalLetter(){
		return Character.isUpperCase(title.charAt(0));
	}
}
