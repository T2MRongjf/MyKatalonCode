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

WebUI.callTestCase(findTestCase('003_Asset_management/New_Asset/New_Asset_002'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Asset_manage/Edit_info/input__assetsname'), '笔记本电脑')

WebUI.click(findTestObject('Asset_manage/Edit_info/input__usercompany'))

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/dd__SH'))

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/input__asset_classify'))

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/dd__Furniture'))

WebUI.delay(2)

WebUI.setText(findTestObject('Asset_manage/New_Asset/input_SN'), 'SN12345687')

WebUI.delay(2)

WebUI.setText(findTestObject('Asset_manage/Edit_info/input_SAP_sapnumber'), 'sap_0021')

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/i__layui-edge_3'))

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/dd__accountout'))

WebUI.setText(findTestObject('Asset_manage/Edit_info/input__brand'), '惠普')

WebUI.delay(2)

WebUI.setText(findTestObject('Asset_manage/Edit_info/input__model'), 'None')

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/in_take_date'))

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/i_'))

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/i__1'))

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/td_10'))

WebUI.delay(2)

WebUI.setText(findTestObject('Asset_manage/Edit_info/input__amount'), '12536.3')

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/cost_center'))

WebUI.delay(2)

WebUI.click(findTestObject('Asset_manage/Edit_info/dd__CQ1'))

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/durable_years'))

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/dd_2years'))

WebUI.delay(1)

not_run: WebUI.click(findTestObject('Asset_manage/Edit_info/input__layui_use_depart'))

not_run: WebUI.delay(1)

not_run: WebUI.click(findTestObject('Asset_manage/Edit_info/dd_SH_VGM'))

not_run: WebUI.delay(1)

not_run: WebUI.click(findTestObject('Asset_manage/Edit_info/i__layui-edge'))

not_run: WebUI.delay(1)

not_run: WebUI.click(findTestObject('Asset_manage/Edit_info/dd__uasername'))

not_run: WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/input_assetplace'))

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/dd_TCLfactory'))

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/input__status'))

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/dd_Receive'))

WebUI.delay(1)

WebUI.setText(findTestObject('Asset_manage/Edit_info/input__loginUserName'), '系统管理员')

WebUI.click(findTestObject('Asset_manage/Edit_info/Maintenance_date'))

WebUI.delay(1)

WebUI.click(findTestObject('Asset_manage/Edit_info/td_7'))

WebUI.delay(1)

not_run: WebUI.deleteAllCookies(FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

not_run: WebUI.uploadFile(findTestObject('Asset_manage/Edit_info/button_uploadfile'), 'C:\\rjf file\\katalon\\katalon_project\\katalon_project\\Data\\picture\\001-crutch.png')

CustomKeywords.'custom_keyword.uploadfilefromwindow.uploadFile'(findTestObject('Asset_manage/Edit_info/button_uploadfile'), 
    'G:\\Auto_Learning\\katalon\\katalon_project\\katalon_project\\Data\\picture\\001-crutch.png')

WebUI.delay(8)

not_run: WebUI.click(findTestObject('Asset_manage/Edit_info/button__deletefile'))

WebUI.setText(findTestObject('Asset_manage/Edit_info/textarea__description'), 'here is the asset description')

WebUI.delay(2)

not_run: WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

