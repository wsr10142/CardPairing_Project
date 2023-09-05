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
	private StartScreen start = new StartScreen();//�إ߶}�l���e���O����
	private EndScreen end = new EndScreen();
	private CardLayout card = new CardLayout();
	private JPanel Parent = new JPanel(card);
	//------------------------------------------------------------------------------
	public void setParentP()
	{
		Parent.add(game.getGP(),"gameP");
		Parent.add(start.getSPanel(),"startP");
		Parent.add(end.getEndP(),"endP");
		GameFrame.setContentPane(Parent);//�N���e���O���ج[��
	}
	//------------------------------------------------------------------------------
	public void setGameFrame()
	{
		GameFrame.setTitle("Card Game");
		GameFrame.setJMenuBar(game.getJMB());
		//CardC.add(start.getSPanel(), BorderLayout.CENTER);//��l�e���]���}�l�e��
		GameFrame.setSize(1200,1000);//�j�p���e1200��1000
		GameFrame.setLocation(0,0);//�b���W����m�u�X
		GameFrame.setVisible(true);//�����i�� 	
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����Y�����{��   		
		GameFrame.setResizable(false);//�]�w�������i�Y��
		
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
		//CardC.add(game.getGP(), BorderLayout.CENTER);//��l�e���]���}�l�e��
		card.show(Parent, "gameP");
	}
	//------------------------------------------------------------------------------
	public void goToSS()
	{
		/*CardC.remove(end.getEndP());
		CardC.add(start.getSPanel(), BorderLayout.CENTER);//��l�e���]���}�l�e��*/
		card.show(Parent, "startP");
	}
	//------------------------------------------------------------------------------
	public void goToES()
	{
		/*CardC.remove(game.getGP());
		CardC.add(end.getEndP(), BorderLayout.CENTER);//��l�e���]���}�l�e��*/
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
