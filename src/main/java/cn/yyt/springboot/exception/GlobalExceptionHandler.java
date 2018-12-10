package cn.yyt.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHadler(HttpServletRequest request,Exception e){
        //全局错误处理，错误自动跳到errorPage页面
        ModelAndView mav=new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("errorPage");

        return mav;
    }
}
