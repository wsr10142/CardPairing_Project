package myfinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.Applet;
import java.applet.AudioClip;
import javax.sound.sampled.*;


public class GameScreen {
	private ButtonHandler BH=new ButtonHandler();
	private JMenuBar jmb=new JMenuBar();
	private JMenu game=new JMenu("遊戲");
	private JMenuItem[] g=new JMenuItem[2];
			
	private final int row=5;
	private final int col=6;
	//private int img_H=0,img_W=0;//圖片高,圖片寬
			
	private int Look_Sec=5;//一開始看的時間
	private int Error_Sec=1;//翻錯停留的時間
			
	private JButton [] imgBtn = new JButton[row * col]; //圖片按鈕
	private ImageIcon [] img = new ImageIcon[row * col]; //存放圖物件
	
	//Panel
	private JPanel CardB = new JPanel(new GridLayout(5,6,10,10));//圖片排版
	
	private int rand_folder;
	private int[] order;//記錄牌的順序
	private int[] TwoImg= {-1,-1};//紀錄翻開的兩張圖
	private int[] TwoBtn= {-1,-1};//紀錄點擊的兩個按鈕
	private int Correct_img;//判斷配對成功的數量
	private boolean[] img_S=new boolean[15];//配對成功的牌
	private boolean[] btn_S=new boolean[30];//配對成功的按鈕
	private boolean isReady=false;//判斷是否翻兩張牌
    boolean over = false;//看看是否結束
    
    AudioClip card_sound;//點擊按鈕的音樂
	//------------------------------------------------------------------------------
	public JPanel getGP()
	{
		return CardB;
	}
	//------------------------------------------------------------------------------
	public GameScreen() 
	{
		//初始化按鈕
		//選擇題庫
		
		rand_folder=(int)(Math.random()*2);
		for(int i=0;i<30;i++) 
		{
			img[i]=new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image.jpg"));
			imgBtn[i]=new JButton(img[i]);
			imgBtn[i].addActionListener(BH);
			imgBtn[i].setEnabled(false);
			imgBtn[i].setSize(5,5);
			CardB.add(imgBtn[i]);//圖片排版
		}
		card_sound = Applet.newAudioClip(getClass().getResource("/music/pupu_69.wav"));
		
		TwoImg[0]= -1;
		TwoImg[1]= -1;
		TwoBtn[0]= -1;
		TwoBtn[1]= -1;
		
		isReady=false;
		over = false;
		Correct_img=0;
		
		for(int i=0;i<15;i++)
		{
			img_S[i]=false;
		}
		for(int i=0;i<30;i++)
		{
			btn_S[i]=false;
		}
		
		//設置視窗
		jmb.add(game);
		g[0]=new JMenuItem("開始遊戲");
		g[1]=new JMenuItem("結束遊戲");
		game.add(g[0]);
		game.add(g[1]);
		g[0].addActionListener(BH);
		g[1].addActionListener(BH);
	}
	//初始化
	private void Initial()
	{			
		TwoImg[0]= -1;
		TwoImg[1]= -1;
		TwoBtn[0]= -1;
		TwoBtn[1]= -1;
		isReady=false;
		over = false;
		Correct_img=0;
		
		for(int i=0;i<15;i++)
		{
			img_S[i]=false;
		}
		for(int i=0;i<30;i++)
		{
			btn_S[i]=false;
		}
		
		rand_folder=(int)(Math.random()*2);
		for(int i=0;i<30;i++) 
		{
			img[i]=new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image.jpg"));
			imgBtn[i]=new JButton(img[i]);
			imgBtn[i].addActionListener(BH);
			imgBtn[i].setEnabled(false);
			imgBtn[i].setSize(5,5);
			CardB.add(imgBtn[i]);//圖片排版
		}
	}
	//------------------------------------------------------------------------------
	public JMenuBar getJMB()
	{
		return jmb;
	}
	//------------------------------------------------------------------------------
	private class ButtonHandler implements  ActionListener
	{
    	public void actionPerformed(ActionEvent ae)
		{
    		for(int i=0;i<30;i++)
			{
    			if(ae.getSource()==imgBtn[i])
				{   
    				card_sound.play();
					check(i,((order[i]/2)));
					break;
				}
			}					
    		if(ae.getSource()==g[0])
    		{
				ini_play();
			}
			else if(ae.getSource()==g[1])
			{
				for(int i=0;i<30;i++)
				{
					CardB.remove(imgBtn[i]);
				}
				Initial();
				over=true;
			}
		}
	}

