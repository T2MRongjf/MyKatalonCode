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

WebUI.callTestCase(findTestCase('001_Login_Home/001_Navigate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.setText(findTestObject('Login/loginname'), account_error)

WebUI.delay(1)

WebUI.setText(findTestObject('Login/password'), pwd_error)

WebUI.delay(1)

WebUI.click(findTestObject('Login/button_ login'))

a = WebUI.verifyElementPresent(findTestObject('Login/label_incorrect'), 30, FailureHandling.CONTINUE_ON_FAILURE)

if (a) {
    WebUI.comment('find this item,pwd or name not correct')
} else {
    WebUI.comment('Not find this item,please give one correct tips!')
}

WebUI.closeBrowser()

