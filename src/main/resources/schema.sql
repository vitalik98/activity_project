drop table if exists user_project;
drop table if exists reports;
drop table if exists projects;
drop table if exists users;
create table users
(
    id   bigint       not null
        primary key,
    name varchar(255) null
);
create table projects
(
    id   bigint       not null
        primary key,
    name varchar(255) null,
    type varchar(255) null
);
create table reports
(
    id          bigint       not null
        primary key,
    activities  varchar(255) null,
    days_absent int          null,
    hours       int          null,
    month       int          null,
    year        tinyblob     null,
    project_id  bigint       null,
    user_id     bigint       null,
    constraint reports_projects_id_fk
        foreign key (project_id) references projects (id),
    constraint reports_users_id_fk
        foreign key (user_id) references users (id)
);
create table user_project
(
    id         bigint not null
        primary key,
    project_id bigint null,
    user_id    bigint null,
    constraint user_project_projects_id_fk
        foreign key (project_id) references projects (id)
            on update cascade on delete cascade,
    constraint user_project_users_id_fk
        foreign key (user_id) references users (id)
            on update cascade on delete cascade
);
