package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.SalesMan;

/**
 * ���ݿ�SalesMan�����
 * @author lyons(zhanglei)
 *
 */
public final class SalesManDao {
	PreparedStatement pstmt = null;
	Connection conn 		= null;
	ResultSet  rs   		= null;
	/**
	 * 1.ǰ̨������½
	 * @param sName �û���
	 * @return ArrayList<SalesMan> sPassWord,sId
	 */
	public ArrayList<SalesMan> checkstandLog(String sName){
		String sqlsName = "SELECT SID,SPASSWORD FROM SALESMAN WHERE SNAME=?";
		conn = DbConn.getconn();
		ArrayList<SalesMan> salesManInfo = new ArrayList<SalesMan>();
		try{
			pstmt =  conn.prepareStatement(sqlsName);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String sPassWd = rs.getString("spassword");
				int sId = rs.getInt("sId");
				SalesMan salesMan = new SalesMan(sId,sPassWd);
				salesManInfo.add(salesMan);
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			DbClose.queryClose(pstmt, rs, conn);
		}
		
		
		return salesManInfo;
	}
	/**
	 * 2.����ۻ�Ա
	 * @param sName �û���
	 * @return boolean
	 */
	public boolean addSalesMan(SalesMan salesMan) {
		// TODO Auto-generated method stub
		boolean bool = false;
	    conn = DbConn.getconn();
		String sql = "INSERT INTO SALESMAN(SNAME,SPASSWORD) VALUES(?,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,salesMan.getSName());
			pstmt.setString(2, salesMan.getSPassWd());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			{
				bool = true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally{
			DbClose.addClose(pstmt, conn);
		}
		
		
		return bool;
	}
	/**
	 * 3.�����ۻ�Ա��Ϣ
	 * @param key 	Ҫ������
	 * @param sName �û���
	 * @return boolean
	 */
	public  boolean updateSalesMan(int key,SalesMan sName)
	{
		boolean bool = false;
		conn = DbConn.getconn();
		switch(key)
		{
		case 1: //	3.1 �����ۻ�Ա����
			String sqlName = "UPDATE SALESMAN SET SNAME=? WHERE SID=?";
			try
			{
				pstmt = conn.prepareStatement(sqlName);
				pstmt.setString(1, sName.getSName());
				pstmt.setInt(2, sName.getSId());
				
				int rs = pstmt.executeUpdate();
				if(rs > 0)
				{
					bool = true;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally{
				DbClose.addClose(pstmt, conn);
			}
			break;
		case 2: //	3.2 �����ۻ�Ա����
			String sqlPrice = "UPDATE SALESMAN SET SPASSWORD=? WHERE SID=?";
			try{
				pstmt = conn.prepareStatement(sqlPrice);
				pstmt.setString(1,sName.getSPassWd());
				pstmt.setInt(2, sName.getSId());
				
				int rs = pstmt.executeUpdate();
				if(rs > 0)
				{
					bool = true;
				}
				
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally{
				DbClose.addClose(pstmt, conn);
			}
			break;
		default:
			break;
		}
		return bool;
	}
	/**
	 * 4.ɾ���ۻ�Ա
	 * @param sName �û���
	 * @return boolean
	 */
	public boolean deleteSalesMan(String sName)
	{
		boolean bool = false;
		conn = DbConn.getconn();
		String sql ="DELETE FROM SALESMAN WHERE SNAME=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sName);
			int rs = pstmt.executeUpdate();
			if (rs > 0)
			{
				bool = true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally{
					DbClose.addClose(pstmt,conn);
				}
	 return bool;
	}
	/**
	 * 5.ģ����ѯ�ۻ�Ա
	 * @param sName �û���
	 * @return ArrayList<SalesMan>
	 */
	public ArrayList<SalesMan> querySalesMan(String sName)
	{
		ArrayList<SalesMan> SalesManList = new ArrayList<SalesMan>();
		conn = DbConn.getconn();	
	
		sName = "%"+sName+"%";	//���û�����ȡ���ַ������� % ���ţ����ﵽģ����ѯ��Ŀ��.�ַ��� �����ӻ��и�����ķ�ʽ�����Ż����룡
		String sql = "SELECT * FROM SALESMAN WHERE SNAME LIKE ?";  //��Ȼ����ֱ�Ӹ� % .ֻ���������ַ����ķ�ʽ
		   try
		   {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sName);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					int sid = rs.getInt("sid");
					String sname = rs.getString(2);
					String sPassWord = rs.getString(3);
					
					SalesMan salesMan = new SalesMan(sid,sname,sPassWord);
					SalesManList.add(salesMan);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}finally
					{
						DbClose.queryClose(pstmt, rs, conn);
					}
		return SalesManList;
	}
	
	/**
	 * 6.��ʾ�����ۻ�Ա
	 * @return ArrayList<SalesMan>
	 */
	public  ArrayList<SalesMan> displaySalesMan()
	{
		ArrayList<SalesMan> salesManList = new ArrayList<SalesMan>();
		conn = DbConn.getconn(); 
		String sql = "SELECT * FROM SALESMAN";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while (rs.next())
			{
				int sId = rs.getInt(1);
				String sName = rs.getString(2);
				String sSpassWord = rs.getString(3);
				
				SalesMan salesMan = new SalesMan(sId,sName,sSpassWord);
				salesManList.add(salesMan);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DbClose.queryClose(pstmt, rs, conn);
				}
	 return salesManList;
	}
	


	

}
