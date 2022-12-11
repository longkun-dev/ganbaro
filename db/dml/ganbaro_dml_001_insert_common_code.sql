-- 常量初始化

truncate table common_code;

insert into common_code(label, code, value)
values ('SEX', 'M', '男'),
       ('SEX', 'F', '女'),
       ('SEX', 'U', '保密'),
       ('ACCOUNT_STATUS', 'A', '正常'),
       ('ACCOUNT_STATUS', 'B', '封禁'),
       ('ACCOUNT_STATUS', 'C', '注销'),
       ('DID_IT', 'Y', 'day +1 !'),
       ('DID_IT', 'Y', '归 0 -_-||');
