import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CargodomSetup {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static String email1;
    public static String password1;

    public static String email2;
    public static String password2;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-88.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60);
        driver.manage().window().maximize();

        }

    public static String navigateToCargodom(){

        driver.get("http://138.201.81.153:9095/");
        return driver.getCurrentUrl();

    }

    public static String changeLanguage() {

        WebElement languageBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[1]/a/span/span"));
        languageBtn.click();

        WebElement languageEnglishBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[1]/ul/li[1]/a"));
        languageEnglishBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement confirmationMessage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/h1"));
        return confirmationMessage.getText();
    }

    public static String registerLookingForTransporter(){

        WebElement registerBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a/span"));
        registerBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement iAmLookingForTransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[1]/button"));
        iAmLookingForTransporterBtn.click();

        WebElement clientTypeDdl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[1]/div[2]/select"));
        clientTypeDdl.click();
        clientTypeDdl.sendKeys(Keys.ENTER);

        WebElement firstNameTxt = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameTxt.sendKeys("FirstName");

        WebElement lastNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[4]/div[2]/input"));
        lastNameTxt.sendKeys("LastName");

        WebElement addressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[1]/div[2]/input"));
        addressTxt.sendKeys("Blvd Jane Sandanski no.1");

        WebElement cityTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div[2]/input"));
        cityTxt.sendKeys("Skopje");

        WebElement postalCodeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[5]/div[2]/input"));
        postalCodeTxt.sendKeys("1000");

        WebElement countryDdl = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/div[1]/span"));
        countryDdl.click();

        WebElement countryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/input[1]"));
        countryTxt.sendKeys("Macedonia");
        countryTxt.sendKeys(Keys.ENTER);

        WebElement phoneNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/input"));
        phoneNumberTxt.sendKeys("+38970223305");

        WebElement eMailTxt = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email1 = "kirekirca" + new Random().nextInt(10000) + "@gmail.com";
        eMailTxt.sendKeys(email1);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password1 = "kire1234";
        passwordTxt.sendKeys(password1);

        WebElement passwordConfirmationTxt = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
        passwordConfirmationTxt.sendKeys(password1);

        WebElement termsOfUseAndPrivacyPolicyCb = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
        termsOfUseAndPrivacyPolicyCb.click();

        WebElement registerClientBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/input"));
        registerClientBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement confirmationMessage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/h3"));
        return confirmationMessage.getText();

    }

    public static String signInClient() {

        WebElement signInBtn1 = driver.findElement(By.xpath("//*[@id=\"login\"]/span[2]"));
        signInBtn1.click();

        WebElement usernameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        usernameTxt.sendKeys(email1);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTxt.sendKeys(password1);

        WebElement rememberMeCb = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/div[3]/label/input"));
        rememberMeCb.click();

        WebElement signInBtn2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        signInBtn2.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement confirmationMesage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/div/h3"));
        return confirmationMesage.getText();

    }

    public static String clientCreateRequest() {

        WebElement createRequestBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a/span[2]"));
        createRequestBtn.click();

        WebElement titleTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input"));
        titleTxt.sendKeys("Motorbike");

        WebElement categoryBtn = driver.findElement(By.xpath("//*[@id=\"field_y\"]"));
        categoryBtn.click();
        Select categoryDdl = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
        categoryDdl.selectByVisibleText("Motorbike");

        WebElement pickUpTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
        pickUpTxt.sendKeys("Skopje");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pickUpTxt.sendKeys(Keys.ARROW_DOWN);
        pickUpTxt.sendKeys(Keys.ENTER);

        WebElement deliveryTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
        deliveryTxt.sendKeys("Chicago");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deliveryTxt.sendKeys(Keys.ARROW_DOWN);
        deliveryTxt.sendKeys(Keys.ENTER);

        WebElement setPickUpDateCb = driver.findElement(By.xpath("//*[@id=\"setPickUpDate\"]"));
        setPickUpDateCb.click();

        WebElement earliestPickUpDateTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[1]/input"));
        earliestPickUpDateTxt.sendKeys("01.03.2022");

        WebElement latestPickUpDateTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[7]/div[2]/input"));
        latestPickUpDateTxt.sendKeys("05.03.2022");

        WebElement setDeliveryDateCb = driver.findElement(By.xpath("//*[@id=\"setDeliveryUpDate\"]"));
        setDeliveryDateCb.click();

        WebElement earliestDeliveryDateTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[1]/input"));
        earliestDeliveryDateTxt.sendKeys("10.03.2022");

        WebElement latsestDeliveryDateTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[9]/div[2]/input"));
        latsestDeliveryDateTxt.sendKeys("15.03.2022");

        WebElement itemMakeTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[2]/div[2]/input"));
        itemMakeTxt.sendKeys("BMW");

        WebElement itemModelTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[3]/div[2]/input"));
        itemModelTxt.sendKeys("1000");

        WebElement itemYearTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[4]/div[2]/input"));
        itemYearTxt.sendKeys("2021");

        WebElement cashOnPickUpCb = driver.findElement(By.xpath("//*[@id=\"cachePickup\"]"));
        cashOnPickUpCb.click();

        WebElement submitRequestBtn = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[14]/input"));
        submitRequestBtn.click();

        WebElement confirmationMessage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr/td[1]/a"));
        return confirmationMessage.getText();

    }

    public static String signOut() {

        WebElement signOutBtn = driver.findElement(By.xpath("//*[@id=\"logout2\"]/span"));
        signOutBtn.click();

        return driver.getCurrentUrl();
    }

    public static String registerIAmTransporter() {

        WebElement registerBtn = driver.findElement(By.xpath("/html/body/div[1]/nav/div[3]/ul/li[3]/a/span"));
        registerBtn.click();

        WebElement iAmTransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/button"));
        iAmTransporterBtn.click();

        WebElement firstNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[1]/div[2]/input"));
        firstNameTxt.sendKeys("First Name");

        WebElement lastNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/input"));
        lastNameTxt.sendKeys("Last Name");

        WebElement companyNameTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[5]/div[2]/input"));
        companyNameTxt.sendKeys("FAST TRANSPORT");

        WebElement addressTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[7]/div[2]/input"));
        addressTxt.sendKeys("Blvd. Partizanski Odredi No.2");

        WebElement cityTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[9]/div[2]/input"));
        cityTxt.sendKeys("Skopje");

        WebElement postalCode = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[11]/div[2]/input"));
        postalCode.sendKeys("1000");

        WebElement countryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/div[1]/span"));
        countryBtn.click();
        WebElement countryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/input[1]"));
        countryTxt.sendKeys("Macedonia");
        countryTxt.sendKeys(Keys.ENTER);

        WebElement taxNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[15]/div[2]/input"));
        taxNumberTxt.sendKeys("25895784125658");

        WebElement phoneNumberTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[16]/div[2]/input"));
        phoneNumberTxt.sendKeys("0038970223305");

        WebElement eMailTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[2]/div[2]/input"));
        email2 = "kirekirca" + new Random().nextInt(10000) + "@gmail.com";
        eMailTxt.sendKeys(email2);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password2 = "kire4321";
        passwordTxt.sendKeys(password2);

        WebElement passwordConfirmation = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
        passwordConfirmation.sendKeys(password2);

        WebElement termsOfUseAndPrivacyPolicyCb = driver.findElement(By.xpath("//*[@id=\"acceptTerms\"]"));
        termsOfUseAndPrivacyPolicyCb.click();

        WebElement registerTransporterBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/form/div[10]/input"));
        registerTransporterBtn.click();

        WebElement confirmationMessage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/h3"));
        return confirmationMessage.getText();

    }

    public static String signInTransporter() {

        WebElement signInBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/span[2]"));
        signInBtn.click();

        WebElement usernameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        usernameTxt.sendKeys(email2);

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTxt.sendKeys(password2);

        WebElement signInTransporterBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        signInTransporterBtn.click();

        WebElement confirmationMessage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div[1]/div[1]/div[2]/h4"));
        return confirmationMessage.getText();

    }

    public static String transporterSearchActiveRequestsAndMakeAnOffer() {

        WebElement fromCountryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[1]/country-selector/div/div[1]/span"));
        fromCountryBtn.click();

        WebElement fromCountryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[1]/country-selector/div/input[1]"));
        fromCountryTxt.sendKeys("Macedonia");
        fromCountryTxt.sendKeys(Keys.ENTER);

        WebElement toCountryBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[2]/country-selector/div/div[1]/span"));
        toCountryBtn.click();

        WebElement toCountryTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[2]/div[1]/div/div[2]/country-selector/div/input[1]"));
        toCountryTxt.sendKeys("United States");
        toCountryTxt.sendKeys(Keys.ENTER);

        WebElement categoryBtn = driver.findElement(By.xpath("//*[@id=\"field_y\"]"));
        categoryBtn.click();
        Select categoryDdl = new Select(driver.findElement(By.xpath("//*[@id=\"field_y\"]")));
        categoryDdl.selectByVisibleText("Motorbike");

        WebElement searchBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[1]/div[2]/request-search/div/div/div[3]/a/span[2]"));
        searchBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement motorbikeBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/request-search-list/div[2]/request-list/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"));
        motorbikeBtn.click();

        WebElement createOfferBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/button"));
        createOfferBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement priceTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[2]/div[2]/table/tbody/tr/td[5]/input"));
        priceTxt.sendKeys("2000");

        WebElement pickUpTimeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[1]/input"));
        pickUpTimeTxt.sendKeys("03.03.2022 01:00");
        pickUpTimeTxt.sendKeys(Keys.ENTER);

        WebElement deliveryTimeTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[2]/input"));
        deliveryTimeTxt.sendKeys("10.03.2022 03:00");
        deliveryTimeTxt.sendKeys(Keys.ENTER);

        WebElement offerIsValidUntilTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[3]/input"));
        offerIsValidUntilTxt.sendKeys("02.03.2022 00:00");
        offerIsValidUntilTxt.sendKeys(Keys.ENTER);

        WebElement cancelBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[2]"));
        cancelBtn.click();

        WebElement insuranceBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[4]/select"));
        insuranceBtn.click();
        Select insuranceDdl = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[4]/select")));
        insuranceDdl.selectByVisibleText("5.000 EUR");

        WebElement messageToTheClientTxt = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[2]/div/textarea"));
        messageToTheClientTxt.sendKeys("For any further information please contact me. Best regards.");

        WebElement createOfferBtn1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/div/div[5]/button"));
        createOfferBtn1.click();

        WebElement createOfferBtn2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
        createOfferBtn2.click();

        WebElement confirmationMessage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[6]/div[1]/div/h2"));
        return confirmationMessage.getText();

    }

    public static String clientAcceptOfferForHisRequest() {

        WebElement myRequestsBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[4]/a/span[2]"));
        myRequestsBtn.click();

        WebElement motorbikeBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr/td[1]/a"));
        motorbikeBtn.click();

        WebElement moreBtn = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div[2]/div/div[8]/a"));
        moreBtn.click();

        WebElement offerOneRadioBtn = driver.findElement(By.xpath("//*[@id=\"offer0\"]"));
        offerOneRadioBtn.click();

        WebElement acceptBtn = driver.findElement(By.xpath("//*[@value='Accept']"));
        acceptBtn.click();

        WebElement confirmationMessage = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr/td[7]/div/span/span[4]"));
        return confirmationMessage.getText();
    }

    public static void end() {
        driver.quit();

        }


}

