package myfinal;
//import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.*;

//import java.awt.*;

public class GameFrame {
	//data
	private JFrame GameFrame = new JFrame();
	//private Container CardC=GameFrame.getContentPane();
	private GameScreen game = new GameScreen();
	private StartScreen start = new StartScreen();//建立開始內容面板物件
	private EndScreen end = new EndScreen();
	private CardLayout card = new CardLayout();
	private JPanel Parent = new JPanel(card);
	//------------------------------------------------------------------------------
	public void setParentP()
	{
		Parent.add(game.getGP(),"gameP");
		Parent.add(start.getSPanel(),"startP");
		Parent.add(end.getEndP(),"endP");
		GameFrame.setContentPane(Parent);//將內容面板放到框架中
	}
	//------------------------------------------------------------------------------
	public void setGameFrame()
	{
		GameFrame.setTitle("Card Game");
		GameFrame.setJMenuBar(game.getJMB());
		//CardC.add(start.getSPanel(), BorderLayout.CENTER);//初始畫面設為開始畫面
		GameFrame.setSize(1200,1000);//大小為寬1200高1000
		GameFrame.setLocation(0,0);//在左上角位置彈出
		GameFrame.setVisible(true);//視窗可見 	
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉即結束程式   		
		GameFrame.setResizable(false);//設定視窗不可縮放
		
		//new add
		start.setSPanel();
    	start.setStartButton();
    	start.setComponent();
    	start.setCatLeft();
		start.setCatRight();
		start.setTitle();
		//start.setGameName();
    	//start.setRuleTxt();
    	//start.setSPanel();
    	//start.setStartButton();
    	//start.setComponent();
    	
    	end.setGameOver();
    	end.setAgain();
    	end.setComponent();
    	end.setEndP();
	}
	//------------------------------------------------------------------------------
	public void goToGS()
	{
		//CardC.remove(start.getSPanel());
		//CardC.add(game.getGP(), BorderLayout.CENTER);//初始畫面設為開始畫面
		card.show(Parent, "gameP");
	}
	//------------------------------------------------------------------------------
	public void goToSS()
	{
		/*CardC.remove(end.getEndP());
		CardC.add(start.getSPanel(), BorderLayout.CENTER);//初始畫面設為開始畫面*/
		card.show(Parent, "startP");
	}
	//------------------------------------------------------------------------------
	public void goToES()
	{
		/*CardC.remove(game.getGP());
		CardC.add(end.getEndP(), BorderLayout.CENTER);//初始畫面設為開始畫面*/
		end.setShowTime();
		card.show(Parent, "endP");
	}
	//------------------------------------------------------------------------------
	public void callStart()
	{
		end.setStart();
	}
	public void callEnd()
	{
		end.setEnd();
	}
	//------------------------------------------------------------------------------
	public void setTouchFlag()
	{
		start.touchToStart=false;
		end.touchToAgain=false;
		game.over=false;
		
	}
	/*
	public void setInitial()
	{
		game.Initial();
	}*/
	//------------------------------------------------------------------------------
	public boolean judgeStartB()
	{
		return start.touchStart();
	}
	//------------------------------------------------------------------------------
	public boolean judgeEndB()
	{
		return end.touchAgain();
	}
	//------------------------------------------------------------------------------
	public boolean judgeOver()
	{
		return game.getOver();
	}
	//------------------------------------------------------------------------------
		public void ShowTalks()//new add
		{
			start.showTalk();
		}
}
