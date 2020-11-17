package com.hangyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    //好享待订单初始化接口

    @GetMapping("")
    public  Void  OrderInit(){


    return  null;
    }
}
