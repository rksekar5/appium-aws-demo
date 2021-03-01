package mobile.iosapp.testapp;

import lombok.SneakyThrows;
import mobile.iosapp.common.IosBaseTest;
import mobile.iosapp.test_app.page_objects.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAppTestIos extends IosBaseTest {

  private HomePage homePage;

  @SneakyThrows
  @BeforeMethod
  public void setup() {
    homePage = new HomePage();
  }

  @Test
  public void testSendKeysToInput() {

    // Check that it doesn"t have a value
    String value = homePage.getTextFieldValue();
    Assert.assertNull(value);

    // Send keys to that input
    homePage.enterValueInTextField("Hello World!");

    // Check that the input has new value
    value = homePage.getTextFieldValue();
    Assert.assertEquals(value, "Hello World!");
  }

  @Test
  public void testOpenAndCloseAlert() {

    // Find Button element and click on it
    homePage.clickOnShowAlertButton();

    // Check the text
    String alertTitle = homePage.getTitleFromAlertBox();
    Assert.assertEquals(alertTitle, "Cool title");

    // Dismiss the alert
    homePage.clickOnOkButtonOnAlert();

    homePage.clickOnShowAlertButton();
    homePage.clickOnCancelButtonOnAlert();
  }
}
