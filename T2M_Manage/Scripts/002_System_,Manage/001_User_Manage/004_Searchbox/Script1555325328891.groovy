import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.swing.table.TableColumn as TableColumn
import javax.swing.table.TableRowSorter as TableRowSorter
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.TakeScreenshotKeyword as TakeScreenshotKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('002_System_,Manage/001_User_Manage/001_Enter_User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

Total_First = WebUI.getAttribute(findTestObject('Syetem_settings/User_Manage/Search/total_list'), 'innerText')

if (Total_First) {
    WebUI.comment(Total_First)
} else {
    assert false
}

//输入关键词为空情况，通过判断最开始的总条数和最后点击搜索总条数是否一致来判断
WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username_empty)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

Actual_First = WebUI.getAttribute(findTestObject('Syetem_settings/User_Manage/Search/total_list'), 'innerText')

if (Total_First == Actual_First) {
    WebUI.comment('搜索结果没变，输入的关键字为空')
} else {
    WebUI.comment('搜索结果与最开始的结果不一致，请检查。')

    assert false
}

//输入关键词与列表中数据不匹配的情况，通过判断是否存在‘无数据’这个元素来判断
WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username_Noteaxst)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

data = WebUI.getAttribute(findTestObject('Syetem_settings/User_Manage/Search/Nodata'), 'innerText')

WebUI.comment(data)

if (data == '无数据') {
    WebUI.comment('搜索结果为空，输入的关键字没有匹配的内容')
} else {
    WebUI.comment('搜索结果不一致，请检查。')

    assert false
}

//输入模糊搜索关键词，查询搜索的结果与统计的结果是否一致
WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username_Normal)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

//获取搜索结果中的总条数
Normal_result = WebUI.getAttribute(findTestObject('Syetem_settings/User_Manage/Search/total_list'), 'innerText')

if (Normal_result) {
    WebUI.comment('搜索结果存在')

    WebUI.comment(Normal_result[2])
} else {
    WebUI.comment('搜索结果与最开始的结果不一致，请检查。')

    assert false
}

//获取搜索结果列表中的条数
WebUI.verifyElementPresent(findTestObject('Syetem_settings/User_Manage/Search/table'), 10)

table = findTestObject('Syetem_settings/User_Manage/Search/table')

println(table)

list = CustomKeywords.'custom_keyword.WebUICustomKeywords.getHtmlTableRows'(findTestObject('Syetem_settings/User_Manage/Search/table'), 
    'tbody')

TableRows_All = list.size()

println(TableRows_All)
int b = Integer.parseInt(Normal_result[2]);
if (TableRows_All == (b)) {
    WebUI.comment('搜索结果为正确的')
} else {
    WebUI.comment('搜索结果与列表中存在的数量不一致，请检查')

    assert false
}

