import java.util.*;

public class CollectionsTest{
	
	public static void main(String[] args){

		Map<String, Integer> m = Collections.synchronizedMap(new TreeMap<String, Integer>());
		m.put("a",1);
		m.put("b",2);
		
		System.out.println("m: "+m);

		Map t = new Hashtable(m);
		t.put("a",1);
		t.put("a",3);
	
		System.out.println("t: "+t);

		m.clear();

		List<String> list = new ArrayList<String>();

		for(String arg : args){
			m.put(arg, m.get(arg) == null ? 1 : m.get(arg)+1);
			list.add(arg);
		}

		System.out.println("List: "+list);

		String con="";
		for(String k : m.keySet()){
			con = con + k;
		}

		System.out.println(con);

		System.out.println("before: "+m);
		for(Iterator<String> it = m.keySet().iterator(); it.hasNext();){
			if(it.next().equals("bogus"))
				it.remove();
		}


		System.out.println("after:" +m);
		System.out.println(m.size()+" distinct words");
	}


}