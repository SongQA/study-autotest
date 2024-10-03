package mobile.views

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import mobile.base.BaseView
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

    override fun isPageLoaded(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPageTitle(): String {
        TODO("Not yet implemented")
    }

    fun tapClickScreenButton() {
        tap(clickScreenButton)
    }
}