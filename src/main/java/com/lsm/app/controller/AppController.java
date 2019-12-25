package com.lsm.app.controller;


import com.lsm.app.dto.AppDTO;
import com.lsm.app.dto.groups.AppGroups;
import com.lsm.app.service.IAppService;
import com.lsm.common.annotation.CustomAnnotation;
import com.lsm.common.base.Result;
import com.lsm.common.base.ReturnResponse;
import com.lsm.common.entity.app.AppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class AppController {

    @Autowired
    IAppService appService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return appService.test();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome!";
    }

    @RequestMapping(value = "/testGatewayFilterFactory", method = RequestMethod.GET)
    public String testGatewayFilterFactory() {
        return "testGatewayFilterFactory!";
    }

    @RequestMapping(value = "/testCustomAnnotation", method = RequestMethod.GET)
    public String testCustomAnnotation() {
        Class<AppEntity> clazz = AppEntity.class;
        // 获取类注解
        CustomAnnotation customAnnotation = clazz.getAnnotation(CustomAnnotation.class);
        System.out.println(customAnnotation.value());
        return customAnnotation.value();
    }

    /**
     * 新增APP
     *
     * @param appDTO
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/addApp", method = RequestMethod.POST)
    public Result addApp(@Validated(value = AppGroups.Insert.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success("新增APP成功");
    }


    /**
     * 测试优雅停机
     *
     * @return
     */
    @RequestMapping(value = "/testElegantShutdown", method = RequestMethod.GET)
    public String testElegantShutdown() {
        appService.testElegantShutdown();
        return "SUCCESS";
    }

    /*@RequestMapping(value = "/getApp", method = RequestMethod.GET)
    public Result getApp() {
        return ReturnResponse.success(appService.getApp());
    }*/

    @RequestMapping(value = "/saveApp", method = RequestMethod.POST)
    public Result saveApp(@Validated(value = AppGroups.Insert.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.saveApp(appDTO));
    }

    @RequestMapping(value = "/removeApp", method = RequestMethod.POST)
    public Result removeApp(@Validated(value = AppGroups.Delete.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.removeApp(appDTO));
    }

    @RequestMapping(value = "/deleteApp", method = RequestMethod.POST)
    public Result deleteApp(@Validated(value = AppGroups.Delete.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.deleteApp(appDTO));
    }

    @RequestMapping(value = "/updateApp", method = RequestMethod.POST)
    public Result updateApp(@Validated(value = AppGroups.Update.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.updateApp(appDTO));
    }

    @RequestMapping(value = "/getAppCount", method = RequestMethod.POST)
    public Result getAppCount(@Validated(value = AppGroups.Select.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.getAppCount(appDTO));
    }

    @RequestMapping(value = "/getApp", method = RequestMethod.POST)
    public Result getApp(@Validated(value = AppGroups.Select.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.getApp(appDTO));
    }

    @RequestMapping(value = "/listApp", method = RequestMethod.POST)
    public Result listApp(@Validated(value = AppGroups.Select.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.listApp(appDTO));
    }
}
