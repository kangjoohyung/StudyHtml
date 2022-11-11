package ex22110678910;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Ex12ElectronicsDAOImpl implements Ex12ElectronicsDAO {
  private Properties proFile = new Properties();
	
	public Ex12ElectronicsDAOImpl() {
		try {
			//dbQuery�� �غ��� ~.properties������ �ε��ؼ� Properties �ڷᱸ���� �����Ѵ�.
			
			//���� ������Ʈ�� ��Ÿ��(����)�ɶ�, �� ������ ����ɶ� classes������ ��ġ��
			//�������� �����ͼ� ��θ� �����ؾ��Ѵ�.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
			
			System.out.println("ElecdaoImpl/query.select = " +proFile.getProperty("query.select"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Ex09Electronics> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Ex09Electronics> list = new ArrayList<Ex09Electronics>();
		
		String sql= proFile.getProperty("query.select");//select * from Ex09Electronics  order by writeday desc
		try {
			con = Ex01DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Ex09Electronics electonics = 
				new Ex09Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
						rs.getString(8), rs.getInt(9));
				
			   list.add(electonics);
			}
		}finally {
			Ex01DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Ex09Electronics> getBoardList(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Ex09Electronics> list = new ArrayList<Ex09Electronics>();
		
		String sql= proFile.getProperty("query.pagingSelect");//select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM Ex09Electronics ORDER BY writeday desc) a) where  rnum>=? and rnum <=? 
		try {
			
			
			con = Ex01DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//��ü���ڵ���� ���Ѵ�.
			int totalCount = this.getTotalCount(con);
			int totalPage = totalCount%Ex07PageCnt.pageSize==0 ? totalCount/Ex07PageCnt.pageSize : (totalCount/Ex07PageCnt.pageSize)+1;
			
			Ex07PageCnt pageCnt = new Ex07PageCnt();
			pageCnt.setPageCnt(totalPage);
			pageCnt.setPageNo(pageNo);
			
			ps = con.prepareStatement(sql);
			//? 2���� set����
			ps.setInt(1, (pageNo-1) * pageCnt.pageSize +1); //����
			ps.setInt(2, pageNo * pageCnt.pageSize);//��
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Ex09Electronics electonics = 
				new Ex09Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
						rs.getString(8), rs.getInt(9));
				
			   list.add(electonics);
			}
		}finally {
			Ex01DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	
	/**
	 * ��ü���ڵ� �� �˻��ϱ�
	 * */
	private int getTotalCount(Connection con) throws SQLException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		String sql= proFile.getProperty("query.totalCount");//select count(*) from Ex09Electronics
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			Ex01DbUtil.dbClose(null, ps, rs);
		}
		return result;
	}

	@Override
	public Ex09Electronics selectByModelNum(String modelNum) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Ex09Electronics electronics = null;
		
		String sql= proFile.getProperty("query.selectBymodelNum");//select * from Ex09Electronics where model_num=?
		try {
			con = Ex01DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				electronics = new Ex09Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
						rs.getString(8), rs.getInt(9));
				
				//������� �˻�!!!
				electronics.setRepliesList(this.getReply(con, modelNum));
			
			}
		}finally {
			Ex01DbUtil.dbClose(con, ps, rs);
		}
		return electronics;
	}
	/*PreparedStatement ps2;
	ps2=con.prepareStatement("select * from product_category where category_code = ?");
	ps2.setString(1, list.get(1));
	rs2=ps2.executeQuery();
	if(rs.next()) */
	/**
	 * ������� �������� 
	 * */
	private List<Ex10Reply> getReply(Connection con , String modelNum)throws SQLException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Ex10Reply> list = new ArrayList<Ex10Reply>();
		String sql=proFile.getProperty("query.replyByParentNum");//select * from replies where parent_model_num=?
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				Ex10Reply reply = new Ex10Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(reply);
			}
			
		}finally {
			Ex01DbUtil.dbClose(null, ps, rs);
		}
		return list;
	}
	

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("query.updateReadnum");//update Ex09Electronics set readnum=readnum+1 where model_num=?
		try {
			con = Ex01DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			result = ps.executeUpdate();
		}finally {
			Ex01DbUtil.dbClose(con, ps);
		}
		return result;
	}
	

	@Override
	public int insert(Ex09Electronics electronics) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("query.insert");//insert into Ex09Electronics values(?,?,?,?,?,sysdate,0,?,?)
		try {
			con = Ex01DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, electronics.getModelNum());
			ps.setString(2, electronics.getModelName());
			ps.setInt(3, electronics.getPrice());
			ps.setString(4, electronics.getDescription());
			ps.setString(5, electronics.getPassword());
			ps.setString(6, electronics.getFname());
			ps.setInt(7, electronics.getFsize());
			
			result = ps.executeUpdate();
		}finally {
			Ex01DbUtil.dbClose(con, ps);
		}
		return result;
	}
	

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("query.delete");//delete Ex09Electronics where model_num=? and password=?
		try {
			con = Ex01DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, modelNum);
			ps.setString(2, password);
			
			result = ps.executeUpdate();
		}finally {
			Ex01DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(Ex09Electronics electronics) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("query.update");//update Ex09Electronics set model_name=?,price=?,description=? where model_num=? and password=?
		try {
			con = Ex01DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, electronics.getModelName());
			ps.setInt(2, electronics.getPrice());
			ps.setString(3, electronics.getDescription());
			ps.setString(4, electronics.getModelNum());
			ps.setString(5, electronics.getPassword());
			
			result = ps.executeUpdate();
		}finally {
			Ex01DbUtil.dbClose(con, ps);
		}
		return result;
	}//updateEnd
	
}//Ŭ������
