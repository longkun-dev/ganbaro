修改用户名密码
```postgresql
alter user ganbaro password '12345678';
```

创建新用户
```postgresql
create user ganbaro with password '12345678';
```

列出所有的表
```
\list
```

查看配置文件地址
```
show config
```
修改 /etc/postgresql/../pg_hba.config 开启远程登录
