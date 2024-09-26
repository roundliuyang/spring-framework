package org.springframework.test.yly.aop.transaction;


import org.springframework.context.annotation.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;


@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class AppConfig {

    // 自定义 TransactionManager，不依赖 DataSource
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new MockTransactionManager();
    }

    // 自定义的事务管理器，只用于模拟事务行为
    static class MockTransactionManager extends AbstractPlatformTransactionManager {
        @Override
        protected Object doGetTransaction() {
            System.out.println("get transaction...");
            return new Object();  // 返回一个虚拟的事务对象
        }

        @Override
        protected void doBegin(Object transaction, TransactionDefinition definition) {
            System.out.println("transaction start...");
        }

        @Override
        protected void doCommit(DefaultTransactionStatus status) {
            System.out.println("transaction commit...");
        }

        @Override
        protected void doRollback(DefaultTransactionStatus status) {
            System.out.println("transaction rollback...");
        }
    }

    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class,
                StudentService.class);
        context.refresh();
//        StudentService studentService = context.getBean(StudentService.class);    // cglib 代理
        IStudentService studentService = context.getBean(IStudentService.class);   // jdk代理
        studentService.saveStudent("xiaoMing");
    }

}


