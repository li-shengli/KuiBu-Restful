/*create key space*/
CREATE KEYSPACE KuiBu
           WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 2};

/*create key family*/	   
CREATE TABLE userInformation (
	longinName text PRIMARY KEY,
	password text,
	userId uuid,
    nickname text,
    gender int,     --0 means male, 1 means female
    mail text,
	profileUrl text,
	tasklist list<uuid>, -- list of taskId
    createTime timestamp,
    lastUpdateTime timestamp
) WITH comment='user information';

CREATE TABLE taskCommonInfo (
    taskId uuid,
    taskName text,
    taskType int,
    taskStatus int,      --currently not in used 
    taskFrom int,        --0 means private, 1 means public 
	priority int,
    createTime timestamp,
	startTime timestamp,
    lastUpdateTime timestamp,
	endTime timestamp,
    PRIMARY KEY (taskId)
) WITH comment='Common Information of one task';

CREATE TABLE taskReadingInfo (
    taskId uuid,
	pagesIntotal int,
	pagesCurrent int,
	daysToFinish int, --how many days will be spent to finish this book
	history map<int, int>, --key is the days since the task started, value is the number of pages was read in that day.
	PRIMARY KEY (taskId)
) WITH comment='Information for tasks of Reading';