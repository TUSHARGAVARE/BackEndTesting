package practice;

import org.testng.annotations.Test;



import static com.backend.tessting.A.*;//static import
//can access method directly  present in another package class without using a classname

public class Run1 {

	@Test
	public void sampleTest() {
		//	given();
		//	when();
		//	then();

	//	A a1 = new A();
		//   a1.a(); traditional way
		//   a1.b();
		//    a1.c();
		// method chaining if non static need to create obj n call by obj ref.
		a().b().c().d();

	}
}
