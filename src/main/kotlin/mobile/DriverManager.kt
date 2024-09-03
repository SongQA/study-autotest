package mobile

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.options.BaseOptions
import java.net.MalformedURLException
import java.net.URL

object DriverManager {

    private lateinit var driver: AppiumDriver

    enum class Platform {
        ANDROID, IOS
    }

    // 플랫폼에 따라 드라이버 생성
    fun createDriver(platform: Platform): AppiumDriver {
        driver = when (platform) {
            Platform.ANDROID -> createAndroidDriver()
            Platform.IOS -> createIOSDriver()
        }

        return driver
    }

    // Android 드라이버 생성
    private fun createAndroidDriver(): AndroidDriver {
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

        return AndroidDriver(getUrl(), options)
    }

    // iOS 드라이버 생성
    private fun createIOSDriver(): IOSDriver {
        val options = BaseOptions()
            .amend("platformName", "iOS")
            .amend("appium:platformVersion", "17.5")
            .amend("appium:automationName", "XCuiTest")
            .amend("appium:udid", "1F669193-7A3A-401C-8BFE-7101F0DE7471")
            .amend("appium:app", "/Users/eck.song92/Downloads/TestApp.app")
            .amend("appium:includeSafariInWebviews", true)
            .amend("appium:newCommandTimeout", 3600)
            .amend("appium:connectHardwareKeyboard", true)

        return IOSDriver(getUrl(), options)
    }

    // 드라이버 가져오기
    fun getDriver(): AppiumDriver {
        return driver
    }

    // 드라이버 종료
    fun quitDriver() {
        driver.quit()
    }

    private fun getUrl(): URL {
        return try {
            URL("http://127.0.0.1:4723")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid URL")
        }
    }
}