package mobile.androidapp.apidemos.pageobjects;

import static com.diconium.qa.testautomationframework.common.Logger.logInfo;
import static mobile.androidapp.common.AndroidFactory.appiumDriver;
import static mobile.utils.MobileUtils.clickMobileElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.androidapp.common.AndroidUtilities;
import org.openqa.selenium.support.PageFactory;

public class ControlsPage {

  public ControlsPage() {
    PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
  }

  @AndroidFindBy(accessibility = "1. Light Theme")
  public MobileElement LIGHT_THEME;

  @AndroidFindBy(accessibility = "2. Dark Theme")
  public MobileElement DARK_THEME;


  private final AndroidUtilities androidUtilities = new AndroidUtilities();


  public void clickLightTheme() {
    logInfo("Click on Light theme");
    clickMobileElement(LIGHT_THEME);
  }

  public void clickDarkTheme() {
    logInfo("Click on Dark theme");
    clickMobileElement(DARK_THEME);
  }

}
