package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="languages")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate_cv"})

public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;	
	@Column(name="name")	
	private String name;
	
	@Column(name="level")	
	private int level;
	
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	

}
