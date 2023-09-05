package myfinal;
/*
 * 開始畫面
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
		//--內容面板--
		private JPanel StartP = new JPanel();//開始頁面的面板
		
		//--開始頁面的元件--
		private JButton StartB=new JButton();//開始按鈕
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
		
		//設定面板
		public void setSPanel()
		{
			//面板佈局
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
		//設定開始按鈕
		public void setStartButton()
		{
			startimg=new ImageIcon("Image/CAT6.png");
			StartB=new JButton(startimg);
			StartB.setBounds(380, 400, 400, 260);//按鈕的(x,y)+寬x高
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
		
		//將設定好的各個元件放到面板中
		public void setComponent()
		{
			StartP.add(TalkRight);
			StartP.add(TalkLeft);
			StartP.add(CatLeft);
			StartP.add(CatRight);
			StartP.add(StartB);//開始按鈕
			StartP.add(Title);
		}
	
	/*//data member
	boolean touchToStart=false;
	//--內容面板--
	private JPanel StartP = new JPanel();//開始頁面的面板
	
	//--開始頁面的元件--
	private JButton StartB=new JButton("Next");//開始按鈕
	private JLabel GameName = new JLabel();//在最上方顯示遊戲名稱
	private Font GNameF=new Font(null,1,80);//遊戲名稱的文字屬性
	private JTextPane RuleTxt=new JTextPane();//建立文字區
	//設定文字區文字屬性
	//private StyledDocument RuleStyle=RuleTxt.getStyledDocument();
	private SimpleAttributeSet RuleSA = new SimpleAttributeSet();

	//member function
	
	//設定面板
	public void setSPanel()
	{
		//面板佈局
		StartP.setLayout(null);
	}
	
	public JPanel getSPanel()
	{
		return StartP;
	}
	
	//設定顯示的遊戲名稱
	public void setGameName()
	{
		GameName.setBounds(360,30,450,100);//位置與大小
		GameName.setText("Card Game");//顯示文字
		GameName.setFont(GNameF);//套用文字屬性
	}
	
	//設定向玩家說明的規則
	public void setRuleTxt()
	{
		RuleTxt.setBounds(100, 170, 1000, 600);//規則說明的文字區的位置與大小
		RuleTxt.setEditable(false);//不可編輯
		RuleTxt.setBackground(Color.LIGHT_GRAY);//文字區背景色
		//--設定字體屬性--
		StyleConstants.setFontFamily(RuleSA, "Arial");
		StyleConstants.setFontSize(RuleSA, 50);
		//--使文字置中--
		StyleConstants.setAlignment(RuleSA, StyleConstants.ALIGN_CENTER);
		RuleTxt.setParagraphAttributes(RuleSA,false);
		
		//顯示文字
		RuleTxt.setText(
				"歡迎進入這個翻牌遊戲!!\r\n\r\n"+
				"一開始會翻開所有牌面，"+"\r\n"+
				"玩家有5秒的時間進行記憶，"+"\r\n"+
				"5秒過後將會蓋起所有的牌。"+"\r\n\r\n"+
				"所有牌面蓋起後即開始計時，"+"\r\n"+
				"請務必試著用最短的時間翻開所有的牌!!"+"\r\n"+
				"挑戰極限吧!!"+"\r\n");
	}
	
	//設定開始按鈕
	public void setStartButton()
	{
		StartB.setBounds(550, 800, 80, 40);//按鈕的(x,y)+寬x高
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
	
	//將設定好的各個元件放到面板中
	public void setComponent()
	{
		StartP.add(GameName);//遊戲名稱
		StartP.add(RuleTxt);//規則說明
		StartP.add(StartB);//開始按鈕
	}*/
}