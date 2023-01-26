package com.automation.web;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.automation.baseClass.BaseClass;
import com.automation.scenarios.SauceLabScenarios;
import com.automation.supportLibraries.Log4jUtil;

public class SauceLab extends BaseClass {
	Logger log = Log4jUtil.loadLogger(SauceLab.class);
	SauceLabScenarios slScenario = new SauceLabScenarios();

	@Test(priority=0)
	public void addProductToCart()  throws Exception {
		scenarioName = new Exception().getStackTrace()[0].getMethodName();
		slScenario.orderPlacement(scenarioName);}
}

