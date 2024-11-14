package stats;
import java.util.LinkedList;
import org.json.JSONObject;

public class Planes{
	String planeID;
	LinkedList<String> weaponIDs;
	int planeCount;
	JSONObject weaponStats = JsonData.weaponStats;
	JSONObject planeStats = JsonData.planeStats;;
	JSONObject barrageStats = JsonData.barrageStats;;
	String dir = System.getProperty("user.dir");
	LinkedList<String> AAGuns = new LinkedList<String>();
	LinkedList<Weapons> weaponList = new LinkedList<Weapons>();
	
	public Planes(String planeID,LinkedList<String> id, int planes) {
		this.planeID = planeID;
		weaponIDs = id;
		planeCount = planes;
		getWeapons();
		
	}
	
	private void getWeapons(){
		for(String w: weaponIDs) {
			if(isAAGun(w)) {
				continue;
			}else
			weaponList.add(new Weapons(w,true));
		}
	}
	
	private boolean isAAGun(String id) {
		JSONObject base = weaponStats.getJSONObject(weaponStats.getJSONObject(id).optInt("base",Integer.parseInt(id))+"");
		int type =  base.getInt("type");
		if(type == 4) {
			if(base.has("name"))
				AAGuns.add(base.getString("name"));
			else
				AAGuns.add("No Name");
			
				return true;
		}
		else
			return false;
	}
	
	public void printWeapons(boolean printExcel){
		System.out.println("----------------------------------------------------");
		System.out.print("AA guns: ");
		if(AAGuns.isEmpty()) {
			System.out.println("None");
		}else {
			for(String AA: AAGuns) {
				System.out.print(AA + ", ");
			}
			System.out.println("");
		}
		System.out.println("Total Planes: " + planeCount);
		for(Weapons w: weaponList) {
			w.printWeaponBulletMultiplier(planeCount, planeID, printExcel);
		}

	}
}
