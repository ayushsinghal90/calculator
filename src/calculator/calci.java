package calculator;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class calci extends Applet implements ActionListener{

	TextField oc;
    String c= "1234567890c+-*/=";
    String msg="0";
    String f = "0";
    String res = "";
    Button  b;
	public void init()
	{
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setSize(400,500);
		setLayout(gb);
		oc = new TextField(20);
	
        gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx=50;
		gbc.ipady=20;
		for(int i = 0; i < 4; i++) {
             
			for(int j = 0; j < 4; j++) {
				gbc.gridx=0+j;
				gbc.gridy=i+1;
				
				int k = i * 4 + j;
			
				b=new Button(""+ c.charAt(k));
			gb.setConstraints(b, gbc);
			add(b);
			b.addActionListener(this);
			}
			}
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=4;
		gb.setConstraints(oc, gbc);
		add(oc);
		oc.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String str =e.getActionCommand();
		evaluate(str);
	
	}
	public void evaluate(String str)
	{
		String d ="1234567890";
		String j ="+-*/";
		if(d.indexOf(str)!=-1) {
			msg += str;
			res +=str;
			oc.setText(msg);
			}
			else if(j.indexOf(str)!=-1) {
				int u = msg.length();
				if(j.indexOf(msg.charAt(u-1))==-1)
				{	
					if(j.indexOf(f)!=-1)
				    {
					  subeval();
				    }
					msg += str;
					res +=str;
				    f=str;
				}
				else
				{
					msg=msg.replace(msg.charAt(u-1),str.charAt(0));
					f=str;
					res =msg;
					System.out.println(msg);
				}
				oc.setText(msg);
				}
		    
			else if(str.equals("c")) {
				msg = "0";
				res = "";
				f="0";
				oc.setText(msg);
				}
			else if(str.equals("=")) {
				 subeval();
				 oc.setText(res);
				 msg=res;
				 f="0";
	}
	}
		public void subeval()
		{
			String t="";
			 t=res.substring(0,res.indexOf(f));
			 int g = Integer.parseInt(t);
			 t=res.substring((res.indexOf(f)+1),res.length());
			 int h = Integer.parseInt(t);
			 System.out.println(f);
			 if(f.equals("+")) {
				 res=Integer.toString(g+h);
			    }
			 else if(f.equals("-")) {
				 res=Integer.toString(g-h);
			     }
			 else if(f.equals("*")) {
				 res=Integer.toString(g*h);
			     }
			 else if(f.equals("/")) {
			     res=Integer.toString(g/h);
			     }
			}
}
