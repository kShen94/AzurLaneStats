package stats;

import java.util.ArrayList;
import java.util.HashMap;

public class AugmentData {

	private int skillUpgradeCount;
	private ArrayList<String> skillList;
	private String innateID;
	private HashMap<String,String> skillMapping;
	
	public AugmentData() {
		
	}
	
	
	public AugmentData(int skillUpgradeCount, ArrayList<String> skills, String innateID) {
		this.skillUpgradeCount = skillUpgradeCount;	
		this.skillList = skills;
		this.innateID = innateID;
		mapSkills();
	}
	
	private void mapSkills() {
		skillMapping = new HashMap<String,String>();
		for(int x = 0; x < skillList.size(); x+=2) {
			if(skillList.size() > x+1) {
				skillMapping.put(skillList.get(x), skillList.get(x+1));
			}
		}
	}
	
	public Boolean hasSkill(String id) {
		return skillMapping.containsKey(id);
	}
	
	public String getSkillUpgrade(String id) {
		return skillMapping.get(id);
	}
	
	public void setSkillUpgradeCount(int count) {
		skillUpgradeCount = count;
	}
	
	public void setSkills(ArrayList<String> list) {
		skillList = list;
		mapSkills();
	}
	
	public void setInnateID(String id) {
		innateID = id;
	}
	
	public int getSkillUpgradeCount() {
		return skillUpgradeCount;
	}
	
	public ArrayList<String> getSkillList(){
		return skillList;
	}
	
	public String getInnateID() {
		return innateID;
	}
	
}
