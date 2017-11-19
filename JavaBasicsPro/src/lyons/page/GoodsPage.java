package lyons.page;

import lyons.tool.QueryPrint;
import lyons.tool.ScannerChoice;
import lyons.entity.Goods;

import java.util.ArrayList;

import lyons.dao.GoodsDao;
public final class GoodsPage extends ScannerChoice{
	

	/**
	 * 1.�����Ʒ����
	 */
	public static void  addGoodsPage(){
		System.out.println("\t����ִ�������Ʒ����\n");
		System.out.println("\nՈݔ�������Ʒ-����");
		String gname	= ScannerInfoString();
		System.out.println("\nՈݔ�������Ʒ-�۸�");
		double gprice   = ScannerInfo();
		System.out.println("\nՈݔ�������Ʒ-����");
		int    gnum		= ScannerInfoNum();
		
		Goods goods  	= new Goods(gname,gprice,gnum);
		boolean bool = new GoodsDao().addGoods(goods);
		if(bool)
		{
			System.out.println("\n\t!���ѳɹ������Ʒ�����ݿ�!");			
		}else 
			{
				System.out.println("�����Ʒʧ��");	
		}
		
	}
	
	public static void updateGoodsPage(){
		System.out.println("\t����ִ�� ������Ʒ ����\n");
		System.out.println("��������Ҫ���ĵ���Ʒ����");
		//���ò�����Ʒ��������ʾ��Ҫ���ĵ���Ʒ��Ϣ
		int gid = QueryPrint.query("upateGoodsPage");////return the goods gid
	    System.out.println("\n--------��ѡ����Ҫ���ĵ�����\n");
	    System.out.println("\t1.������Ʒ-����");
	    System.out.println("\t2.������Ʒ-�۸�");
	    System.out.println("\t3.������Ʒ-����");
	    System.out.println("\n������ѡ��,���߰�0������һ���˵�.");
	    do
	    {
	    	String choice = ScannerInfoString();
	    	String regex  = "[0-3]";
	    	if(choice.matches(regex))
	    	{
	    		int info =  Integer.parseInt(choice);
	    		switch(info)
	    		{
	    		case 0:
	    			MainPage.MaintenancePage();
	    			break;
	    		case 1:
	    			System.out.println("��������Ʒ-������");
	    			String gname = ScannerInfoString();
	    			Goods goodsName  = new Goods(gid,gname);
	    			boolean boolName = new GoodsDao().updateGoods(1,goodsName);
	    			if(boolName)
	    			{
	    				System.out.println("\n\t�����ɹ�������Ʒ�������ݿ⣡��\n");
	    			}else
	    			{
	    				System.err.println("\n\t����������Ʒ��ʧ������");
	    			}
	    			changedInfoNext("upateGoodsPage");
	    			break;
	    		case 2:
	    			System.out.println("��������Ʒ-�¼۸� ");
	    			double gprice = ScannerInfo();
	    			Goods goodsPrice = new Goods(gid,gprice);
	    			boolean boolprice = new GoodsDao().updateGoods(2,goodsPrice);
	    			if(boolprice)
	    			{
	    				System.out.println("\n\t�����ɹ�������Ʒ�۸������ݿ⣡��\n");
	    			}else 
				 	{
					 	System.err.println("\n\t����������Ʒ�۸�ʧ������");
				 	}
	    			changedInfoNext("upateGoodsPage");
	    			break;
	    		case 3:
	    			System.out.println("��������Ʒ-������ ");
	    			int gNum = ScannerInfoNum();
	    			Goods goodsNum = new Goods(gid,gNum);
	    			boolean boolNum = new GoodsDao().updateGoods(3,goodsNum);
	    			if (boolNum)
					 {
						 System.out.println("\n\t�����ɹ�������Ʒ���������ݿ⣡��\n");
					 }else 
					 	{
						 	System.err.println("\n\t����������Ʒ����ʧ������");
					 	}
					 	changedInfoNext("upateGoodsPage");
	    			break;
	    		default:
	    			System.out.println("��������ȷ��ѡ��");
	    			break;
	    		}
	    	}
	    	System.err.println("����������");
			System.out.println("������ѡ��,���߰�0������һ���˵�.");
	    }while(true);
	}
	/**
	 * 3.ɾ����Ʒ����
	 */
	public static void deleteGoodsPage() {
		// TODO Auto-generated method stub
		System.out.println("\t����ִ�� ɾ����Ʒ ����\n");
		System.out.println("��������Ҫɾ������Ʒ����");
		//���ò�����Ʒ��������ʾ��Ҫɾ������Ʒ
		int gid = QueryPrint.query("deleteGoodsPage");//return the goods gid
		//ȷ��del
		do
		{
			System.out.println("\nȷ��ɾ������Ʒ��Y/N");
			String choice = ScannerInfoString();
			if("y".equals(choice)||"Y".equals(choice))
			{
				boolean boolDeleteGoods = new GoodsDao().deleteGoods(gid);
				if(boolDeleteGoods)
				{
					System.err.println("\t�����ѳɹ��h������Ʒ����\n");
				}else
				{
					System.err.println("\n\t�����h������Ʒʧ������");
				}
				changedInfoNext("deleteGoodsPage");
					
			}else if("N".equals(choice) || "n".equals(choice))
			{
				MainPage.MaintenancePage();
			}
			System.out.println("\t!!��������,����������!!\n");
		}while(true);
	}

