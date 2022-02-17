package com.cg.app.hotelbooking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Review {
		
	@Id
	@SequenceGenerator(name="idgen",initialValue=100,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="idgen")
	private int review_id;
	private String feedback;
	@Range(min =1, max=5)
	private int rating;
	private int service_id;
	private int user_id;
	
	

	
	

}
