--删除触发器
drop trigger tr_student_delete;
drop trigger tr_student_update;
drop trigger tr_student_insert;

drop trigger tr_grade_delete;
drop trigger tr_grade_update;
drop trigger tr_grade_insert;

--删除序列
drop sequence gid;

--删除所有表
drop table student;
drop table grade;
drop table operation




--创建记录在源数据库的进行修改、删除的操作的表
create table operation(
                        tablename varchar(30),
                        primarykey  char(9) ,
                        ation char(1)
);

--创建班级表序列
create sequence gid increment by 1 start with 1;

--创建班级表
create table grade(
    gid         int           primary key,    
    gname       varchar2(50)  not null,       
    year        char(4)       not null,          
    stucount    int default(0)
);


--创建学生表
create table student(
    sno         char(9)       primary key,    
    sname       varchar2(50)  not null,       
    ssex        char(3)       not null,       
    sage        smallint      not null,       
    gid         int           not null,       
    foreign key (gid) references grade(gid) on delete cascade
);

--**************************记录对student表进行删除操作的触发器***********************
create or replace trigger tr_student_delete
before delete on student
referencing old as old new as new
for each row
  begin
    insert into operation(tablename,primarykey,ation) values('student',:old.sno,'D');
end tr_student_delete;
--**************************记录对student表进行删除操作的触发器结束***********************

--**************************记录对student表进行修改操作的触发器***********************
create or replace trigger tr_student_update
before update on student
referencing old as old new as new
for each row
  begin
    insert into operation(tablename,primarykey,ation) values('student',:old.sno,'U');
end tr_student_update;
--**************************记录对student表进行修改操作的触发器结束***********************

--**************************记录对student表进行插入操作的触发器***********************
create or replace trigger tr_student_insert
after insert on student
referencing old as old new as new
for each row
  begin
    insert into operation(tablename,primarykey,ation) values('student',:new.sno,'I');
end tr_student_insert;
--**************************记录对student表进行插入操作的触发器结束***********************

--**************************记录对grade表进行删除操作的触发器***********************
create or replace trigger tr_grade_delete
before delete on grade
referencing old as old new as new
for each row
  begin
    insert into operation(tablename,primarykey,ation) values('grade',:old.gid,'D');
end tr_grade_delete;
--**************************记录对grade表进行删除操作的触发器结束***********************

--**************************记录对grade表进行修改操作的触发器***********************
create or replace trigger tr_grade_update
after update on grade
referencing old as old new as new
for each row
  begin
    if :new.gid != :old.gid or :new.gname != :old.gname or :new.year != :old.year then
      insert into operation(tablename,primarykey,ation) values('grade',:old.gid,'U');
      end if;
end tr_grade_update;
--**************************记录对grade表进行删除操作的触发器结束***********************

--**************************记录对grade表进行插入操作的触发器***********************
create or replace trigger tr_grade_insert
after insert on grade
referencing old as old new as new
for each row
  begin
    insert into operation(tablename,primarykey,ation) values('grade',:new.gid,'I');
end tr_grade_insert;
--**************************记录对grade表进行插入操作的触发器结束***********************


--**************************统计学生数量触发器开始***********************
create or replace trigger tr_student
after insert or delete or update on student
declare
  cursor cur_student is select gid,count(*) count from student group by gid;
begin
  for temp in cur_student loop
       update grade set stucount = temp.count where (gid = temp.gid and grade.stucount != temp.count);
  end loop;
end tr_student;
--**************************统计学生数量触发器结束***********************

--插入班级表数据
insert into grade(gid,gname,year) values(gid.nextval,'计算机141','2014');
insert into grade(gid,gname,year) values(gid.nextval,'计算机142','2014');
insert into grade(gid,gname,year) values(gid.nextval,'计算机143','2014');
insert into grade(gid,gname,year) values(gid.nextval,'软件141','2014');
insert into grade(gid,gname,year) values(gid.nextval,'计算机151','2015');
insert into grade(gid,gname,year) values(gid.nextval,'计算机152','2015');
insert into grade(gid,gname,year) values(gid.nextval,'软件151','2015');
insert into grade(gid,gname,year) values(gid.nextval,'软件152','2015');
insert into grade(gid,gname,year) values(gid.nextval,'自动化151','2015');
insert into grade(gid,gname,year) values(gid.nextval,'自动化152','2015');
insert into grade(gid,gname,year) values(gid.nextval,'自动化153','2015');
insert into grade(gid,gname,year) values(gid.nextval,'自动化154','2015');
commit;


