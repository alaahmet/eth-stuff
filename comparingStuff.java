import java.util.*;
class Pair implements Comparable<Pair>{
	int a;
	int b;
	int c;
	public Pair(int a,int b,int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public int compareTo(Pair arg0) {
		return arg0.a - this.a;
		
	}
	public String toString() {
		return a+" "+b+" "+c+"\n";
	}
}
public class comparingStuff {
	public static void main(String[] args) throws Exception {
		ArrayList <Pair> al = new ArrayList<Pair>();
		for(int i=0;i<10;++i) {
			Random rand = new Random();
			int randa = rand.nextInt(10);
			int randb = rand.nextInt(10);
			int randc = rand.nextInt(10);
			Pair pair = new Pair(randa,randb,randc);
			al.add(pair);
		}
		Collections.sort(al);
		System.out.println(al);
	}
}

/*
PRINTS THIS

[8 4 0
, 8 6 3
, 6 2 7
, 6 2 5
, 5 0 4
, 4 4 7
, 4 7 2
, 2 5 7
, 1 9 4
, 0 5 1
]

*/