/**
 * 
 */
package com.nantian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ld
 * @date   2018年6月7日
 */
@Controller
public class IndexController {

	@RequestMapping(value="index")
	public String goto_statisticsPage() {
		
		return "index";
	}
}
