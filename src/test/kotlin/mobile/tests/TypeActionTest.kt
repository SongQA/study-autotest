package mobile.tests

import mobile.base.TestBase
import mobile.views.MainView
import mobile.views.TypeActionTestView
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class TypeActionTest : TestBase() {


    @BeforeClass
    fun test_setup() {
        with(MainView) {
            isViewLoaded()
            checkIfTextInputScreenButtonIsVisible()
            tapTextInputScreenButton()
        }
    }

    @Test(priority = 1, description = "Tests if TypeActionTestView is displayed")
    fun test_01() {
        with(TypeActionTestView) {
            isViewLoaded()
            getViewTitle()
        }
    }

    @Test(priority = 2, description = "Tests if English input field accepts text")
    fun test_02() {
        with(TypeActionTestView) {
            typeEnglishInputField("1234")
            checkIfEnglishFieldErrorIsVisible()
            typeEnglishInputField("abcd")
            checkIfEnglishFieldErrorIsNotVisible()
        }
    }

    @Test(priority = 3, description = "Tests if text is hidden as * when typing")
    fun test_03() {
        with(TypeActionTestView) {
            typePasswordInputField("1234")
            checkIfPasswordTextIsHide("1234")
        }
    }

    @Test(priority = 4, description = "Tests if text is visible when show button is clicked")
    fun test_04() {
        with(TypeActionTestView) {
            typePasswordInputField("1234")
            checkIfPasswordTextIsHide("1234")
            tapTogglePasswordVisibilityButton()
            checkIfPasswordTextIsVisible("1234")
        }
    }

    @Test(priority = 5, description = "Tests if name input field accepts up to 10 characters")
    fun test_05() {
        with(TypeActionTestView) {
            typeNameInputField("12345678901")
            checkIfNameInputFieldMaxLengthIsTen()
        }
    }

    @Test(priority = 6, description = "Tests if input field is disabled when disable button is clicked")
    fun test_06() {
        with(TypeActionTestView) {
            typeNameInputField("abcd")
            checkIfNameTextIsVisible("abcd")
            checkIfNameFieldIsEnabled()

            tapToggleNameInputEnableButton()
            checkIfNameFieldIsDisabled()
        }
    }
}