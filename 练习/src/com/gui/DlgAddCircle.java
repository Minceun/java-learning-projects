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

public class DlgAddCircle extends JDialog{
	//Geo o;
	JLabel labels = new JLabel("radius:");
	JTextField txtFields = new JTextField();
	JButton btnOk = new JButton("OK");
	public DlgAddCircle(DrawingPanel pa, Geo o) {
		super(pa,"Add Circle",true);
		Container container=getContentPane();
		container.setBackground(Color.white);
		//this.o = o;
		container.setLayout(new GridLayout(3,2));
		container.add(labels);
		container.add(txtFields);
		container.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = Integer.parseInt(txtFields.getText());
				((Circle)o).setParams(r);
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


