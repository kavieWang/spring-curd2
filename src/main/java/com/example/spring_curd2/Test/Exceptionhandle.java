package com.example.spring_curd2.Test;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class Exceptionhandle {

//    @ExceptionHandler({RuntimeException.class})
//    public ModelAndView handleArithmeticException2(Exception exception)
//    {
//        System.out.println("出错了"+exception);
//        ModelAndView mv=new ModelAndView("error");
//        mv.addObject("exception",exception);
//        return mv;
//    }
}
