# DynamicProxy_Demo
This is a dynamic proxy demo to simulate spring jdkDynamicProxy mode

src/main/java/cn/edu/hdu/factory/BeanFactory is Used to generate dynamic proxy objects and enhance the methods that are executed;
src/main/java/cn/edu/hdu/service/impl/AccountServiceImpl is implement business processing;
src/main/java/cn/edu/hdu/dao/impl/AccountDaoImpl is used to realize the addition, deletion and change of the database;
src/main/java/cn/edu/hdu/utils/TransactionManger is a main transaction operating class;

BeanFactory is used to ehance AccountServiceImpl methods;
src/test/java/SpringDbutilsTest is a test class to test aop.
