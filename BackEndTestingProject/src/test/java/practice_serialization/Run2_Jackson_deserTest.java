package practice_serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run2_Jackson_deserTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objMapr = new ObjectMapper();
		Project pObj = objMapr.readValue(new File("./project.json"), Project.class);
		System.out.println(pObj.getProjectName());//Deserialization
		System.out.println(pObj.getTeamSize());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getCreatedBy());
	}

}
