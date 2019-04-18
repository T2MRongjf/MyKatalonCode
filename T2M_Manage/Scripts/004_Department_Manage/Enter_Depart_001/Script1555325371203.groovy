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

WebUI.click(findTestObject('Syetem_settings/User_Manage/a_systemsetings'))

WebUI.delay(1)

WebUI.click(findTestObject('Depart Manage/Btn_Manage'))

WebUI.delay(1)

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

Btn = WebUI.verifyElementPresent(findTestObject('Depart Manage/Brtn_newDepart'), 10)

if (Btn) {
    WebUI.comment('Enter the department manage page successful')
} else {
    try {
        Btn = WebUI.verifyElementPresent(findTestObject('Depart Manage/Btn_NewUsers'), 10)
    }
    catch (Exception e) {
        WebUI.comment('not enter the department manage page')
    } 
}

