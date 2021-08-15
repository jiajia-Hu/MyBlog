package com.demo.blog.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 自定义异常处理
 * @Author Jessie
 * @Date 2021/8/15
 */
@Slf4j
@ControllerAdvice
//@ControllerAdvice 拦截controller注解的拦截器
public class ExceptionHandlerDefine {

    /**
    　　* @Description: 异常处理
    　　* @Throws Exception
    　　* @Author Jessie
    　　* @Date 2021/8/15 17:43
       *@ExceptionHandler(Exception.class) 标识可以做异常处理
    　　*/
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception{
        log.error("Request URL : {} , Exception : {}",request.getRequestURL(), e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");
        //返回自定义的错误页面
        return modelAndView;
    }
}
