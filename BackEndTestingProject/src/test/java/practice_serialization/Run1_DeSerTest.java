package practice_serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run1_DeSerTest {
	
 public static void main(String[] args) throws IOException, ClassNotFoundException {
	 
	 FileInputStream fis = new FileInputStream("./f.txt");
	 
	 ObjectInputStream ois = new ObjectInputStream(fis);
	 NEEDFORSPEED userObj =(NEEDFORSPEED) ois.readObject();
	 
	 System.out.println(userObj.name);
	 System.out.println(userObj.level);
	 System.out.println(userObj.score);
	 System.out.println(userObj.life);

	}
}
