package com.pb.study.begod.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description SysLogAutoConfig
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/09/22 21:04
 */


@Aspect
@Configuration
@Slf4j
public class SysLogAutoConfig {

    private HttpServletRequest request;

    private ObjectMapper objectMapper;

    public SysLogAutoConfig(HttpServletRequest request, ObjectMapper objectMapper) {
        this.request = request;
        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Money.class, new MoneyJsonSerializer());
//        simpleModule.addDeserializer(Money.class, new MoneyJsonDeserializer());
        this.objectMapper = objectMapper.registerModule(simpleModule);
    }


    @Pointcut("@within(com.pb.study.begod.log.SysLog)")
    public void withSysLogAnnotation() {

    }

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void withControllerAnnotation() {

    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void withRestControllerAnnotation() {

    }

    @Pointcut("(withControllerAnnotation() || withRestControllerAnnotation()) && withSysLogAnnotation()")
    public void isSysLogController() {

    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void withServiceAnnotation() {

    }

    @Pointcut("withServiceAnnotation() && withSysLogAnnotation()")
    public void isSysLogService() {

    }


    /**
     * Controller方法调用之前调用
     *
     * @param joinPoint 切入点
     */
    @Before("isSysLogController()")
    public void doBeforeControllerMethod(JoinPoint joinPoint) {

        //添加日志打印
        String requestId = String.valueOf(System.currentTimeMillis()) + (int) (Math.random() * 100000);

        String requestURI = request.getRequestURI();

        Object[] argsBefore = joinPoint.getArgs();
        Object[] args = new Object[argsBefore.length];
        // 移除无法被序列化的参数
        for (int i = 0; i < argsBefore.length; i++) {
            Object argBefore = argsBefore[i];
            if (argBefore instanceof ServletRequest || argBefore instanceof ServletResponse
                    || argBefore instanceof MultipartFile) {
                continue;
            }

            args[i] = argBefore;
        }

        String parameter;
        try {
            parameter = objectMapper.writeValueAsString(args);
        } catch (Exception e) {
            parameter = Arrays.toString(args);
        }
        log.info("===========@Before：：请求URL：{}，请求方法：{}，请求参数：{}", requestURI, joinPoint.getSignature(), parameter);
    }

    /**
     * Service方法调用之前调用
     *
     * @param joinPoint 切入点
     */
    @Before("isSysLogService()")
    public void doBeforeServiceMethod(JoinPoint joinPoint) {

        String parameter;
        try {
            parameter = objectMapper.writeValueAsString(joinPoint.getArgs());
        } catch (Exception e) {
            parameter = Arrays.toString(joinPoint.getArgs());
        }
        log.info("===========@Before：：方法：{}，参数：{}", joinPoint.getSignature(), parameter);
    }


    /**
     * Controller方法之后调用
     *
     * @param joinPoint   切入点
     * @param returnValue 方法返回值
     */
    @AfterReturning(pointcut = "isSysLogController()", returning = "returnValue")
    public void doAfterControllerMethodReturning(JoinPoint joinPoint, Object returnValue) {

        String requestURI = request.getRequestURI();
        if (returnValue.getClass() != Void.class) {
            String response;
            try {

                    response = objectMapper.writeValueAsString(returnValue);
            } catch (JsonProcessingException e) {
                response = returnValue.toString();
            }

            log.info("===========@After：：请求URL：{}，请求方法：{}，响应内容：{}", requestURI, joinPoint.getSignature(), response);

        }
    }

    /**
     * Service方法之后调用
     *
     * @param joinPoint   切入点
     * @param returnValue 方法返回值
     */
    @AfterReturning(pointcut = "isSysLogService()", returning = "returnValue")
    public void doAfterServiceMethodReturning(JoinPoint joinPoint, Object returnValue) {

        if (returnValue.getClass() != Void.class) {
            String response;
            try {
//                if(returnValue instanceof PageQueryResultBind){
//                    response = "分页查询不返回响应信息";
//                } else if(returnValue instanceof BindResult && ((BindResult) returnValue).getData() != null && ((BindResult) returnValue).getData() instanceof PageQueryResultBind){
//                    response = "分页查询不返回响应信息";
//                }else{
                response = objectMapper.writeValueAsString(returnValue);

            } catch (JsonProcessingException e) {
                response = returnValue.toString();
            }

            log.info("===========@After：：方法：{}，返回值：{}", joinPoint.getSignature(), response);

        }
    }

    /**
     * 统计方法执行耗时Around环绕通知
     *
     * @param joinPoint
     * @return
     */
    @Around("isSysLogController()")
    public Object doAroundControllerMethod(ProceedingJoinPoint joinPoint) {


        //获取开始执行的时间
        long startTime = System.currentTimeMillis();

        String requestURI =request.getRequestURI();

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("===========@Around：：请求URL：{}，请求方法：{}", requestURI, joinPoint.getSignature(), throwable);
            return "error";
        }

        // 获取执行结束的时间
        long endTime = System.currentTimeMillis();
        // 打印耗时的信息
        log.info("===========@Around：：请求URL：{}，请求方法：{}，本次会话共耗时：{}毫秒", requestURI, joinPoint.getSignature(), endTime - startTime);
        return proceed;
    }


}
