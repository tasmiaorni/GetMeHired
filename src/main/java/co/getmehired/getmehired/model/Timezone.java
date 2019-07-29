package co.getmehired.getmehired.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document(collection = "Timezone")
@AllArgsConstructor
public class Timezone {

	@Id
	private String id;
	private String timezoneID;
	private String offset;
	private String abbr;
	private String value;
	private String text;
}
