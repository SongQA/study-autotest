package mobile.utilities

import mobile.driver.DriverManager
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration
import kotlin.io.println

interface ActionUtil : WaitUtil {

    /**
     * Tap Action
     */
    fun tap(element: WebElement) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val tapSequence = Sequence(finger, 0)

        val location = element.location
        val size = element.size
        val centerX = location.x + size.width / 2
        val centerY = location.y + size.height / 2

        tapSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

        DriverManager.getDriver().perform(listOf(tapSequence))
        println("Tap element: $element")
    }

    fun forceTap(element: WebElement) {
        element.click()
        println("Force Tap element: $element")
    }

    fun doubleTap(element: WebElement) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val tapSequence = Sequence(finger, 0)

        val location = element.location
        val size = element.size
        val centerX = location.x + size.width / 2
        val centerY = location.y + size.height / 2

        tapSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

        tapSequence.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), centerX, centerY))
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

        try {
            DriverManager.getDriver().perform(listOf(tapSequence))
            println("Double tap element: $element")
        } catch (e: Exception) {
            println("Double tap failed: $element")
        }
        println("Tap element: $element")
    }

    fun longTap(element: WebElement, duration: Long) {

        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val tapSequence = Sequence(finger, 0)

        val location = element.location
        val size = element.size
        val centerX = location.x + size.width / 2
        val centerY = location.y + size.height / 2

        tapSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        tapSequence.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), centerX, centerY))
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

        DriverManager.getDriver().perform(listOf(tapSequence))
        println("Tap element: $element")
    }

    fun type(element: WebElement, text: String, clear: Boolean = true) {
        if (clear) element.clear()
        element.sendKeys(text)
        println("Typing text: $text to element: $element")
    }
}
