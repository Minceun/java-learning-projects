package 上机;

import java.util.Scanner;

//停车场收费标准：晚20:00到次日早8:00收费10元；
//早8:00到晚20:00，30分钟以内免费，超过30分钟以1小时计算，每小时5元。 
public class parkTicket implements Computeable{
	int isNight;
	int parkTime;
	public parkTicket() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您是否为夜间停车，是为1否为0（晚20:00到次日早8:00）：");
		isNight = input.nextInt();
		if(isNight==1) {
			System.out.println("最后您应付的停车费为:10元");
		}
		else {
			System.out.println("最后您应付的停车费为："+ticket());
		}
		input.close();
	}
	public int ticket() {
		System.out.println("请输入您的停车小时（不足30分钟向下取整，超过30分钟向上取整）：");
		Scanner input = new Scanner(System.in);
		parkTime = input.nextInt();
		if(parkTime<=0.5 && parkTime >0) {
			return 0;
		}
		else {
			return parkTime*5;
		}
	}
}
