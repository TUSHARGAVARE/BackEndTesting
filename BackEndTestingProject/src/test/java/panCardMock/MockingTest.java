package panCardMock;

import org.mockito.Mockito;
import org.testng.Assert;

class PANCard{
	public  String isvalid(String panCard)
	{

		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true)//{5}initial 5 characters of A-Z & 4 char of 0-9
		{
			return "Is Valid PAN CARD";
		}
		else
		{
			return "Is Invalid PAN CARD";
		}
	}

	public static PANCard getMockObject() {

		PANCard mockObj = Mockito.mock(PANCard.class);
							Mockito.when(mockObj.isvalid("ABCDE1234A")).thenReturn("Valid PAN Card");
							Mockito.when(mockObj.isvalid("ABCDE1234B")).thenReturn("Valid PAN Card");
							Mockito.when(mockObj.isvalid("ABCDE1234C")).thenReturn("Invalid PAN Card");
	                        return mockObj;
	}
}
public class MockingTest {

	public static void main(String[] args) {
		//Since it is a static method with the help of the className try to get pancard Obj
		PANCard obj = PANCard.getMockObject();
		System.out.println(obj.isvalid("ABCDE1234D"));//Not A valid pan card
		// output return null bcoz this data is not added in the mocking solution

	}

}
