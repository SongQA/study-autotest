package mobile

import mobile.driver.DriverManager
import mobile.driver.DriverManager.createDriver
import mobile.driver.DriverManager.quitDriver
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass

interface TestBase : ActionUtil, WaitUtil {

    @BeforeClass
    fun setUp() {
        createDriver(DriverManager.Platform.IOS) // or DriverManager.Platform.ANDROID
        println("Setting up the test")
    }

    @AfterClass
    fun tearDown() {
        quitDriver()
        println("Tearing down the test")
    }
}