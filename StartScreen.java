package myfinal;
/*
 * �}�l�e��
 */

import java.awt.*;

//new add
import javax.swing.*;
import javax.swing.text.StyleConstants;
//import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen {
	
	//new add
	//data member
		boolean touchToStart=false;
		boolean talkOver=false;
		//--���e���O--
		private JPanel StartP = new JPanel();//�}�l���������O
		
		//--�}�l����������--
		private JButton StartB=new JButton();//�}�l���s
		private ImageIcon startimg=new ImageIcon();
		private JLabel CatRight = new JLabel();
		private ImageIcon catright = new ImageIcon("Image/CAT1.png"); 
		private JLabel CatLeft = new JLabel();
		private ImageIcon catleft = new ImageIcon("Image/CAT4.png");
		private JLabel TalkRight=new JLabel();
		private JLabel TalkLeft=new JLabel();
		private ImageIcon talkright = new ImageIcon("Image/talkright01.png");
		private ImageIcon talkleft = new ImageIcon("Image/talkleft01.png");
		private JLabel Title = new JLabel();
		private ImageIcon title = new ImageIcon("Image/title.png");
		private JLabel Witch = new JLabel();
		private ImageIcon witch = new ImageIcon("Image/CAT6.png");
		
		
		

		//member function
		
		//�]�w���O
		public void setSPanel()
		{
			//���O�G��
			StartP.setLayout(null);
			StartP.setBackground(java.awt.Color.white);
		}
		
		public JPanel getSPanel()
		{
			return StartP;
		}
		
		//title
		public void setTitle()
		{
			Title.setIcon(title);
			Title.setBounds(200, 50, 750, 400);
			Title.setVisible(true);
		}
		
		//imgCat
		public void setCatLeft()
		{
			CatLeft.setIcon(catleft);
			CatLeft.setBounds(0, 585, 440, 440);
			CatLeft.setVisible(true);
		}
		
		public void setCatRight()
		{
			CatRight.setIcon(catright);
			CatRight.setBounds(845,610, 400, 400);
			CatRight.setVisible(true);
		}
		
		//catTalk
		
		
		public void showTalk()
		{
			int img=0;
			while(true)
			{
				if(img==0)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					img++;
				}
				else if(img==1)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					TalkLeft.setVisible(false);
					TalkRight.setBounds(520, 450, 400, 400);
					TalkRight.setIcon(talkright);
					TalkRight.setVisible(true);
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					catleft = new ImageIcon("Image/CAT5.png");
					CatLeft.setBounds(-10, 560, 440, 440);
					CatLeft.setIcon(catleft);
					TalkRight.setVisible(false);
					TalkLeft.setBounds(300, 580, 440, 440);
					TalkLeft.setIcon(talkleft);
					TalkLeft.setVisible(true);
					
					img++;
				}
				else if(img==2)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkright=new ImageIcon("Image/talkright02.png");
					TalkRight.setBounds(500, 450, 400, 400);
					TalkRight.setIcon(talkright);
					TalkLeft.setVisible(false);
					TalkRight.setVisible(true);
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkleft=new ImageIcon("Image/talkleft02.png");
					TalkLeft.setIcon(talkleft);
					TalkRight.setVisible(false);
					TalkLeft.setVisible(true);
					img++;
				}
				else if(img==3)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkright=new ImageIcon("Image/talkright03.png");
					TalkRight.setBounds(500, 400, 400, 400);
					TalkRight.setIcon(talkright);
					TalkLeft.setVisible(false);
					TalkRight.setVisible(true);
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkleft=new ImageIcon("Image/talkleft03.png");
					TalkLeft.setIcon(talkleft);
					TalkRight.setVisible(false);
					TalkLeft.setVisible(true);
					img++;
				}
				else if(img==4)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkright=new ImageIcon("Image/talkright04.png");
					TalkRight.setBounds(450, 400, 420, 400);
					TalkRight.setIcon(talkright);
					TalkLeft.setVisible(false);
					TalkRight.setVisible(true);
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkleft=new ImageIcon("Image/talkleft04.png");
					TalkLeft.setIcon(talkleft);
					TalkRight.setVisible(false);
					TalkLeft.setVisible(true);
					img++;
				}
				else if(img==5)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkright=new ImageIcon("Image/talkright05.png");
					TalkRight.setIcon(talkright);
					TalkLeft.setVisible(false);
					TalkRight.setVisible(true);
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					catleft = new ImageIcon("Image/CAT2.png");
					CatLeft.setBounds(0, 625, 440, 440);
					CatLeft.setIcon(catleft);
					talkleft=new ImageIcon("Image/talkleft05.png");
					TalkLeft.setBounds(300, 580, 440, 440);
					TalkLeft.setIcon(talkleft);
					TalkRight.setVisible(false);
					TalkLeft.setVisible(true);
					img++;
				}
				else if(img==6)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkright=new ImageIcon("Image/talkright06.png");
					TalkRight.setIcon(talkright);
					TalkRight.setVisible(true);
					img++;
				}
				else if(img==7)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					talkright=new ImageIcon("Image/talkright07.png");
					TalkLeft.setVisible(false);
					TalkRight.setIcon(talkright);
					img++;
				}
				else if(img==8)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					catright = new ImageIcon("Image/CAT3.png");
					CatRight.setBounds(800,620, 400, 400);
					CatRight.setIcon(catright);
					talkright=new ImageIcon("Image/talkright08.png");
					TalkRight.setIcon(talkright);
					img++;
				}
				else if(img==9)
				{
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException e) {}
					TalkRight.setVisible(false);
					StartB.setVisible(true);
					break;
				}
			}
		}
		//�]�w�}�l���s
		public void setStartButton()
		{
			startimg=new ImageIcon("Image/CAT6.png");
			StartB=new JButton(startimg);
			StartB.setBounds(380, 400, 400, 260);//���s��(x,y)+�ex��
			StartB.setVisible(false);
		}
		
		public boolean touchStart()
		{
			StartB.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					touchToStart=true;
				}
				
			});
			return touchToStart;
		}
		
		//�N�]�w�n���U�Ӥ����쭱�O��
		public void setComponent()
		{
			StartP.add(TalkRight);
			StartP.add(TalkLeft);
			StartP.add(CatLeft);
			StartP.add(CatRight);
			StartP.add(StartB);//�}�l���s
			StartP.add(Title);
		}
	
	/*//data member
	boolean touchToStart=false;
	//--���e���O--
	private JPanel StartP = new JPanel();//�}�l���������O
	
	//--�}�l����������--
	private JButton StartB=new JButton("Next");//�}�l���s
	private JLabel GameName = new JLabel();//�b�̤W����ܹC���W��
	private Font GNameF=new Font(null,1,80);//�C���W�٪���r�ݩ�
	private JTextPane RuleTxt=new JTextPane();//�إߤ�r��
	//�]�w��r�Ϥ�r�ݩ�
	//private StyledDocument RuleStyle=RuleTxt.getStyledDocument();
	private SimpleAttributeSet RuleSA = new SimpleAttributeSet();

	//member function
	
	//�]�w���O
	public void setSPanel()
	{
		//���O�G��
		StartP.setLayout(null);
	}
	
	public JPanel getSPanel()
	{
		return StartP;
	}
	
	//�]�w��ܪ��C���W��
	public void setGameName()
	{
		GameName.setBounds(360,30,450,100);//��m�P�j�p
		GameName.setText("Card Game");//��ܤ�r
		GameName.setFont(GNameF);//�M�Τ�r�ݩ�
	}
	
	//�]�w�V���a�������W�h
	public void setRuleTxt()
	{
		RuleTxt.setBounds(100, 170, 1000, 600);//�W�h��������r�Ϫ���m�P�j�p
		RuleTxt.setEditable(false);//���i�s��
		RuleTxt.setBackground(Color.LIGHT_GRAY);//��r�ϭI����
		//--�]�w�r���ݩ�--
		StyleConstants.setFontFamily(RuleSA, "Arial");
		StyleConstants.setFontSize(RuleSA, 50);
		//--�Ϥ�r�m��--
		StyleConstants.setAlignment(RuleSA, StyleConstants.ALIGN_CENTER);
		RuleTxt.setParagraphAttributes(RuleSA,false);
		
		//��ܤ�r
		RuleTxt.setText(
				"�w��i�J�o��½�P�C��!!\r\n\r\n"+
				"�@�}�l�|½�}�Ҧ��P���A"+"\r\n"+
				"���a��5���ɶ��i��O�СA"+"\r\n"+
				"5��L��N�|�\�_�Ҧ����P�C"+"\r\n\r\n"+
				"�Ҧ��P���\�_��Y�}�l�p�ɡA"+"\r\n"+
				"�аȥ��յۥγ̵u���ɶ�½�}�Ҧ����P!!"+"\r\n"+
				"�D�Է����a!!"+"\r\n");
	}
	
	//�]�w�}�l���s
	public void setStartButton()
	{
		StartB.setBounds(550, 800, 80, 40);//���s��(x,y)+�ex��
	}
	
	public boolean touchStart()
	{
		StartB.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				touchToStart=true;
			}
			
		});
		return touchToStart;
	}
	
	//�N�]�w�n���U�Ӥ����쭱�O��
	public void setComponent()
	{
		StartP.add(GameName);//�C���W��
		StartP.add(RuleTxt);//�W�h����
		StartP.add(StartB);//�}�l���s
	}*/
}