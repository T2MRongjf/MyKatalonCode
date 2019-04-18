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

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/test/input__keyword'), usersearch)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

for (int i = 1; i <= 1; i++) {
    first_btn = WebUI.modifyObjectProperty(findTestObject('Syetem_settings/User_Manage/Search/tr_td'), 'xpath', 'equals', 
        ('//div[@id="mainContent"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[' + i) + ']/td[1]/div/span', true)

    data1 = WebUI.getAttribute(first_btn, 'innerText')
}

WebUI.delay(5)

WebUI.click(findTestObject('Syetem_settings/User_Manage/Edit_user_info/Btn_Delete'))

WebUI.delay(1)

WebUI.click(findTestObject('Syetem_settings/User_Manage/Delete_user/Btn_Cancel'))

WebUI.delay(1)

//搜索之前取消删除的用户，查看是否仍然存在
WebUI.setText(findTestObject('Object Repository/test/input__keyword'), usersearch)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Syetem_settings/User_Manage/Search/table'), 10)

table = findTestObject('Syetem_settings/User_Manage/Search/table')

println(table)

TableRows = CustomKeywords.'custom_keyword.WebUICustomKeywords.getHtmlTableRows'(findTestObject('Syetem_settings/User_Manage/Search/table'), 
    'tbody')

int TableRows_All = TableRows.size()

println(TableRows_All)

for (int i = 1; i <= TableRows_All; i++) {
    println(i)

    println(TableRows_All)

    if (WebUI.verifyElementPresent(findTestObject('Syetem_settings/User_Manage/Search/table'), 10)) {
        WebUI.comment('find the table object')
    }
    
    new_btn = WebUI.modifyObjectProperty(findTestObject('Syetem_settings/User_Manage/Search/tr_td'), 'xpath', 'equals', 
        ('//div[@id="mainContent"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[' + i) + ']/td[1]/div/span', true)

    WebUI.verifyElementPresent(new_btn, 10)

    content = WebUI.getAttribute(new_btn, 'innerText')

    if (content == data1) {
        WebUI.comment('取消删除的用户没有被删除')
    } else {
        WebUI.comment('取消删除用户已经删除，请检查！！！')

        assert false
    }
}

