-- 测试用户初始化

truncate table daily_sentence;

insert into daily_sentence(content, author)
values ('最可怕的敌人，就是没有坚强的信念。', '罗曼·罗兰'),
       ('忍耐和坚持虽是痛苦的事情，但却能渐渐地为你带来好处。', '奥维德'),
       ('锲而舍之，朽木不折；锲而不舍，金石可镂。', '荀况'),
       ('既然我已经踏上这条道路，那么，任何东西都不应妨碍我沿着这条路走下去。', '康德'),
       ('When you want to give up, remember why you started.', null);
