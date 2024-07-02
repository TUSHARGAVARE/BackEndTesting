package encryption;

import org.testng.annotations.Test;

public class AESEncryptTest {
	@Test
	public void aesSampleTest() throws Exception {
		
		String privateKey = "Ac03tEam@j!tu_#1";
		String data = "{\"name\" : \"Tussshar\", \"id\":\"tpy-023\"}";
		
		EncrypAndDecryptUtility ed = new EncrypAndDecryptUtility();
		
		//symmetric Encrypt Data
		System.out.println(ed.encrypt(data,privateKey));
		
	    //symmetric Decrypt Data
	System.out.println(ed.decrypt("gSFuC5fEO2O7/6umA6hX2CV7TWlfayI5tuSgCesZ8xdIxcV5XQJCIILhM8BbZ/JQ",privateKey));

// both the sides for encryption n decryption also we r using  same private key 
	}


}
