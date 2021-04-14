import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CargodomTest {

    @BeforeClass
    public static void beforeClass() {
        CargodomSetup.setup();
    }

    @Test (priority = 1)
    public static void testForVerifyingThatHomePageIsOpened() {
        Assert.assertEquals(CargodomSetup.navigateToCargodom(), "http://138.201.81.153:9095/");
    }

    @Test (priority = 2)
    public static void testForVerifyingThatLanguageIsChanged() {
        Assert.assertEquals(CargodomSetup.changeLanguage(), "Clever way to find transporter");

    }

    @Test (priority = 3)
    public static void testForVerifyingThatClientIsCreated() {
        Assert.assertEquals(CargodomSetup.registerLookingForTransporter(), "Your account was successfully created! Please check your e-mail to activate your account.");
    }

    @Test (priority = 4)
    public static void testForVerifyingThatClientIsSignedIn() {
        Assert.assertEquals(CargodomSetup.signInClient(), "FirstName LastName");
    }

    @Test (priority = 5)
    public static void testForVerifyingThatClientRequestIsCreated() {
        Assert.assertEquals(CargodomSetup.clientCreateRequest(), "Motorbike");
    }

    @Test (priority = 6)
    public  static void testForVerifyingThatClientIsSignedOut() {
        Assert.assertEquals(CargodomSetup.signOut(),"http://138.201.81.153:9095/");
    }

    @Test (priority = 7)
    public static void testForVerifyingThatTransporterIsCreated() {
        Assert.assertEquals(CargodomSetup.registerIAmTransporter(),"Your account was successfully created! Please check your e-mail to activate your account.");
    }

    @Test (priority = 8)
    public static void testForVerifyingThatTransporterIsSignedIn() {
        Assert.assertEquals(CargodomSetup.signInTransporter(), "FAST TRANSPORT");
    }

    @Test (priority = 9)
    public static void testForVerifyingThatTransporterFindRequestAndMadeAnOffer() {
        Assert.assertEquals(CargodomSetup.transporterSearchActiveRequestsAndMakeAnOffer(), "Offers for the request");
    }

    @Test (priority = 10)
    public static void testForVerifyingThatTransporterIsSignedOut() {
        Assert.assertEquals(CargodomSetup.signOut(),"http://138.201.81.153:9095/");
    }

    @Test (priority = 11)
    public static void testForVerifyingThatClientIsSignedInAgain() {
        Assert.assertEquals(CargodomSetup.signInClient(),"FirstName LastName");
    }

    @Test (priority = 12)
    public static void testForVerifyingThatOfferForTheRequestIsAcceptedByClient() {
        Assert.assertEquals(CargodomSetup.clientAcceptOfferForHisRequest(), "FINISHED");
    }

    @AfterClass
    public static void afterClass(){
        CargodomSetup.end();
    }
    
}
