package mobile.views

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import mobile.base.BaseView
import org.openqa.selenium.WebElement

object ScrollAndSwipeActionTestView : BaseView {

    init {
        initElements()
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scroll and Swipe Action Test']")
    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    private lateinit var viewTitle: WebElement

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='VeriNative']")
    private lateinit var backButton: WebElement

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='1']")
    private lateinit var transverseCard: WebElement

    override fun isViewLoaded(): Boolean {
        return waitForElementVisible(viewTitle, transverseCard)
    }

    override fun getViewTitle(): String {
        return viewTitle.text
    }

    override fun tapBackButton() {
        tap(backButton)
    }
}