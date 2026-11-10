package 上机;
import java.util.Scanner;
//海洋公园门票：A区100元，B区160元，套票200元。（60岁以上或12岁以下半价，80岁以上免票）
public class seaparkTicket implements Computeable{
	final int ABC[]= {100,160,200} ;
	static int i;
	int age;
	public seaparkTicket() {
		Scanner input = new Scanner(System.in);
		System.out.println("请选择您要购买的票种，A区按1（100元），B区按2（160元），套票按3（200元）：");
		i = input.nextInt();
		System.out.println("请输入您的年龄：");
		age = input.nextInt();
		System.out.println("最后您应缴的票价为："+ticket());
		input.close();
	}
	public int ticket() {
		if(age > 60 || age < 12)
			return ABC[i-1]/2;
		else if(age > 80)
			return 0;
		else
			return ABC[i-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		seaparkTicket sea = new seaparkTicket();

	}
}
