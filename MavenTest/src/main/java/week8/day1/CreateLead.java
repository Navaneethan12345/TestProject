package week8.day1;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends Annotations{


	@Test(dataProvider="fetchData")
	public void createLead(String CompanyName,String FirstName,String LastName,String Email,String Phone) {

		
		WebElement CreateLead = locateElement("linktext","Create Lead");
		click(CreateLead);
	
		WebElement companyName = locateElement("id", "createLeadForm_companyName");
		type(companyName, CompanyName);
		
		WebElement firstName = locateElement("id", "createLeadForm_firstName");
		type(firstName, FirstName);
		
		WebElement lastName = locateElement("id", "createLeadForm_lastName");
		type(lastName, LastName);
		
		WebElement emailAddress=locateElement("id","createLeadForm_primaryEmail");
    	type(emailAddress,Email);


		WebElement phoneNumber=locateElement("id","createLeadForm_primaryPhoneNumber");
		type(phoneNumber,Phone);



//		//Final Submit for Create Lead
		WebElement createLeadSubmit = locateElement("class","smallSubmit");
		click(createLeadSubmit);
	}
		
		@DataProvider(name="fetchData")
		public Object[][] getData() throws IOException {
			ReadExcel excel=new ReadExcel();
			
			

     return excel.readExcelData("CreateLeadExcel");
		
	}
	
}

	

