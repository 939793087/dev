package userManager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import net.sf.json.JSONArray;
import userManager.VO.CmsShopVO;
import userManager.VO.UserVO;
import userManager.service.CmsShopService;
import userManager.service.UserService;

@Controller("CmsShopController")
@RequestMapping(value = "/cmsshop",produces="text/plain;charset=UTF-8")
public class CmsShopController {
	
	@Autowired
	private CmsShopService cmsShopService;
	
	@RequestMapping(value="/listCMSShop",method=RequestMethod.GET)
	@ResponseBody
	public String findListShop(@RequestParam("callback") String callback,@RequestParam(required = false) String company,
			@RequestParam(required = false) String shopid,
			@RequestParam(required = false) String createdate,
			@RequestParam(required = false) String shopname,
			@RequestParam(required = false) String shoptype,
			@RequestParam(required = false) String parentshopid,
			@RequestParam(required = false) String topshopid,
			@RequestParam(required = false) String mobile){
		CmsShopVO cmsshopVO = new CmsShopVO();
		cmsshopVO.setCompany(company);
		cmsshopVO.setShopid(shopid);
		cmsshopVO.setCreatedate(createdate);
		cmsshopVO.setShopname(shopname);
		cmsshopVO.setShoptype(shoptype);
		cmsshopVO.setParentshopid(parentshopid);
		cmsshopVO.setTopshopid(topshopid);
		cmsshopVO.setMobile(mobile);
		List<CmsShopVO> list = new ArrayList<>();
		list = cmsShopService.findListByID(cmsshopVO);
        return callback+"("+JSONArray.fromObject(list).toString()+")";
	}
	@RequestMapping(value="/updatebyID",method=RequestMethod.GET)
	@ResponseBody
	public String updatebyID(@RequestParam("callback") String callback,@RequestParam(required=true) String shopid,
			@RequestParam(required=true) String parentshopid,@RequestParam(required = true) Integer isNum){
		int temp=0;
		if(1 == isNum){//修改父级ID
			temp= cmsShopService.updatebyID(shopid,parentshopid);
		}else if(2 == isNum){//修改下级ID
			temp= cmsShopService.updateShopid(shopid, parentshopid);
		}
		
		return callback+"("+JSONArray.fromObject(temp).toString()+")";
	}
}
