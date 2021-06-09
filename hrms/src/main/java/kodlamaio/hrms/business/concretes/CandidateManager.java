package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;
	
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
		
	}

	@Override
	public DataResult<List<Candidate>>getAll(){
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi.");
	}
	@Override
	public Result add(Candidate candidate) {
		if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentityNumber() == null|| candidate.getBirthYear()==null
				|| candidate.getEmail() == null || candidate.getPassword() == null ) {
			return new ErrorResult("Herhangi bir alan boş bırakılamaz ! ");
			
			
		}else if(candidateDao.getByIdentityNumber(candidate.getIdentityNumber())!= null) {
				return new ErrorResult("Kullanilan bir  TCkimlik no  girdiniz!");
				
		}		
		
		else {
			candidateDao.save(candidate);
			return new SuccessResult("Kayıt başarılı bir şekilde tamamlandı!");
		}

}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber),"İş arayanlar Tc kimlik no ya göre listelendi.");
	}
}



	
