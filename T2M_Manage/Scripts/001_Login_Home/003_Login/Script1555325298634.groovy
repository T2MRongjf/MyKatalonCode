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

WebUI.setText(findTestObject('Login/loginname'), account_normal)

WebUI.delay(1)

WebUI.setText(findTestObject('Login/password'), pwd_normal)

WebUI.delay(1)

WebUI.click(findTestObject('Login/remember_password'))

WebUI.delay(1)

R = WebUI.verifyElementNotChecked(findTestObject('Login/remember_password'), 10)

if (R) {
    WebUI.comment('The remember pwd box no checked')
} else {
    WebUI.comment('The remember pwd box is checked!!')
}

WebUI.click(findTestObject('Login/button_ login'))

a = WebUI.verifyElementPresent(findTestObject('homepage/a_homepage'), 40)

if (a) {
    WebUI.comment('Find the homepag lable,Login successful')

    WebUI.takeScreenshot()
} else {
    WebUI.comment('Not find the HomePage button')

    WebUI.closeBrowser()
}

