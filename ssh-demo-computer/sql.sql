INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (1, 'Intel i7-7500 3M处理', '', 2000.0, 1);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (2, '金士顿骇客神条', '16G', 1500.0, 2);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (3, '西部数据2TB 7200转64M', '500G', 3000.0, 4);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (4, '七彩虹iGame960烈焰战神', '', 2500.0, 3);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (6, 'Intel i5 盒装CPU处理器', '', 2800.0, 1);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (7, '西部数据1TB 7200转64M', '560G', 2000.0, 4);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (8, 'DELL IPS 52寸高清显示器', '', 2000.0, 5);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (9, '英特尔i9-9900', '400', 480.0, 1);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (10, '三星高清IPS显示器52寸', '', 2000.0, 5);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (11, '英伟达显卡', '', 1000.0, 3);


INSERT INTO componenttype (typeId, TYPENAME) VALUES (1, 'CPU');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (2, '内存');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (3, '显卡');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (4, '硬盘');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (5, '显示器');


INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (1, 'MyComputer', '金士顿骇客神条', 'Intel i7-7500 3M处理', '七彩虹iGame960烈焰战神', 'DELL IPS 52寸高清显示器', '西部数据1TB 7200转64M', 5800.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (2, 'MyComputer', '金士顿骇客神条', 'Intel i5 盒装CPU处理器', '七彩虹iGame960烈焰战神', 'DELL IPS 52寸高清显示器', '西部数据1TB 7200转64M', 5800.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (11, 'DIY', '金士顿骇客神条', 'Intel i5 盒装CPU处理器', '七彩虹iGame960烈焰战神', 'DELL IPS 52寸高清显示器', '西部数据1TB 7200转64M', 6800.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (12, 'DIY', '金士顿骇客神条', '英特尔i9-9900', '七彩虹iGame960烈焰战神', 'DELL IPS 52寸高清显示器', '西部数据1TB 7200转64M', 7888.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (13, 'DIYPro', '金士顿骇客神条', 'Intel i5 盒装CPU处理器', '七彩虹iGame960烈焰战神', 'DELL IPS 52寸高清显示器', '西部数据2TB 7200转64M', 7890.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (14, 'DiyX', '金士顿骇客神条', 'Intel i5 盒装CPU处理器', '七彩虹iGame960烈焰战神', '三星高清IPS显示器52寸', '西部数据2TB 7200转64M', 6000.0, 0, null);
