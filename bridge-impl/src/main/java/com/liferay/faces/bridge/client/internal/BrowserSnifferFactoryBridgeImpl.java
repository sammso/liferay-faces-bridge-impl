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
package com.liferay.faces.bridge.client.internal;

import javax.faces.context.ExternalContext;

import com.liferay.faces.util.client.BrowserSniffer;
import com.liferay.faces.util.client.BrowserSnifferFactory;


/**
 * @author  Kyle Stiemann
 */
public class BrowserSnifferFactoryBridgeImpl extends BrowserSnifferFactory {

	// Private Data Memebers
	private BrowserSnifferFactory wrappedBrowserSnifferFactory;

	public BrowserSnifferFactoryBridgeImpl(BrowserSnifferFactory browserSnifferFactory) {
		this.wrappedBrowserSnifferFactory = browserSnifferFactory;
	}

	@Override
	public BrowserSniffer getBrowserSniffer(ExternalContext externalContext) {

		// Since we cannot obtain the HttpServletRequest, so we cannot obtain information about the browser, so
		// return a BrowserSniffer implementation which returns false for all booleans, 0 for all numbers, and "" for
		// all Strings.
		return new BrowserSnifferPortalImpl();
	}

	@Override
	public BrowserSnifferFactory getWrapped() {
		return wrappedBrowserSnifferFactory;
	}
}
