package ex22110678910;

import java.sql.SQLException;

import kosta.mvc.dao.UserDAO;
import kosta.mvc.dao.UserDAOImpl;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.exception.AuthenticationException;

public class Ex13UserServiceImpl implements UserService {
     private UserDAO userDAO = new UserDAOImpl();
  	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
		
		//daoȣ��
		UserDTO dbDTO = userDAO.loginCheck(userDTO);
		if(dbDTO == null) {
			throw new AuthenticationException("������ �ٽ� Ȯ�����ּ���.");
		}
		
		return dbDTO;
	}

}




