package mobile.base

import mobile.driver.DriverManager.quitDriver
import mobile.driver.DriverManager.setDriver
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Parameters

open class TestBase {

    companion object {
        lateinit var testPlatform: String
    }

    @BeforeTest(alwaysRun = true)
    @Parameters("platform")
    fun setUp(platform: String) {
        testPlatform = platform.lowercase()
        setDriver(platform)
    }

    @AfterMethod(alwaysRun = true)
    fun tearDownMethod(result: ITestResult) {
        if (listOf(ITestResult.FAILURE).contains(result.status)) {
            println(result.throwable.stackTraceToString())
        }
    }

    @AfterTest
    fun tearDown() {
        quitDriver()
        println("Tearing down the test")
    }
}
