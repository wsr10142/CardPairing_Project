package myfinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class final_top { 
	  public static void main(String[] args) { 
			GameFrame GF = new GameFrame();
			GF.setGameFrame();
			GF.setParentP();
			GF.goToSS();
			GF.setTouchFlag();
			//-----------------------------------------
			GF.ShowTalks();//new add
	    	while(true)
	    	{
	    		if(GF.judgeStartB())
	    		{
	    			GF.callStart();
	    			GF.goToGS();
	    			GF.setTouchFlag();
	    			
	    		}
	    		if(GF.judgeOver())
	    		{
	    			GF.callEnd();
	    			GF.goToES();
	    			while(true)
	    			{
	    				if(GF.judgeEndB())
	    				{
	    					GF.goToSS();
	    					if(GF.judgeStartB())
	    					{
	    						break;
	    					}
	    				}
	    			}
	    		}	
	    	}
	  }
}

