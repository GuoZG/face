package com.sft.face.controller;


import com.sft.face.entity.UFace;
import com.sft.face.service.IUFaceService;
import com.sft.face.util.http.HttpClient;
import com.sys.ant.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GuoZG
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/face/u-face")
public class UFaceController extends BaseController {

    @Autowired
    private IUFaceService iuFaceService;

    @GetMapping("/list")
    public List<UFace> query(){
        return iuFaceService.list();
    }

    @GetMapping("/h")
    public String weather() throws Exception {
        return HttpClient.doGet("http://v.juhe.cn/weather/index?format=2&cityname=广州&key=30d33ce6870429b885774186d801cca9");
    }
}
