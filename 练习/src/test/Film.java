package test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Film {

	HashSet<MyTicket> film = new HashSet<MyTicket>();
	
	public Film() {
		MyTicket ticket1 = new MyTicket("001","20191212","a1");
		MyTicket ticket2 = new MyTicket("002","20191212","a2");
		MyTicket ticket3 = new MyTicket("003","20191212","a3");
		MyTicket ticket4 = new MyTicket("004","20191212","a4");
		MyTicket ticket5 = new MyTicket("005","20191212","a5");
		film.add(ticket1);
		film.add(ticket2);
		film.add(ticket4);
		film.add(ticket5);
		film.add(ticket3);
	}
	@Override
    public String toString() {
        return "Film{" +
                "MyTickets=" + film +
                '}';
    }
	
	public HashSet<MyTicket> getMyTickets() {
        return film;
    }
	
	public void setMyTickets(HashSet<MyTicket> film) {
        this.film = film;
    }
	
	public void sort() {
		
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return film.equals(film.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film);
    }

    //sort function
    public ArrayList<MyTicket> sortBySid(){
        ArrayList<MyTicket> temp = new ArrayList<MyTicket>(this.film);

        Collections.sort(temp, new Comparator<MyTicket>() {
            @Override
            public int compare(MyTicket o1, MyTicket o2) {
                if(Integer.parseInt(o1.getsid()) > Integer.parseInt(o2.getsid()))
                    return 1;
                else if (Integer.parseInt(o1.getsid()) < Integer.parseInt(o2.getsid()))
                    return -1;
                return 0;
            }
        });

        return temp;
    }
}
