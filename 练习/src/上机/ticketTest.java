package 上机;

import java.util.Scanner;

/* 编写程序实现收费功能，测试函数仅需输出收费结果。
 *  a）海洋公园门票：A区100元，B区160元，套票200元。（60岁以上或12岁以下半价，80岁以上免票）
 *  b）地铁售票标准：5公里以内2元，每超过3公里加收1元； 
 *  c）停车场收费标准：晚20:00到次日早8:00收费10元；早8:00到晚20:00，30分钟以内免费，超过30分钟以1小时计算，每小时5元。
 * 提示：（i）定义一个提供计算功能的接口 
 *      （ii）定义一个方法，以上面的接口类型作为参数，方法然后实现计算并输出结果 
 */
public class ticketTest {

	static int select;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请选择要计算的票价系统:\n（1）为海洋公园门票\n（2）地铁售票\n（3）停车场收费");
		Scanner input = new Scanner(System.in);
		select = input.nextInt();
		switch(select) {
			case 1:
				seaparkTicket seapark = new seaparkTicket();
				break;
			case 2:
				subwayTicket subway = new subwayTicket();
				break;
			case 3:
				parkTicket park = new parkTicket();
				break;
			default:
				break;
		}
		input.close();
	}
}
