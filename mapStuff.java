import java.util.*;

public class mapStuff {
	public static void main(String[] args) throws Exception {
		Map <Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int i=0;i<10;++i) {
			Random rand = new Random();
			int ax = rand.nextInt(12);
			int bx = rand.nextInt(124);
			map.put(ax,bx);
		}
		for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}

/*
PRINTS THIS

0 0
2 77
3 74
4 52
5 66
6 73
7 113
9 61
10 27

*/