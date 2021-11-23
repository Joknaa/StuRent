create table post
(
    Post_ID          int auto_increment
        primary key,
    User_ID          int                     not null,
    City             varchar(255)            null,
    Address          varchar(100)            not null,
    Gender           enum ('Man', 'Woman')   not null,
    Price            int                     not null,
    Description      varchar(100)            null,
    Has_Wifi         varchar(10) default '0' null,
    Has_Water_Heater varchar(10) default '0' null,
    Allow_Pets       varchar(10) default '0' null,
    Allow_Smoking    varchar(10) default '0' null,
    Is_Available     tinyint     default 1   null
);

create index post_users_User_ID_fk
    on post (User_Name);

INSERT INTO sturent.post (Post_ID, User_Name, City, Address, Gender, Price, Description, Has_Wifi, Has_Water_Heater, Allow_Pets, Allow_Smoking, Is_Available) VALUES (1, 1, null, '', 'Man', 0, 'test', '0', '0', '0', '0', 1);
INSERT INTO sturent.post (Post_ID, User_Name, City, Address, Gender, Price, Description, Has_Wifi, Has_Water_Heater, Allow_Pets, Allow_Smoking, Is_Available) VALUES (2, 1, null, '', 'Man', 0, null, '0', '0', '0', '0', 1);
INSERT INTO sturent.post (Post_ID, User_Name, City, Address, Gender, Price, Description, Has_Wifi, Has_Water_Heater, Allow_Pets, Allow_Smoking, Is_Available) VALUES (3, 1, null, '', 'Man', 0, null, '0', '0', '0', '0', 1);