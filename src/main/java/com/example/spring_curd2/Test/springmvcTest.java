package com.example.spring_curd2.Test;

import com.example.spring_curd2.dao.EmployeeDao;
import com.example.spring_curd2.entiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Controller
public class springmvcTest {

    @Autowired
    private EmployeeDao employeeDao;



    @RequestMapping("/testResponsestatusExceptionReslove")
    public String testResponsestatusExceptionReslove(@RequestParam("i") int i )
    {
        if (i==13)
        {
           throw new UsernameNotmatchPasswordExceptionhandle();
        }
        System.out.println("testResponsestatusExceptionReslove");
        return "success";

    }




    @RequestMapping("/testFileupload")
    public String testUpload(@RequestParam("desc") String desc, @RequestParam("file")MultipartFile file) throws IOException
    {
        System.out.println("desc"+desc);
        System.out.println("OriginalFilename"+file.getOriginalFilename());
        System.out.println("InputStream:"+file.getInputStream());
        return "success";
    }

    @RequestMapping("/testsimpleCoverts")
    public String testcoverts(@RequestParam("employee")Employee employee, Map<String,Object> map)
    {
        System.out.println("save:"+employee);
        employeeDao.save(employee);
        return "input";
    }

}
