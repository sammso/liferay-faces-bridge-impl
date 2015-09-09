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
package com.liferay.faces.bridge.scope.internal;

import com.liferay.faces.bridge.scope.BridgeRequestScopeManager;
import com.liferay.faces.bridge.scope.BridgeRequestScopeManagerFactory;


/**
 * @author  Neil Griffin
 */
public class BridgeRequestScopeManagerFactoryImpl extends BridgeRequestScopeManagerFactory {

	@Override
	public BridgeRequestScopeManager getBridgeRequestScopeManager() {

		BridgeRequestScopeManager bridgeRequestScopeManager = null;

		if (bridgeRequestScopeManager == null) {
			bridgeRequestScopeManager = new BridgeRequestScopeManagerImpl();
		}

		return bridgeRequestScopeManager;
	}

	public BridgeRequestScopeManagerFactory getWrapped() {

		// Since this is the factory instance provided by the bridge, it will never wrap another factory.
		return null;
	}

}
