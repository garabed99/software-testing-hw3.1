import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Acer\\AUA\\4th Year\\2nd Semester\\Software Testing\\chromedriver.exe");
//        getSearchElement();
        getCareersElement();
//        getHacksBlogElement();
//        getReferencesJSElement();
    }

    public static void getSearchElement() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"hp-search-q\"]"));
        searchInput.sendKeys(".reduce()");
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(1500);

        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/ul/li[1]/h3/a"));
        firstResult.click();
    }

    public static void getCareersElement() throws InterruptedException {
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();

        //select Careers from footer
        js.executeScript("document.querySelector(\"#nav-footer > div > div.page-footer-nav-col-1 > ul > li:nth-child(3) > a\").click();");

        //this resize of page isnt working
//        WebElement html = driver.findElement(By.tagName("html"));
//        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
//        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

//        Thread.sleep(1500);

            //select location in list
//        Select location = new Select(driver.findElement(By.xpath("//*[@id=\"listings-filters\"]/div[1]")));
//        location.selectByValue("Berlin Office");

        //TODO: Find careers in Berlin Location

//        WebElement locations = driver.findElement(By.xpath("//*[@id=\"id_location\"]"));
//        locations.click();
//
//        WebElement berlin = driver.findElement(By.xpath("//*[@id=\"id_location\"]/option[3]"));
//        berlin.click();
    }

    public static void getHacksBlogElement() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();

        //open hacks blog page
        WebElement hacksBlog = driver.findElement(By.cssSelector("#nav-footer > div > div.page-footer-nav-col-1 > ul > li:nth-child(2) > a"));
        hacksBlog.click();
        Thread.sleep(3500);

        //write and in the search bar
        WebElement searchInput = driver.findElement(By.xpath("/html/body/div/header/div/div[2]/form/input"));
        searchInput.sendKeys("javascript");
        searchInput.sendKeys(Keys.ENTER);

        //"attempt": open first article from results
        WebElement firstBlog = driver.findElement(By.cssSelector("#content-main > ul > li:nth-child(1) > div > h3 > a"));
        firstBlog.click();
    }

    public static void getReferencesJSElement() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();
        // Locating the Main Menu (Parent element)
        WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[2]/nav/ul/li[1]/a"));

//Instantiating Actions class
        Actions actions = new Actions(driver);

//Hovering on main menu
        actions.moveToElement(mainMenu);

// Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[2]/nav/ul/li[1]/ul/li[4]/a"));

//To mouseover on sub menu
        actions.moveToElement(subMenu);

//build()- used to compile all the actions into a single step
        actions.click().build().perform();
    }
}
