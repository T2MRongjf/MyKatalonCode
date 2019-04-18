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

WebUI.callTestCase(findTestCase('004_Department_Manage/Enter_Depart_001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Depart Manage/Brtn_newDepart'))

WebUI.delay(1)

text = WebUI.getAttribute(findTestObject('Depart Manage/input__topdepart'), 'text')

if (text == 'null') {
    WebUI.comment('depart box is null')
}

WebUI.setText(findTestObject('Object Repository/Depart Manage/input__deptname'), topname)

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Depart Manage/input__abbreviation'), 'CS')

WebUI.delay(1)

WebUI.click(findTestObject('Depart Manage/i_enabledisable'))

WebUI.delay(1)

WebUI.click(findTestObject('Depart Manage/i_enabledisable'))

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Depart Manage/textarea__note'), '备注信息测试，是否必填')

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Depart Manage/button__save'))

WebUI.delay(1)

text = WebUI.getAttribute(findTestObject('Depart Manage/cite_topname'), 'value')

WebUI.comment(text)

if (text == topname) {
    WebUI.comment('新增顶级部门成功！！！')
}

