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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;


/**
 * @author Jeff Muller, jeffrey.muller@epfl.ch
 */
public class HttpRequestUtil {

    /**
     * to fix the problematic use of HttpServletRequest.getRemoteUser throughout Liferay
     */
	public static String getRemoteUser(HttpServletRequest request) {
        return validate(request.getRemoteUser());
	}
	public static String getRemoteUser(PortletRequest request) {
        return validate(request.getRemoteUser());
	}
    
    public static String validate(String userName) {
        long userId = GetterUtil.getLong(userName);
        if(userId <= 0)
            return null;
        else
            return String.valueOf(userId);
    }
}