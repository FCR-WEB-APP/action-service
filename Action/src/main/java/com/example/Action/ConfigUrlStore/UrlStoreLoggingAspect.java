package com.example.Action.ConfigUrlStore;

import com.example.Action.Dao.UrlStoreDao;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class UrlStoreLoggingAspect {

    private final UrlStoreDao urlStoreDao;

    public UrlStoreLoggingAspect(UrlStoreDao urlStoreDao) {
        this.urlStoreDao = urlStoreDao;
    }

    @Pointcut("execution(* com.example.Action.Controller..*(..))")
    public void restControllerMethods() {
        // Pointcut to capture all methods in the Controller package
    }

    @After("restControllerMethods()")
    public void apiCall(JoinPoint joinPoint) {
        System.out.println("API Call intercepted");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String apiUrl = request.getRequestURI();
            String httpMethod = request.getMethod();
            System.out.println("Captured URL: " + apiUrl + ", Method: " + httpMethod);

            urlStoreDao.saveApiUrl(apiUrl, httpMethod);
        } else {
            System.out.println("Request attributes are null");
        }
    }
}
