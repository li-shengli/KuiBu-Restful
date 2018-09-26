package com.selfstudy.kuibu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.Result;
import com.selfstudy.kuibu.persistence.GroupEntity;
import com.selfstudy.kuibu.service.api.IGroupService;
import com.selfstudy.kuibu.vo.Group;
import com.selfstudy.kuibu.vo.GroupMember;

public class GroupService extends AbstractService implements IGroupService {

	@Override
	public List<Group> getGroups() {
		List<Group> results = new ArrayList<Group>();
		Result<GroupEntity> result = accessor.getGroups();
		for (GroupEntity groupEntity : result) {
			Group group = new Group(groupEntity);
			group.setMembers(getGroupMember(groupEntity));
			results.add(group);
		}
		return results;
	}

	@Override
	public Group getGroup(String id) {
		Mapper<GroupEntity> mapper = manager.mapper(GroupEntity.class);
		GroupEntity entity = mapper.get(UUID.fromString(id));
		Group result = new Group(entity);
		result.setMembers(getGroupMember(entity));
		return result;
	}

	@Override
	public void createGroup(Group group) {

		// add new record in group table
		Mapper<GroupEntity> groupMapper = manager.mapper(GroupEntity.class);
		GroupEntity entity = group.toEntity();
		groupMapper.save(entity);

		// add new column for new group in table
		factory.getSession()
				.execute("alter table xplan.personInformation add " + entity.getGroupColumnName() + " int;");
		for (GroupMember member : group.getMembers()) {
			factory.getSession().execute("update xplan.personInformation set " + entity.getGroupColumnName()
					+ " =1 where personID=" + member.getPersonId());
		}

		// create view for new group
		String sqlTemplateForMView = "create materialized view xplan.%view_name% as select personid, name, gid,mail, %column_name% from personinformation where personId is not null and %column_name% is not null primary key (personid, %column_name%)";
		String sqlForMView = sqlTemplateForMView.replaceAll("%view_name%", group.getGroupTableName())
				.replaceAll("%column_name%", group.getGroupColumnName());
		factory.getSession().execute(sqlForMView);
	}

	private List<GroupMember> getGroupMember(GroupEntity group) {
		List<GroupMember> results = new ArrayList<GroupMember>();
		 ResultSet resultSet = manager.getSession().execute(" select personid,gid,name,mail FROM xplan." + group.getGroupTableName()); 
		for (Row row : resultSet.all()) {
			UUID personId = row.get(0, UUID.class);
			String gid = row.getString(1);
			String name = row.getString(2);
			String email = row.getString(3);
			results.add(new GroupMember(personId.toString(), name, gid, email));
		}
		return results;
	}

	@Override
	public void updateGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGroup(Group group) {
		// delete record from group
		accessor.deleteGroup(UUID.fromString(group.getId()));

		// remove view
		factory.getSession().execute(" drop MATERIALIZED VIEW  xplan." + group.getGroupTableName() + "; ");

		// remove column
		factory.getSession().execute("alter table xplan.personInformation drop " + group.getGroupColumnName());
	}

}
