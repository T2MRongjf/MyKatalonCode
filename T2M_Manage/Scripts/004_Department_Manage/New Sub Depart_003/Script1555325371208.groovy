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

WebUI.click(findTestObject('Depart Manage/cite_topname'))

WebUI.delay(0)

WebUI.rightClick(findTestObject('Depart Manage/cite_topname'))

WebUI.delay(0)

WebUI.click(findTestObject('Depart Manage/sub_depart/new_subdepart'))

WebUI.delay(0)

WebUI.setText(findTestObject('Depart Manage/sub_depart/sub__deptname'), subname)

WebUI.delay(0)

WebUI.setText(findTestObject('Depart Manage/sub_depart/Sub__abbreviation'), 'SubCS')

WebUI.delay(0)

not_run: WebUI.click(findTestObject('Depart Manage/sub_depart/i_enable'))

not_run: WebUI.delay(0)

WebUI.setText(findTestObject('Depart Manage/sub_depart/Sub__note'), '这是一个子部门的备注，需要验证各种字符请进行参数化')

WebUI.delay(0)

WebUI.click(findTestObject('Depart Manage/sub_depart/button_submit'))

WebUI.delay(0)

