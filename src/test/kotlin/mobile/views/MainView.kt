package mobile.views

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import mobile.base.BaseView
import mobile.common.ErrorMessages
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.openqa.selenium.WebElement

object MainView : BaseView {
    init {
        initElements()
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VeriNative']")
    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    private lateinit var viewTitle: WebElement

    @AndroidFindBy(xpath = "//*[@text='Click Action Test']")
    @iOSXCUITFindBy(xpath = "//*[@name='Click Action Test']")
    private lateinit var clickScreenButton: WebElement

    @AndroidFindBy(xpath = "//*[@text='Text Input and Editing Test']")
    @iOSXCUITFindBy(xpath = "//*[@name='Text Input and Editing Test']")
    private lateinit var TextInputScreenButton: WebElement

    @AndroidFindBy(xpath = "//*[@text='Scroll and Swipe Action Test']")
    @iOSXCUITFindBy(xpath = "//*[@name='Scroll and Swipe Action Test']")
    private lateinit var ScrollScreenButton: WebElement

    @AndroidFindBy(xpath = "//*[@text='Waiting and Loading Test']")
    @iOSXCUITFindBy(xpath = "//*[@name='Waiting and Loading Test']")
    private lateinit var WaitingScreenButton: WebElement

    @AndroidFindBy(xpath = "//*[@text='Screen Rotation Test']")
    @iOSXCUITFindBy(xpath = "//*[@name='Screen Rotation Test']")
    private lateinit var RotationScreenButton: WebElement

    @AndroidFindBy(xpath = "//*[@text='Drag and Drop Test']")
    @iOSXCUITFindBy(xpath = "//*[@name='Drag and Drop Test']")
    private lateinit var DragAndDropScreenButton: WebElement

    @AndroidFindBy(xpath = "//*[@text='Modal, Popup, Toast Test']")
    @iOSXCUITFindBy(xpath = "//*[@name='Modal, Popup, Toast Test']")
    private lateinit var ModalScreenButton: WebElement
    

    override fun isViewLoaded(): Boolean {
        return waitForElementVisible(viewTitle, clickScreenButton)
    }

    override fun getViewTitle(): String {
        return viewTitle.text
    }

    override fun tapBackButton() {
        TODO("Not yet implemented")
    }

    fun tapClickScreenButton() {
        tap(clickScreenButton)
    }

    fun tapTextInputScreenButton() {
        tap(TextInputScreenButton)
    }

    fun tapScrollScreenButton() {
        tap(ScrollScreenButton)
    }

    fun tapWaitingScreenButton() {
        tap(WaitingScreenButton)
    }

    fun tapRotationScreenButton() {
        tap(RotationScreenButton)
    }

    fun tapDragAndDropScreenButton() {
        tap(DragAndDropScreenButton)
    }

    fun tapModalScreenButton() {
        tap(ModalScreenButton)
    }

    fun checkIfClickActionTestButtonIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            clickScreenButton.isDisplayed,
            equalTo(true)
        )
    }

    fun  checkIfTextInputScreenButtonIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            TextInputScreenButton.isDisplayed,
            equalTo(true)
        )
    }

    fun checkIfScrollScreenButtonIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            ScrollScreenButton.isDisplayed,
            equalTo(true)
        )
    }

    fun checkIfWaitingScreenButtonIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            WaitingScreenButton.isDisplayed,
            equalTo(true)
        )
    }

    fun checkIfRotationScreenButtonIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            RotationScreenButton.isDisplayed,
            equalTo(true)
        )
    }

    fun checkIfDragAndDropScreenButtonIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            DragAndDropScreenButton.isDisplayed,
            equalTo(true)
        )
    }

    fun checkIfModalScreenButtonIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            ModalScreenButton.isDisplayed,
            equalTo(true)
        )
    }
}