--插入学生表数据
insert into student values('201400601','李勇','男',19,1);
insert into student values('201400602','刘晨','男',20,1);
insert into student values('201400603','王敏','女',20,1);
insert into student values('201400604','张立','男',22,1);
insert into student values('201400605','吴宾','女',21,1);
insert into student values('201400606','张海','男',20,1);
insert into student values('201400607','钱小平','女',18,1);
insert into student values('201400608','王大力','男',19,1);
insert into student values('201400609','张健','男',19,1);
insert into student values('201400610','张齐朴','男',19,1);
insert into student values('201400611','何世焱','男',19,1);
insert into student values('201400612','乔勇','男',19,1);
insert into student values('201400613','余天璞','男',19,1);
insert into student values('201400614','郑德祥','男',19,1);
insert into student values('201400615','沈忱','男',19,1);
insert into student values('201400616','杜达林','男',19,1);
insert into student values('201400617','方科','男',19,1);
insert into student values('201400618','崔昌瑞','男',19,1);
insert into student values('201400619','蔡基利','男',19,1);
insert into student values('201400620','陈礼锐','男',19,1);

insert into student values('201400630','刘大伟','男',19,2);
insert into student values('201400631','杨宝宏','男',19,2);
insert into student values('201400632','陈立淦','男',19,2);
insert into student values('201400633','肖克','男',19,2);
insert into student values('201400634','郭清吉','男',19,2);
insert into student values('201400635','代磊','男',19,2);
insert into student values('201400636','刘斌龙','男',19,2);
insert into student values('201400637','陈少鹏','男',19,2);
insert into student values('201400638','张嘉伟','男',19,2);
insert into student values('201400639','李博古','男',19,2);
insert into student values('201400640','金力','男',19,2);
insert into student values('201400641','张景峰','男',19,2);
insert into student values('201400642','张仁涛','男',19,2);
insert into student values('201400643','裴晓斌','男',19,2);
insert into student values('201400644','李成','男',19,2);
insert into student values('201400645','王龙','男',19,2);
insert into student values('201400646','史成林','男',19,2);
insert into student values('201400647','刘其辉','男',19,2);
insert into student values('201400648','张锋','男',19,2);
insert into student values('201400649','常铮','男',19,2);
insert into student values('201400650','王娜娜','女',19,2);
insert into student values('201400651','严涛','男',19,2);
insert into student values('201400652','李江','男',19,2);
insert into student values('201400653','李晓真','男',19,2);
insert into student values('201400654','罗雷','男',19,2);
insert into student values('201400655','李豪','男',19,2);
insert into student values('201400656','高瞻','男',19,2);
insert into student values('201400657','吴建兵','男',19,2);
insert into student values('201400658','陈新坤','男',19,2);
insert into student values('201400659','李盼','男',19,2);
insert into student values('201400660','潘威','男',19,2);
insert into student values('201400661','陈光银','男',19,2);

insert into student values('201400670','吕建雨','男',19,3);
insert into student values('201400671','尚前进','男',19,3);
insert into student values('201400672','陈龙','男',19,3);
insert into student values('201400673','潘和星','男',19,3);
insert into student values('201400674','陈啟飞','男',19,3);
insert into student values('201400675','罗烈','男',19,3);
insert into student values('201400676','陈涛','男',19,3);
insert into student values('201400677','许泽亭','男',19,3);
insert into student values('201400678','卢秦亮','男',19,3);
insert into student values('201400679','张云飞','男',19,3);
insert into student values('201400680','史博文','男',19,3);
insert into student values('201400681','龚进伟','男',19,3);
insert into student values('201400682','周靖','男',19,3);
insert into student values('201400683','孙亚鹏','男',19,3);
insert into student values('201400684','陈强','男',19,3);
insert into student values('201400685','罗四维','男',19,3);
insert into student values('201400686','赫中翮','男',19,3);
insert into student values('201400687','王辉','男',19,3);
insert into student values('201400688','刁劼庭','男',19,3);
insert into student values('201400689','白小康','男',19,3);
insert into student values('201400690','方敏','男',19,3);
insert into student values('201400691','张博文','男',19,3);
insert into student values('201400692','秦正位','男',19,3);
insert into student values('201400693','熊海森','男',19,3);
insert into student values('201400694','曾虎','男',19,3);
insert into student values('201400695','张小华','男',19,3);
insert into student values('201400696','宋亚威','男',19,3);
insert into student values('201400697','张龙','男',19,3);
insert into student values('201400698','王德红','男',19,3);
insert into student values('201400699','杨文亮','男',19,3);
insert into student values('201400700','石东','男',19,3);
insert into student values('201400701','董求求','男',19,3);

