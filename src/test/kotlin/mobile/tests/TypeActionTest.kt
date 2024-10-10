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
}