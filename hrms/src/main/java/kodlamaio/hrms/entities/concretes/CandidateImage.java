package kodlamaio.hrms.entities.concretes;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Table(name="candidate_images")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class CandidateImage {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name = "uploaded_at")
	private LocalDate uploadedAt;
	
	

	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

}
