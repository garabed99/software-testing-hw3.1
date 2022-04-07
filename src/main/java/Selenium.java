import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium {
    public static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","util/chromedriver.exe");
        getSearchElement();
        getCareersElement();
        getHacksBlogElement();
        getReferencesJSElement();
        getChangeThemeElement();
    }

    public static void getSearchElement() {
        driver = new ChromeDriver();
        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.id("top-nav-search-q"));
        searchInput.sendKeys(".reduce()");
        searchInput.sendKeys(Keys.ENTER);

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //opens first result
        driver.findElement(By.cssSelector("#content > div.search-results > ul > li:nth-child(1) > h3 > a")).click();
    }

    public static void getCareersElement() {
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();

        //select Careers from footer
        js.executeScript("document.querySelector(\"#nav-footer > div > div.page-footer-nav-col-1 > ul > li:nth-child(3) > a\").click();");

        //switch driver into the new tab
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //Find careers in Berlin Location
        WebElement locations = driver.findElement(By.xpath("//*[@id=\"id_location\"]"));
        locations.click();

        //select location in list
        WebElement berlin = driver.findElement(By.xpath("//*[@id=\"id_location\"]/option[2]"));
        berlin.click();
    }

    public static void getHacksBlogElement() {
        driver = new ChromeDriver();
        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();
        driver.getWindowHandle();

        //open hacks blog page
        WebElement hacksBlog = driver.findElement(By.cssSelector("#nav-footer > div > div.page-footer-nav-col-1 > ul > li:nth-child(2) > a"));
        hacksBlog.click();

        //switch driver into the new tab
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //write and in the search bar of 2nd page
        WebElement searchInput = driver.findElement(By.xpath("/html/body/div/header/div/div[2]/form/input"));
        searchInput.sendKeys("javascript");
        searchInput.sendKeys(Keys.ENTER);

        //"attempt": open first article from results
        WebElement firstBlog = driver.findElement(By.cssSelector("#content-main > ul > li:nth-child(1) > div > h3 > a"));
        firstBlog.click();
    }

    public static void getReferencesJSElement() {
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
    public static void getChangeThemeElement() {
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://developer.mozilla.org/en-US/");
        driver.manage().window().maximize();

        WebElement themeButton = driver.findElement(By.className("theme-switcher-menu"));
        themeButton.click();
        js.executeScript("document.querySelector(\"#root > div > header > div > div.top-navigation-main > div.theme-switcher-menu > ul > li:nth-child(2) > button\").click();");


    }
}
