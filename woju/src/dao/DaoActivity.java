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
			actBuffer[i-1].setActName("锤子");
			actBuffer[i-1].setAdress("交大");
			actBuffer[i-1].setId(i);
			actBuffer[i-1].setStatement("这是一个游戏，我们可以减肥哇哦就fin静安寺");			
		}
		return actBuffer;
	}

}
