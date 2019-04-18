import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
import com.google.common.collect.ArrayTable.Column as Column
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

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/test/input__keyword'), username)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/test/button__layui-btn'))

WebUI.delay(1)

WebUI.comment('Start checking if the search results are match with the keyword')

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

    //判断搜索结果是否与输入的关键词相匹配
    if (content.indexOf(username) != -1) {
        //"只要test.indexOf('This')返回的值不是-1说明content字符串中包含字符串username,相反如果包含返回的值必定是-1"
        WebUI.comment(((('列表中值为' + content) + ',输入的关键词为') + username) + ',存在包含关系,搜索结果相匹配')

        assert true
    } else {
        WebUI.comment(((('列表中值为' + content) + ',输入的关键词为') + username) + ',不存在包含关系,搜索结果不匹配')

        assert false
    }
}

//判断列表中除了姓名一列，其他列中的数据应该与搜索的关键字不匹配
for (int i = 1; i <= TableRows_All; i++) {
    for (int j = 2; j <= 5; j++) {
        n_btn = WebUI.modifyObjectProperty(findTestObject('Syetem_settings/User_Manage/Search/tr_td'), 'xpath', 'equals', 
            ((('//div[@id="mainContent"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[' + i) + ']/td[') + j) + 
            ']/div', true)

        WebUI.verifyElementPresent(n_btn, 10)

        name_content = WebUI.modifyObjectProperty(findTestObject('Syetem_settings/User_Manage/Search/tr_td'), 'xpath', 'equals', 
            ('//div[@id="mainContent"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[' + i) + ']/td[1]/div/span', 
            true)

        WebUI.verifyElementPresent(name_content, 10)

        name = WebUI.getAttribute(name_content, 'innerText')

        data = WebUI.getAttribute(n_btn, 'innerText')

        if (data == null) {
            WebUI.comment('值为空，不匹配')
        } else if (data.indexOf(username) != -1) {
            WebUI.comment(((('列表中值为' + data) + ',输入的关键词为') + username) + ',列表中的其他数据与关键字存在包含关系,请继续验证姓名列是否与关键词相匹配')

            if (name.indexOf(username) != -1) {
                WebUI.comment(((('姓名为' + name) + ',输入的关键词为') + username) + ',姓名与关键词存在包含关系,搜索结果相匹配,所以case pass')

                assert true
            } else {
                WebUI.comment(((('姓名为' + name) + ',输入的关键词为') + username) + ',姓名与关键词不存在包含关系,但是被搜索出来,所以case fail.')

                assert false
            }
        } else {
            WebUI.comment(((('列表中值为' + data) + ',输入的关键词为') + username) + ',不存在包含关系,搜索结果不匹配，case pass')

            assert true
        }
    }
}

