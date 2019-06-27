package executionEngine;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript {
	
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static Method method[];
    
    public DriverScript()
    {
    	actionKeywords=new ActionKeywords();
    	
    	method=actionKeywords.getClass().getMethods();
    }
    
	public static void main(String[] args) throws Exception {
		
	String sPath=Constants.Path_TestData;
		
    ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestSteps);
    
    for(int iRow=1;iRow<=9;iRow++)
    {
      String sActionKeyword=ExcelUtils.getCellData(iRow,Constants.Col_ActionKeyword);
      execute_Actions();
      
      }
  
      }
	
	private static void execute_Actions()throws Exception{
		
		for(int i=0;i<method.length;i++) {
			
			if(method[i].getName().equals(sActionKeyword)) {
				method[i].invoke(actionKeywords);
				
				break;
			}
		}
	}
	
	}


