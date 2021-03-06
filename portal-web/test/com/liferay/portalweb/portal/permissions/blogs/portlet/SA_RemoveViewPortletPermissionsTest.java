/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_RemoveViewPortletPermissionsTest extends BaseTestCase {
	public void testSA_RemoveViewPortletPermissions() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Blogs Permissions Page");
		selenium.clickAt("link=Blogs Permissions Page",
			RuntimeVariables.replace("Blogs Permissions Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		Thread.sleep(5000);
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(@id,'configuration')]");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(@id,'configuration')]"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(@id,'configuration')]",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible("link=Permissions");
		selenium.clickAt("link=Permissions",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("//iframe[@id='_33_configurationIframeDialog']");
		selenium.selectFrame("//iframe[@id='_33_configurationIframeDialog']");
		assertTrue(selenium.isChecked("//input[@id='guest_ACTION_VIEW']"));
		selenium.uncheck("//input[@id='guest_ACTION_VIEW']");
		assertFalse(selenium.isChecked("//input[@id='guest_ACTION_VIEW']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.waitForVisible("//input[@id='guest_ACTION_VIEW']");
		assertFalse(selenium.isChecked("//input[@id='guest_ACTION_VIEW']"));
		selenium.selectFrame("relative=top");
	}
}