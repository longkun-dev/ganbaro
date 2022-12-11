-- 用户信息类
drop table if exists public.common_code;

create table if not exists public.common_code
(
    id           varchar(36) not null default gen_random_uuid() primary key,
    label        varchar(50) not null,
    code         varchar(50),
    value        varchar(255),
    created_time timestamp   not null default now(),
    created_by   varchar(50) not null default current_user,
    updated_time timestamp   not null default now(),
    updated_by   varchar(50) not null default current_user
);

comment on table public.common_code is '常量表';
comment on column public.common_code.id is '主键';
comment on column public.common_code.label is '名称';
comment on column public.common_code.code is '编码';
comment on column public.common_code.value is '值';
