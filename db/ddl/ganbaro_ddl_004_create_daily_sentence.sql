-- 用户信息类
drop table if exists public.daily_sentence;

create table if not exists public.daily_sentence
(
    id           varchar(36) not null default gen_random_uuid() primary key,
    content      text        not null,
    author       varchar(100),
    show_times   int         not null default 0,
    like_times   int         not null default 0,
    created_time timestamp   not null default now(),
    created_by   varchar(50) not null default current_user,
    updated_time timestamp   not null default now(),
    updated_by   varchar(50) not null default current_user
);

comment on table public.daily_sentence is '每日一句';
comment on column public.daily_sentence.id is '主键';
comment on column public.daily_sentence.content is '内容';
comment on column public.daily_sentence.author is '作者';
comment on column public.daily_sentence.show_times is '展示次数';
comment on column public.daily_sentence.like_times is '被喜欢次数';
