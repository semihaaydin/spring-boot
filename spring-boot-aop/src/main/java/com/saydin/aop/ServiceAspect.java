package com.saydin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    /*@Before("execution(* com.saydin.service.*.*(..))")
     @Async
    //@execution : joint point
    //bu adresdeki tümünün executionunda bu method çalışşın ilk * servisin altındaki tüm class ikinci * servis altındaki tüm methodalar
    //ikinci * create* yapsaydık createile başlayanlarda
    public void beforeCreateCustomer(JoinPoint joinPoint){
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("createCustomer Method  önce paramtreler : "+joinPoint.getArgs()[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.setName("After Creaed method");
        thread.start();
    }

    @After("execution(* com.saydin.service.*.*(..))")
    @Async
    public void afterCreateCustomer(JoinPoint joinPoint){
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(8000);
                System.out.println("createCustomer Method  sonra paramtreler : "+joinPoint.getArgs()[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setName("After Creaed method");
        thread.start();
    }*/
}
