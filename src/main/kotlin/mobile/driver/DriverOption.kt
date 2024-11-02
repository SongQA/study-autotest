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
            setUdid("FECC038C-D475-4467-B3AC-39221CEBE2C6")
            setApp("${System.getProperty("user.dir")}/src/main/resources/VeriNative.app")
            setIncludeSafariInWebviews(true)
            setNewCommandTimeout(Duration.ofMillis(3600))
            setCapability("connectHardwareKeyboard", false)
        }
    }
}
