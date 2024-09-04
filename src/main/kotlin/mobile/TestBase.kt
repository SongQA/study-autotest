package mobile

import mobile.DriverManager.createDriver
import mobile.DriverManager.quitDriver
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