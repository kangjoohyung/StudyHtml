package ex22110678910;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class Ex14ElectronicsServiceImpl implements Ex14ElectronicsService {
	private Ex12ElectronicsDAO elecDAO = new Ex12ElectronicsDAOImpl();
	

	public Ex14ElectronicsServiceImpl() {
		//���� Ȯ������ �־�� ���
		System.out.println("Elec~ServiceImpl");
	}

	@Override
	public List<Ex09Electronics> selectAll() throws SQLException {
		List<Ex09Electronics>  list = elecDAO.selectAll();
		return list;
	}

	@Override
	public List<Ex09Electronics> selectAll(int pageNo) throws SQLException {
		List<Ex09Electronics>  list = elecDAO.getBoardList(pageNo);//����¡ó���ϴ� daoȣ��
		
		return list;
	}

	@Override
	public void insert(Ex09Electronics electronics) throws SQLException {
		int result = elecDAO.insert(electronics);
		if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");

	}

	@Override
	public Ex09Electronics selectByModelnum(String modelNum, boolean flag) throws SQLException {
		
		if(flag) {
			if(elecDAO.increamentByReadnum(modelNum) == 0){//��ȸ�� ����
				throw new SQLException("��ȸ�� ���� ������ �˻��Ҽ� �����ϴ�.");
			}
		}

		Ex09Electronics electronics = elecDAO.selectByModelNum(modelNum);
		if(electronics == null)
			throw new SQLException("�󼼺��⿡ ������ �߻��߽��ϴ�.");
		
		return electronics;
	}

	@Override
	public void delete(String modelNum, String password , String saveDir) throws SQLException {
         Ex09Electronics dbElec = elecDAO.selectByModelNum(modelNum);
		
		if(dbElec == null) {
			throw new SQLException("�𵨹�ȣ ������ ���� �Ҽ������ϴ�.");
			
		}else if(!dbElec.getPassword().equals(password)) {
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���.-��������");
		}
		
		 if(elecDAO.delete(modelNum, password) == 0) {
			 throw new SQLException("�������� �ʾҽ��ϴ�.");
		 }
		 
		 //������ �Ǿ����� ÷�������� �ִ� ���� save�������� ���ϵ� �����Ѵ�.
		 if(dbElec.getFname()!=null) {
			 String fileName = saveDir+"/" + dbElec.getFname();
			 new File(fileName).delete();
		 }

	}

	@Override
	public void update(Ex09Electronics electronics) throws SQLException {
		//���޵� ����� DB������� ����� ��ġ�ϴ��� ���� üũ�Ѵ�.
		Ex09Electronics dbElec = elecDAO.selectByModelNum(electronics.getModelNum());
		
		if(dbElec == null) {
			throw new SQLException("�𵨹�ȣ ������ �����Ҽ� �����ϴ�.");
			
		}else if(!dbElec.getPassword().equals(electronics.getPassword())) {
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���.-��������");
		}
		
		if(elecDAO.update(electronics) ==0) {
			throw new SQLException("���������ʾҽ��ϴ�.^^");
		}
		

	}

}

