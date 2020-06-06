import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.push(5);
		list.push(9);
		list.push(11);
		Iterator<Integer> it = list.iterator();

		
		System.out.println(it.next());
		
	}

}
