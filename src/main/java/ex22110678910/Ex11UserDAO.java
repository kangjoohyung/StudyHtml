package ex22110678910;

import java.sql.SQLException;

import kosta.mvc.dto.UserDTO;

public interface Ex11UserDAO {
  /**
   * �α��� ���
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
}
