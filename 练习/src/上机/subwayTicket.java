package 上机;

import java.util.Scanner;

//地铁售票标准：5公里以内2元，每超过3公里加收1元;
public class subwayTicket implements Computeable{
	int distence;
	public subwayTicket() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您乘坐的地铁的总里程（不足一公里按一公里计算）：");
		distence = input.nextInt();
		System.out.println("最后您应付的地铁票价为："+ticket());
		input.close();
	}
	public int ticket() {
		if(distence <= 5 && distence > 0)
			return 2;
		else
			return 2+(distence-5)/3;
	}
}
