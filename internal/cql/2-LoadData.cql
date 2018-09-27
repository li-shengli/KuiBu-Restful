
truncate eventlist;
truncate personinformation;
truncate eventparticipate;
truncate teaminfo;

alter table eventparticipate add c_movie_ticket_2017_q1 tuple<int, text>;
alter table eventparticipate add c_movie_ticket_2016_q4 tuple<int, text>;
 
insert into eventlist (eventid,createtime,eventcolumnname, eventdesc, eventstatus,eventtitle) values (11111111-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),'c_movie_ticket_2016_q4','ticket',0,'Movie Ticket 2016 Q4');
insert into eventlist (eventid,createtime,eventcolumnname, eventdesc, eventstatus,eventtitle) values (11111112-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),'c_movie_ticket_2017_q1','ticket',0,'Movie Ticket 2017 Q1');

insert into personinformation (personid,createtime,gender,name,namefirstletter,team, GID, mail)values (22222222-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),0,'Zhai Guanglong','ZGL','OSM', '10007817', 'guanglong.zhai@gemalto.com');
insert into personinformation (personid,createtime,gender,name,namefirstletter,team, GID, mail)values (22222223-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),0,'Li Shengli','LSL','OSM', '10007817', 'shengli.li@gemalto.com');
insert into personinformation (personid,createtime,gender,name,namefirstletter,team, GID, mail)values (22222224-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),0,'Yang Bin','YB','DBA', '10007817', 'run.li@gemalto.com');
insert into personinformation (personid,createtime,gender,name,namefirstletter,team, GID, mail)values (22222225-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),0,'Li Run','LR','OSL', '10007817', 'bin.yang@gemalto.com');
insert into personinformation (personid,createtime,gender,name,namefirstletter,team, GID, mail)values (22222226-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),0,'Cheng Zhida','CZD','OSL', '10007817', 'guanglong.zhai@gemalto.com');
insert into personinformation (personid,createtime,gender,name,namefirstletter,team, GID, mail)values (22222227-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),1,'Huang Jianfang','HJF','IW', '10007817', 'run.li@gemalto.com');
insert into personinformation (personid,createtime,gender,name,namefirstletter,team, GID, mail)values (22222228-6221-4ccb-8387-f22b6a1b3543,toTimestamp(now()),1,'Zhu Fan','ZF','NGM', '10007817', 'bin.yang@gemalto.com');

insert into eventparticipate (personid, c_movie_ticket_2016_q4,c_movie_ticket_2017_q1) values (22222222-6221-4ccb-8387-f22b6a1b3543,(0,null),(1,'1483494512678'));
insert into eventparticipate (personid, c_movie_ticket_2016_q4,c_movie_ticket_2017_q1) values (22222223-6221-4ccb-8387-f22b6a1b3543,(0,null),(0,null));
insert into eventparticipate (personid, c_movie_ticket_2016_q4,c_movie_ticket_2017_q1) values (22222224-6221-4ccb-8387-f22b6a1b3543,(1,'1483494512678'),(0,null));
insert into eventparticipate (personid, c_movie_ticket_2016_q4,c_movie_ticket_2017_q1) values (22222225-6221-4ccb-8387-f22b6a1b3543,(0,null),(0,null));
insert into eventparticipate (personid, c_movie_ticket_2016_q4,c_movie_ticket_2017_q1) values (22222226-6221-4ccb-8387-f22b6a1b3543,(1,'1483494512678'),(1,'1483494512678'));
insert into eventparticipate (personid, c_movie_ticket_2016_q4,c_movie_ticket_2017_q1) values (22222227-6221-4ccb-8387-f22b6a1b3543,(0,null),(0,null));
insert into eventparticipate (personid, c_movie_ticket_2016_q4,c_movie_ticket_2017_q1) values (22222228-6221-4ccb-8387-f22b6a1b3543,(0,null),(0,null));

insert into teaminfo(teamid,name, teamLeader) values(33333331-6221-4ccb-8387-f22b6a1b3543,'OSM', 'LiHaixue');
insert into teaminfo(teamid,name, teamLeader) values(33333332-6221-4ccb-8387-f22b6a1b3543,'DBA', 'YangBin');
insert into teaminfo(teamid,name, teamLeader) values(33333333-6221-4ccb-8387-f22b6a1b3543,'OSL', 'Musa');
insert into teaminfo(teamid,name, teamLeader) values(33333334-6221-4ccb-8387-f22b6a1b3543,'NGM', 'MaZhongyuan');
insert into teaminfo(teamid,name, teamLeader) values(33333335-6221-4ccb-8387-f22b6a1b3543,'IW', 'Susan');
 