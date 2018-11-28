package userManager.VO;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

public class CmsShopVO extends SerializableSerializer {
	private String company;
	private String shopid;
	private String createdate;
	private String shopname;
	private String shoptype;
	private String parentshopid;
	private String topshopid;
	private String mobile;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShoptype() {
		return shoptype;
	}
	public void setShoptype(String shoptype) {
		this.shoptype = shoptype;
	}
	public String getParentshopid() {
		return parentshopid;
	}
	public void setParentshopid(String parentshopid) {
		this.parentshopid = parentshopid;
	}
	public String getTopshopid() {
		return topshopid;
	}
	public void setTopshopid(String topshopid) {
		this.topshopid = topshopid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
