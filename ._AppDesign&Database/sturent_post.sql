create table post
(
    Post_ID      int auto_increment
        primary key,
    User_ID      int                     not null,
    Title        varchar(20)             not null,
    Address      varchar(100)            not null,
    Gender       enum ('Male', 'Female') not null,
    Price        int                     not null,
    Description  varchar(100)            null,
    Is_Available tinyint default 1       null
);

create index post_users_User_ID_fk
    on post (User_ID);

INSERT INTO sturent.post (Post_ID, User_ID, Title, Address, Gender, Price, Description, Is_Available) VALUES (1, 1, 'post1', '', 'Male', 0, 'test', 1);
INSERT INTO sturent.post (Post_ID, User_ID, Title, Address, Gender, Price, Description, Is_Available) VALUES (2, 1, 'post2', '', 'Male', 0, null, 1);
INSERT INTO sturent.post (Post_ID, User_ID, Title, Address, Gender, Price, Description, Is_Available) VALUES (3, 1, 'post3', '', 'Male', 0, null, 1);