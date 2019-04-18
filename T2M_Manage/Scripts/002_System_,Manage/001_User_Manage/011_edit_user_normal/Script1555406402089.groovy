import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.callTestCase(findTestCase('002_System_,Manage/001_User_Manage/001_Enter_User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/test/input__keyword'), usersearch)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/Edit_user_info/edit_first'))

WebUI.delay(2)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/input__addDeptName'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/Edit_user_info/div_NB_QA'))

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input_ realname'), username)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input_position'), position)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input__mobile'), mobile)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/Edit_user_info/input_email'), email)

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/Edit_user_info/button_Saveedit'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

data_content = WebUI.getAttribute(findTestObject('Syetem_settings/User_Manage/Search/td_number1'), 'data-content')

if (data_content == username) {
    WebUI.comment('人员编辑修改成功')
} else {
    WebUI.comment('人员编辑后没有成功保存，请查看截图')

    WebUI.takeScreenshot('编辑人员失败')

    assert false
}

