-- 用户信息类
drop table if exists public.user_info;

create table if not exists public.user_info
(
    id              varchar(36) not null default gen_random_uuid() primary key,
    uid             varchar(10) not null,
    username        varchar(50),
    password        varchar(32)          default '895DFACA991AC5E79121E435878EDAFB',
    sex             varchar(1)           default 'U',
    description     varchar(100),
    last_login_time timestamp,
    account_status  varchar(1)           default 'A',
    created_time    timestamp   not null default now(),
    created_by      varchar(50) not null default current_user,
    updated_time    timestamp   not null default now(),
    updated_by      varchar(50) not null default current_user
);

comment on table public.user_info is '用户信息表';
comment on column public.user_info.id is '主键';
comment on column public.user_info.uid is '用户id';
comment on column public.user_info.username is '用户名';
comment on column public.user_info.password is '登陆密码，md5加密';
comment on column public.user_info.sex is '性别';
comment on column public.user_info.description is '个人签名';
comment on column public.user_info.last_login_time is '上次登陆时间';

