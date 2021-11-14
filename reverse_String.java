
public class reverse_String {
	public static String reverse(String s) {
		if(s.equals("")) {
			return s;
		}
		else {
			return reverse(s.substring(1,s.length())+s.substring(0,1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
