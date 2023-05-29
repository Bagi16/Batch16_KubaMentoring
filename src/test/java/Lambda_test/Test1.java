package Lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Test1 {

     @Test
     public void Test1() throws InterruptedException {
         //Go with test annotation @Test
         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         WebDriver driver = new ChromeDriver(options);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("https://www.lambdatest.com/selenium-playground");

         WebElement inputSubmitButton = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
         inputSubmitButton.click();
         Thread.sleep(2000);
         WebElement name = driver.findElement(By.cssSelector("#name"));
         name.sendKeys("Bagi");
         WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
         email.sendKeys("baagiisd@gmail.com");
         WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
         password.sendKeys("123456789");
         WebElement company = driver.findElement(By.cssSelector("#company"));
         company.sendKeys("CodeFish");
         WebElement website = driver.findElement(By.cssSelector("#websitename"));
         website.sendKeys("www.codefish.com");
         WebElement allCountries = driver.findElement(By.xpath("//select[@name='country']"));
         Select country = new Select(allCountries);
         country.selectByVisibleText("Mongolia");
         WebElement city = driver.findElement(By.cssSelector("#inputCity"));
         city.sendKeys("Chicago");
         WebElement address1 = driver.findElement(By.cssSelector("#inputAddress1"));
         address1.sendKeys("1234 main st");
         WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
         address2.sendKeys("5678 main st");
         WebElement state = driver.findElement(By.cssSelector("#inputState"));
         state.sendKeys("Illinois");
         WebElement zipCode = driver.findElement(By.cssSelector("#inputZip"));
         zipCode.sendKeys("12345");
         WebElement submitButton = driver.findElement(By.xpath("//button[.='Submit']"));
         submitButton.click();
         Thread.sleep(2000);
         WebElement text = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting')]"));
         String actualText = text.getText().trim();
         String expectedText = "Thanks for contacting us, we will get back to you shortly.";
         Assert.assertEquals(actualText,expectedText);



     }
}
