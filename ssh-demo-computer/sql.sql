INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (1, 'Intel i7-7500 3M����', '', 2000.0, 1);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (2, '��ʿ�ٺ�������', '16G', 1500.0, 2);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (3, '��������2TB 7200ת64M', '500G', 3000.0, 4);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (4, '�߲ʺ�iGame960����ս��', '', 2500.0, 3);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (6, 'Intel i5 ��װCPU������', '', 2800.0, 1);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (7, '��������1TB 7200ת64M', '560G', 2000.0, 4);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (8, 'DELL IPS 52�������ʾ��', '', 2000.0, 5);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (9, 'Ӣ�ض�i9-9900', '400', 480.0, 1);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (10, '���Ǹ���IPS��ʾ��52��', '', 2000.0, 5);
INSERT INTO component (COMPONENTID, COMPONENTNAME, CAPACITY, PRICE, TYPEID) VALUES (11, 'Ӣΰ���Կ�', '', 1000.0, 3);


INSERT INTO componenttype (typeId, TYPENAME) VALUES (1, 'CPU');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (2, '�ڴ�');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (3, '�Կ�');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (4, 'Ӳ��');
INSERT INTO componenttype (typeId, TYPENAME) VALUES (5, '��ʾ��');


INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (1, 'MyComputer', '��ʿ�ٺ�������', 'Intel i7-7500 3M����', '�߲ʺ�iGame960����ս��', 'DELL IPS 52�������ʾ��', '��������1TB 7200ת64M', 5800.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (2, 'MyComputer', '��ʿ�ٺ�������', 'Intel i5 ��װCPU������', '�߲ʺ�iGame960����ս��', 'DELL IPS 52�������ʾ��', '��������1TB 7200ת64M', 5800.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (11, 'DIY', '��ʿ�ٺ�������', 'Intel i5 ��װCPU������', '�߲ʺ�iGame960����ս��', 'DELL IPS 52�������ʾ��', '��������1TB 7200ת64M', 6800.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (12, 'DIY', '��ʿ�ٺ�������', 'Ӣ�ض�i9-9900', '�߲ʺ�iGame960����ս��', 'DELL IPS 52�������ʾ��', '��������1TB 7200ת64M', 7888.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (13, 'DIYPro', '��ʿ�ٺ�������', 'Intel i5 ��װCPU������', '�߲ʺ�iGame960����ս��', 'DELL IPS 52�������ʾ��', '��������2TB 7200ת64M', 7890.0, 0, null);
INSERT INTO computer (COMPUTERID, COMPUTERNAME, MEMORY, CPU, VIDEOCARD, DISPLAY, HDD, PRICE, computer_id, computer_name) VALUES (14, 'DiyX', '��ʿ�ٺ�������', 'Intel i5 ��װCPU������', '�߲ʺ�iGame960����ս��', '���Ǹ���IPS��ʾ��52��', '��������2TB 7200ת64M', 6000.0, 0, null);
