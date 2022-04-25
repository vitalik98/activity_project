create table if not exists users
(
    id   bigint       not null auto_increment
        primary key,
    name varchar(255) null
);
create table if not exists projects
(
    id   bigint       not null auto_increment
        primary key,
    name varchar(255) null,
    type varchar(255) null
);
create table if not exists reports
(
    id          bigint       not null auto_increment
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
create table if not exists user_project
(
    id         bigint not null auto_increment
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
