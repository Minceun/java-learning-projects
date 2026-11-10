package test;

public class Tester {
	public static void main(String[] args) {
		MyTicket.print();
	
		Film film = new Film();

        System.out.println(film.sortBySid());
	}
}