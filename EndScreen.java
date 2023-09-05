package myfinal;

/*
 * 遊戲結束畫面
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EndScreen {
	//data member
	timer time=new timer();
	boolean touchToAgain=false;
	private JPanel EndP = new JPanel();//建立空的內容面板
	private JLabel GameOver = new JLabel();//遊戲結束提示
	private JLabel ShowTime = new JLabel();//顯示玩家花費時間
	private JButton Again = new JButton("再來一次");//再來一次的按鈕
	private long totalTime=0;
	private long min=0;
	private long sec=0;
	//new add
	private JLabel Duck = new JLabel();
	private ImageIcon duck = new ImageIcon("Image/endduck.jpg");
	//member function
	
	//-------------------------------------------new add
	public void setDuck()
	{
		Duck.setIcon(duck);
		Duck.setBounds(10, 10, 1100, 734);
	}
	//--------------------------------------------
	
	public void setStart()
	{
		time.setStartTime();
	}
	public void setEnd()
	{
		time.setEndTime();
	}
	
	public void ExcuteTime()
	{
		totalTime = time.getEndTime()-time.getStartTime();
		sec=(totalTime/1000)%60;
		min=(totalTime/1000)/60;
	}
	
	//設定內容面板
	public void setEndP()
	{
		EndP.setLayout(null);
	}
	
	public JPanel getEndP()
	{
		return EndP;
	}
	
	//設定遊戲結束提示
	public void setGameOver()
	{
		Font GOfont = new Font(null,1,120);//字體屬性
		GameOver.setFont(GOfont);//套用屬性
		GameOver.setText("遊戲結束");//顯示文字
		GameOver.setBounds(345, 300, 1000, 120);//位置與大小
	}
	
	//設定時間顯示
	public void setShowTime()
	{
		Font STfont = new Font(null,1,45);//字體屬性
		ShowTime.setFont(STfont);//套用屬性
		ShowTime.setBounds(370, 450, 500, 50);
		ExcuteTime();
		if(sec<10)
		{
			ShowTime.setText("你所花費的時間: "+min+":0"+sec);
		}
		else
		{
			ShowTime.setText("你所花費的時間: "+min+":"+sec);
		}
	}
	//設定再來一次的按鈕
	public void setAgain()
	{
		Font Afont = new Font(null,1,30);
		Again.setFont(Afont);
		Again.setBounds(490, 700, 200, 80);
	}
	public boolean touchAgain()
	{
		Again.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				touchToAgain=true;
			}	
		});
		return touchToAgain;
	}
	//將元件放到面板中
	public void setComponent()
	{
		EndP.add(GameOver);
		EndP.add(ShowTime);
		EndP.add(Again);
	}
}
