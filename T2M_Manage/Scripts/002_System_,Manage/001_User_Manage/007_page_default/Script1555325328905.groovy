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

//验证默认的是勾选每页显示10条
WebUI.verifyOptionSelectedByValue(findTestObject('Syetem_settings/User_Manage/Search/select_page'), '10', false, 10)

//修改每页展示多少条，然后切换页面，再检查。
List value = ['10', '20', '30', '40', ]

//'60', '70', '80', '90']
for (def b : value) {
    WebUI.delay(4)

    WebUI.selectOptionByValue(findTestObject('Syetem_settings/User_Manage/Search/select_page'), b, false)

    WebUI.verifyOptionSelectedByValue(findTestObject('Syetem_settings/User_Manage/Search/select_page'), b, false, 10)

    WebUI.click(findTestObject('Asset_manage/New_Asset/a_Fixed'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Syetem_settings/User_Manage/a_systemsetings'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Syetem_settings/User_Manage/a_user_manage'))

    WebUI.delay(5)

    a = WebUI.verifyOptionSelectedByValue(findTestObject('Syetem_settings/User_Manage/Search/select_page'), '10', false, 
        10)

    if (a) {
        WebUI.comment('恢复默认，case pass!!')
    }
}

