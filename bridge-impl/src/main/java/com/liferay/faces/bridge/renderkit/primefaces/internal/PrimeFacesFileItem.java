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
package com.liferay.faces.bridge.renderkit.primefaces.internal;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.model.UploadedFile;


/**
 * @author  Neil Griffin
 */
public class PrimeFacesFileItem implements FileItem {

	// serialVersionUID
	private static final long serialVersionUID = 4243775660521293895L;

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(PrimeFacesFileItem.class);

	// Private Data Members
	private String clientId;
	private FileItemHeaders fileItemHeaders;
	private UploadedFile uploadedFile;

	public PrimeFacesFileItem(String clientId, UploadedFile uploadedFile) {
		this.clientId = clientId;
		this.uploadedFile = uploadedFile;
	}

	public void delete() {

		// Will never be called by the PrimeFaces UploadedFile interface.
		throw new UnsupportedOperationException();
	}

	public byte[] get() {

		byte[] bytes = null;

		try {
			File file = new File(uploadedFile.getAbsolutePath());

			if (file.exists()) {
				RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
				bytes = new byte[(int) randomAccessFile.length()];
				randomAccessFile.readFully(bytes);
				randomAccessFile.close();
				file.delete();
			}
		}
		catch (Exception e) {
			logger.error(e);
		}

		return bytes;
	}

	public void write(File file) throws Exception {

		// Will never be called by the PrimeFaces UploadedFile interface.
		throw new UnsupportedOperationException();
	}

	public String getContentType() {
		return uploadedFile.getContentType();
	}

	public boolean isFormField() {
		return false;
	}

	public String getFieldName() {
		return clientId;
	}

	public void setFieldName(String name) {
		clientId = name;
	}

	public void setFormField(boolean state) {

		// Will never be called by the PrimeFaces UploadedFile interface.
		throw new UnsupportedOperationException();
	}

	@Override
	public FileItemHeaders getHeaders() {
		return fileItemHeaders;
	}

	@Override
	public void setHeaders(FileItemHeaders fileItemHeaders) {
		this.fileItemHeaders = fileItemHeaders;
	}

	public InputStream getInputStream() throws IOException {
		return new UploadedFileInputStream(uploadedFile.getAbsolutePath());
	}

	public String getName() {
		return uploadedFile.getName();
	}

	public OutputStream getOutputStream() throws IOException {

		// Will never be called by the PrimeFaces UploadedFile interface.
		throw new UnsupportedOperationException();
	}

	public long getSize() {
		return uploadedFile.getSize();
	}

	public String getString() {
		return getString("UTF-8");
	}

	public String getString(String encoding) {
		String stringValue = null;
		byte[] bytes = get();

		if (bytes != null) {

			try {
				stringValue = new String(bytes, encoding);
			}
			catch (UnsupportedEncodingException e) {
				logger.error(e);
			}
		}

		return stringValue;
	}

	public boolean isInMemory() {
		return false;
	}

}
