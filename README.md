# CassandraAssignment

Problem Statement:
1: User : email text, password text, userid int.
2: Video: video_id,video_name text, userid int, year.

Access Pattern:

1. select query to find user by email.
2. select video by video_name.
3. select videos uploaded after 2015
3. select video by user_id and records should be selected in descending order by year

I have created three tables: user,video,videoByYear

create table user (
                  email text PRIMARY KEY,
                  password text,
                   userId int);

create table video (
     video_Id Int,
    video_name text PRIMARY KEY,
    userId int,
     year int
   );

create table videoByYear (
  video_Id int,
  video_name text,
  userId int,
  year int,
  PRIMARY KEY (userId,year)
);
