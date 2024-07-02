package practice_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NEEDFORSPEED implements Serializable //to achieve ser need to implement ser...its marker interface(empty methods)
{
	String name;
	int level;
	long score;
	int life;
	
	public NEEDFORSPEED(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

public class Run1_Ser {

	public static void main(String[] args) throws IOException {
		
		NEEDFORSPEED userObj = new NEEDFORSPEED("Tushara",15,70000,1);
		FileOutputStream fos = new FileOutputStream("./f.txt");
		
		ObjectOutputStream oos= new  ObjectOutputStream(fos);
		oos.writeObject(userObj);
		System.out.println("======END========");

	}

}
