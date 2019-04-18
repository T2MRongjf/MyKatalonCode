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

WebUI.click(findTestObject('Login/a_Loginout'))

WebUI.delay(1)

R = WebUI.verifyElementChecked(findTestObject('Login/remember_password'), 3)

if (R) {
    WebUI.comment('check the remember pwd box!')
} else {
    WebUI.comment('The remember pwd box no checked!!')
}

WebUI.click(findTestObject('Login/button_ login'))

a = WebUI.verifyElementPresent(findTestObject('homepage/a_homepage'), 40, FailureHandling.CONTINUE_ON_FAILURE)

if (a) {
    WebUI.comment('Find the homepag lable,Login successful，the pwd not clear')

    WebUI.takeScreenshot()

    assert true
} else {
    WebUI.comment('Not find the HomePage button')

    WebUI.closeBrowser()

    assert false
}

WebUI.callTestCase(findTestCase('001_Login_Home/003_Login'), [('account_normal') : 'admin', ('pwd_normal') : '654321'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Login/a_Loginout'))

WebUI.delay(1)

R = WebUI.verifyElementChecked(findTestObject('Login/remember_password'), 10)

if (R) {
    WebUI.comment('check the remember pwd box!')
} else {
    WebUI.comment('The remember pwd box no checked!!')
}

WebUI.click(findTestObject('Login/button_ login'))

a = WebUI.verifyElementPresent(findTestObject('Login/label_incorrect'), 30, FailureHandling.CONTINUE_ON_FAILURE)

if (a) {
    WebUI.comment('The account and pwd have cleared')

    assert true
} else {
    WebUI.comment('Not find this item,please give one correct tips!maybe the accout and pwd not cleared!')

    assert false
}

