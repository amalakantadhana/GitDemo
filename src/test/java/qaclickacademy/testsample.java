package qaclickacademy;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;

public class testsample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		datadriven d = new datadriven();
		ArrayList<String> data=d.getData("Add profile"); //method returns the arraylist
		System.out.println(data.get(0)); //get the test case name
		System.out.println(data.get(1)); // get the data1
		System.out.println(data.get(2)); //gets the data2
		System.out.println(data.get(3)); //gets the data3
		
		driver.findelement(By.xpath("//sdkjfkds")).sendkeys(data.get(3));

	}

}
