package com.commonutils;

import com.api.TestContext;
import com.ui.utils.DriverFactory;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static DriverFactory driverFactory;

	private static GetPropertyValue configFileReader;

	private static TestContext context;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public static DriverFactory getDriver() {
		return (driverFactory == null) ? new DriverFactory() : driverFactory;
	}

	public static GetPropertyValue getConfigReader() {
		return (configFileReader == null) ? new GetPropertyValue() : configFileReader;
	}

	public static TestContext getTestContext() {
		return (context == null) ? new TestContext() : context;
	}

}