insert into student values('201500488','杨武','男',19,9);
insert into student values('201500775','徐康','男',19,9);
insert into student values('201500816','袁磊','男',19,9);
insert into student values('201500824','柯信','男',19,9);
insert into student values('201500831','周豪杰','男',19,9);
insert into student values('201500832','孟春节','男',19,9);
insert into student values('201500833','苏逸帆','男',19,9);
insert into student values('201500834','陈恒锋','男',19,9);
insert into student values('201500835','申能','男',19,9);
insert into student values('201500836','姜明','男',19,9);
insert into student values('201500843','张杨','男',19,9);
insert into student values('201502005','吕豪','男',19,9);
insert into student values('201500855','邹元广','男',19,9);
insert into student values('201500856','阳争超','男',19,9);
insert into student values('201500857','柯贤聪','男',19,9);
insert into student values('201500858','余邦豪','男',19,9);
insert into student values('201500859','南亮亮','男',19,9);
insert into student values('201500860','卢旭','男',19,9);
insert into student values('201500861','郭志欣','男',19,9);
insert into student values('201500862','张律','男',19,10);
insert into student values('201500863','张雨佳','男',19,10);
insert into student values('201500864','林小丰','男',19,10);
insert into student values('201500865','齐斌凯','男',19,10);
insert into student values('201500866','程东承','男',19,10);
insert into student values('201500867','侯华龙','男',19,10);
insert into student values('201500868','胡宇航','男',19,10);
insert into student values('201500869','吴素谦','男',19,10);
insert into student values('201500870','王高','男',19,10);
insert into student values('201500871','葛龙','男',19,10);
insert into student values('201500872','黄鑫','男',19,10);
insert into student values('201500873','郑兴','男',19,10);
insert into student values('201500875','银泽','男',19,10);
insert into student values('201500876','刘宇炜','男',19,10);
insert into student values('201500878','罗志刚','男',19,10);
insert into student values('201500879','胡耀天','男',19,10);
insert into student values('201500880','王璇','男',19,10);
insert into student values('201500881','蒲星宇','男',19,10);
insert into student values('201500882','艾杰','男',19,10);
insert into student values('201500883','夏超锋','男',19,10);
insert into student values('201500885','张雨','男',19,10);
insert into student values('201500886','李龙','男',19,10);
insert into student values('201500380','张稳','男',19,10);
insert into student values('201500890','汪向杰','男',19,11);
insert into student values('201500891','丁明波','男',19,11);
insert into student values('201500892','李冲','男',19,11);
insert into student values('201500893','刘栋梁','男',19,11);
insert into student values('201500894','王鹏坤','男',19,11);
insert into student values('201500895','魏磊斌','男',19,11);
insert into student values('201500896','邓玢璐','男',19,11);
insert into student values('201500897','李志文','男',19,11);
insert into student values('201500898','陶新宇','男',19,11);
insert into student values('201500899','赵德坤','男',19,11);
insert into student values('201500900','王博文','男',19,11);
insert into student values('201500901','彭文豪','男',19,11);
insert into student values('201500902','黄飞灵','男',19,11);
insert into student values('201500903','周晓双','男',19,11);
insert into student values('201500904','张清亮','男',19,11);
insert into student values('201500905','祝小明','男',19,11);
insert into student values('201500907','张元松','男',19,11);
insert into student values('201500908','龚宸','男',19,11);
insert into student values('201500909','向忠旭','男',19,11);
insert into student values('201500910','徐林浩','男',19,11);
insert into student values('201500911','许威','男',19,11);
insert into student values('201500912','吕青秀','男',19,11);
insert into student values('201500913','杨威','男',19,11);
insert into student values('201500914','王佳豪','男',19,11);
insert into student values('201500915','潘昊','男',19,11);
insert into student values('201500916','云登','男',19,11);
insert into student values('201500917','柯奇','男',19,11);
insert into student values('201500918','李鹏飞','男',19,11);
insert into student values('201500919','王清','男',19,11);
insert into student values('201500920','陈立衡','男',19,11);
insert into student values('201500921','曹建彬','男',19,11);
insert into student values('201500922','张泽辰','男',19,11);
insert into student values('201500923','何珊','男',19,11);
insert into student values('201500924','陈苗苗','男',19,11);
insert into student values('201500925','丁雄莉','男',19,11);
insert into student values('201500926','赵梦雨','男',19,11);
insert into student values('201500927','刘书晴','男',19,11);
insert into student values('201501586','沈植诚','男',19,11);
insert into student values('201502413','石炜','男',19,11);
insert into student values('201500930','张知朋','男',19,12);
insert into student values('201500931','张志广','男',19,12);
insert into student values('201500935','盛豆豆','男',19,12);
insert into student values('201500938','刘远智','男',19,12);
insert into student values('201500939','张远','男',19,12);
insert into student values('201500940','卢海宇','男',19,12);
insert into student values('201500941','闻宏','男',19,12);
insert into student values('201500959','葛乾','男',19,12);
insert into student values('201500962','付康浩','男',19,12);
insert into student values('201500966','杨福临','男',19,12);
commit;


select * from grade;

select * from student where sno='201600785';

select * from operation;

delete from operation;

insert into student values('201600785','朱永银','男',21,13);
delete from student where sno='201500966';
delete from student where sno='201600785';
update student set sno='201600786' where sno='201500966';

insert into grade(gid,gname,year) values(gid.nextval,'计算机162','2016');

delete from grade where gname='计算机162';

update grade set gname='计算机172' where gname='计算机142';









