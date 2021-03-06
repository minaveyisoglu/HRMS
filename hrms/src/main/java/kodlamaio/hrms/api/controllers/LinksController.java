package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;
@CrossOrigin
@RestController
@RequestMapping("/api/links")
public class LinksController {
	private LinkService linkService;
	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Link>> getAll(){
		return this.linkService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	DataResult<List<Link>> getByCandidateId(int candidateId){
		return this.linkService.getByCandidateId(candidateId);
	}
	@PostMapping("/add")
	Result add(@RequestBody Link link) {
		return this.linkService.add(link);
	}
	

}
