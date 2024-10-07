package mobile.tests

import mobile.base.TestBase
import mobile.views.MainView
import org.testng.annotations.Test

class MainScreenTest : TestBase() {

    @Test
    fun test_enter_click_screen() {
        assert(MainView.isViewLoaded())
        MainView.tapClickScreenButton()
    }
}
