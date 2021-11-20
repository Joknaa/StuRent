create table hibernate_sequence
(
    next_val bigint null
)
    engine = InnoDB;

INSERT INTO sturent.hibernate_sequence (next_val) VALUES (19);