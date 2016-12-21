package com.guotv.chen.testserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.guotv.chen.testserver.entity.User;
import com.guotv.chen.testserver.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("userpage")
	@ResponseBody
	public Page<User> list(@RequestParam(value="page",defaultValue="0") Integer page,@RequestParam(value="size",defaultValue="5") Integer size){
		Sort sort=new Sort(Direction.DESC,"name");
		Pageable pageable=new PageRequest(page,size,sort);
		return userService.queryByUser(pageable);
	}
	@RequestMapping("user")
	public void list(@RequestParam(value="page",defaultValue="0") Integer page,@RequestParam(value="size",defaultValue="5") Integer size, Model model){
		/*Sort sort=new Sort(Direction.DESC,"name");
		Pageable pageable=new PageRequest(page,size,sort);
		Page<User> pageusers=userService.queryUsers(pageable);
		model.addAttribute("queryUsers", pageusers.getContent());*/
	}

}
