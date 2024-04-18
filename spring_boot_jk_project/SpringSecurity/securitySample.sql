

desc users;

drop table users;
create table users(
    username varchar2(50) primary key,
    password varchar2(100) not null,
    enabled char(1) default '1'
    
    
    
);

commit;

desc authorities;

drop table authorities;
create table authorities(
    username varchar2(50) not null,
    authority varchar2(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

select * from users;
select * from authorities;


desc users;
desc authorities;

insert into users values ( 
    'admin',
    'admin',
    1
);
insert into users values ( 
    'user',
    'user',
    1
);
insert into users values ( 
    'member',
    'member',
    1
);


insert into authorities values (
    'admin',
    'ROLE_USER'
);
insert into authorities values (
    'admin',
    'ROLE_MANAGER'
);
insert into authorities values (
    'admin',
    'ROLE_ADMIN'
);



commit;

select * from users;
select * from authorities;

insert into authorities values (
    'user',
    'ROLE_USER'
);
insert into authorities values (
    'member',
    'ROLE_MANAGER'
);
insert into authorities values (
    'user',
    'ROLE_ADMIN'
);

delete from authorities where username = 'user' and authority = 'ROLE_ADMIN';








