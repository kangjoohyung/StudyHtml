package ex22110678910;

import java.sql.SQLException;


public interface Ex11UserDAO {
  /**
   * 로그인 기능
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * */
	Ex08UserDTO loginCheck(Ex08UserDTO userDTO)throws SQLException;
}
