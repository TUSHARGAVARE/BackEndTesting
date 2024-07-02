package practice_serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

   
 class Project1 {

   String projectName;
   String projectStatus;
   int teamSize;
   List<String> teamMember;
   ProjectManager projectManager;

   

    public Project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
		ProjectManager projectManager) {
	super();
	this.projectName = projectName;
	this.projectStatus = projectStatus;
	this.teamSize = teamSize;
	this.teamMember = teamMember;
	this.projectManager = projectManager;
}
	public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
    public String getProjectStatus() {
        return projectStatus;
    }
    
    public void setTeamMember(List<String> teamMember) {
        this.teamMember = teamMember;
    }
    public List<String> getTeamMember() {
        return teamMember;
    }
    
    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
    public ProjectManager getProjectManager() {
        return projectManager;
    }
    
}


   
 class ProjectManager{

   String name;
   String empID;

    public ProjectManager(String name, String empID) {
	super();
	this.name = name;
	this.empID = empID;
}
	public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setEmpID(String empID) {
        this.empID = empID;
    }
    public String getEmpID() {
        return empID;
    }
    
}


public class Run3_POJO {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		List<String> lst = new ArrayList<String>();
		lst.add("Amar");
		lst.add("Aman");
		lst.add("Virender");
 
		ProjectManager pm = new ProjectManager("AquaMan","tek025");
		Project1 projObj = new Project1("Tushar","created",10,lst,pm);
		ObjectMapper objMapr = new ObjectMapper();
		objMapr.writeValue(new File("./Project1.json"), projObj);
	}
}