	public static void queryGoodsPage() {
		// TODO Auto-generated method stub
		System.out.println("\t\t  ����ִ�в�ѯ��Ʒ����\n");
		System.out.println("\t\t1.������Ʒ �������� ��ѯ");
		System.out.println("\t\t2.������Ʒ �۸����� ��ѯ");
		System.out.println("\t\t3.������Ʒ  �ؼ���  ��ѯ");
		System.out.println("\n������ѡ��,���߰�0������һ���˵�.");
		do{
			String scann = ScannerInfoString();
			String regex = "[1-3]";
			if(scann.matches(regex))
			{
				int opt = Integer.parseInt(scann);
				switch(opt)
				{
				case 0:
					 MainPage.MaintenancePage();
					 break;
				case 1:
				case 2:
				case 3:
					if(opt == 3)//���û�ʹ��3�����ؼ��ֲ�ѯ��ʱ����Ҫ��ӡ����Ŀ��
					{
						System.out.println("\t\t����ִ����Ʒ  �ؼ���  ��ѯ����\n");
						System.out.println("\n��������Ʒ�ؼ���");
					}
					 ArrayList<Goods> goodsList = new GoodsDao().queryGoods(opt);
					 
					if(goodsList == null || goodsList.size()< 0 )
					{
						System.err.println("\n\t!!����ѯ����Ʒ������!!\n");
						queryGoodsPage();
					}
					else
					{
						if(opt == 1) //��ӡĿ¼����Ҫ���ڹ��ܺ����У���Ӱ��������������
						{
							System.out.println("\t\t\t\t\t��Ʒ���� �������� �б�\n\n");
						}
						else if(opt == 2)
						{
							System.out.println("\t\t\t\t\t��Ʒ���� �۸����� �б�\n\n");
						}else
						{
							System.out.println("\t\t\t\t\t�������ҵ���Ʒ����\n\n");
						}
						System.out.println("\t��Ʒ���\t\t��Ʒ����\t\t��Ʒ�۸�\t\t��Ʒ����\t\t��ע\n");
						for(int i = 0,length = goodsList.size(); i < length; i++)
						{
							Goods goods = goodsList.get(i);
							System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"$\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
							int gnum = goods.getGnum();
							if(gnum == 0)
							{
								System.out.println("\t\t����Ʒ���ۿգ�");
							}else if(gnum < 0)
							{
							  System.out.println("\t\t����Ʒ�Ѳ���10��");
							}else 
							{
							  System.out.println("\t\t-");
							}
						  System.out.println("\t");
							
						}
					}
					
					System.out.println("---------------------");
					do
					{
						 System.out.println("���� 0 ������һ���˵�");
						 String choiceNext = ScannerInfoString();
						
						 if ("0".equals(choiceNext))
						{
							 MainPage.MaintenancePage();
						}
						 System.err.println("��������");
					} while (true);
					
					
				default:
					break;
				}
			}
			
			
		}while(true);
		
	}

	public static void displayGoodsPage() {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t\t\t������Ʒ�б�\n\n");
		ArrayList<Goods> goodsList = new GoodsDao().displayGoods();
		if(goodsList.size() < 0)
		{
		  System.out.println("�����Ϊ�գ�");
		  MainPage.MaintenancePage();
		}
		else
		{
			System.out.println("\t��Ʒ���\t\t��Ʒ����\t\t��Ʒ�۸�\t\t��Ʒ����\t\t��ע\n");
			for(int i = 0,length = goodsList.size(); i < length ;i++)
			{
				Goods goods = goodsList.get(i);
				System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"$\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
				int gnum    =  goods.getGnum();
				if(gnum == 0)
				{
					System.out.println("\t\t����Ʒ���ۿգ�");
				}
				else if(gnum < 10)
				{
					System.out.println("\t\t����Ʒ�Ѳ���10��");
				}
				else
				{
					System.out.println("\t\t-");
				}
				System.out.println("\t");	
			}
			System.out.println("---------------------");
			do
			{
				System.out.println("���� 0 ������һ���˵�");
				String choice = ScannerInfoString();
				if ("0".equals(choice))
				{
					MainPage.MaintenancePage();
				}
				System.out.println("��������");
			} while (true);
			
		}
		
		
	}
	

}
