import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Weapons implements Interface {
	private HashMap<String,Integer> hash;
	public void getdata() throws FileNotFoundException {
		Scanner input= new Scanner(new File("Weapons.txt"));
		while(input.hasNext()) {
			hash.put(input.next(),Integer.parseInt(input.next()));
		}
	}
	public Weapons() throws FileNotFoundException {
		hash=new HashMap<String,Integer>();
		getdata();
		}
	public int getweapon(String weapon) throws Exception {
		if (!hash.containsKey(weapon))
			throw new Exception();
		//returns stat of the relevant weapon
		int stat=hash.get(weapon);
		return stat;
	}
}

