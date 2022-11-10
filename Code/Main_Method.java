package HW04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main_Method {
	WebDriver driver;
	
	String name = "webdriver.chrome.driver";
	String path = "C:/Users/water/Downloads/chromedriver_win32/chromedriver.exe";
	String url;
	
	public void chrome_d(String input_url) {
		System.setProperty(name, path);
		driver = new ChromeDriver();
		url = input_url;
	}
	

}
