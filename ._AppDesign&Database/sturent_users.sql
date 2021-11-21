create table users
(
    User_Name varchar(100)            not null,
    Email     varchar(100)            not null,
    Password  varchar(100)            not null,
    Gender    enum ('Male', 'Female') null,
    Phone     int                     null,
    Is_Admin  tinyint default 0       null,
    constraint users_Email_uindex
        unique (Email),
    constraint users_User_Name_uindex
        unique (User_Name)
);

alter table users
    add primary key (User_Name);

INSERT INTO sturent.users (User_Name, Email, Password, Gender, Phone, Is_Admin) VALUES ('Oknaa', 'Oknaa@kun.me', 'oknaa', 'Male', 708008065, 0);
INSERT INTO sturent.users (User_Name, Email, Password, Gender, Phone, Is_Admin) VALUES ('Niaa', 'Niaa@ma.me', 'nia', 'Female', 689228833, 1);