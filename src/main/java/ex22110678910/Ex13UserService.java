 package ex22110678910;

import java.sql.SQLException;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.exception.AuthenticationException;

public interface Ex13UserService {
	/**
	 * �α��� üũ
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
}
