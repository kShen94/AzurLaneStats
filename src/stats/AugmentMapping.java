package stats;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class AugmentMapping {

	public static HashMap<String,String[]> augmentMap;

	static {
		augmentMap = new HashMap<String,String[]>();
		InputStream is;
		try {
			is = new FileInputStream("./resources/augmentMap.txt");

			Scanner sc = new Scanner(is);

			while(sc.hasNext()) {
				String next = sc.nextLine();
				String[] split = next.split(",");
				augmentMap.put(split[0],new String[]{split[1],split[2]});
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String[] getAugment(String groupId) {
		return augmentMap.get(groupId);
	}
}
