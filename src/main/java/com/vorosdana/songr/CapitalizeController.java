package com.vorosdana.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/capitalize")
public class CapitalizeController {

    @GetMapping("/{input}")
    @ResponseBody
    public String capitalize(@PathVariable String input){
        return input.toUpperCase();
    }
}
