/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/8/30 14:31:51                           */
/*==============================================================*/


drop table if exists AdminInfo;

drop table if exists CptInfo;

drop table if exists CptItInfo;

drop table if exists GetTeam;

drop table if exists Register;

drop table if exists StuInfo;

drop table if exists Team;

/*==============================================================*/
/* Table: AdminInfo                                             */
/*==============================================================*/
create table AdminInfo
(
   AdminId              varchar(20) not null,
   Name                 varchar(20),
   AdPsw                varchar(30),
   primary key (AdminId)
);

/*==============================================================*/
/* Table: CptInfo                                               */
/*==============================================================*/
create table CptInfo
(
   CptId                varchar(20) not null,
   CptItemId            varchar(20),
   CptName              varchar(50),
   CptYear              varchar(20),
   HoldTime             varchar(20),
   RegiStart            varchar(20),
   RegiEnd              varchar(20),
   GameTime             varchar(20),
   Contact              varchar(20),
   Web                  varchar(50),
   primary key (CptId)
);

/*==============================================================*/
/* Table: CptItInfo                                             */
/*==============================================================*/
create table CptItInfo
(
   CptItemId            varchar(20) not null,
   CptItemName          varchar(50),
   ResPerson            varchar(20),
   BelongCol            varchar(30),
   CptLevel             varchar(20),
   primary key (CptItemId)
);

/*==============================================================*/
/* Table: GetTeam                                               */
/*==============================================================*/
create table GetTeam
(
   StuId                varchar(20) not null,
   TeamId               varchar(20) not null,
   IsLeader             varchar(10),
   IsPtcpt              varchar(10),
   primary key (StuId, TeamId)
);

/*==============================================================*/
/* Table: Register                                              */
/*==============================================================*/
create table Register
(
   TeamId               varchar(20) not null,
   CptId                varchar(20) not null,
   RegiTime             varchar(20),
   RegiStatus           varchar(10),
   AwdGrade             varchar(10),
   primary key (TeamId, CptId)
);

/*==============================================================*/
/* Table: StuInfo                                               */
/*==============================================================*/
create table StuInfo
(
   StuId                varchar(20) not null,
   Name                 varchar(20),
   StuPsw               varchar(30),
   SClass               varchar(20),
   Grade                varchar(20),
   Profess              varchar(20),
   PhoneNum             varchar(20),
   primary key (StuId)
);

/*==============================================================*/
/* Table: Team                                                  */
/*==============================================================*/
create table Team
(
   TeamId               varchar(20) not null,
   TeamName             varchar(20),
   MemNum               int,
   primary key (TeamId)
);

alter table CptInfo add constraint FK_Contain foreign key (CptItemId)
      references CptItInfo (CptItemId) on delete restrict on update restrict;

alter table GetTeam add constraint FK_getTeam foreign key (StuId)
      references StuInfo (StuId) on delete restrict on update restrict;

alter table GetTeam add constraint FK_getTeam2 foreign key (TeamId)
      references Team (TeamId) on delete restrict on update restrict;

alter table Register add constraint FK_Register foreign key (TeamId)
      references Team (TeamId) on delete restrict on update restrict;

alter table Register add constraint FK_Register2 foreign key (CptId)
      references CptInfo (CptId) on delete restrict on update restrict;

