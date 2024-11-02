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
                )
            )
            as AppiumFluentWait<AppiumDriver>
    }

    fun waitForElementVisible( vararg element: WebElement, waitTime: Int = WaitTime.WAIT_DEFAULT): Boolean {
        var result = false

        try {
            result = wait(waitTime).until {
                element.all {
                    println("Wait Element Until Appear: $it")
                    it.isDisplayed
                }
            }
        } catch (e: TimeoutException) {
            result = false
        }

        return result
    }

    fun waitForElementNotVisible( vararg element: WebElement, waitTime: Int = WaitTime.WAIT_DEFAULT): Boolean {
        var result = false

        run repeatBlock@ {
            repeat(10) {
                try {
                    element.all {
                        println("Wait Element Until Disappear: $it")
                        it.isDisplayed
                    }
                } catch (e: Exception) {
                    result = true
                    return@repeatBlock
                }
                Thread.sleep(WaitTime.WAIT_RETRY.toLong())
            }
        }

        return result
    }
}
