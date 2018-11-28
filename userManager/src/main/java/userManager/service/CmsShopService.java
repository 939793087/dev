package userManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import userManager.VO.CmsShopVO;
import userManager.VO.UserVO;
import userManager.dao.ICmsShopDao;
import userManager.dao.UserDao;

@Service
public class CmsShopService {
	
	@Autowired
	private ICmsShopDao cmsShopDao;
	
	/**
	 * 查询数据
	 * @param cmsShopVO
	 * @return
	 */
	public List<CmsShopVO> findListByID(CmsShopVO cmsShopVO){
		
		return cmsShopDao.findListShop(cmsShopVO);
	}
	
	/**
	 * 修改父级ID
	 * @param shopid
	 * @param parentshopid
	 * @return
	 */
	public int updatebyID(String shopid,String parentshopid){
		return cmsShopDao.updatebyID(shopid,parentshopid);
	}
	
	/**
	 * 修改下级ID
	 * @param shopid
	 * @param parentshopid
	 * @return
	 */
	public int updateShopid(String shopid,String parentshopid){
		return cmsShopDao.updatebyID(shopid,parentshopid);
	}

}
