package Utility;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.json.JSONObject;
import org.json.JSONTokener;

public class UpdateAugmentList {


	public static void updateAugmentList() {

		try {

			JSONObject augmentData = new JSONObject(new JSONTokener(new FileInputStream("./resources/spweapon_data_statistics.json")));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./resources/augmentMap.txt"), StandardCharsets.UTF_8));

			List<String> auglist = new ArrayList<>();
			//Bulin augment
			auglist.add("10002,902190,9036,9037");
			JSONObject aug;
			for (int x = 10000; x < 200000; x += 10) {
				String key = String.valueOf(x);
				if (augmentData.has(key)) {
					aug = augmentData.getJSONObject(key);
					String entry;
					if (aug.getJSONArray("skill_upgrade").length() > 0 && aug.getJSONArray("skill_upgrade").getJSONArray(0).getInt(0) !=0) {
						JSONObject baseAug = augmentData.getJSONObject(String.valueOf(x - 10));
						entry = baseAug.getInt("unique") + ","+baseAug.getInt("effect_id");
						for(int y =0; y <aug.getJSONArray("skill_upgrade").length(); y++ ){
							entry = entry + "," +
									aug.getJSONArray("skill_upgrade").getJSONArray(y).getInt(0) + "," +
									aug.getJSONArray("skill_upgrade").getJSONArray(y).getInt(1);
						}
						auglist.add(entry);
					}
				}
			}

			auglist = new ArrayList<>(new TreeSet<>(auglist));

			for (String line : auglist) {
				output.write(line);
				output.newLine();
			}
			
			output.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	private static String augmentEntry(String uniqueID, ArrayList<Integer> skillID, ArrayList<Integer> upgradeID, Integer innateID) throws Exception {
		if(skillID.size() != upgradeID.size())
			throw new Exception("Mismatching augment size: skillID-"+skillID.size()+",UpgradeID-"+upgradeID.size());
		String entry = uniqueID+","+innateID;
		for(int x = 0; x < skillID.size(); x++) {
			entry= entry+","+skillID.get(x)+","+upgradeID.get(x);
		}
		return entry;
	}
}
