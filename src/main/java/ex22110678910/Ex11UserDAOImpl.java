package ex22110678910;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Ex11UserDAOImpl implements Ex11UserDAO {
	private Properties proFile = new Properties();
	
	public Ex11UserDAOImpl() {
		try {
			//dbQuery�� �غ��� ~.properties������ �ε��ؼ� Properties �ڷᱸ���� �����Ѵ�.
			
			//���� ������Ʈ�� ��Ÿ��(����)�ɶ�, �� ������ ����ɶ� classes������ ��ġ��
			//�������� �����ͼ� ��θ� �����ؾ��Ѵ�.
			InputStream is = getClass().getClassLoader().getResourceAsStream("ex02dbQuery.properties");
			proFile.load(is);
			
			System.out.println("query.userlogin = " +proFile.getProperty("query.userlogin"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Ex08UserDTO loginCheck(Ex08UserDTO userDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Ex08UserDTO dbDTO =null;
		
		String sql= proFile.getProperty("query.userlogin");//select * from users where user_id=? and pwd=?
		try {
			con = Ex01DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getPwd());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dbDTO = new Ex08UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			
		}finally {
			Ex01DbUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}

}












