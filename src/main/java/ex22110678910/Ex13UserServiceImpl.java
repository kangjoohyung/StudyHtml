package ex22110678910;

import java.sql.SQLException;


public class Ex13UserServiceImpl implements Ex13UserService {
     private Ex11UserDAO userDAO = new Ex11UserDAOImpl();
  	
	@Override
	public Ex08UserDTO loginCheck(Ex08UserDTO userDTO) throws SQLException, Ex05AuthenticationException {
		
		//daoȣ��
		Ex08UserDTO dbDTO = userDAO.loginCheck(userDTO);
		if(dbDTO == null) {
			throw new Ex05AuthenticationException("������ �ٽ� Ȯ�����ּ���.");
		}
		
		return dbDTO;
	}

}





