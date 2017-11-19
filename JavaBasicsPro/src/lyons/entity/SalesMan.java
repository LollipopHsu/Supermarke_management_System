package lyons.entity;

public final class SalesMan {
	
	private int sId;
	private String sName;
	private String sPassWd;
	
	
	/**
	 * ��֤�û���½
	 * @param sId,spassWord
	 */
	 public SalesMan(int sId,String spassWord)
	 {
		 this.sId = sId;
		 this.sPassWd = spassWord;
	 }
	 
	 /**
	  * ��ѯ�û��������û�����
	  * @param sId,sName,sPassWord
	  */
	 
	 public SalesMan(int sId,String sName,String sPassWord)
	 {
		 this.sId = sId;
		 this.sName = sName;
		 this.sPassWd = sPassWord;
	 }
	 
	 /**
	  * ����û�
	  * @param NsNameame,sPassWord
	  */
	 public SalesMan(String sName,String sPassWord)
	 {
		 this.sName = sName;
		 this.sPassWd = sPassWord;
	 }
	 
	 //����set,get����
	 
	 public int getSId()
	 {
		 return sId;
	 }
	 public void setSId(int id)
	 {
		 this.sId = id;
	 }
	 public String getSName()
	 {
		 return sName;
	 }
	 public void setSName(String name)
	 {
		 this.sName = name;
	 }
	 public String getSPassWd()
	 {
		 return sPassWd;
	 }
	 public void setSPassWd(String passwd)
	 {
		 this.sPassWd = passwd;
	 }
	 

}
