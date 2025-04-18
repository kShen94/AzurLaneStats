package stats;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class SkillTree {
	private ArrayList<SkillTree> nodes = new ArrayList<SkillTree>();
	private String type;
	private String id;
	
	public SkillTree(String type,String id) {
		this.id = id;
		this.type = type;
		parse();
	}
	
	public ArrayList<SkillTree> getNodes(){
		return nodes;
	}
	
	public String getType() {
		return type;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFullName() {
		return type+"_"+id;
	}
	
	private void parse() {
		if(type.equals("buff"))
			parseBuff();
		else if(type.equals("skill"))
			parseSkill();
	}
	
	private void parseSkill() {
		JSONArray b;
		JSONObject obj = JsonData.skillCfg.getJSONObject("skill_"+id);
		//navigates through json to find effect_list of the object
		if (obj.has("10") && (obj.get("10") instanceof JSONObject) ) {
			b = obj.getJSONObject("10").getJSONArray("effect_list");
		}
		else if(obj.has("2") && (obj.get("2") instanceof JSONObject)){
			b = obj.getJSONObject("2").getJSONArray("effect_list");
		}
		else if(obj.has("1") && (obj.get("1") instanceof JSONObject)){
			b = obj.getJSONObject("1").getJSONArray("effect_list");
		}
		else if(obj.has("effect_list") && !obj.getJSONArray("effect_list").isEmpty()) {
			b = obj.getJSONArray("effect_list");
		}else
			return;
		for(int i = 0; i < b.length(); i++) {
			JSONObject effect = b.getJSONObject(i);
			if(effect.has("type") && effect.getString("type").equals("BattleSkillCLSArea")) {
				effect = effect.getJSONObject("arg_list");
				addSlashWeapon(new SlashWeapon(id+"",
						effect.getInt("damage_param_a") , 
						effect.getInt("damage_param_b"), 
						effect.getDouble("life_time"), 
						effect.getInt("move_type"), 
						effect.getInt("range"), 
						effect.getInt("speed_x"))
						,id);
			}
			else if(effect.has("arg_list") && effect.get("arg_list") instanceof JSONObject) {
				effect = effect.getJSONObject("arg_list");
				//if skillID is found, add new skillID -> skillID to map
				if(effect.has("skill_id")) {
					addSkill(Integer.toString(effect.getInt("skill_id")));
				}
				//if skillID is found, add new skillID -> buffID to map
				else if(effect.has("buff_id")) {
					addBuff(Integer.toString(effect.getInt("buff_id")));
				//if skillID is found, add new skillID -> weaponID to map
				}else if(effect.has("weapon_id")) {
					String target = b.getJSONObject(i).optString("target_choise", "TargetNil");
					addWeapon(Integer.toString(effect.getInt("weapon_id")),target);
				}
				else if(effect.has("skill_id_list")) {
					JSONArray list = effect.getJSONArray("skill_id_list");
					for(int l = 0; l < list.length(); l++) {
						addSkill(Integer.toString(list.getInt(l)));
					}
				}
			}
		}
	}
	
	private void parseBuff() {
		JSONArray b;
		JSONObject obj = JsonData.buffCfg.getJSONObject("buff_"+id);
		//navigates through json to find effect_list of the object
		if (obj.has("10") && (obj.get("10") instanceof JSONObject) && obj.getJSONObject("10").has("effect_list")) {
			b = obj.getJSONObject("10").getJSONArray("effect_list");
		}
		else if(obj.has("effect_list") && obj.get("effect_list") instanceof JSONArray && !obj.getJSONArray("effect_list").isEmpty() 
				&& !(obj.getJSONArray("effect_list").get(0) instanceof JSONArray)) {
			b = obj.getJSONArray("effect_list");
		}else if(obj.getJSONArray("effect_list").isEmpty())
			return;
		else if(obj.has("2") && (obj.get("2") instanceof JSONObject)){
			b = obj.getJSONObject("2").getJSONArray("effect_list");
		}
		else{
			return;
		}
		for(int i = 0; i < b.length(); i++) {
			JSONObject effect = b.getJSONObject(i);
			if(effect.has("arg_list") && effect.get("arg_list") instanceof JSONObject) {
				effect = effect.getJSONObject("arg_list");
				//if skill does not exist, add to tree
				if(effect.has("skill_id")) 
					addSkill(Integer.toString(effect.getInt("skill_id")));
				//if buff does not exist, add to tree
				else if(effect.has("buff_id")) 
					addBuff(Integer.toString(effect.getInt("buff_id")));
				//if weaponID is found, add current buffID -> weaponID to map
				else if(effect.has("weapon_id")) {
					String target = b.getJSONObject(i).optString("target_choise", "TargetNil");
					addWeapon(Integer.toString(effect.getInt("weapon_id")),target);
				}
				else if(effect.has("skill_id_list")) {
					JSONArray list = effect.getJSONArray("skill_id_list");
					for(int l = 0; l < list.length(); l++) {
						addSkill(Integer.toString(list.getInt(l)));
					}
				}
			}
		}
	}
	
	private void addSkill(String id) {
		if(Abilities.addDict("skill_"+id))
			nodes.add(new SkillTree("skill",id));
	}
	
	private void addBuff(String id) {
		if(Abilities.addDict("buff_"+id))
			nodes.add(new SkillTree("buff",id));
	}
	private void addWeapon(String id, String target) {
		Abilities.addWeapon(id, target);
		nodes.add(new SkillTree("weapon",id));
	}
	
	private void addSlashWeapon(SlashWeapon sw,String id) {
		Abilities.addSlashWeapon(sw, id);
	}
	
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }
	
	private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
		buffer.append(prefix);
		buffer.append(getFullName());
		buffer.append('\n');
		for (Iterator<SkillTree> it = nodes.iterator(); it.hasNext();) {
			SkillTree next = it.next();
			if (it.hasNext()) {
				next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
			} else {
				next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
			}
		}
	}
}
