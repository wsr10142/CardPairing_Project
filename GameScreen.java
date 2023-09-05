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
	private JMenu game=new JMenu("�C��");
	private JMenuItem[] g=new JMenuItem[2];
			
	private final int row=5;
	private final int col=6;
	//private int img_H=0,img_W=0;//�Ϥ���,�Ϥ��e
			
	private int Look_Sec=5;//�@�}�l�ݪ��ɶ�
	private int Error_Sec=1;//½�����d���ɶ�
			
	private JButton [] imgBtn = new JButton[row * col]; //�Ϥ����s
	private ImageIcon [] img = new ImageIcon[row * col]; //�s��Ϫ���
	
	//Panel
	private JPanel CardB = new JPanel(new GridLayout(5,6,10,10));//�Ϥ��ƪ�
	
	private int rand_folder;
	private int[] order;//�O���P������
	private int[] TwoImg= {-1,-1};//����½�}����i��
	private int[] TwoBtn= {-1,-1};//�����I������ӫ��s
	private int Correct_img;//�P�_�t�令�\���ƶq
	private boolean[] img_S=new boolean[15];//�t�令�\���P
	private boolean[] btn_S=new boolean[30];//�t�令�\�����s
	private boolean isReady=false;//�P�_�O�_½��i�P
    boolean over = false;//�ݬݬO�_����
    
    AudioClip card_sound;//�I�����s������
	//------------------------------------------------------------------------------
	public JPanel getGP()
	{
		return CardB;
	}
	//------------------------------------------------------------------------------
	public GameScreen() 
	{
		//��l�ƫ��s
		//����D�w
		
		rand_folder=(int)(Math.random()*2);
		for(int i=0;i<30;i++) 
		{
			img[i]=new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image.jpg"));
			imgBtn[i]=new JButton(img[i]);
			imgBtn[i].addActionListener(BH);
			imgBtn[i].setEnabled(false);
			imgBtn[i].setSize(5,5);
			CardB.add(imgBtn[i]);//�Ϥ��ƪ�
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
		
		//�]�m����
		jmb.add(game);
		g[0]=new JMenuItem("�}�l�C��");
		g[1]=new JMenuItem("�����C��");
		game.add(g[0]);
		game.add(g[1]);
		g[0].addActionListener(BH);
		g[1].addActionListener(BH);
	}
	//��l��
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
			CardB.add(imgBtn[i]);//�Ϥ��ƪ�
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
		order=rand_card(30);//���o�H���ͦ����Ϥ��}�C
		//�L�X����
		for(int i=0;i<30;i++)
			{
				 imgBtn[i].setIcon(new ImageIcon(getClass().getResource("/image_"+rand_folder+"/image_p" + (order[i]/2) + ".jpg")));
				 imgBtn[i].setEnabled(true);
		    }
			//�ݧ�����\�P
			new Thread(new Runnable()
	        {
	         public void run()
	         {
	          try{Thread.sleep(Look_Sec * 1000);
	                 }catch(InterruptedException e){}
	          			//½�^�I����
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
		//���O���Ĥ@�ӫ��s�P�Ϥ�
		int img_temp=TwoImg[0];
        int btn_temp=TwoBtn[0];
        //�x�s�ĤG�ӫ��s��T
        TwoImg[0]=img_num;
        TwoBtn[0]=Btn_num;
        //�x�s�Ĥ@�ӫ��s��T
        TwoImg[1]=img_temp;
        TwoBtn[1]=btn_temp;
        //�I���P�@�i�Ϥ��ɡA���L���I��
        if(TwoBtn[0]==TwoBtn[1])
        {
        	return;
        }
        if(isReady==true)//�P�_�O�_½��i�P
        {
        	for(int i=0;i<30;i++)//��½��i�P��A�]�w��L�P����½
        	{		
        		if(i!=TwoBtn[0]&&i!=TwoBtn[1])
        		{
        			imgBtn[i].setEnabled(false);
        		}
        	}
        	//�Ϥ��۵�
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
        		img_S[img_num]=true;//�t�令�\
        		TwoImg[0] = -1;
        		TwoImg[1] = -1;
                TwoBtn[0] = -1;
                TwoBtn[1] = -1;
                this.GameEnd();
                isReady = false;
                return;
        	}
        	 //run();
        	//½���j�@��\�P
        	new Thread(new Runnable()
            {
             public void run()
             {
            	 try{
            	      Thread.sleep(Error_Sec * 1000);
            	      }catch(InterruptedException e){}
            	     //�\��쥻½�}���Ϥ�        
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
