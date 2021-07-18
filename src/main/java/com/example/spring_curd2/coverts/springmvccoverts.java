package com.example.spring_curd2.coverts;

import com.example.spring_curd2.entiy.Employee;
import org.springframework.core.convert.converter.Converter;

public class springmvccoverts implements Converter<String, Employee> {
    @Override
    public Employee convert(String source) {

        if (source!=null)
        {

        }
        return null;
    }
}
