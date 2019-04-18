import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('002_System_,Manage/001_User_Manage/001_Enter_User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('begain to add one new user!')

WebUI.click(findTestObject('Object Repository/Syetem_settings/User_Manage/a_ new_user'))

WebUI.delay(1)

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/choose_dept'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/i__TreeNB'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/cite_CQDepart'))

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_ RealName'), username)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_position'), position)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_mobile'), mobile)

WebUI.delay(1)

WebUI.setText(findTestObject('Syetem_settings/User_Manage/user_info/input_email'), Email)

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/user_info/button_ Save'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

data_content = WebUI.getAttribute(findTestObject('Syetem_settings/User_Manage/Search/td_number1'), 'data-content')

if (data_content == username) {
    WebUI.comment('人员添加成功')
} else {
    assert false
}

