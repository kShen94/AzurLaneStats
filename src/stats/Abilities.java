package stats;
import java.util.ArrayList;
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
	
	public Abilities(JSONArray skillList,Boolean augment, String groupId) {
		for(int i = 0; i< skillList.length();i++) {
			String skill =Integer.toString(skillList.getInt(i));
			if(augment) {
				String[] aug = AugmentMapping.getAugment(groupId);
				if(skill.equals(aug[0]))
					skills.add(aug[1]);
				else
					skills.add(skill);
			}else
				skills.add(skill);
		}
		parseSkills();
		printTree();
	}
	
	public Abilities(String skill) {
		skills.add(skill+"");
		parseSkills();
		printTree();
	}
	
	public Abilities(int id, String groupId, Boolean augment) {
		getSkillList(id+"");
		for(int i = 0; i< skillList.length();i++) {
			String skill =Integer.toString(skillList.getInt(i));
			if(augment) {
				String[] aug = AugmentMapping.getAugment(groupId);
				if(aug!=null && skill.equals(aug[0]))
					skills.add(aug[1]);
				else
					skills.add(skill);
			}else
				skills.add(skill);
		}
		parseSkills();
	}
	
	private void getSkillList(String shipId) {
		skillList = shipTemplate.getJSONObject(shipId).getJSONArray("buff_list_display");
	}
	
	public static boolean addDict(String value) {
		return skillDict.add(value);
	}
	
	public static boolean checkDict(String value) {
		return skillDict.contains(value);
	}
	
	public static void addWeapon(String id, String target) {
		if(skillDict.add("weapon_"+id))
			weaponsList.add(new Weapons(id,target));
	}
	
	public static void addSlashWeapon(SlashWeapon sw, String id) {
		if(skillDict.add(id))
			weaponsList.add(sw);
	}
	
	public static void addPlane(Planes p) {
		planesList.add(p);
	}
	
	private void parseSkills() {
		for(String s : skills) {
			tree.add(new SkillTree("buff",s));
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
