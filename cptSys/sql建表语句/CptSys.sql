/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/8/28 11:30:41                           */
/*==============================================================*/


drop table if exists AdministratorInformationSheet;

drop table if exists CompetitionInformation;

drop table if exists CompetitionItemsInformation;

drop table if exists Register;

drop table if exists StudentInformation;

drop table if exists TeamTable;

drop table if exists getTeam;

/*==============================================================*/
/* Table: AdministratorInformationSheet                         */
/*==============================================================*/
create table AdministratorInformationSheet
(
   AdministratorNumber  varchar(20) not null,
   Name                 varchar(20),
   LoginPassword        varchar(30),
   primary key (AdministratorNumber)
);

/*==============================================================*/
/* Table: CompetitionInformation                                */
/*==============================================================*/
create table CompetitionInformation
(
   CompetitionNumber    varchar(20) not null,
   GameNumber           varchar(20),
   CompetitionName      varchar(50),
   CompetitionYear      date,
   HoldingPeriod        int,
   RegistrationStart    datetime,
   RegistrationEnd      datetime,
   CompetingTime        date,
   Contacts             varchar(20),
   Website              varchar(50),
   primary key (CompetitionNumber)
);

/*==============================================================*/
/* Table: CompetitionItemsInformation                           */
/*==============================================================*/
create table CompetitionItemsInformation
(
   GameNumber           varchar(20) not null,
   GameName             varchar(50),
   ResponsiblePerson    varchar(20),
   AffiliatedCollege    varchar(30),
   CompetitionLevel     char(1),
   primary key (GameNumber)
);

/*==============================================================*/
/* Table: Register                                              */
/*==============================================================*/
create table Register
(
   TeamsNumber          varchar(20) not null,
   CompetitionNumber    varchar(20) not null,
   RegistrationTime     datetime,
   RegistrationStatus   varchar(10),
   AwardGrade           varchar(10),
   primary key (TeamsNumber, CompetitionNumber)
);

/*==============================================================*/
/* Table: StudentInformation                                    */
/*==============================================================*/
create table StudentInformation
(
   StudentNumber        varchar(20) not null,
   Name                 varchar(20),
   LoginPassword        varchar(30),
   Class                varchar(20),
   Grade                varchar(20),
   Specialty            varchar(20),
   PhoneNumber          varchar(20),
   primary key (StudentNumber)
);

/*==============================================================*/
/* Table: TeamTable                                             */
/*==============================================================*/
create table TeamTable
(
   TeamsNumber          varchar(20) not null,
   TeamName             varchar(20),
   NumberOfPlayer       int,
   primary key (TeamsNumber)
);

/*==============================================================*/
/* Table: getTeam                                               */
/*==============================================================*/
create table getTeam
(
   StudentNumber        varchar(20) not null,
   TeamsNumber          varchar(20) not null,
   isLeader            varchar(10),
   isWillToParticipate varchar(10),
   primary key (StudentNumber, TeamsNumber)
);

alter table CompetitionInformation add constraint FK_Contain foreign key (GameNumber)
      references CompetitionItemsInformation (GameNumber) on delete restrict on update restrict;

alter table Register add constraint FK_Register foreign key (TeamsNumber)
      references TeamTable (TeamsNumber) on delete restrict on update restrict;

alter table Register add constraint FK_Register2 foreign key (CompetitionNumber)
      references CompetitionInformation (CompetitionNumber) on delete restrict on update restrict;

alter table getTeam add constraint FK_getTeam foreign key (StudentNumber)
      references StudentInformation (StudentNumber) on delete restrict on update restrict;

alter table getTeam add constraint FK_getTeam2 foreign key (TeamsNumber)
      references TeamTable (TeamsNumber) on delete restrict on update restrict;

