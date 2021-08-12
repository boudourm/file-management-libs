package Généréité;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuGenerator 
{
	
	//Static Methods
	public static TreeIL<ButtonActionExemple> tilbae = new TreeIL<ButtonActionExemple>();

	
	
	public static void mainFrame(String title,Map<String,ButtonAction> buttons)
	{
		JFrame f = new JFrame(title);
		f.getContentPane().setLayout(new FlowLayout());
		//Buttons
		int x=100,y=100,z=300,w=40;
		ArrayList<JButton> blist= new ArrayList<JButton>();
		for (Map.Entry<String,ButtonAction> entry : buttons.entrySet())
		 {
			JButton jbtn = new JButton(entry.getKey());
			jbtn.setBounds(x,y,z,w);
			y+=45;
			
			jbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					entry.getValue().perform(new Object ());
					
				}
			});
			blist.add(jbtn);
		}
		
		for (JButton jButton : blist) {
			f.add(jButton);
		}
		
		f.setSize(500,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static JFrame formFromClass(Class classe) throws Exception
	{
		//JFrame
		JFrame f = new JFrame("Insert "+classe.getSimpleName());
		f.getContentPane().setLayout(new FlowLayout());
		
		//Form
		int x=50,y=50,z=150,w=30;
		Object o = classe.getDeclaredConstructor(null).newInstance();
		Field[] fields = classe.getDeclaredFields();
		Map<Field,JTextField> map = new HashMap<Field,JTextField>();
		for (int i = 0; i < fields.length; i++) 
		{
			String name = fields[i].getName();
			JLabel lbl = new JLabel();
			lbl.setBounds(x,y,z,w);
			lbl.setText(name+" : ");
			JTextField txtfd = new JTextField();
			txtfd.setBounds(x+100,y,z,w);
			y+=40;
			f.add(lbl);
			f.add(txtfd);
			map.put(fields[i], txtfd);
			
		
		}
		
		//Button
		//for (Map.Entry<String,ButtonAction> entry : buttons.entrySet())
			JButton insert = new JButton("INSERER");
			 
			insert.setBounds(300,400,z,w);

			insert.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (Map.Entry<Field,JTextField> entry : map.entrySet())
					{
						entry.getKey().setAccessible(true);
						try {
							entry.getKey().set(o, entry.getValue().getText());
						} catch (Exception e) {
							(new ExceptionHandler(LocalDateTime.now(),MenuGenerator.class,(new Object() {}).getClass().getEnclosingMethod(),e)).logException();

						} 
					}
					tilbae.insert(o);
					System.out.println(o);
					tilbae.display();
				}
			});
			f.add(insert);
		
		
		f.setSize(600,600);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return f;
	}
	
	public static JFrame findOption(TreeIL til)
	{
		//JFrame
				JFrame f = new JFrame("Find Element ");
				f.getContentPane().setLayout(new FlowLayout());
		
				
				f.setSize(600,600);
				f.setLayout(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				return f;
	}
}
