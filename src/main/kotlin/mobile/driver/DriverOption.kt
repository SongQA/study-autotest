package mobile.driver

import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.ios.options.XCUITestOptions
import java.time.Duration

object DriverOption {

    fun setAndroidOptions(): UiAutomator2Options {
        return UiAutomator2Options().apply {
            setPlatformVersion("14.0")
            setDeviceName("Pixel 8 Pro API 34")
            setUdid("emulator-5554")
            setApp("${System.getProperty("user.dir")}/src/main/resources/VeriNative.apk")
            setEnsureWebviewsHavePages(true)
            setNativeWebScreenshot(true)
            setNewCommandTimeout(Duration.ofMillis(3600))
            setCapability("connectHardwareKeyboard", false)
            setCapability("disableIdLocatorAutocompletion", true)
        }
    }

    fun setIOSOptions(): XCUITestOptions {
        return XCUITestOptions().apply {
            setPlatformVersion("17.5")
            setUdid("1F669193-7A3A-401C-8BFE-7101F0DE7471")
            setApp("${System.getProperty("user.dir")}/src/main/resources/VeriNative.app")
            setIncludeSafariInWebviews(true)
            setNewCommandTimeout(Duration.ofMillis(3600))
            setCapability("connectHardwareKeyboard", false)
        }
    }
}
