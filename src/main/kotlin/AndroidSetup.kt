import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.options.BaseOptions
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL

class AndroidSetup {

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
        driver.findElement(AppiumBy.xpath("//*[@text='App']")).click()
        driver.findElement(AppiumBy.xpath("//*[@text='Activity']")).click()
        driver.findElement(AppiumBy.xpath("//*[@text='Custom Title']")).click()

        driver.findElement(AppiumBy.id("left_text_edit")).clear()
        driver.findElement(AppiumBy.id("left_text_edit")).sendKeys("Hello, World!")
        driver.findElement(AppiumBy.id("left_text_button")).click()
        assert(driver.findElement(AppiumBy.id("left_text")).text == "Hello, World!")

        driver.findElement(AppiumBy.id("right_text_edit")).clear()
        driver.findElement(AppiumBy.id("right_text_edit")).sendKeys("Hello, World!")
        driver.findElement(AppiumBy.id("right_text_button")).click()
        assert(driver.findElement(AppiumBy.id("right_text")).text == "Hello, World!")
    }

    @AfterMethod
    fun tearDown() {
        driver.quit()
    }
}
