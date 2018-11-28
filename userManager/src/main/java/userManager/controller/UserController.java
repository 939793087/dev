package userManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import userManager.VO.UserVO;
import userManager.service.UserService;

@Controller("userController")
@RequestMapping(value = "/user")
public class UserController {
	
	private UserVO vo;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="islogin2/{user}/{passwords}",method=RequestMethod.GET)
	@ResponseBody
	public boolean islogin2(@PathVariable String user,@PathVariable String passwords){
		boolean isfalse;
		if(!StringUtils.isEmpty(user)){
			isfalse = true;
		}else{
			isfalse = false;
		}
		return isfalse;
	}
	
	@RequestMapping(value="/islogin",method=RequestMethod.GET)
	@ResponseBody
	public UserVO islogin(@RequestParam(value = "user",required=false) String user,@RequestParam(value = "password",required=false) String pwssword){
		vo = userservice.islogin(user,pwssword);
		return vo;
	}

}
