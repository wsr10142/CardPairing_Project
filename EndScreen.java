package myfinal;

/*
 * �C�������e��
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EndScreen {
	//data member
	timer time=new timer();
	boolean touchToAgain=false;
	private JPanel EndP = new JPanel();//�إߪŪ����e���O
	private JLabel GameOver = new JLabel();//�C����������
	private JLabel ShowTime = new JLabel();//��ܪ��a��O�ɶ�
	private JButton Again = new JButton("�A�Ӥ@��");//�A�Ӥ@�������s
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
	
	//�]�w���e���O
	public void setEndP()
	{
		EndP.setLayout(null);
	}
	
	public JPanel getEndP()
	{
		return EndP;
	}
	
	//�]�w�C����������
	public void setGameOver()
	{
		Font GOfont = new Font(null,1,120);//�r���ݩ�
		GameOver.setFont(GOfont);//�M���ݩ�
		GameOver.setText("�C������");//��ܤ�r
		GameOver.setBounds(345, 300, 1000, 120);//��m�P�j�p
	}
	
	//�]�w�ɶ����
	public void setShowTime()
	{
		Font STfont = new Font(null,1,45);//�r���ݩ�
		ShowTime.setFont(STfont);//�M���ݩ�
		ShowTime.setBounds(370, 450, 500, 50);
		ExcuteTime();
		if(sec<10)
		{
			ShowTime.setText("�A�Ҫ�O���ɶ�: "+min+":0"+sec);
		}
		else
		{
			ShowTime.setText("�A�Ҫ�O���ɶ�: "+min+":"+sec);
		}
	}
	//�]�w�A�Ӥ@�������s
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
	//�N�����쭱�O��
	public void setComponent()
	{
		EndP.add(GameOver);
		EndP.add(ShowTime);
		EndP.add(Again);
	}
}
