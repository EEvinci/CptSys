/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/8/28 14:41:37                           */
/*==============================================================*/


drop table if exists AdminInfo;

drop table if exists CptInfo;

drop table if exists CptItemsInfo;

drop table if exists Register;

drop table if exists StuInfo;

drop table if exists Team;

drop table if exists getTeam;

/*==============================================================*/
/* Table: AdminInfo                                             */
/*==============================================================*/
create table AdminInfo
(
   AdministratorNumber  varchar(20) not null,
   Name                 varchar(20),
   LoginPassword        varchar(30),
   primary key (AdministratorNumber)
);

/*==============================================================*/
/* Table: CptInfo                                               */
/*==============================================================*/
create table CptInfo
(
   CptNum               varchar(20) not null,
   CptItemNum           varchar(20),
   CptName              varchar(50),
   CptYear              date,
   HoldTime             int,
   RegiStart            datetime,
   RegiEnd              datetime,
   GameTime             date,
   Contact              varchar(20),
   Web                  varchar(50),
   primary key (CptNum)
);

/*==============================================================*/
/* Table: CptItemsInfo                                          */
/*==============================================================*/
create table CptItemsInfo
(
   CptItemNul           varchar(20) not null,
   CptItemName          varchar(50),
   ResPerson            varchar(20),
   BelongCol            varchar(30),
   CptLevel             char(1),
   primary key (CptItemNul)
);

/*==============================================================*/
/* Table: Register                                              */
/*==============================================================*/
create table Register
(
   TeamNum              varchar(20) not null,
   CptNum               varchar(20) not null,
   RegiTime             datetime,
   RegiStatus           varchar(10),
   AwardGrade           varchar(10),
   primary key (TeamNum, CptNum)
);

/*==============================================================*/
/* Table: StuInfo                                               */
/*==============================================================*/
create table StuInfo
(
   StuNum               varchar(20) not null,
   Name                 varchar(20),
   LogPsw               varchar(30),
   Class                varchar(20),
   Grade                varchar(20),
   Profess              varchar(20),
   PhoneNum             varchar(20),
   primary key (StuNum)
);

/*==============================================================*/
/* Table: Team                                                  */
/*==============================================================*/
create table Team
(
   TeamNum              varchar(20) not null,
   TeamName             varchar(20),
   PlayerNum            int,
   primary key (TeamNum)
);

/*==============================================================*/
/* Table: getTeam                                               */
/*==============================================================*/
create table getTeam
(
   StuNum               varchar(20) not null,
   TeamNum              varchar(20) not null,
   Leader               varchar(10),
   Participate          varchar(10),
   primary key (StuNum, TeamNum)
);

alter table CptInfo add constraint FK_Contain foreign key (CptItemNum)
      references CptItemsInfo (CptItemNul) on delete restrict on update restrict;

alter table Register add constraint FK_Register foreign key (TeamNum)
      references Team (TeamNum) on delete restrict on update restrict;

alter table Register add constraint FK_Register2 foreign key (CptNum)
      references CptInfo (CptNum) on delete restrict on update restrict;

alter table getTeam add constraint FK_getTeam foreign key (StuNum)
      references StuInfo (StuNum) on delete restrict on update restrict;

alter table getTeam add constraint FK_getTeam2 foreign key (TeamNum)
      references Team (TeamNum) on delete restrict on update restrict;

