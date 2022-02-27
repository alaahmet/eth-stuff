
//https://lightoj.com/problem/critical-links
//results in run-time-error, dunno why
import java.util.*;
class Pair implements Comparable<Pair>{
	int x;
	int y;
	public Pair(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int compareTo(Pair arg0) {
		if(this.x == arg0.x)
			return this.y - arg0.y;
		return this.x - arg0.x;
	}
}
public class Bridge_ArticulationPoint {
	public static ArrayList <Integer> v[];
	public static int n,counter;
	public static StringBuilder sb = new StringBuilder();
	public static boolean [] visited;
	public static int [] dfs;
	public static int [] low;
	public static ArrayList<Pair> bridges;
	public static void dfs(int x,int parent) {
		visited[x] = true;
		low[x] = dfs[x] = counter;
		counter++;
		boolean is_articulationPoint = false;
		int children = 0;
		for(int y:v[x]) {
			if(parent == y)
				continue;
			if(visited[y])
				low[x] = Math.min(low[x],dfs[y]);
			else{
				dfs(y,x);
				low[x] = Math.min(low[x], low[y]);
				if(low[y]>dfs[x]) { // edge e = (x,y) is a bridge
					Pair bridge = new Pair(x,y);
					if(x>y)
						bridge = new Pair(y,x);
					bridges.add(bridge);
				}
				/*
				if(low[y]>=dfs[x] && parent!=-1)
					is_articulationPoint = true; // can be called multiple times for a vertex
				*/
				children++;
			}
		}
		if(parent == -1 && children>1)
			is_articulationPoint = true;
		
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int cs=1;cs<=t;cs++) {
			n = sc.nextInt();
			counter = 1;
			v = new ArrayList[n];
			bridges = new ArrayList<Pair>();
			visited = new boolean[n];
			dfs = new int[n];
			low = new int[n];
			for(int i=0;i<n;++i) {
				v[i] = new ArrayList<>();
				visited[i] = false;
				dfs[i] = low[i] = 0;
			}
			for(int i=0;i<n;++i) {
				int x = sc.nextInt();
				String c = sc.next();
				String cc = c.substring(1,c.length()-1);
				int degree = Integer.parseInt(cc);
				for(int j=0;j<degree;++j) {
					int y = sc.nextInt();
					if(x<y) {
						v[x].add(y);
						v[y].add(x);
					}
				}
			}
			for(int i=0;i<n;++i) {
				if(visited[i]==false) {
					dfs(i,-1);
				}
			}
			Collections.sort(bridges);
			sb.append("Case "+cs+":\n");
			sb.append(bridges.size()+" critical links\n");
			for(int i=0;i<bridges.size();i++) {
				Pair bridge = bridges.get(i);
				if(cs == t && i==bridges.size()-1)
					sb.append(bridge.x+" - "+bridge.y);
				else
				sb.append(bridge.x+" - "+bridge.y+"\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
/*
3

8
0 (1) 1
1 (3) 2 0 3
2 (2) 1 3
3 (3) 1 2 4
4 (1) 3
7 (1) 6
6 (1) 7
5 (0)

0

2
0 (1) 1
1 (1) 0
*/