package dao;
import entity.ActivityInfor;


public class DaoActivity {
	private static int NumOnce  = 10;
//	@SuppressWarnings("null")
	public ActivityInfor[] getActivityInfor()
	{
		ActivityInfor[] actBuffer=new ActivityInfor[NumOnce] ;
		
		for(int i=0;i<NumOnce;i++)
		{
			actBuffer[i-1].setAbstractPic("111.png");
			actBuffer[i-1].setActName("����");
			actBuffer[i-1].setAdress("����");
			actBuffer[i-1].setId(i);
			actBuffer[i-1].setStatement("����һ����Ϸ�����ǿ��Լ�����Ŷ��fin������");			
		}
		return actBuffer;
	}

}
