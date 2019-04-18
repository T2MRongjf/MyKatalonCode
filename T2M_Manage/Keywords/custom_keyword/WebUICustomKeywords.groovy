package custom_keyword

import groovy.json.JsonSlurper
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords


import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

public class WebUICustomKeywords {

	/**
	 * Get all rows of HTML table 获取HTML表格的总行数
	 * @param table Katalon test object represent for HTML table 参数1：HTML表格
	 * @param outerTagName outer tag name of TR tag, usually is TBODY 参数2：HTML表格下面的tag标签，一般为tboday
	 * @return All rows inside HTML table 返回HTML表格行的所有行数
	 */
	@Keyword
	def List getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * Get all cells of HTML table row 获取HTML表格行的所有单元格
	 * @param row a WebElement instance represent for HTML table row 参数1：HTML表格的总行数
	 * @param tagName HTML column tag name, usually is TD/TH 参数2：HTML表格下面的tag标签，一般为：TD或TH
	 * @return All cells inside HTML table row 返回HTML表格行的所有单元格
	 */
	@Keyword
	def List getHtmlTableColumns(WebElement row, String tagName) {
		List selectedColumns = row.findElements(By.tagName(tagName))
		return selectedColumns
	}
}

public class getInputText{
	def GetinputValue(WebDriver driver ,WebElement element){
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		try {
			String value = javaScriptExecutor.executeScript("return arguments[0].value", element).toString();
			return value;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}


