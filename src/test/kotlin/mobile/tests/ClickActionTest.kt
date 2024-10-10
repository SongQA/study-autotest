package mobile.tests

import mobile.base.TestBase
import mobile.views.ClickActionTestView
import mobile.views.MainView
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class ClickActionTest: TestBase() {

    @BeforeClass
    fun test_setup() {
        with(MainView) {
            isViewLoaded()
            checkIfClickActionTestButtonIsVisible()
            tapClickScreenButton()
        }
    }

    @Test(priority = 1, description = "Tests if ClickActionTestView is displayed")
    fun test_01() {
        with(ClickActionTestView) {
            isViewLoaded()
            getViewTitle()
        }
    }

    @Test(priority = 2, description = "Tests if ClickButton increases the count when clicked")
    fun test_02() {
        with(ClickActionTestView) {
            val initialCount = getClickCount()
            tapClickButton()
            checkIfClickCountIsIncreased(initialCount, getClickCount())
        }
    }

    @Test(priority = 3, description = "Tests if DoubleClickButton increases the count when double clicked")
    fun test_03() {
        with(ClickActionTestView) {
            var initialCount = getDoubleClickCount()
            tapDoubleClickButton()
            checkIfDoubleClickCountIsNotIncreased(initialCount, getDoubleClickCount())

            initialCount = getDoubleClickCount()
            doubleTapDoubleClickButton()
            checkIfDoubleClickCountIsIncreased(initialCount, getDoubleClickCount())
        }
    }

    @Test(priority = 4, description = "Tests if LongClickButton increases the count when long clicked")
    fun test_04() {
        with(ClickActionTestView) {
            var initialCount = getLongClickCount()
            tapLongClickButton()
            checkIfLongClickCountIsNotIncreased(initialCount, getLongClickCount())

            initialCount = getLongClickCount()
            longTapLongClickButton()
            checkIfLongClickCountIsIncreased(initialCount, getLongClickCount())
        }
    }

    @Test(priority = 5, description = "Tests if ToggleButton turns on and off when clicked")
    fun test_05() {
        with(ClickActionTestView) {
            tapToggleButton()
            checkIfToggleStatusIsOn()
            tapToggleButton()
            checkIfToggleStatusIsOff()
        }
    }

    @Test(priority = 6, description = "Tests if SwitchButton turns on and off when clicked")
    fun test_06() {
        with(ClickActionTestView) {
            tapSwitchButton()
            checkIfSwitchStatusIsOn()
            tapSwitchButton()
            checkIfSwitchStatusIsOff()
        }
    }

    @AfterClass
    fun test_teardown() {
        with(ClickActionTestView) {
            tapBackButton()
        }
    }
}
