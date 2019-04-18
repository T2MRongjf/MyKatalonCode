import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
//搜索元素，获取搜索姓名用户信息，存放到list userinfo中
//查看详情页面，获取用户信息，存放到 userdetail中
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

WebUI.callTestCase(findTestCase('002_System_,Manage/001_User_Manage/001_Enter_User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/Edit_user_info/edit_first'))

WebUI.delay(2)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input_ realname'), empty_user)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input_position'), empty_position)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input__mobile'), empty_mobile)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input_email'), empty_email)

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/Edit_user_info/button_Saveedit'))

if (WebUI.verifyElementPresent(findTestObject('Syetem_settings/User_Manage/user_info/tips_save'), 10)) {
    WebUI.comment('发现不能为空的提示')

    WebUI.delay(1)

    WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/close_user'))
} else {
    assert false
}

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Syetem_settings/User_Manage/a_ new_user'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/choose_dept'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/i__TreeNB'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/cite_CQDepart'))

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_ RealName'), edit_user)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_position'), edit_position)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_mobile'), edit_mobile)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_email'), edit_email)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/button_ Save'))

if (WebUI.verifyElementPresent(findTestObject('Syetem_settings/User_Manage/user_info/save_email'), 10)) {
    WebUI.comment('发现邮件格式不对的提示')

    WebUI.delay(1)

    WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/close_user'))
} else {
    assert false
}

