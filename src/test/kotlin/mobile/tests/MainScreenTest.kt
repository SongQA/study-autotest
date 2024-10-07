package mobile.tests

import mobile.base.TestBase
import mobile.views.MainView
import org.testng.annotations.Test

class MainScreenTest : TestBase() {

    @Test
    fun test_01() {
        with(MainView) {
            isViewLoaded()

            checkIfClickActionTestButtonIsVisible()
            checkIfTextInputScreenButtonIsVisible()
            checkIfScrollScreenButtonIsVisible()
            checkIfWaitingScreenButtonIsVisible()
            checkIfRotationScreenButtonIsVisible()
            checkIfDragAndDropScreenButtonIsVisible()
            checkIfModalScreenButtonIsVisible()
        }
    }
}
