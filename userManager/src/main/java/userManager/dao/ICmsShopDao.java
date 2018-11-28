package userManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import userManager.VO.CmsShopVO;

/**
 * @time 20181117 
 * @author 唐辉
 * 	对cms_shop表的操作
 */
public interface ICmsShopDao {
	
	/**
	 * 根据VO查询集合数据
	 * @param cms
	 * @return
	 */
	public List<CmsShopVO> findListShop(@Param(value = "cms") CmsShopVO cms);
	
	/**
	 * 根据shopid修改父级ID
	 */
	public int updatebyID(@Param(value = "shopid")String shopid,@Param(value = "parentshopid")String parentshopid);
	
	/**
	 * 修改下级ID
	 * @param parentshopid
	 * @param shopid
	 * @return
	 */
	public int updateShopid(@Param(value = "shopid")String shopid,@Param(value = "parentshopid")String parentshopid);
	
}
