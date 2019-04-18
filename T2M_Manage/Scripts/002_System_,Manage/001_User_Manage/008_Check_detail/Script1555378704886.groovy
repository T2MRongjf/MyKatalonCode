import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.nio.channels.SelectableChannel as SelectableChannel
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.TakeScreenshotKeyword as TakeScreenshotKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import org.stringtemplate.v4.compiler.STParser.element_return as element_return
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.callTestCase(findTestCase('002_System_,Manage/001_User_Manage/001_Enter_User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

//搜索元素，获取搜索姓名用户信息，存放到list userinfo中
int i = 1

userinfo = []

for (int j = 1; j <= 5; j++) {
    n_btn = WebUI.modifyObjectProperty(findTestObject('Syetem_settings/User_Manage/Search/tr_td'), 'xpath', 'equals', ((('//div[@id="mainContent"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[' + 
        i) + ']/td[') + j) + ']/div', true)

    WebUI.verifyElementPresent(n_btn, 10)

    data = WebUI.getAttribute(n_btn, 'innerText')

    userinfo.add(data)

    println(userinfo)
}

//查看详情页面，获取用户信息，存放到 userdetail中
WebUI.click(findTestObject('Syetem_settings/User_Manage/Details/div_FirstUser'))

WebUI.delay(10)

userdetail = []

name = findTestObject('Syetem_settings/User_Manage/Details/realname')

position = findTestObject('Syetem_settings/User_Manage/Details/position')

mobile = findTestObject('Syetem_settings/User_Manage/Details/mobile')

email = findTestObject('Syetem_settings/User_Manage/Details/email')

WebElement element1 = WebUiCommonHelper.findWebElement(name, 30)

WebElement element2 = WebUiCommonHelper.findWebElement(position, 30)

WebElement element3 = WebUiCommonHelper.findWebElement(mobile, 30)

WebElement element4 = WebUiCommonHelper.findWebElement(email, 30)

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

String value1 = js.executeScript('return arguments[0].value', element1).toString()

userdetail.add(value1)

String value2 = js.executeScript('return arguments[0].value', element2).toString()

userdetail.add(value2)

String value4 = js.executeScript('return arguments[0].value', element4).toString()

userdetail.add(value4)

String value3 = js.executeScript('return arguments[0].value', element3).toString()

userdetail.add(value3)

WebElement duty = WebUiCommonHelper.findWebElement(findTestObject('Syetem_settings/User_Manage/Details/on_duty'), 30)

String value5 = js.executeScript('return $("[name=\'state\']").val()', duty).toString()

println(value5)

if (value5 == '1') {
    userdetail.add('在职')
} else {
    userdetail.add('离职')
}

println(userdetail)

if (userinfo == userdetail) {
    WebUI.comment('详情展示正确')

    assert true
} else {
    WebUI.comment('详情展示错误')


    assert false
}

