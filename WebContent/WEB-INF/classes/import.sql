# Hibernate tablolari olusturduktan sonra calistirir

# roles
insert into Role(id,title) values('1','Admin');
insert into Role(id,title) values('2','Instructer');
insert into Role(id,title) values('3','Student');

# users
insert into User(id,name,surname,email,password,tcNo,active,role_id) values ('1','Gürkan Mustafa','CAKIR','admin@admin.com','asdasd','51245853952',b'1','1');
insert into User(id,name,surname,email,password,tcNo,active,role_id) values ('2','Ahmet','EMİN','ahmet@emin.com','asdasd','51539524576',b'1','2');
insert into User(id,name,surname,email,password,tcNo,active,role_id) values ('3','Mehmet','ÇALIŞ','mehmet@calis.com','asdasd','1111111111',b'1','3');

# season
insert into Season(id,title,startDate,endDate) values ('1','2016-2017 GÜZ','2016-10-01','2017-01-07');

# faculty
insert into Faculty(id,name) values ('1','Mühendislik Fakultesi');
insert into Faculty(id,name) values ('2','İktisadi ve İdari Bilimler Fakultesi');
insert into Faculty(id,name) values ('3','Fen Edebiyat Fakultesi');
insert into Faculty(id,name) values ('4','Güzelsanatlar Fakultesi');

# department
insert into Department(id,name,faculty_id) values ('1','Bilgisayar Mühendisliği','1');
insert into Department(id,name,faculty_id) values ('2','Kimya Mühendisliği','1');

# userDepartment
insert into UserDepartment(id,user_id,department_id,startDate,endDate,active) values ('1','1','1','2016-10-10',NULL,b'1');

# Lesson
insert into Lesson(id,name,credit,ects,lessonAbstract,department_id,instructor_id) values ('1','Fizik','5','5','asd','1','2');
insert into Lesson(id,name,credit,ects,lessonAbstract,department_id,instructor_id) values ('2','Matematik','5','5','asdef','1','2');
