package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestEncoding {
	
	@RequestMapping(value="/index/{type}")
	public String index(ModelMap mmMap,@PathVariable("type") String type,RedirectAttributes attr){
		if("1".equals(type)){
			System.out.println("在index(1)方法内...");
			return "redirect:/test/myRedirectWithoutArgs";
		}else if("2".equals(type)){
			System.out.println("在index(2)方法内...");
			attr.addAttribute("username","用户名：Zhangsan,");
			attr.addAttribute("passwd","密码：888");
			return "redirect:/test/myRedirectWithArgsURL";
		}else if ("3".equals(type)) {
			System.out.println("在index(3)方法内...");
			attr.addFlashAttribute("username", "李四");
			attr.addFlashAttribute("passwd", "123456");
			return "redirect:/test/myRedirectWithArgs";
		}else {
			System.out.println("不在index()方法内...");
			return "index";
		}
	}
}
