package com.example.spring_curd2.handle;


import com.example.spring_curd2.dao.DepartmentDao;
import com.example.spring_curd2.dao.EmployeeDao;
import com.example.spring_curd2.entiy.Department;
import com.example.spring_curd2.entiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

@Controller
public class EmployeeHandle {


    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private EmployeeDao employeeDao;

   @Autowired
   private ResourceBundleMessageSource messageSource;


//   尝试将异常传入页面


//    @ExceptionHandler({RuntimeException.class})
//    public ModelAndView handleArithmeticException2(Exception exception)
//    {
//        System.out.println("出错了"+exception);
//        ModelAndView mv=new ModelAndView("error");
//        mv.addObject("exception",exception);
//        return mv;
//    }



    /**
     *  方法的入参可以加入Exception类型单位参数，该参数及对应发生的异常对象
     *  方法的入参不能传入Map,若希望把异常信息传导到页面上，需要使用modelview作为返回值
     *  方法标记异常有优先级
     * @param
     * @return
     */
//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception exception)
//    {
//        System.out.println("出错了"+exception);
//        ModelAndView mv=new ModelAndView("error");
//        mv.addObject("exception",exception);
//        return mv;
//    }



   @RequestMapping("/testExceptionHandleExceptionReslove")
   public String testExceptionHandleExceptionReslove(@RequestParam("i") Integer i)
   {
       System.out.println("result"+(10/i));
       return "success";
   }

    @RequestMapping("/ResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException
    {
        byte [] body=null;
        ServletContext servletContext = session.getServletContext();
        InputStream is = servletContext.getResourceAsStream("file/abc.txt");
        body=new byte[is.available()];

        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition","attachment,filename=abc.txt");

        HttpStatus status=HttpStatus.OK;

        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,headers,status);
        return  response;

    }

    @ResponseBody
    @RequestMapping("/testhttpmessageconvert")
    public String testhttpmessageconvert(@RequestBody String body)
    {
        System.out.println(body);
        return "helloworld" + new Date();
    }

    @ModelAttribute
    public  void  getEmployee(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map)
    {
        if(id!=null)
        {
            map.put("employee",employeeDao.get(id));
        }
    }


    @RequestMapping(value = "/input",method = RequestMethod.PUT)
    public String update(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/emp";
    }


    @RequestMapping(value = "/input/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String,Object> map)
    {

        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "input";
    }



    @RequestMapping(value = "/input/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id)
    {
           employeeDao.delete(id);
           return "redirect:/emp";
    }


    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emp";
    }


    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String list(Map<String, Object> map) {
        map.put("employees", employeeDao.getAll());
        return "list";
    }
}