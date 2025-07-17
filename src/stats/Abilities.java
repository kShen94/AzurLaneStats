package stats;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class Abilities {
	JSONObject shipTemplate = JsonData.shipTemplate;
	JSONArray skillList;
	ArrayList<String> skills = new ArrayList<String>();
	static HashSet<String> skillDict = new HashSet<String>();
	static ArrayList<Weapons> weaponsList = new ArrayList<Weapons>();
	static ArrayList<Planes> planesList = new ArrayList<Planes>();
	ArrayList<SkillTree> tree = new ArrayList<SkillTree>();
	HashSet<Integer> HIDDENID_SKIP = new HashSet<Integer>(Arrays.asList(1,2,340));
	
	public Abilities(String skill) {
		skills.add(skill);
		parseSkills();
		printTree();
	}
	
	//Get skills and augment enhances
	public Abilities(int id, String groupID, Boolean augment) {
		getSkillList(id+"");
		if(augment)
			addAugment(groupID);
		else {
			addSkillsToList();
		}
		parseSkills();
	}
	
	private void addSkillsToList() {
		for(int i = 0; i< skillList.length();i++) {
			skills.add(Integer.toString(skillList.getInt(i)));
		}
	}
	
	private void addAugment(String groupID) {
		AugmentData aug = AugmentMapping.getAugment(groupID);
		if(aug!=null) {
			for(int i = 0; i< skillList.length();i++) {
				String skill = Integer.toString(skillList.getInt(i));
				String augID = aug.getSkillUpgrade(skill);
				if(augID != null)
					skills.add(augID);
				else
					skills.add(skill);
			}
			skills.add(aug.getInnateID());
		}
		else {
			addSkillsToList();
		}
	}
	
	private void getSkillList(String shipId) {
		JSONObject ship = shipTemplate.getJSONObject(shipId);
		skillList = ship.getJSONArray("buff_list_display");
		JSONArray hidden = ship.getJSONArray("hide_buff_list");
		for(int x = 0; x < hidden.length(); x++) {
			int s = hidden.getInt(x);
			if(!HIDDENID_SKIP.contains(s)) {
				skillList.put(s);
			}
		}
	}
	
	//add to set of skillIDs
	public static boolean addDict(String value) {
		return skillDict.add(value);
	}
	
	public static boolean checkDict(String value) {
		return skillDict.contains(value);
	}
	
	public static void addWeapon(String id, String target) {
		skillDict.add("weapon_"+id);
		weaponsList.add(new Weapons(id,target));
	}
	
	public static void addPointAirstrikeWeapon(String id, String target, String aircraftID) {
		if(skillDict.add("weapon_"+id))
			weaponsList.add(new Weapons(id,target,true,aircraftID));
	}
	
	public static void addSlashWeapon(SlashWeapon sw, String id) {
		if(skillDict.add(id))
			weaponsList.add(sw);
	}
	
	public static void addPlane(Planes p) {
		planesList.add(p);
	}
	
	private void parseSkills() {
		String type = "buff";
		String tag = "";
		for(String s : skills) {
			tree.add(new SkillTree(type,s,tag));
		}
	}
	
	private void parseSkills(String tag) {
		String type = "buff";
		for(String s : skills) {
			tree.add(new SkillTree(type,s,tag));
		}
	}
	
	public void printTree() {
		System.out.println("----------------------------");
		int n = 1;
		for(SkillTree st : tree) {
			System.out.println("Skill "+n);
			System.out.println(st.toString());
			n++;
		}
	}

}
