package com.pb.study.begod.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description HelloController
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/03/23 19:02
 */

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

//    @Autowired
//    private HelloService hello;

    @GetMapping("/helloworld")
    public String helloWorldController() {
        return "hello.sayHello();";
    }

    /**
     * 异步调用restful
     * 当controller返回值是Callable的时候，springmvc就会启动一个线程将Callable交给TaskExecutor去处理
     * 然后DispatcherServlet还有所有的spring拦截器都退出主线程，然后把response保持打开的状态
     * 当Callable执行结束之后，springmvc就会重新启动分配一个request请求，然后DispatcherServlet就重新
     * 调用和处理Callable异步执行的返回结果， 然后返回视图
     *
     * @return
     */
    @GetMapping("/hello")
    public Callable<String> helloController() {
        logger.info(Thread.currentThread().getName() + " 进入helloController方法");
        Callable<String> callable = () -> {
            logger.info(Thread.currentThread().getName() + " 进入call方法");
            String say = "hello world";
            logger.info(Thread.currentThread().getName() + " 从helloService方法返回");
            TimeUnit.SECONDS.sleep(5);
            return say;
        };
        logger.info(Thread.currentThread().getName() + " 从helloController方法返回");
        return callable;
    }

    @GetMapping("/world")
    public WebAsyncTask<String> worldController() {
        logger.info(Thread.currentThread().getName() + " 进入helloController方法");

        // 3s钟没返回，则认为超时
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(3000, () -> {
            logger.info(Thread.currentThread().getName() + " 进入call方法");
            String say = "hello.sayHello()";
            logger.info(Thread.currentThread().getName() + " 从helloService方法返回");
            return say;
        });
        logger.info(Thread.currentThread().getName() + " 从helloController方法返回");

        webAsyncTask.onCompletion(() -> logger.info(Thread.currentThread().getName() + " 执行完毕"));

        webAsyncTask.onTimeout(() -> {
            logger.info(Thread.currentThread().getName() + " onTimeout");
            // 超时的时候，直接抛异常，让外层统一处理超时异常
            throw new TimeoutException("调用超时");
        });
        return webAsyncTask;
    }

    /**
     * 异步调用，异常处理，详细的处理流程见MyExceptionHandler类
     *
     * @return
     */
    @GetMapping("/exception")
    public WebAsyncTask<String> exceptionController() {
        logger.info(Thread.currentThread().getName() + " 进入helloController方法");
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                logger.info(Thread.currentThread().getName() + " 进入call方法");
                throw new TimeoutException("调用超时!");
            }
        };
        logger.info(Thread.currentThread().getName() + " 从helloController方法返回");
        return new WebAsyncTask<>(20000, callable);
    }

}
