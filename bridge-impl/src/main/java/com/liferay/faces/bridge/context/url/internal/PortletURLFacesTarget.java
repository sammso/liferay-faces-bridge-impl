/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.bridge.context.url.internal;

import java.net.MalformedURLException;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.faces.bridge.filter.internal.PortletURLWrapper;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Neil Griffin
 */
public abstract class PortletURLFacesTarget extends PortletURLWrapper {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(PortletURLFacesTarget.class);

	// Private Data Members
	private PortletURL wrappedPortletURL;

	public PortletURLFacesTarget(PortletURL portletURL, String portletMode, String windowState, boolean secure)
		throws MalformedURLException {

		this.wrappedPortletURL = portletURL;

		if (portletMode != null) {

			try {
				this.wrappedPortletURL.setPortletMode(new PortletMode(portletMode));
			}
			catch (PortletModeException e) {

				if (portletMode == null) {
					logger.error(e.getMessage());
				}
				else {
					logger.error(e.getMessage() + " portletMode=[" + portletMode + "]");
				}
			}
		}

		if (windowState != null) {

			try {
				this.wrappedPortletURL.setWindowState(new WindowState(windowState));
			}
			catch (WindowStateException e) {

				if (windowState == null) {
					logger.error(e.getMessage());
				}
				else {
					logger.error(e.getMessage() + " windowState=[" + windowState + "]");
				}
			}
		}

		try {
			this.wrappedPortletURL.setSecure(secure);
		}
		catch (PortletSecurityException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public PortletURL getWrapped() {
		return wrappedPortletURL;
	}
}
