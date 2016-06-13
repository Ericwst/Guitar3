# Guitar3
guitar3
-------------
##说明：
1. 采用OOD方法，主要业务逻辑由对象模型完成，有针对模型的测试程序。
![alt text](https://github.com/Ericwst/Guitar3/blob/master/5.jpg "文档结构")
2. web界面实现用户查询，吉他添加和删除。
![alt text](https://github.com/Ericwst/Guitar3/blob/master/1.jpg "数据库空")
![alt text](https://github.com/Ericwst/Guitar3/blob/master/2.jpg "添加")
![alt text](https://github.com/Ericwst/Guitar3/blob/master/3.jpg "查询")
3. 可以只使用servlet或者其他框架，要求servlet或action中依赖数据访问层的接口而非实现，使用工厂模式实现DAO层实例化。
![alt text](https://github.com/Ericwst/Guitar3/blob/master/8.jpg "mysql")
4. 使用jdbc或者ORM工具将对象持久化到数据库。
Hibernate持久化到数据库
5. 分别实现sqliteDAO和mysqlDAO。
![alt text](https://github.com/Ericwst/Guitar3/blob/master/6.jpg "mysql")
![alt text](https://github.com/Ericwst/Guitar3/blob/master/7.jpg "sqlite")
