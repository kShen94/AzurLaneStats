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
	
	public Abilities(JSONArray skillList) {
		for(int i = 0; i< skillList.length();i++) {
			skills.add( Integer.toString(skillList.getInt(i)));
		}
		parseSkills();
		printTree();
	}
	
	public Abilities(String skill) {
		skills.add(skill+"");
		parseSkills();
		printTree();
	}
	
	public Abilities(int id) {
		getSkillList(id+"");
		for(int i = 0; i< skillList.length();i++) {
			skills.add( Integer.toString(skillList.getInt(i)));
		}
		parseSkills();
		printTree();
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
	
	public static void addPlane(Planes p) {
		planesList.add(p);
	}
	
	private void parseSkills() {
		for(String s : skills) {
			tree.add(new SkillTree("buff",s));
		}
	}
	
	private void printTree() {
		System.out.println("----------------------------");
		int n = 1;
		for(SkillTree st : tree) {
			System.out.println("Skill "+n);
			System.out.println(st.toString());
			n++;
		}
	}

}
