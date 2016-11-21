# Hibernate tablolari olusturduktan sonra calistirir

SET GLOBAL FOREIGN_KEY_CHECKS=0;

# roles
insert into Role(id,title) values('1','Admin');
insert into Role(id,title) values('2','Instructor');
insert into Role(id,title) values('3','Student');

# users
insert into User(id,name,surname,email,password,tcNo,active,roleId) values ('1','Gürkan Mustafa','CAKIR','admin@gmail.com','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.','51245853952',b'1',1);
insert into User(id,name,surname,email,password,tcNo,active,roleId) values ('2','Ahmet','EMİN','instructor@gmail.com','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.','51539524576',b'1',2);
insert into User(id,name,surname,email,password,tcNo,active,roleId) values ('3','Mehmet','ÇALIŞ','student@gmail.com','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.','1111111111',b'1',3);

# season
insert into Season(id,title,startDate,endDate) values ('1','2016-2017 GÜZ','2016-10-01','2017-01-07');