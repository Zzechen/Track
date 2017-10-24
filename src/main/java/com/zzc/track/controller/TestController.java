package com.zzc.track.controller;

import com.zzc.track.model.TestModel;
import com.zzc.track.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public @ResponseBody
    String test() {
        List<TestModel> modelList = testService.selectAll();
        StringBuilder sb = new StringBuilder();
        for (TestModel model : modelList) {
            sb.append(model.toString());
        }
        return sb.toString();
    }

}
