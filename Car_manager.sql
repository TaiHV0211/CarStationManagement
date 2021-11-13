CREATE DATABASE CAR
GO
USE CAR
GO

create table Account 
(
	USERNAME varchar(50),
	GMAIL NCHAR(50),
	PASS CHAR(20) UNIQUE NOT NULL,
	CONFIRM CHAR(20) NOT NULL,
	CONSTRAINT PK_US PRIMARY KEY (USERNAME)
)
go
-- drop table USERS
select * from Account
insert into Account VALUES 
('vanhtai','vantai@0211','sfdsf','ád')