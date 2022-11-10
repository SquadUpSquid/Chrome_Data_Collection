package HW04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.opencsv.CSVWriter;

public class Collection {
	public static void main(String[] args) throws IOException {
		
		File file =  new File("C:/Users/water/Desktop/chrome_data.csv");
		FileWriter outputfile = new FileWriter(file);
		CSVWriter writer = new CSVWriter(outputfile);
		
		Main_Method m = new Main_Method();
		m.chrome_d("https://www.google.com");
		
		m.driver.get(m.url);
		
		
		try {
			m.driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/"
					+ "div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("https://www.sec.gov/edgar/search/");
		}
			catch(Exception e) {
			System.out.println("Error in the search box");
			}
		
		try {
			m.driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/"
					+ "div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
		}
			catch(Exception e) {
				System.out.println("Enter key is not working");
			}
		
		try {
			m.driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3")).click();
		}
			catch(Exception e){
			System.out.println("New click error");
			}
		
		try {
			m.driver.findElement(By.xpath("//*[@id=\"entity-short-form\"]")).sendKeys("Tesla");
		}
			catch(Exception e) {
			System.out.println("Error in the search box");
			}
		
		try {
			m.driver.findElement(By.xpath("//*[@id=\"entity-short-form\"]")).sendKeys(Keys.ENTER);
		}
			catch(Exception e) {
				System.out.println("Enter key is not working");
			}
		
		
		
		
		for(int i=1; i<101; i++) {
			String form;
			String filed;
			String reporting;
			String filingEntity;
			
			try {
				form = m.driver.findElement(By.xpath("//*[@id=\"hits\"]/table/tbody/tr["+ Integer.toString(i) +"]/td[1]")).getText();
			}
				catch (Exception e){
					form = "null";
				}
			
			try {
				filed = m.driver.findElement(By.xpath("//*[@id=\"hits\"]/table/tbody/tr["+ Integer.toString(i) +"]/td[2]")).getText();
			}
				catch (Exception e){
					filed = "null";
				}
			
			try {
				reporting = m.driver.findElement(By.xpath("//*[@id=\"hits\"]/table/tbody/tr["+ Integer.toString(i) +"]/td[3]")).getText();
			}
				catch (Exception e){
					reporting = "null";
				}
			
			try {
				filingEntity = m.driver.findElement(By.xpath("//*[@id=\"hits\"]/table/tbody/tr["+ Integer.toString(i) +"]/td[4]")).getText();
			}
				catch (Exception e){
					filingEntity = "null";
				}
						
			
			
			String[] a = {form, filed, reporting, filingEntity};
			writer.writeNext(a);
			
		}
		
		try {
			writer.close();
		}
			catch(Exception e) {
				System.out.println("CSV file slow error");
			}
			finally {
				m.driver.close();
			}
			
	}

}
