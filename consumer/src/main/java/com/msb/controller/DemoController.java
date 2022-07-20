package com.msb.controller;

import com.msb.persion;
import com.msb.service.impl.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private PersionService persionService;
    @RequestMapping("/show")
    @ResponseBody
    public List<persion> show(){
        return persionService.show();
    }
}
