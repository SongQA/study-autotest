package mobile.utilities

import io.appium.java_client.AppiumDriver
import io.appium.java_client.AppiumFluentWait
import io.appium.java_client.AppiumFluentWait.IterationInfo
import mobile.driver.DriverManager
import org.openqa.selenium.WebElement
import java.time.Duration
import java.util.function.Function
import mobile.data.WaitTime
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.TimeoutException

interface WaitUtil {

    fun wait(seconds: Int): AppiumFluentWait<AppiumDriver> {
        val pollingStrategy = Function { info: IterationInfo ->
            Duration.ofMillis(
                if (info.number < 4) (4 - info.number) * 100 else info.interval.toMillis()
            )
        }
        val appiumFluentWait = AppiumFluentWait(DriverManager.getDriver())
        return appiumFluentWait.withPollingStrategy(pollingStrategy)
            .withTimeout(Duration.ofSeconds(seconds.toLong()))
            .pollingEvery(Duration.ofMillis(100))
            .ignoreAll(
                listOf(
                    StaleElementReferenceException::class.java,
                    NoSuchElementException::class.java,
                    TimeoutException::class.java,
                )
            )
            as AppiumFluentWait<AppiumDriver>
    }

    fun waitForElementVisible( vararg element: WebElement, waitTime: Int = WaitTime.WAIT_DEFAULT): Boolean {
        return wait(waitTime).until {
            element.all {
                println("Wait element: $it")
                it.isDisplayed
            }
        }
    }

    fun waitForSpecificTime(waitTime: Int = WaitTime.WAIT_DEFAULT) {
        Thread.sleep(waitTime.toLong())
    }
}
