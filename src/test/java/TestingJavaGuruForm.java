import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tatiana on 31.03.2017.
 */

public class TestingJavaGuruForm {
    @Test
    public void JavaGuruTest() throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:/server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://javaguru.lv");
        WorkWithFiles log = new WorkWithFiles();
        MyDateFormat now = new MyDateFormat();
        String date = now.getDateInShortFormat();
        String fileName = "D://test.txt";
        String textString = date + "\r\n" + driver.getTitle()+ "\r\n";
        WebElement linkPage = driver.findElement(By.linkText("Курс Тестирования(QA)"));
        linkPage.click();
        WebElement linkReg = driver.findElement(By.linkText("Регистрация на курс"));
        linkReg.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        textString = textString + driver.getTitle() + "\r\n";
        String[][] parametrs = {
                {"entry_1000000", "Вася"},
                {"entry_1000001", "Пупкин"},
                {"entry_1000002", "+371 2500 50 50"},
                {"entry_1000003", "ant@bk.ru"},
                {"group_738971122_1", ""},
                {"entry_1000004", "HTML, CSS, MySQL"},
                {"group_1887084786_1", ""},
                {"entry_1696450117", "друг"},
                {"entry_1000006", "Хочу ходить на курсы утром"},
                {"entry_1091055623", "157895"}
        };

        for(int k=0; k<parametrs.length; k++){
            if (parametrs[k][1] != "") {
                WebElement id = driver.findElement(By.id(parametrs[k][0]));
                id.sendKeys(parametrs[k][1]);
                textString = textString + (parametrs[k][0]) + ": " + parametrs[k][1] + "\r\n";
            } else {
                WebElement id = driver.findElement(By.id(parametrs[k][0]));
                id.click();
                textString = textString + (parametrs[k][0]) + ": click\r\n";
            }
        }
        WebElement submitForm = driver.findElement(By.id("ss-submit"));
        submitForm.submit();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        textString = textString + driver.getTitle() + "\r\n" + "\r\n";
        log.write(fileName, textString);
        driver.quit();
        log.read(fileName);
    }
}