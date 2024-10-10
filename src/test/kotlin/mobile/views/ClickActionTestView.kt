package mobile.views

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import mobile.base.BaseView
import mobile.base.TestBase.Companion.testPlatform
import mobile.common.ErrorMessages
import mobile.data.Platform.ANDROID
import mobile.data.Platform.IOS
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.openqa.selenium.WebElement

object ClickActionTestView : BaseView {

    init {
        initElements()
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Click Action Test']")
    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    private lateinit var viewTitle: WebElement

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='VeriNative']")
    private lateinit var backButton: WebElement

    @AndroidFindBy(id = "ClickButton")
    @iOSXCUITFindBy(accessibility = "ClickButton")
    private lateinit var clickButton: WebElement

    @AndroidFindBy(id = "ClickCount")
    @iOSXCUITFindBy(accessibility = "ClickCount")
    private lateinit var clickCount: WebElement

    @AndroidFindBy(id = "DoubleClickButton")
    @iOSXCUITFindBy(accessibility = "DoubleClickButton")
    private lateinit var doubleClickButton: WebElement

    @AndroidFindBy(id = "DoubleClickCount")
    @iOSXCUITFindBy(accessibility = "DoubleClickCount")
    private lateinit var doubleClickCount: WebElement

    @AndroidFindBy(id = "LongClickButton")
    @iOSXCUITFindBy(accessibility = "LongClickButton")
    private lateinit var longClickButton: WebElement

    @AndroidFindBy(id = "LongClickCount")
    @iOSXCUITFindBy(accessibility = "LongClickCount")
    private lateinit var longClickCount: WebElement

    @AndroidFindBy(id = "ToggleButton")
    @iOSXCUITFindBy(accessibility = "ToggleButton")
    private lateinit var toggleButton: WebElement

    @AndroidFindBy(id = "ToggleStatus")
    @iOSXCUITFindBy(accessibility = "ToggleStatus")
    private lateinit var toggleStatus: WebElement

    @AndroidFindBy(id = "SwitchButton")
    @iOSXCUITFindBy(accessibility = "SwitchButton")
    private lateinit var switchButton: WebElement

    @AndroidFindBy(id = "SwitchStatus")
    @iOSXCUITFindBy(accessibility = "SwitchStatus")
    private lateinit var switchStatus: WebElement

    override fun isViewLoaded(): Boolean {
        return waitForElementVisible(viewTitle, clickButton)
    }

    override fun getViewTitle(): String {
        return viewTitle.text
    }

    override fun tapBackButton() {
        tap(backButton)
    }

    fun tapClickButton() {
        tap(clickButton)
    }

    fun getClickCount(): Int {
        return clickCount.text.toInt()
    }

    fun checkIfClickCountIsIncreased(initialCount: Int, actualCount: Int) {
        assertThat(
            ErrorMessages.Action.CLICK_FAILED,
            actualCount,
            equalTo(initialCount + 1)
        )
    }

    fun tapDoubleClickButton() {
        tap(doubleClickButton)
    }

    fun doubleTapDoubleClickButton() {
        doubleTap(doubleClickButton)
    }

    fun getDoubleClickCount(): Int {
        return doubleClickCount.text.toInt()
    }

    fun checkIfDoubleClickCountIsIncreased(initialCount: Int, actualCount: Int) {
        assertThat(
            ErrorMessages.Action.CLICK_FAILED,
            actualCount,
            equalTo(initialCount + 1)
        )
    }

    fun checkIfDoubleClickCountIsNotIncreased(initialCount: Int, actualCount: Int) {
        assertThat(
            ErrorMessages.Action.CLICK_FAILED,
            actualCount,
            equalTo(initialCount)
        )
    }

    fun tapLongClickButton() {
        tap(longClickButton)
    }

    fun longTapLongClickButton() {
        longTap(longClickButton, 1100)
    }

    fun getLongClickCount(): Int {
        return longClickCount.text.toInt()
    }

    fun checkIfLongClickCountIsIncreased(initialCount: Int, actualCount: Int) {
        assertThat(
            ErrorMessages.Action.CLICK_FAILED,
            actualCount,
            equalTo(initialCount + 1)
        )
    }

    fun checkIfLongClickCountIsNotIncreased(initialCount: Int, actualCount: Int) {
        assertThat(
            ErrorMessages.Action.CLICK_FAILED,
            actualCount,
            equalTo(initialCount)
        )
    }

    fun tapToggleButton() {
        tap(toggleButton)
    }

    private fun getToggleStatus(): String {
        return toggleStatus.text
    }

    fun checkIfToggleStatusIsOn() {
        assertThat(
            ErrorMessages.Action.CLICK_FAILED,
            getToggleStatus(),
            equalTo("ON")
        )
    }

    fun checkIfToggleStatusIsOff() {
        assertThat(
            ErrorMessages.Action.CLICK_FAILED,
            getToggleStatus(),
            equalTo("OFF")
        )
    }

    fun tapSwitchButton() {
        forceTap(switchButton)
    }

    fun checkIfSwitchStatusIsOn() {
        when(testPlatform) {
            ANDROID -> assertThat(
                ErrorMessages.Action.CLICK_FAILED,
                switchButton.isSelected,
                equalTo(true)
            )
            IOS -> assertThat(
                ErrorMessages.Action.CLICK_FAILED,
                switchButton.getAttribute("value"),
                equalTo("1")
            )
        }
    }

    fun checkIfSwitchStatusIsOff() {
        when(testPlatform) {
            ANDROID -> assertThat(
                ErrorMessages.Action.CLICK_FAILED,
                switchButton.isSelected,
                equalTo(false)
            )
            IOS -> assertThat(
                ErrorMessages.Action.CLICK_FAILED,
                switchButton.getAttribute("value"),
                equalTo("0")
            )
        }
    }
}