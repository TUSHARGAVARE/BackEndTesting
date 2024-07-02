package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodeAndDecodeTest {

	@Test
	public void encodDecodTest() {
		// Convert string into encoded data(encoding)
		//String encodeData = new String(Base64.getEncoder().encode("rmgyantra : rmgy@9999".getBytes()));
	//	System.out.println("Encoded data is : " + encodeData);

		// Convert encoded data back into Decode data(Decoding)
		String decodeData = new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
		System.out.println("Decoded data is : " + decodeData);
		
		//cm1neWFudHJhOnJtZ3lAOTk5OQ==
	}

}
