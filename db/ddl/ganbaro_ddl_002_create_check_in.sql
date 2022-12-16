-- 打卡记录表

drop table if exists public.check_in;

create table if not exists public.check_in
(
    id              varchar(36) not null default gen_random_uuid() primary key,
    uid             varchar(10) not null,
    day             date,
    is_did_it       varchar(1),
    created_time    timestamp   not null default now(),
    created_by      varchar(50) not null default current_user,
    updated_time    timestamp   not null default now(),
    updated_by      varchar(50) not null default current_user
);

comment on table public.check_in is '每日完成情况';
comment on column public.check_in.id is '主键';
comment on column public.check_in.uid is '用户id';
comment on column public.check_in.day is '日期';
comment on column public.check_in.is_did_it is '是否达成目标';
