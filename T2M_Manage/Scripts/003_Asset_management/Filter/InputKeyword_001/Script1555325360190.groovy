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

WebUI.click(findTestObject('Filter/input__status'))

WebUI.delay(1)

WebUI.click(findTestObject('Filter/dd_Receive'))

WebUI.delay(1)

WebUI.click(findTestObject('Filter/input__classify'))

WebUI.delay(1)

WebUI.click(findTestObject('Filter/dd_furniture'))

WebUI.delay(1)

WebUI.click(findTestObject('Filter/input__useCom'))

WebUI.delay(1)

WebUI.click(findTestObject('Filter/dd_SH'))

WebUI.delay(1)

WebUI.click(findTestObject('Filter/input__keyword'))

WebUI.delay(1)

WebUI.setText(findTestObject('Filter/input__keyword'), keyword)

WebUI.delay(1)

WebUI.click(findTestObject('Filter/button__searchBtn'))

WebUI.delay(1)

