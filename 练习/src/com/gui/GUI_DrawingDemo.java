package com.gui;
/**
 * JButton: Circle, Right, Left, Up, Down
 * Circle is to add a new circle to the 'geometrics' declared in Geometircs class.
 * Right is to make the 'currentGeo' to move 5 units to the right.
 * ......
 * There're six classes of the program.
 * 'GUI_DrawingDemo' class is the main class.
 * 'Geo' and 'Circle' classes are the parent class and child class to describe shapes.
 * 'Geometrics' class is to manage all shapes (adding a new one, drawing all, etc.)
 * 'DrawingPanel' class is a JFrame which can be used to display buttons and graphics.
 * There is an inner class which is defined inside DrawingPanel class 
 * and derived from JPanel to display graphics.
 * 'btnCircle' button is listened by an anonymous inner class.
 * 'btnRight'..... are listened by DrawingPane class.
*/
/*内容 

 * （1）编写程序，随机创建至少10个图形对象（圆形、矩形、三角形、扇形等），图形由ArrayList管理（或使用第4次上机的图形管理类） 
 * （2）根据图形的类型进行分类，分类结果写入HashMap>，如map.put("Circle", new ArrayList()) 
 * （3）对每一种分类中的图形按照面积进行排序 
 * （4）所有图形信息写入文件保存，并可以再次读取并显示所有图形信息，或直接在第4次上机中的绘图程序中显示
 */
public class GUI_DrawingDemo {
	public static void main(String[] args) {
		new DrawingPanel();
	}
}