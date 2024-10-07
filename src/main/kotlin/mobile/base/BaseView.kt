package mobile.base

import io.appium.java_client.pagefactory.AppiumFieldDecorator
import mobile.driver.DriverManager
import mobile.utilities.ActionUtil
import org.openqa.selenium.support.PageFactory

interface BaseView : ActionUtil {
        fun initElements() {
                PageFactory.initElements(AppiumFieldDecorator(DriverManager.getDriver()), this)
        }

        fun isViewLoaded(): Boolean

        fun getViewTitle(): String

        fun tapBackButton()
}
