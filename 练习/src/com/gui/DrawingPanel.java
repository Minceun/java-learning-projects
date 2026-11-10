package com.gui;
/*
 * 目标 掌握GUI编程中的接口监听实现方法 掌握Java的异常处理方法 
 * 内容，完成下列类设计内容（二选一） 
 * 1. 设计一个GUI的绘图程序，要求实现 
 * （1）绘制：圆形、矩形、三角形、扇形 
 * （2）修改图形属性：颜色、位置、不同图形的不同属性 
 * （3）图形的参数使用图形用户界面接收输入，注意：接口实现，接收数据的类型转换等
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class DrawingPanel extends JFrame implements ActionListener{
	private Geometrics obj = new Geometrics();	//图形管理类
	private Geo currentGeo;						//当前操作图形，目前为新增的图形
	
	JButton btnCircle = new JButton("Circle");
	JButton btnRect = new JButton("Rectangle");
	JButton btnTri = new JButton("Triangle");
	JButton btnSector = new JButton("Sector");
	JButton[] btnMove = new JButton[] { new JButton("Right"),new JButton("Left"),new JButton("Up"), new JButton("Down")};
	JPanel p1 = new JPanel();
	//JPanel p2 = new MyPanel();				//定义内部类MyPanel
	JPanel p2 = new JPanel() {					//定义匿名内部类，实现与MyPanel一样，可替代MyPanel
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			obj.draw(g);
		}
	};
	/**Constructor*/
	public DrawingPanel() {
		super("DrawingPane");
		initComponents();						//初始化p1和p2组件
		this.setSize(600,400);
		this.setLocationRelativeTo(null); 		// Center the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**initialize the panels*/
	private void initComponents() {
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCircleClicked(e);
			}
		});	
		p1.add(btnCircle);

		btnRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRectClicked(e);
			}
		});	
		p1.add(btnRect);
		
		btnTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTriClicked(e);
			}
		});	
		p1.add(btnTri);
		
		btnSector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSectorClicked(e);
			}
		});	
		p1.add(btnSector);
		
		for(int i=0; i<btnMove.length; i++) {
			btnMove[i].addActionListener(this);
			p1.add(btnMove[i]);
		}
		p2.setBackground(new Color(255,255,255));
		p2.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(currentGeo != null) {
					if(e.getWheelRotation() < 0)		//==-1
						currentGeo.scale(2, 2);
					else								//==1
						currentGeo.scale(0.5, 0.5);
				}	
				p2.repaint();
			}			
		});
		p2.addMouseMotionListener(new MouseMotionAdapter() {			 
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				String string = "鼠标拖动到位置：（" + e.getX() + "，" + e.getY() + "）";
			}		 
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		p2.addMouseListener(new MouseAdapter() {
		/*	@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1) {
					System.out.println("单击!");
				} else if (e.getClickCount() == 2) {
					System.out.println("双击!!");
				} else if (e.getClickCount() == 3) {
					System.out.println("三连击!!!");
				}
		 
			}
		 */
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("鼠标按下");			
			}
		 /*
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("鼠标松开");
			}		 
			@Override
			public void mouseEntered(MouseEvent e) {

			}		 
			@Override
			public void mouseExited(MouseEvent e) {
			}*/

		});
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
	}
	protected void btnCircleClicked(ActionEvent e) {
		JOptionPane.showMessageDialog(p2, "To add a new Circle!","Information",JOptionPane.INFORMATION_MESSAGE);
		Random r = new Random();
		// Circle(int, int, Color, int)
		currentGeo = obj.add(new Circle(
					r.nextInt(400)+50, r.nextInt(200)+ 50,
					new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)), 
					r.nextInt(40)+20));
		new DlgAddCircle(this, currentGeo);//set width and height
		if(currentGeo == null) {
			JOptionPane.showMessageDialog(p2, "No space for it!","Error",JOptionPane.ERROR_MESSAGE);
		}
		p2.repaint();
	}
	protected void btnRectClicked(ActionEvent e) {
		JOptionPane.showMessageDialog(p2, "To add a new Rectangle!","Information",JOptionPane.INFORMATION_MESSAGE);
		Random r = new Random();
		//Rectangle(x, y, color, w, h)
		currentGeo = obj.add(new Rectangle(300,150,new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)), 0,0));
		new DlgAddRect(this, currentGeo);//set width and height
		if(currentGeo == null) {
			JOptionPane.showMessageDialog(p2, "No space for it!","Error",JOptionPane.ERROR_MESSAGE);
		}
		p2.repaint();
	}
	protected void btnTriClicked(ActionEvent e) {
		JOptionPane.showMessageDialog(p2, "To add a new Triangle!","Information",JOptionPane.INFORMATION_MESSAGE);
		Random r = new Random();
		//Triangle(x, y, color, w, h)
		currentGeo = obj.add(new Triangle(300,150,new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)), r.nextInt(40)+20,r.nextInt(40)+20));
		if(currentGeo == null) {
			JOptionPane.showMessageDialog(p2, "No space for it!","Error",JOptionPane.ERROR_MESSAGE);
		}
		p2.repaint();
	}
	protected void btnSectorClicked(ActionEvent e) {
		JOptionPane.showMessageDialog(p2, "To add a new Sector!","Information",JOptionPane.INFORMATION_MESSAGE);
		Random r = new Random();
		// Sector(int, int, Color, int)     //daiding
		currentGeo = obj.add(new Sector(
					r.nextInt(400)+50, r.nextInt(200)+ 50,
					new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)), 
					r.nextInt(40)+20,r.nextInt(40)+30));
		if(currentGeo == null) {
			JOptionPane.showMessageDialog(p2, "No space for it!","Error",JOptionPane.ERROR_MESSAGE);
		}
		p2.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Right":	currentGeo.toRight(5);	break; 	//currentGeo.x += 5;break;
		case "Left":	currentGeo.toLeft(5);	break; 	//currentGeo.x -= 5;break;
		case "Up":		currentGeo.toUp(5);		break; 	//currentGeo.y -= 5;break;
		case "Down":	currentGeo.toDown(5);	break; 	//currentGeo.y += 5;break;
		}
		p2.repaint();
	}
	//inner class,可使用匿名内部类替换
	class MyPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);//必须有此行，否则无法刷新
			obj.draw(g);
			/*for(Geo o: obj.geometrics) {
				if(o != null) {
					o.draw(g);
				}
			}*/
		}
	}
}
