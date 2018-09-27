package com.selfstudy.kuibu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class KuiBuConfiguration {
	private static Logger logger = Logger.getLogger(KuiBuConfiguration.class);

	private static KuiBuConfiguration instance = new KuiBuConfiguration();

	private Properties properties = new Properties();

	private KuiBuConfiguration() {
		try {
			InputStream stream = KuiBuConfiguration.class.getResourceAsStream("/kuibu.properties");
			this.properties.load(stream);
		} catch (IOException e) {
			logger.error("Cannot Init Cofigurtion", e);
		}
	}

	public static KuiBuConfiguration getInstance() {
		return instance;
	}

	public String get(String key) {
		return properties.getProperty(key);
	}
}
