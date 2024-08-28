import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.options.BaseOptions
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL

class SampleTest {

    private lateinit var driver: AndroidDriver

    @BeforeMethod
    fun setUp() {
        val options = BaseOptions()
            .amend("platformName", "Android")
            .amend("appium:platformVersion", "14.0")
            .amend("appium:deviceName", "Pixel 8 Pro API 34")
            .amend("appium:automationName", "UiAutomator2")
            .amend("appium:udid", "emulator-5554")
            .amend("appium:app", "/Users/eck.song92/Downloads/ApiDemos-debug.apk")
            .amend("appium:ensureWebviewsHavePages", true)
            .amend("appium:nativeWebScreenshot", true)
            .amend("appium:newCommandTimeout", 3600)
            .amend("appium:connectHardwareKeyboard", true)

        driver = AndroidDriver(getUrl(), options)
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
