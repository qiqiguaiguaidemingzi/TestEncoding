package com.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/test")
public class MyRedirect {
	@RequestMapping(value = "/myRedirectWithoutArgs")
    public String myRedirectWithoutArgs(ModelMap mmMap) throws Exception {
        System.out.println("在myRedirectWithoutArgs()方法内...");
        mmMap.addAttribute("msg", "不带参数的重定向");
        return "index";
    }  
	
	@RequestMapping(value = "/myRedirectWithArgsURL")
    public String myRedirectWithArgsURL(ModelMap mmMap,Person p)
            throws Exception {
        System.out.println("在myRedirectWithArgsURL()方法内...");
        System.out.println("参数为：" + p.getUsername() + p.getPasswd());
        mmMap.addAttribute("msg","带参数的重定向,参数为==>" + p.getUsername() + p.getPasswd());
        return "index";
    }  
	
	@RequestMapping(value = "/myRedirectWithArgs")
    public String myRedirectWithArgs(ModelMap mmMap, HttpServletRequest request) throws Exception {
        System.out.println("在myRedirectWithArgs()方法内...");
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        System.out.println((String)map.get("username")+map.get("passwd"));
        mmMap.addAttribute("msg", "带参数的重定向,不拼接URL");
        return "index";
    } 
	
	@RequestMapping(value="/postData")
	public String postData(ModelMap mmMap,@RequestParam String username){
		System.out.println("username的值为：");
		System.out.println(username);
		mmMap.addAttribute("msg", username);
		return "index";
		/*这个方法用来测试,springmvc方法中参数的注入方式,
		 * 有两种方式
		 * 一、要求使用了@RequestParam注解,并且value属性的值,要与前台页面中参数的name属性一致,
		 * 	   此时,方法的参数名可以任意取名;
		 * 
		 * 二、要求方法的参数名,与前台页面中参数的name属性一致,此时,@RequestParam注解加不加都一样
		 * 
		 * 满足上述任意一种,springmvc会自动将前台提交的数据,注入方法的参数中
		 * */
	}
}
