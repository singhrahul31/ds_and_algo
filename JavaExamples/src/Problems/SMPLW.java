package Problems;

public class SMPLW {
	
	public static void main(String[] args) {
		String s = "fdfsnkm\n\rdasdl\rksm";
		String[] sa = s.split("[\n\r]");
		for(String a: sa) {
			if(a.length() > 0)
			System.out.println(a + " " + a.length());
		}
		System.out.println(sa.length);
	}
}
