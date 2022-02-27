package com.warm.system.controller;

import com.warm.system.entity.H2MetaLoc;
import com.warm.system.mapper.H2MetaLocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuchuanqi
 * @date 2022/2/27 17:01.
 */
@RequestMapping("h2")
@RestController
public class H2Controller {
    @Autowired
    H2MetaLocMapper h2MetaLocMapper;

    @GetMapping("listall")
    public List<H2MetaLoc> listall(){
        return h2MetaLocMapper.all();
    }
}
