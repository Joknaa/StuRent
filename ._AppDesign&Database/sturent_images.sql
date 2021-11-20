create table images
(
    Image_ID int auto_increment
        primary key,
    Post_ID  int          not null,
    Path     varchar(255) not null
);

create index images_post_Post_ID_fk
    on images (Post_ID);

