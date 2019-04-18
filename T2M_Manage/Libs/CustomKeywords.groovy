
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import org.openqa.selenium.WebElement


def static "custom_keyword.uploadfilefromwindow.uploadFile"(
    	TestObject to	
     , 	String filePath	) {
    (new custom_keyword.uploadfilefromwindow()).uploadFile(
        	to
         , 	filePath)
}

def static "custom_keyword.WebUICustomKeywords.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new custom_keyword.WebUICustomKeywords()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "custom_keyword.WebUICustomKeywords.getHtmlTableColumns"(
    	WebElement row	
     , 	String tagName	) {
    (new custom_keyword.WebUICustomKeywords()).getHtmlTableColumns(
        	row
         , 	tagName)
}
