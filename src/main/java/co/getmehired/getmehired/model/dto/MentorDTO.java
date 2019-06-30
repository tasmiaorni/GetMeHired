package co.getmehired.getmehired.model.dto;

//import java.io.File;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import co.getmehired.getmehired.model.Degree;
import co.getmehired.getmehired.model.TalentStatus;
import co.getmehired.getmehired.model.Timezone;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class MentorDTO {
	
	@Id
	private String id;
	
	private String nameMentor; 
	
	private Integer phoneNumberMentor;
	
	@NotBlank(message = "Authentic verification id. Must match with the unique user")
	private String emailAddressMentor;
	
	private Timezone timezoneMentor;
	
	@NotBlank(message = "Should provide atleast one address")
	private String addressMentor;
	
	private String calendlyUrlMentor;
	
	private String resumeMentor; //For uploading resume File.io has been imported from java module
	
	@NotNull(message = "Should provide atleast one bank account number")
	private Integer bankAccountMentor;
	
	@NotNull(message = "Should provide routing number associated with bank account")
	private Integer routingNumberMentor;
	
	private Degree accademicDegreeMentor;
	
	private String degreeSubjectMentor;
	
	private String degreeInstituteMentor;
	
	private String mentorExpertise;
	
	private String name;
	
	private String noteTalent;
	
	private TalentStatus talentStatus;
	
	private String meetingTopic;

}
