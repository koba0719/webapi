# create table if  not exists users (
#   id int primary key,
#   name varchar(255),
#   age int,
#   sex tinyint
# );
#
# delete from users;
# insert into users
# VALUES( 1 , 'John' , 26 , 1),
# ( 2 , 'Bob' , 40 , 1),
# ( 3 , 'Michael' , 20 , 1),
# ( 4 , 'Mary' , 30 , 0);

create table if not EXISTS m_user_tbl(
  user_seq INT PRIMARY KEY ,
  user_id VARCHAR(20),
  sha_pass VARCHAR(64)
);

DELETE FROM m_user_tbl;
INSERT INTO m_user_tbl
    VALUES (1,'root','8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918');