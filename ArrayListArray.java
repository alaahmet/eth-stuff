import java.util.*;
 
class ArrayListArray
{	
	public static ArrayList<Integer> v[];
	public static void main (String[] args)
	{	
		int n = 5;
		v = new ArrayList[n];
		for(int i=0;i<n;++i){
			v[i] = new ArrayList<>();
		}
		for(int i=0;i<n;++i){
			v[i].add(i);
			v[i].add(i+1);
		}
		for(int i=0;i<n;++i){
			System.out.println(i+": "+v[i]);
		}
	}
}

/*

OUTPUT

0: [0, 1]
1: [1, 2]
2: [2, 3]
3: [3, 4]
4: [4, 5]

*/