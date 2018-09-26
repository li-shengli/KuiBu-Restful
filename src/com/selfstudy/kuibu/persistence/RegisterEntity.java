package com.selfstudy.kuibu.persistence;

import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "xplan", name = "eventparticipate", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class RegisterEntity {


	@PartitionKey
	@Column(name = "persionid")
	private UUID id;

	@Column(name="name")
	private String name;
	
	
}
