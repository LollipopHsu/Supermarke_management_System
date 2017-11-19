package lyons.entity;
/**
 * Gsales �������ʵ����
 * @author lyons(zhanglei)
 */
public class Gsales {
	private int gId;
	private int sId;
	private int sNum;
	
	private String gName; 
	private double gPrice;
	private int gNum;
	private int allSnum; //������Ʒ�����ܺ�
	/**
	 * �������
	 * @param gId,sId,sNum
	 */
	public Gsales(int gId,int sId,int sNum)
	{
		this.gId = gId;
		this.sId = sId;
		this.sNum = gNum;
		this.allSnum = allSnum;
	}
	/**
	 * չ����Ʒ�б�
	 * @param gName,gPrice,gNum,allSnum
	 */
	public Gsales(String gName,double gPrice,int gNum,int allSnum)
	{
		this.gName = gName;
		this.gPrice = gPrice;
		this.gNum = gNum;
		this.allSnum = allSnum;
	}
	//����set��get
	public int getGId()
	{
		return gId;
	}
	public void setGId(int id)
	{
		gId = id;
	}
	public int getSId()
	{
		return sId;
	}
	public void setSId(int Id)
	{
		sId = Id;
		
	}
	public int getSNum()
	{
		return sNum;
	}
	public void setSNum(int num)
	{
		sNum = num;
	}
	public String getGName()
	{
		return gName;
	}
	public void setGName(String name)
	{
		gName = name;
	
	}
	public double getGPrice()
	{
		return gPrice;
	}
	public void setGPrice(double price)
	{
	 	gPrice = price;
	}
	public int getAllSnum()
	{
		return allSnum;
		
	}
	public void setAllSnum(int allsnum)
	{
		allSnum = allsnum;
	}
	
	
}
