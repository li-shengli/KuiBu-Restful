package com.selfstudy.kuibu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class XplanConfiguration {
	private static Logger logger = Logger.getLogger(XplanConfiguration.class);

	private static XplanConfiguration instance = new XplanConfiguration();

	private Properties properties = new Properties();

	private XplanConfiguration() {
		try {
			InputStream stream = XplanConfiguration.class.getResourceAsStream("/xplan.properties");
			this.properties.load(stream);
		} catch (IOException e) {
			logger.error("Cannot Init Cofigurtion", e);
		}
	}

	public static XplanConfiguration getInstance() {
		return instance;
	}

	public String get(String key) {
		return properties.getProperty(key);
	}
}
