import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LinkedInDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.linkedin.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("amitvchandran@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("An@kulam01");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String pageTitle = driver.getTitle();
        System.out.println("The Title of the page is : " + pageTitle);
        Assert.assertTrue(pageTitle.contains("LinkedIn"));
        driver.quit();
    }
}
