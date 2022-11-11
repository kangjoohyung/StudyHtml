package ex22110678910;

import java.sql.SQLException;


public class Ex13UserServiceImpl implements Ex13UserService {
     private Ex11UserDAO userDAO = new Ex11UserDAOImpl();
  	
	@Override
	public Ex08UserDTO loginCheck(Ex08UserDTO userDTO) throws SQLException, Ex05AuthenticationException {
		
		//dao호출
		Ex08UserDTO dbDTO = userDAO.loginCheck(userDTO);
		if(dbDTO == null) {
			throw new Ex05AuthenticationException("정보를 다시 확인해주세요.");
		}
		
		return dbDTO;
	}

}





