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
package com.liferay.cdi.portlet.bridge.filter;

import java.io.IOException;
import java.util.Collection;

import javax.portlet.PortletRequest;
import javax.portlet.filter.PortletRequestWrapper;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * This class isolates methods that were added to {@link HttpServletRequest} in the Servlet 3.0 API.
 *
 * @author  Neil Griffin
 */
public abstract class HttpServletRequest_3_0_Adapter extends PortletRequestWrapper implements HttpServletRequest {

	public HttpServletRequest_3_0_Adapter(PortletRequest portletRequest) {
		super(portletRequest);
	}

	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		throw new UnsupportedOperationException();
	}

	public void login(String username, String password) throws ServletException {
		throw new UnsupportedOperationException();
	}

	public void logout() throws ServletException {
		throw new UnsupportedOperationException();
	}

	public AsyncContext startAsync() throws IllegalStateException {
		throw new UnsupportedOperationException();
	}

	public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
		throws IllegalStateException {
		throw new UnsupportedOperationException();
	}

	public AsyncContext getAsyncContext() {
		throw new UnsupportedOperationException();
	}

	public boolean isAsyncStarted() {
		throw new UnsupportedOperationException();
	}

	public boolean isAsyncSupported() {
		throw new UnsupportedOperationException();
	}

	public DispatcherType getDispatcherType() {
		throw new UnsupportedOperationException();
	}

	public Part getPart(String name) throws IOException, ServletException {
		throw new UnsupportedOperationException();
	}

	public Collection<Part> getParts() throws IOException, ServletException {
		throw new UnsupportedOperationException();
	}

	public ServletContext getServletContext() {
		throw new UnsupportedOperationException();
	}
}
