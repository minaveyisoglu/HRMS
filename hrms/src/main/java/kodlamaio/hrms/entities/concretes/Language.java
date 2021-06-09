package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="languages")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Language {
	@Id
	
	@Column(name="id")	
	private int id;	
	@Column(name="name")	
	private String name;
	
	@Column(name="level")	
	private int level;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	

}
