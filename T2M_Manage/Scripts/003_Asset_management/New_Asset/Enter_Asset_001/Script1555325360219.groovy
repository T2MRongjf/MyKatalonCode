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

WebUI.callTestCase(findTestCase('001_Login_Home/002_Login'), [('account_normal') : 'admin', ('pwd_normal') : '654321'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Asset_manage/New_Asset/a_Fixed'))

Fixed_text = WebUI.getAttribute(findTestObject('Asset_manage/New_Asset/a_Fixed'), 'text', FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyMatch(Fixed_text, '固定资产管理', false)) {
	
    WebUI.comment("'enter to Fixed manage successfully!!the text is '固定资产管理'")
	
	WebUI.takeScreenshot()
	
} 
else {
	
    WebUI.comment('enter to Fixed manage fail,you can try again ')

    WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)
}