	//------------------------------------------------------------------------------
	private int[] rand_card(int n)
	{
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=i;
		}
		for(int i=0;i<n;i++)
		{
			int r=(int)(Math.random()*n);
			int b=a[i];
			a[i]=a[r];
			a[r]=b;
		}
			return a;
	}
	//------------------------------------------------------------------------------
	private void ini_play()
	{
		order=rand_card(30);//取得隨機生成的圖片陣列
		//印出答案
		for(int i=0;i<30;i++)
			{
				 imgBtn[i].setIcon(new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image_p" + (order[i]/2) + ".jpg")));
				 imgBtn[i].setEnabled(true);
		    }
			//看完五秒蓋牌
			new Thread(new Runnable()
	        {
	         public void run()
	         {
	          try{Thread.sleep(Look_Sec * 1000);
	                 }catch(InterruptedException e){}
	          			//翻回背景圖
	                   for(int i = 0; i < img.length; i++)
	                   {
	                	   img[i]=new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image.jpg"));
	                	   imgBtn[i].setIcon(img[i]);
	                	   imgBtn[i].setEnabled(true);
	                	   btn_S[i]=false;
	                   }
	         }
	        }).start();
			for(int i=0;i<15;i++)
			{
				img_S[i]=false;
			}
			isReady=false;
			over = false;
			TwoImg[0]= -1;
			TwoImg[1]= -1;
			TwoBtn[0]= -1;
			TwoBtn[1]= -1;
			Correct_img=0;
	}
	//------------------------------------------------------------------------------
	private void check(int Btn_num,int img_num)
	{
		imgBtn[Btn_num].setIcon(new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image_p" + img_num + ".jpg")));    
		//先記錄第一個按鈕與圖片
		int img_temp=TwoImg[0];
        int btn_temp=TwoBtn[0];
        //儲存第二個按鈕資訊
        TwoImg[0]=img_num;
        TwoBtn[0]=Btn_num;
        //儲存第一個按鈕資訊
        TwoImg[1]=img_temp;
        TwoBtn[1]=btn_temp;
        //點擊同一張圖片時，為無效點擊
        if(TwoBtn[0]==TwoBtn[1])
        {
        	return;
        }
        if(isReady==true)//判斷是否翻兩張牌
        {
        	for(int i=0;i<30;i++)//當翻兩張牌後，設定其他牌不能翻
        	{		
        		if(i!=TwoBtn[0]&&i!=TwoBtn[1])
        		{
        			imgBtn[i].setEnabled(false);
        		}
        	}
        	//圖片相等
        	if(TwoImg[0]==TwoImg[1])
        	{
        		imgBtn[TwoBtn[0]].setEnabled(false);
        		imgBtn[TwoBtn[1]].setEnabled(false);
        		btn_S[TwoBtn[0]]=true;
        		btn_S[TwoBtn[1]]=true;
        		for(int i=0;i<30;i++)
            	{
        			if(btn_S[i]!=true)
        			{
        				imgBtn[i].setEnabled(true);
        			}
            	}
        		img_S[img_num]=true;//配對成功
        		TwoImg[0] = -1;
        		TwoImg[1] = -1;
                TwoBtn[0] = -1;
                TwoBtn[1] = -1;
                this.GameEnd();
                isReady = false;
                return;
        	}
        	 //run();
        	//翻錯隔一秒蓋牌
        	new Thread(new Runnable()
            {
             public void run()
             {
            	 try{
            	      Thread.sleep(Error_Sec * 1000);
            	      }catch(InterruptedException e){}
            	     //蓋住原本翻開的圖片        
            	 	imgBtn[TwoBtn[0]].setIcon(new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image.jpg")));
            	 	imgBtn[TwoBtn[1]].setIcon(new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image.jpg")));
            	 	for(int i=0;i<30;i++)
                 	{
            	    	 if(btn_S[i]!=true)
 	        			{
 	        				imgBtn[i].setEnabled(true);
 	        			}
                 	}
             }
            }).start();
    	
        }
       isReady=!isReady;
	}
	//------------------------------------------------------------------------------
	public void GameEnd()
	{
		Correct_img=0;
		 for(int i=0;i<15;i++)
         {
         	if(img_S[i]==true)
         	{
         		Correct_img++;
         	}
         }
         if(Correct_img==15)
         {
        	for(int i=0;i<30;i++)
			{
				CardB.remove(imgBtn[i]);
			}
			Initial();
        	over=true;
         }
     }
	//------------------------------------------------------------------------------
	public boolean getOver()
	{
		return over;
	}
	
}
