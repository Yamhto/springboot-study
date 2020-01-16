package com.yamhto.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yamhto
 * @className: SwaggerController.java
 * @package com.yamhto.swagger.controller
 * @description:
 * @date 2020/1/16 16:57
 */
@Api(value="SwaggerController",tags={"swagger测试"})
@RestController
@CrossOrigin
@RequestMapping("/swagger")
public class SwaggerController {

    @ApiOperation(value="swagger测试", notes="swagger测试")
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test() {
        return "swagger测试";
    }
}
