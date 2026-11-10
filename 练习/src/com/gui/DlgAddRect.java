package com.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgAddRect extends JDialog{
	//Geo o;
	JLabel[] labels = new JLabel[] {new JLabel("width: "),new JLabel("height: ")};
	JTextField[] txtFields = new JTextField[] {new JTextField(),new JTextField()};
	JButton btnOk = new JButton("OK");
	public DlgAddRect(DrawingPanel pa, Geo o) {
		super(pa,"Add Rect",true);
		Container container=getContentPane();
		container.setBackground(Color.white);
		//this.o = o;
		container.setLayout(new GridLayout(3,2));
		for(int i=0; i< labels.length; i++) {
			container.add(labels[i]);
			container.add(txtFields[i]);
		}
		container.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int w = Integer.parseInt(txtFields[0].getText());
				int h = Integer.parseInt(txtFields[1].getText());
				((Rectangle)o).setParams(w,h);
				dispose();
			}			
		});		
		//this.setLocationRelativeTo(pa);
		//setBounds(600,300,200,150);
		this.setSize(200,150);
		centreWindow(this);
		this.setVisible(true);
	}
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}


