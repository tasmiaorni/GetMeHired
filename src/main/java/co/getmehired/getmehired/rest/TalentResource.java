package co.getmehired.getmehired.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.dto.TalentDTO;
import co.getmehired.getmehired.service.TalentService;
import co.getmehired.getmehired.service.TalentService;

@CrossOrigin
@RestController
public class TalentResource {

	@Autowired
	private TalentService talentService;
	
		
		talent = talentService.save(talent);
		return talent;
	
	@PostMapping("/api/talents")
	public Talent saveTalent(@Validated @RequestBody Talent talent) {
		talent = talentService.save(talent);
		return talent;
	}

	@GetMapping("/api/talents")
	public List<TalentDTO> getTalents() {
		List<TalentDTO> talentDTOs = new ArrayList<>();

		List<Talent> talents = talentService.getTalents();

		for (Talent t : talents) {
			TalentDTO dto=new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),
					t.getImmigrationExpiary(),t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),
					t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSuuportNeeded(),t.getObjective(),t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),
					t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());

			talentDTOs.add(dto);
		}
		return talentDTOs;
			TalentDTO dto = new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(), t.getEmailAddress(), t.getTimezone(), null, t.getImmigrationExpiary(),
			t.getAddress(),t.getSsnNumber(),t.getBankAccount(), t.getRoutingNumber(),t.getCitizenship(), t.getImmigrationStatus(), t.getAccademicDegree(),
			t.getDegreeSubject(),t.getGraduationDate(), null, t.getSupportNeeded(),null, null, null, t.getCuurrentJob(), t.getCurrentEmployer(),
			t.getJobSalary(), t.getNewEmployer(),t.getNewPosition(), t.getJobStartdate(), null);
//			
			talentDTOs.add(dto);
		}
		
	@GetMapping("/api/talents/{id}")
	public TalentDTO getTalent(@PathVariable String id) {
		Talent t = talentService.getTalentById(id).orElseGet(null);

		TalentDTO dto=new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),
				t.getImmigrationExpiary(),t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),
				t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSuuportNeeded(),t.getObjective(),t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),
				t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());
		
		return dto;
	}
//		dto.setName(t.getName());
//		dto.setEmailAddress(t.getEmailAddress());
//		dto.setPhoneNumber(t.getPhoneNumber());
//		//TODO: HW: add all other fields (use a method)
		
	@PutMapping("/api/talents/{id}")
	public TalentDTO updateTalent(@PathVariable String id,@RequestBody Talent t) {
		TalentDTO dto=new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),
				t.getImmigrationExpiary(),t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),
				t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSuuportNeeded(),t.getObjective(),t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),
				t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());
	}
		
		talentService.save(t);
		talentService.removeTalentById(id);
		return dto;
	}

	@DeleteMapping("/api/talents/{id}")
	public TalentDTO deleteTalent(@PathVariable String id) {
		Talent t = talentService.getTalentById(id).orElseGet(null);

		TalentDTO dto=new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),
				t.getImmigrationExpiary(),t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),
				t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSuuportNeeded(),t.getObjective(),t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),
				t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());

		talentService.removeTalentById(id);
		return dto;
	}
		Talent currentTalent = talentService.getTalentById(id).orElseGet(null);
		
		try {
			currentTalent.setName(talentInfo.getName());
			currentTalent.setPhoneNumber(talentInfo.getPhoneNumber());
			currentTalent.setEmailAddress(talentInfo.getEmailAddress());
			
		} catch (IllegalArgumentException e) {
			System.out.println("ID is invalid");
		}
		
		return talentService.save(currentTalent); 
		
		
	}
	

	@DeleteMapping("/api/talents/{id}")
	public void deleteTalent(@PathVariable String id) {
		 this.talentService.deletebyId(id);
	}
	
}
