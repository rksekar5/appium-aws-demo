package mobile.androidapp.common;

import com.diconium.qa.testautomationframework.common.RetryListener;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners({RetryListener.class})
public class AndroidBaseTest extends AndroidFactory {

  @SneakyThrows
  @BeforeMethod(alwaysRun = true)
  protected void setUpAndroidApp(ITestContext result) {
    service = startServer();

    appiumDriver = androidCapabilities("android_demo_app");
    appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod(alwaysRun = true)
  protected void tearDown(ITestResult testResult) {
    appiumDriver.closeApp();
    removeAppFromDevice();
    service.stop();
  }

  private void removeAppFromDevice() {
    if (appiumDriver.isAppInstalled(readValueFromMobileConfigFile("android_package_name")))
      log.debug("Uninstalling the app as part of cleanup");
    appiumDriver.removeApp(readValueFromMobileConfigFile("android_package_name"));
  }
}
