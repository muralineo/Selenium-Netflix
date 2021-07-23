package com.netflix;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NetflixTest {
    // Creates the ChromeDriver object
    ChromeDriver driver;
    // website address to be tested
    String url = "https://www.netflix.com/browse";
    String userID = ""; // Enter your userId of Netflix
    String password = ""; // Enter your password

    //This method opens the website
    @org.testng.annotations.Test(priority = 0)
    public void invokeBrowser(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mural\\IdeaProjects\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    // Verifies the title of the page displayed at the tab of the browser
    @org.testng.annotations.Test(priority = 1)
    public void verifyTheTitleOfThePage(){

        String expectedTitle = "Netflix";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    // Signups into the Netflix page
    @Test(priority = 2)
    public void signIn(){
        driver.findElement(By.name("userLoginId")).sendKeys(userID);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn login-button btn-submit btn-small']")).click();

    }

    // Selects the profile and play "The Man from U.N.C.L.E movie"
    @Test(priority = 3)
    public void profileSelection(){
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver,30);
        // I have four profiles in my Netflix page. So in Xpath, I've put 4 meaning that it will select the 4th profile
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[4]")));
        // click on the compose button as soon as the "compose" button is visible
        driver.findElement(By.xpath("//ul/li[4]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://occ-0-2484-3662.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUVcmApHj_khyriBHUgraZctENUT6ks9VsC6UfYx17HZecXr9eriIxdRlTRwpnnic6HQrAyg_YkkjsZsvbA3qi4mRR8.webp?r=72f']")));
        // click on the compose button as soon as the "compose" button is visible
        driver.findElement(By.xpath("//img[@src='https://occ-0-2484-3662.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUVcmApHj_khyriBHUgraZctENUT6ks9VsC6UfYx17HZecXr9eriIxdRlTRwpnnic6HQrAyg_YkkjsZsvbA3qi4mRR8.webp?r=72f']")).click();
        driver.findElement(By.linkText("Play")).click();
    }



}
