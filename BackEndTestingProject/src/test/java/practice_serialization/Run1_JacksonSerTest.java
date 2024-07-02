package practice_serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(

		value= { "createdBy",
				"projectName",
				"teamSize",
				"status"

		}
		)
@JsonIgnoreProperties(
		value = {

				"teamSize"
		},allowSetters=true
		)

class Project // POJO class [plain old java Object]
{

	private String projectName;
	@JsonProperty(value="created By")//to keep space
	private String createdBy;
	private int teamSize;
	private String status;

	private Project(){}	//for Deserialization

	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public String getStatus() {
		return status;
	}

}

public class Run1_JacksonSerTest {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Project pObj = new Project("FishermanWharf","Tushar",15,"Created");

		ObjectMapper objMapr = new ObjectMapper();
		objMapr.writeValue(new File("./project.json"), pObj);//jackson serialization or marshalling
		System.out.println("============END===============");


	}

}
