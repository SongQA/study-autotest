package mobile.utilities

import mobile.data.Direction
import mobile.data.Direction.*
import mobile.driver.DriverManager
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration
import kotlin.io.println

interface ActionUtil : WaitUtil {

    companion object {
        val screenWidth = DriverManager.getDriver().manage().window().size.width
        val screenHeight = DriverManager.getDriver().manage().window().size.height
    }

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

    /**
     * Swipe Action
     */
    private fun swipe(
        startX: Int,
        endX: Int,
        startY: Int,
        endY: Int
    ) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val swipeActionSequence = Sequence(finger, 1)
        swipeActionSequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
        swipeActionSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        swipeActionSequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY))
        swipeActionSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
        DriverManager.getDriver().perform(listOf(swipeActionSequence))
    }

    fun swipeScreen(
        startX: Double?,
        endX: Double?,
        startY: Double?,
        endY: Double?
    ) {
        val startXPosition = (startX!! * screenWidth).toInt()
        val endXPosition = (endX!! * screenWidth).toInt()
        val startYPosition = (startY!! * screenHeight).toInt()
        val endYPosition = (endY!! * screenHeight).toInt()
        swipe(startXPosition, endXPosition, startYPosition, endYPosition)
    }

    fun swipeScreen(direction: Direction, short: Boolean = false) {
        when (direction) {
            LEFT -> when (short) {
                false -> swipeScreen(0.85, 0.15, 0.7, 0.3)
                true -> swipeScreen(0.7, 0.3, 0.7, 0.3)
            }
            RIGHT -> when (short) {
                false -> swipeScreen(0.15, 0.85, 0.7, 0.3)
                true -> swipeScreen(0.3, 0.7, 0.7, 0.3)
            }
            UP -> when (short) {
                false -> swipeScreen(0.5, 0.5, 0.85, 0.15)
                true -> swipeScreen(0.5, 0.5, 0.7, 0.3)
            }
            DOWN -> when (short) {
                false -> swipeScreen(0.5, 0.5, 0.15, 0.85)
                true -> swipeScreen(0.5, 0.5, 0.3, 0.7)
            }
        }
    }
}
