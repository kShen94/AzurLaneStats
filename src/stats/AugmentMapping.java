package stats;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AugmentMapping {

	public static HashMap<String, AugmentData> augmentMap;

	static {
		augmentMap = new HashMap<String,AugmentData>();
		InputStream is;
		try {
			is = new FileInputStream("./resources/augmentMap.txt");

			Scanner sc = new Scanner(is);

			while(sc.hasNext()) {
				String next = sc.nextLine();
				String[] split = next.split(",");
				ArrayList<String> skillList = new ArrayList<>();
				AugmentData data = new AugmentData();
				data.setInnateID(split[1]);
				for(int x = 2; x < split.length; x++) {
					skillList.add(split[x]);
				}
				data.setSkills(skillList);
				data.setSkillUpgradeCount((split.length-2)/2);
				augmentMap.put(split[0],data);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static AugmentData getAugment(String groupId) {
		AugmentData s = augmentMap.get(groupId);
		return s;
	}
}
