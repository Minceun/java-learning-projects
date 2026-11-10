package test;

import java.util.Objects;

public class MyTicket {
	
	String sid;
	String date;
	String seatNo;
	
	static String name = "薄晓丽";
	static String num = "170405326";
	
	static public void print() {
		System.out.println("姓名为："+name+"，学号为："+num);
	}
	
	public MyTicket(String sid,String date,String seatNo) {
		this.sid = sid;
		this.date = date;
		this.seatNo = seatNo;
	}
	
	public String getsid() {
		return this.sid;
	}
	public String getdate() {
		return this.date;
	}
	public String seatNo() {
		return this.seatNo;
	}
	@Override
    public String toString() {
        return "MyTicket{" +
                "sid='" + sid + '\'' +
                ", date='" + date + '\'' +
                ", seatNo='" + seatNo +" "
                +'}'+"\n";
    }


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTicket  ticket= (MyTicket) o;
        return sid.equals(ticket.sid) &&
                date.equals(ticket.date) &&
                seatNo.equals(ticket.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,date,seatNo);
    }
}
