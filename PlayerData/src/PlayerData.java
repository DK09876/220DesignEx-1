import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class PlayerData implements Interface {
	 
	private HashMap<String,int[]> hash;
	 
	
	 public void getdata() throws FileNotFoundException {
		 String username="";
		 int[] stats= new int[3];
		 File newFile = new File("Players.txt");
		 Scanner input= new Scanner(newFile);
			while(input.hasNext()) {			
				username = input.next();
				for (int i=0;i<3;i++) {
					stats[i]=Integer.parseInt(input.next());
				}
				hash.put(username,stats);
			}	
		input.close();	
	 }
	
	 public PlayerData() throws FileNotFoundException {
		 hash = new HashMap <String, int[]>();
		 //hash has all of the existing players
		 getdata();
	 }
	 
	 public void addPlayer(String username) throws Exception {
		 //takes username of new user and adds it to the map with new stats starting from 1
		 //ignores if hash already has the username
		 if (!hash.containsKey(username)) {
		 int[] stats_i=new int[3];
		 for (int i=0;i<3;i++) {
			 stats_i[i]=1;
		 }
		 hash.put(username, stats_i);
		 updatedata();
		 }
	 }
	 
	 public void updatedata() throws Exception {
		 //stuff to write to text file
		 FileWriter writer= new FileWriter("Players.txt",false);
		 PrintWriter pwriter=new PrintWriter(writer);
		 //foreach key value pair traversal for hashmap
		 hash.forEach((k,v)->{
			 pwriter.println(k);
			 int[] arr=v;
			 for(int i=0;i<3;i++)
				 pwriter.println(arr[i]);
		 }
		 );
		 pwriter.close();
	 }
	 
	 public void levelup(String username,int stat) throws Exception {
		 //if stat value not within 1-3 then throw exception
		 hash.forEach((k,v)->{
			 System.out.print(k);
			 for(int j=0;j<v.length;j++)
			 System.out.print(v[j]);
		 }
				 );
		 if (!hash.containsKey(username))   
			 throw new Exception();
		 if (stat>3 || stat<1)
			 throw new Exception();
		 int i = stat - 1;
//		 hash.forEach((k,v)->{
//			 System.out.print(k);
//			 for(int j=0;j<v.length;j++)
//			 System.out.print(v[j]);
//		 }
		//		 );
		 
		// System.out.println(username);
		 int[] stats= hash.get(username);
		 System.out.println(stats.length);
		 
		 stats[i] += 1;
		
	
	 
//	 	for (int k = 0; k < stats.length; k++) {
//	 		System.out.println(stats[k]);
//	 	}
//	 
		 hash.put(username,stats);	
		 
		 hash.forEach((k,v)->{
			 System.out.print(k);
			 for(int j=0;j<v.length;j++)
				 System.out.print(v[j]);
		 }
		);
		
		 updatedata();
	 }
	 
}
