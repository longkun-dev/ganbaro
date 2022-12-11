-- 用户信息类
drop table if exists public.did_info;

create table if not exists public.did_info
(
    id           varchar(36) not null default gen_random_uuid() primary key,
    uid          varchar(10) not null,
    day          date,
    did_it       varchar(1),
    created_time timestamp   not null default now(),
    created_by   varchar(50) not null default current_user,
    updated_time timestamp   not null default now(),
    updated_by   varchar(50) not null default current_user
);

comment on table public.did_info is '每日完成情况';
comment on column public.did_info.id is '主键';
comment on column public.did_info.uid is '用户id';
comment on column public.did_info.day is '日期';
comment on column public.did_info.did_it is '是否达成目标';

