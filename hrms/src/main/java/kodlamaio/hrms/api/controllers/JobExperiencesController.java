package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
@CrossOrigin
@RestController
@RequestMapping("/api/jobExperiences")

public class JobExperiencesController {
	private JobExperienceService jobExperienceService;
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>>getAll(){
		return this.jobExperienceService.getAll();
	}
	@GetMapping("/getByCandidateIdOrderByDateOfEndDESC")
	public DataResult<List<JobExperience>>getByCandidateIdOrderByDateOfEndDESC(int candidateId){
		return this.jobExperienceService.getByCandidateIdOrderByDateOfEndDESC(candidateId);
	}

}
