package userManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import userManager.VO.UserVO;

public interface UserDao {
	
	public UserVO islogin(@Param(value="loginID")String loginID,@Param(value="password")String password);
	
	public List<UserVO> findListByID(UserVO userVO);
}
