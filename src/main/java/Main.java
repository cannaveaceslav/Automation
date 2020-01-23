import com.github.javafaker.Address;
import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;




public class Main {

    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker(new Locale("ru-RU"));
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String secondname = faker.name().firstName();
        Address placeOfBirth = faker.address();




        //-------------дата рождения
        Date date1 = faker.date().birthday(19, 70);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String birthday = sdf.format(date1);
        String email = "A3TM" + faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        int passport_seria = (int)(Math.random() * 9999);
        int passport_number = (int)(Math.random() * 999999);
        //long passport2 = (long) (Math.random() * 9999999999);
        String passport =String.valueOf(passport_seria) +String.valueOf(passport_number);
        System.out.println(passport);
        //////////////////////
        System.setProperty("webdriver.chrome.driver", "C:/vcanna/chromedriver.exe");
        //Podbor-kredita    STEP 1
        WebDriver driver = new ChromeDriver();
        driver.get("http://credithub.ru//");
        driver.manage().window().maximize();
        //Thread.sleep(1000);  // Let the user actually see something!
        //создаем переменную для закрытия всплывающих окон в подборе


        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/ul[1]/li[2]/a[1]")).click();//подбор кредита
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastname);//фамилия
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstname);//имя
        driver.findElement(By.xpath("//input[@id='father_name']")).sendKeys(secondname);//отчество
        driver.findElement(By.xpath("//input[@id='birth_date']")).sendKeys(birthday);//дата рождения
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("7977" + phone.substring(4));//телефон
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);//мыло
        //клик со смещением по чекбоксу
        WebElement checkbox1 = driver.findElement(By.xpath("//div[@class='simple-check form-group']"));
        Actions build = new Actions(driver);
        build.moveToElement(checkbox1, -100, 0).click().build().perform();
        driver.findElement(By.xpath("//button[@class='btn btn-1 btn_blue form-btn first-step-submit']")).click();//Продолжить
        //Podbor-kredita    STEP 2
        driver.findElement(By.xpath("//input[@id='user-passport_seria_number']")).sendKeys(passport);// паспорт "4444444444"
        driver.findElement(By.xpath("//input[@id='passport_subdivision_code']")).sendKeys("771001");// подразделение
        driver.findElement(By.xpath("//input[@id='passport_birth_place']")).sendKeys("Москва");// подразделение
        driver.findElement(By.xpath("//input[@id='user-passport_issued_at']")).sendKeys("05/05/2017");// дата выдачи паспорта
        driver.findElement(By.xpath("//input[@id='passport_issued_by']")).sendKeys("ГУВД Г. МОСКВЫ");// кем выданпаспорт
        driver.findElement(By.xpath("//input[@id='user-salary']")).sendKeys("50000");// ежемесячный доход
        driver.findElement(By.xpath("//input[@id='registration_region']")).sendKeys("г Москва");// адрес прописки регион
        driver.findElement(By.xpath("//input[@id='registration_city']")).sendKeys("г Москва");// город
        driver.findElement(By.xpath("//input[@id='registration_street']")).sendKeys("ул Некрасовская");// улица
        driver.findElement(By.xpath("//input[@id='registration_housenum']")).sendKeys("12");// номер дома
        driver.findElement(By.xpath("//button[@id='second-step-submit']")).submit();// продолжить
        //Podbor-kredita    STEP 3
        //создаем списк из всего списка UL из HTML и в цикле кликаем по каждому офферу
     driver.findElement(By.xpath("//button[@class='button button--info advice-block__button']")).click();// номер дома


        //Thread.sleep(3000);
        //WebElement exit = driver.findElement((By.className("//span[contains(text(),'×')]")));
        //exit.click();/*
    /* WebElement countryUL= driver.findElement(By.xpath("//section[1]//ul[1]"));
     List<WebElement> countriesList=countryUL.findElements(By.tagName("li"));
     for (WebElement li : countriesList) {
      if (li.getText().equals("Узнать решение")) {
       li.click();
      }
     }*/


     /*
        WebElement offersUL = driver.findElement(By.xpath("//section[1]//ul[1]"));
        List<WebElement> offersList = offersUL.findElements(By.tagName("li"));
        System.out.println(offersList.size());
        for (WebElement li : offersList) {
            li.click();
            Thread.sleep(3000);
            driver.findElement((By.className("//span[contains(text(),'×')]"))).click();
        }*/

    }
    //  driver.quit();
    //Thread.sleep(3000);
}

