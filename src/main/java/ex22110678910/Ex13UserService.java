 package ex22110678910;

import java.sql.SQLException;

public interface Ex13UserService {
	/**
	 * �α��� üũ
	 * */
   Ex08UserDTO loginCheck(Ex08UserDTO userDTO)throws SQLException , Ex05AuthenticationException;
}
