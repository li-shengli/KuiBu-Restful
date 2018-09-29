package com.selfstudy.kuibu.persistence.factory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;
import com.selfstudy.kuibu.constants.Gender;
import com.selfstudy.kuibu.util.KuiBuConfiguration;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DAOFactory {
	private static Logger logger = Logger.getLogger(DAOFactory.class);

	static String[] CONTACT_POINTS = { KuiBuConfiguration.getInstance().get("db.connection.host") };

	static int PORT = Integer.valueOf(KuiBuConfiguration.getInstance().get("db.connection.port"));

	private Cluster cluster;

	private Session session;

	@PostConstruct
	public void initialize() {
		cluster = Cluster.builder().addContactPoints(CONTACT_POINTS).withPort(PORT).build();

		cluster.getConfiguration().getCodecRegistry().register(new EnumOrdinalCodec<Gender>(Gender.class));

		logger.info("Connected to cluster: " + cluster.getMetadata().getClusterName());

		session = cluster.connect();
	} 

	@PreDestroy
	public void destory() {
		if (session != null) {
			session.close();
		}
		if (cluster != null) {
			cluster.close();
		}
	}
	
	public Session getSession() {
		return session;
	}
	

}
