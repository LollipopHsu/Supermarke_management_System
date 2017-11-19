package lyons.page;

import lyons.tool.Arith;
import lyons.tool.QueryPrint;
import lyons.tool.ScannerChoice;
import lyons.page.GoodsPage;

import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.dao.GsalesDao;
import lyons.dao.SalesManDao;
import lyons.entity.Goods;
import lyons.entity.Gsales;
import lyons.entity.SalesMan;


public class MainPage extends ScannerChoice {
	public static void main(String args[]) {
		MainPage.mianPage();
	}
/**
 * ϵͳ������
 **/
	public static void mianPage() {

		System.out.println("\t**************************\t");
		System.out.println("\t*                     *\t");
		System.out.println("\t*    1. ��Ʒά��                 *\t");
		System.out.println("\t*    2. ǰ̨����                 *\t");
		System.out.println("\t*    3. ��Ʒ����                 *\t");
		System.out.println("\t*                     *\t");
		System.out.println("\t**************************\t");
		System.out.println("\t*��ѡ��Ҫ������߰�0�˳�");
		System.out.println("\t*");
		do {
			String choice = ScannerInfoString();
			String regex = "[0-3]";
			if (choice.matches(regex)) {
				int num = Integer.parseInt(choice);
				switch (num) {
				case 0:
					System.out.println("------------------");
					System.out.println("���Ѿ��˳�ϵͳ!");
					System.exit(1);// �˳����򣬷���ֵ�������
					break;
				case 1:
					MaintenancePage();
					break;
				case 2:
					checkstandLogPage();
					break;
				case 3:
					salesManManagementPage();
					break;

				}

			}

		} while (true);

	}
	
	public static void MaintenancePage() {
		System.out.println("\t1");
		System.out.println("\tִ����ʾ��Ʒά���˵�");
		System.out.println("\t�̳��������ϵͳ  >> ��Ʒά��");
		System.out.println("\t**************************\t");
		System.out.println("\t1. �����Ʒ");
		System.out.println("\t2. ������Ʒ");
		System.out.println("\t3. ɾ����Ʒ");
		System.out.println("\t4. ��ʾ������Ʒ");
		System.out.println("\t5. ��ѯ��Ʒ");
		System.out.println("\t**************************\t");
		System.out.println("\t*��ѡ��Ҫ�������ֻ��߰�0������һ���˵�");
		do {
            String choic = ScannerInfoString();
            String regex = "[0-5]";
            if(choic.matches(regex));
            {
            	int  num = Integer.parseInt(choic);
            	switch(num)
            	{
            	case 0 :
            		mianPage();
            		break;
            	case 1 :
            		GoodsPage.addGoodsPage();
            		break;
            	case 2 :
            		GoodsPage.updateGoodsPage();
            		break;
            	case 3:
            		GoodsPage.deleteGoodsPage();
            		break;
            	case 4:
            		GoodsPage.displayGoodsPage();
            		
            		break;
            	case 5:
            		GoodsPage.queryGoodsPage();
            		break;
            		
            	}
            }
		} while (true);

	}
	
