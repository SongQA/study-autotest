import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.options.BaseOptions
import org.openqa.selenium.WebDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL
import java.time.Duration

class iOSSetup {

    private lateinit var driver: IOSDriver

    @BeforeMethod
    fun setUp() {
        val options = BaseOptions()
            .amend("platformName", "iOS")
            .amend("appium:platformVersion", "17.5")
            .amend("appium:automationName", "XCuiTest")
            .amend("appium:udid", "1F669193-7A3A-401C-8BFE-7101F0DE7471")
            .amend("appium:app", "/Users/eck.song92/Downloads/TestApp.app")
            .amend("appium:includeSafariInWebviews", true)
            .amend("appium:newCommandTimeout", 3600)
            .amend("appium:connectHardwareKeyboard", true)

        driver = IOSDriver(getUrl(), options)
    }

    private fun getUrl(): URL {
        return try {
            URL("http://127.0.0.1:4723")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid URL")
        }
    }

    @Test
    fun sampleTest() {
        Thread.sleep(10000)
    }

    @AfterMethod
    fun tearDown() {
        driver.quit()
    }
}