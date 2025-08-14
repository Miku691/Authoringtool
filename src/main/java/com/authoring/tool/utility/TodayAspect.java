package com.authoring.tool.utility;

import java.lang.reflect.Field;
import java.time.LocalDate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TodayAspect {

    @Before("execution(* com.authoring.tool..*(..))") 
    public void validateTodayDate(JoinPoint joinPoint) throws IllegalArgumentException, IllegalAccessException {
        
        for (Object arg : joinPoint.getArgs()) {
            if (arg != null) {
                for (Field field : arg.getClass().getDeclaredFields()) {
                    
                    // Check if @Today annotation is present
                    if (field.isAnnotationPresent(Today.class)) {
                        field.setAccessible(true);
                        
                        Object value = field.get(arg);
                        
                        if (value instanceof LocalDate date) {
                            if (!date.equals(LocalDate.now())) {
                                throw new IllegalArgumentException(
                                    "Date must be today's date: " + LocalDate.now()
                                );
                            }
                        }
                    }
                }
            }
        }
    }
}
