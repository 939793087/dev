package userManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import userManager.VO.UserVO;
import userManager.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	public UserVO islogin(String loginID,String password){
		return userdao.islogin(loginID, password);
	}
	
	public List<UserVO> findListByID(UserVO userVO){
		
		return userdao.findListByID(userVO);
	}

}
