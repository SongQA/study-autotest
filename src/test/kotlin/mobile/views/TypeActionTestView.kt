package mobile.views

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import mobile.base.BaseView
import mobile.common.ErrorMessages
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.openqa.selenium.WebElement

object TypeActionTestView : BaseView {

    init {
        initElements()
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Text Input and Editing Test']")
    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    private lateinit var viewTitle: WebElement

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='VeriNative']")
    private lateinit var backButton: WebElement

    @AndroidFindBy(id = "englishInput")
    @iOSXCUITFindBy(accessibility = "englishInput")
    private lateinit var englishInputField: WebElement

    @AndroidFindBy(id = "englishFieldError")
    @iOSXCUITFindBy(accessibility = "englishFieldError")
    private lateinit var englishFieldError: WebElement

    @AndroidFindBy(id = "passwordInput")
    @iOSXCUITFindBy(accessibility = "passwordInput")
    private lateinit var passwordInputField: WebElement

    @AndroidFindBy(id = "togglePasswordVisibility")
    @iOSXCUITFindBy(accessibility = "togglePasswordVisibility")
    private lateinit var togglePasswordVisibilityButton: WebElement

    @AndroidFindBy(id = "nameInput")
    @iOSXCUITFindBy(accessibility = "nameInput")
    private lateinit var nameInput: WebElement

    @AndroidFindBy(id = "toggleNameInput")
    @iOSXCUITFindBy(accessibility = "toggleNameInput")
    private lateinit var toggleNameInputEnableButton: WebElement

    @AndroidFindBy(id = "nameFieldError")
    @iOSXCUITFindBy(accessibility = "nameFieldError")
    private lateinit var nameFieldError: WebElement

    override fun isViewLoaded(): Boolean {
        return waitForElementVisible(viewTitle, englishInputField)
    }

    override fun getViewTitle(): String {
        return viewTitle.text
    }

    override fun tapBackButton() {
        tap(backButton)
    }

    fun typeEnglishInputField(text: String) {
        type(englishInputField, text)
    }

    fun checkIfEnglishFieldErrorIsVisible() {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            waitForElementVisible(englishFieldError),
            equalTo(true)
        )
    }

    fun checkIfEnglishFieldErrorIsNotVisible() {
        assertThat(
            ErrorMessages.Element.DISPLAY,
            waitForElementNotVisible(englishFieldError),
            equalTo(true)
        )

        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            englishInputField.text.isNotEmpty(),
            equalTo(true)
        )
    }

    fun typePasswordInputField(text: String) {
        type(passwordInputField, text)
    }

    fun tapTogglePasswordVisibilityButton() {
        tap(togglePasswordVisibilityButton)
    }

   fun checkIfPasswordTextIsHide(text: String) {
        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            passwordInputField.text,
            equalTo("•".repeat(text.length))
        )
    }

    fun checkIfPasswordTextIsVisible(text: String) {
        assertThat(
            ErrorMessages.Element.DISPLAY,
            passwordInputField.text,
            equalTo(text)
        )
    }

    fun typeNameInputField(text: String) {
        type(nameInput, text)
    }

    fun checkIfNameTextIsVisible(text: String) {
        assertThat(
            ErrorMessages.Element.DISPLAY,
            nameInput.text,
            equalTo(text)
        )
    }

    fun tapToggleNameInputEnableButton() {
        tap(toggleNameInputEnableButton)
    }

    fun checkIfNameFieldIsEnabled() {
        assertThat(
            ErrorMessages.Element.DISPLAY,
            nameInput.isEnabled,
            equalTo(true)
        )
    }

    fun checkIfNameFieldIsDisabled() {
        assertThat(
            ErrorMessages.Element.DISPLAY,
            nameInput.isEnabled,
            equalTo(false)
        )
    }

    fun checkIfNameInputFieldMaxLengthIsTen() {
        assertThat(
            ErrorMessages.Element.DISPLAY,
            nameInput.text.length,
            equalTo(10)
        )

        assertThat(
            ErrorMessages.Element.NOT_DISPLAY,
            waitForElementVisible(nameFieldError),
            equalTo(true)
        )
    }



}