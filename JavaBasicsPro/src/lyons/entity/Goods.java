package lyons.entity;

public final class Goods {
	private int gid;
	private String gname;
	private double gprice;
	private int gnum;
	
	public Goods(String gname,double gprice,int gnum)
	{
		this.gname  = gname;
		this.gprice = gprice;
		this.gnum   = gnum;
	}
	
	public Goods(int gid,String gname,double gprice,int gnum){
		this.gid	= gid;
		this.gname	= gname;
		this.gprice	= gprice;
		this.gnum	= gnum;
	}
	
	public Goods(int gid,int gnum){
		this.gid	= gid;
		this.gnum	= gnum;
	}
	
	public Goods(int gid,String gname){
		this.gid	= gid;
		this.gname 	= gname;
	}
	
	public Goods(int gid, double gprice) {
		// TODO Auto-generated constructor stub
		this.gid = gid;
		this.gprice = gprice;
	}

	public int getGid(){
		return gid;
	}
	public void setGid(int gid){
		this.gid	= gid;
	}
	public String getGname(){
		return gname;
	}
	public void setGname(String gname){
		this.gname	= gname;
	}
	
	public double getGprice(){
		return gprice;
	}
	
	public void setGprice(double gprice){
		this.gprice	 = gprice;
	}
	
	public int getGnum(){
		return gnum;
	}
	
	public void setgnum(int gnum){
		this.gnum	 = gnum;
	}
	
}