	/**
	 * 2.ǰ̨������½����
	 */
	public static void checkstandLogPage() {
	// TODO Auto-generated method stub
		System.out.println("\n*******��ӭʹ���̳��������ϵͳ*******\n");
		System.out.println("\t 1.��¼ϵͳ\n");
		System.out.println("\t 2.�˳�\n");
		System.out.println("-----------------------------");
		System.out.println("������ѡ��,���߰� 0 ������һ���˵�.");
		do{
			String scann = ScannerChoice.ScannerInfoString();
			String regex = "[0-2]";
			if(scann.matches(regex))
			{
				int info = Integer.parseInt(scann);
				switch (info)
				{
				case 0:
					mianPage();
					break;
				case 1:
					int loginTimes = 3;
					while(loginTimes != 0)
					{
						loginTimes --;
						System.out.println("---�û���---");
						String sName = ScannerChoice.ScannerInfoString();
						System.out.println("---��    ��---");
						String sPassWd = ScannerChoice.ScannerInfoString();
						
						ArrayList<SalesMan> salesManInfo = new SalesManDao().checkstandLog(sName);
						if(salesManInfo == null || salesManInfo.size() == 0)
						{
							System.err.println("\t!!�û�����������!!\n");
							System.out.println("\nʣ���½������"+loginTimes);
						}else
						{
							SalesMan salesMan = salesManInfo.get(0);
							if(sPassWd.equals(salesMan.getSPassWd()))
							{
								System.out.println("\t  ---�˻��ɹ���½---");
								shoppingSettlementPage(salesMan.getSId());//����ΪӪҵԱ���sId
							}else
							{
								System.err.println("\t!!�������!!\n");
								System.out.println("\nʣ���½������"+loginTimes);
							}
						}
						
						
					}
					//loginTimes = 0
					System.out.println("------------------");
					System.err.println("\t�������ѱ�ǿ���˳�ϵͳ����");
					System.exit(1);			
					break;
				case 2 :
					System.out.println("------------------");
					System.out.println("���Ѿ��˳�ϵͳ!");
					System.exit(-1);			
					break;
				}
				
			}
		System.err.println("!��������!");
		System.out.println("��������� 0 ������һ���˵�");
		}while(true);
}
	/**
	 * ����������
	 */
	public static void shoppingSettlementPage(int salesManSid) {
		// TODO Auto-generated method stub
		System.out.println("\n\t*******�������*******\n");
		do{
			System.out.println("�� S ��ʼ�������.�� 0 �����˻���¼����");
			String choNext	= ScannerInfoString();
			if("0".equals(choNext))
			{
				checkstandLogPage();
			}
			else if("s".equals(choNext)||"S".equals(choNext))
			{
				System.out.println("������Ʒ�ؼ���");
				int gid = QueryPrint.querySettlement();
				
				switch(gid)
				{
				case -3:
					//�޴���Ʒ,����ѭ��
					break;
				case -1:
					System.err.println("\t--��Ǹ������Ʒ���ۿ�--");
					break;
				default: 
					System.out.println("--����Ʒ���ѡ����Ʒ--");
					//����gid�����þ�ȷ��ѯ��Ʒ
				 	int shoppingGid = ScannerInfoNum();	
				 	ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(shoppingGid,null);
				 	if(goodsList == null || goodsList.size() == 0)
				 	{
				 		System.out.println("\t�������޴���Ʒ ����\n");
				 	}else
				 	{
				 		Goods goods = goodsList.get(0);
				 		int gNum = goods.getGnum();
				 		double gPrice = goods.getGprice();
				 		
				 		System.out.println("--�����빺������--");
				 		do
				 		{
				 			int choicegoodsNum = ScannerInfoNum();
				 			if(choicegoodsNum > gNum)
				 			{
				 				System.err.println("\t�����ֿⴢ�����㣡��");
								System.out.println("--���������빺������--");
				 			}
				 			else
				 			{
				 				double allPrice  =Arith.mul(choicegoodsNum,gPrice);
				 				System.out.println("\t\t\t  ���ﳵ����\n");
								System.out.println("\t\t��Ʒ����\t��Ʒ����\t��������\t�ܼ�\n");
								System.out.println("\t\t"+goods.getGname()+"\t"+gPrice+" $\t"+choicegoodsNum+"\t"+allPrice+" $\n");
								
								do
								{
									System.out.println("ȷ�Ϲ���Y/N");
									String choShopping = ScannerInfoString(); 
									if ("y".equals(choShopping) || "Y".equals(choShopping))
									{
										System.out.println("\n�ܼۣ�"+allPrice+" $");
										System.out.println("\nʵ�ʽɷѽ��");
										do
										{
											double amount = ScannerInfo();
											double balance = Arith.sub(amount, allPrice);  //�û���Ǯ�빺����Ʒ�ܼۼ�Ĳ��
											if (balance < 0)
											{
												System.err.println("\t�������ɽ��㣡��");
												System.out.println("\n������������ɽ��($)");
											}else
											{
			/*	�����ǹ������������ݿ⣡����������----------------------	  1.����goods������ 
												  2.����sales������
												ԭ��Ʒ����gNum�� ����ԱId  salesManSid */
												
													//��sales�����
													Gsales gSales = new Gsales(goods.getGid(),salesManSid,choicegoodsNum);
													boolean insert = new GsalesDao().shoppingSettlement(gSales);
													
													//��goods�����
													int goodsNewNum = gNum - choicegoodsNum; //����goods���и���Ʒ����
													Goods newGoods = new Goods(goods.getGid(),goodsNewNum);
													boolean update = new GoodsDao().updateGoods(3,newGoods);
							
														if (update && insert)
														{
															System.out.println("���㣺"+balance);
															System.out.println("\nлл���٣���ӭ�´λݹ�");
														}else 
															{
																System.err.println("��֧��ʧ�ܣ�"); //�����������һ�������ݿ���������⣡
															}
													shoppingSettlementPage(salesManSid);//�����ת�����������ҳ��
//	�����������������ݿ⣡����������-----------------------------------	
											}
										}while(true);
									}else if("N".equals(choShopping)||"n".equals(choShopping))
									{
										shoppingSettlementPage(salesManSid);
									}
									System.err.println("\t!! ��ȷ�Ϲ������򣡣�");
								}while(true);
				 			}
				 		}while(true);
				 	}
				 	break;
				}
				
				
			}else
			{
				System.err.println("\t!!������Ϸ��ַ�!!\n");
			}
			
		}while(true);
		
	}
	public static void salesManManagementPage(){
		System.out.println("***************************\n");
		System.out.println("\t 1.����ۻ�Ա\n");
		System.out.println("\t 2.�����ۻ�Ա\n");
		System.out.println("\t 3.ɾ���ۻ�Ա\n");
		System.out.println("\t 4.��ѯ�ۻ�Ա\n");
		System.out.println("\t 5.��ʾ�����ۻ�Ա\n");
		System.out.println("***************************");
		
		System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
		do {
            String choic = ScannerInfoString();
            String regex = "[0-5]";
            if(choic.matches(regex))
            {
            	int info = Integer.parseInt(choic);
            	switch(info)
            	{
            	 case 0: 
            		 break;
            	 case 1:
            	 SalesManPage.addSalesManPage();
            	 break;
            	 case 2:
 					SalesManPage.updateSalesManPage();
 					break;
 				case 3:
 					SalesManPage.deleteSalesManPage();
 					break;
 				case 4:
 					SalesManPage.querySalesManPage();
 					break;
 				case 5:
 					SalesManPage.displaySalesManPage();
 					break;
 				default:
 					break; 
            	}
            }
		} while (true);

	}
	
}
