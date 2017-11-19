package lyons.entity;

public final class SalesMan {
	
	private int sId;
	private String sName;
	private String sPassWd;
	
	
	/**
	 * 验证用户登陆
	 * @param sId,spassWord
	 */
	 public SalesMan(int sId,String spassWord)
	 {
		 this.sId = sId;
		 this.sPassWd = spassWord;
	 }
	 
	 /**
	  * 查询用户、更改用户密码
	  * @param sId,sName,sPassWord
	  */
	 
	 public SalesMan(int sId,String sName,String sPassWord)
	 {
		 this.sId = sId;
		 this.sName = sName;
		 this.sPassWd = sPassWord;
	 }
	 
	 /**
	  * 添加用户
	  * @param NsNameame,sPassWord
	  */
	 public SalesMan(String sName,String sPassWord)
	 {
		 this.sName = sName;
		 this.sPassWd = sPassWord;
	 }
	 
	 //共有set,get方法
	 
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
