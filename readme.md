论文的缓存系统


* H2 sql 字段严格区分大小写
* 基于切面实现的双数据源，不能够利用MyBatisplus自带的数据操作方法，因为此类方法没有被切面选中，不会自动切换数据源，如deleteById(id);



> 改编自如下项目：
> 
> SpringBoot + MyBatis plus + Mysql
> 
> JDK 版本 1.8
> 
> 用到了lombok插件,使用方法百度
> 
> 创建数据库db1,执行user.sql
> 
> 创建数据库db2,执行t_order.sql
> 
> http://localhost:8080/user
> 
> http://localhost:8080/order
> 
> http://localhost:8080/price
> 
> 参考：
>     http://baomidou.oschina.io/mybatis-plus-doc/#/multi-datasource?id=%e5%a4%9a%e6%95%b0%e6%8d%ae%e6%ba%90%e4%bd%bf%e7%94%a8-spring-abstractroutingdatasource-%e5%ae%9e%e7%8e%b0