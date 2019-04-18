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
import com.kms.katalon.core.webui.keyword.builtin.TakeScreenshotKeyword as TakeScreenshotKeyword
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('002_System_,Manage/001_User_Manage/001_Enter_User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

List value = ['10', '20', '30', '40', '50', '60', '70', '80', '90']

for (def b : value) {
    Total_First = WebUI.getAttribute(findTestObject('Syetem_settings/User_Manage/Search/total_list_page'), 'innerText')

    WebUI.comment(Total_First)

    a = (Total_First[(2..3)])

    int total = Integer.parseInt(a)

    WebUI.selectOptionByValue(findTestObject('Syetem_settings/User_Manage/Search/select_page'), b, false)

    int num = Integer.parseInt(b)

    int c = total / num

    d = (total % num)

    println(a)

    println(c)

    println(num)

    println(d)

    //判断总条数除以每页条数，如果小于1，那么就不分页。
    if (c <= 1) {
        WebUI.verifyElementPresent(findTestObject('Syetem_settings/User_Manage/Search/table'), 10)

        list = CustomKeywords.'custom_keyword.WebUICustomKeywords.getHtmlTableRows'(findTestObject('Syetem_settings/User_Manage/Search/table'), 
            'tbody')

        TableRows_All = list.size()

        //判断列表中的数据条数与记录的条数是否一致
        if (TableRows_All == (Total_First[2])) {
            WebUI.comment('未分页，结果为正确的')
        } //判断末页的数据与预期结果是否一致
        else {
            WebUI.comment('搜索结果与列表中存在的数量不一致，请检查')

            assert false
        }
    } else if (c >= 2) {
        for (int i = 1; i <= c; i++) {
            WebUI.click(findTestObject('Syetem_settings/User_Manage/Search/next_page'))

            WebUI.delay(1)
        }
        
        WebUI.verifyElementPresent(findTestObject('Syetem_settings/User_Manage/Search/table'), 10)

        rows = CustomKeywords.'custom_keyword.WebUICustomKeywords.getHtmlTableRows'(findTestObject('Syetem_settings/User_Manage/Search/table'), 
            'tbody')

        leave = rows.size()

        if (leave == d) {
            WebUI.comment('最末页的数据与预期结果相符合，pass')

            assert true
        } else {
            WebUI.comment('最末页的数据与总条数除以每页条数的余数不一致，截屏，请检查，fail')

            WebUI.takeScreenshot('末页数据不一致')

            assert false
        }
    }
}

