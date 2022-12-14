package ex22102526;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ex03TestDAO {
	/**
	 * emp테이블에서 사원이름 검색하기
	 */
	public List<String> selectByEname(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<String> list=new ArrayList<String>();
		String sql="select ename from emp";
		
		try {
			con=Ex02DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Ex02DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}//메소드 끝
}
