package stats;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weapons {
	String weapon_id;
	JSONObject weapon;
	List<Integer> bullet_id = new LinkedList<>();
	List<Integer> barrage_id = new LinkedList<>();
	List<Integer> bulletCount = new LinkedList<>();
	JSONObject weaponStats = JsonData.weaponStats;
	JSONObject planeStats = JsonData.planeStats;
	JSONObject barrageStats = JsonData.barrageStats;
	JSONObject bulletStats = JsonData.bulletStats;
	JSONArray barrageArray;
	JSONArray bulletArray;
	String dir = System.getProperty("user.dir");
	int damage;
	double coeff;
	int attr;
	double attrRatio;
	String scaling;
	JSONObject baseWeapon;
	HashMap<Integer,Bullets> map = new HashMap<Integer, Bullets>();
	Stack<Integer> mapValues = new Stack<Integer>();
	int planeCount;
	Boolean plane = false;
	String target = "";
	List<Planes> pList = new ArrayList<Planes>();


	public Weapons(String id) {
		weapon_id = id;
		checkWeapon();
	}
	
	public Weapons() {
		
	}
	
	
	public Weapons(String id,String target) {
		this.target = target;
		weapon_id = id;
		correctTarget();
		checkWeapon();
	}
	
	public Weapons(String id,String target, boolean plane) {
		this.target = target;
		weapon_id = id;
		correctTarget();
		checkWeapon();
	}

	public Weapons(String id, Boolean plane) {
		weapon_id = id;
		this.plane = plane;
		checkWeapon();
	}

	private void correctTarget() {
		if(target.equals("TargetNil"))
			target = "";
		else if(target.equals("TargetHarmRandomByWeight"))
			target = "Priority target";
		else if(target.equals("TargetHarmRandom"))
			target = "Random target";
		else if(target.equals("TargetHarmNearest"))
			target = "Nearest target";
		else if(target.equals("TargetHarmFarthest"))
			target = "Farthest target";
		else if(target.equals("TargetSameToLastEffect"))
			target = "Same target";
	}
	//TargetHarmNearest
	/**
	 * sets weaponid and baseweapon id if applicable
	 */
	protected void checkWeapon() {
		weapon = weaponStats.getJSONObject(weapon_id);
		if(weapon.has("base"))
			baseWeapon = weaponStats.getJSONObject(weapon.getInt("base")+"");
		else
			baseWeapon = weapon;
		//type 10 and 11
		if(baseWeapon.getInt("type")== 10 || baseWeapon.getInt("type")== 11 ) {
			getPlane(weapon_id);
		}else {
			getGun();

		}
	}

	private void getPlane(String id) {
		//TODO
		JSONArray planeBarrageArray = weapon.optJSONArray("barrage_ID");
		if(planeBarrageArray == null) {
			planeBarrageArray = baseWeapon.getJSONArray("barrage_ID");
		}
		JSONArray planeBulletArray = weapon.optJSONArray("bullet_ID");
		
		if(planeBulletArray!=null && !planeBulletArray.isEmpty())
			createPlane(id,planeBulletArray,planeBarrageArray);
		else
			createPlane(id,planeBarrageArray);
	}

	private void createPlane(String id,JSONArray planeBulletArray,JSONArray planeBarrageArray) {
		for(int i = 0; i < planeBulletArray.length();i++) {
			LinkedList<String> loadout = new LinkedList<String>();
			JSONObject barrage = barrageStats.getJSONObject(planeBarrageArray.getInt(i)+"");
			int planes = (barrage.getInt("primal_repeat")+1)*(barrage.getInt("senior_repeat")+1);
			JSONObject plane = planeStats.optJSONObject(planeBulletArray.getInt(i)+"");
			if(plane == null) {
				plane = planeStats.getJSONObject(weapon_id);
			}
			JSONArray load = plane.getJSONArray("weapon_ID");
			for(int j = 0; j < load.length();j++) {
				loadout.add(load.getInt(j)+"");
			}
			Abilities.addPlane(new Planes(id,loadout,planes));
		}
	}
	private void createPlane(String id, JSONArray planeBarrageArray) {
		LinkedList<String> loadout = new LinkedList<String>();
		JSONObject barrage = barrageStats.getJSONObject(planeBarrageArray.getInt(0)+"");
		int planes = (barrage.getInt("primal_repeat")+1)*(barrage.getInt("senior_repeat")+1);
		JSONObject plane = planeStats.optJSONObject(id);
		if(plane == null) {
			plane = planeStats.getJSONObject(weapon_id);
		}
		JSONArray load = plane.getJSONArray("weapon_ID");
		for(int j = 0; j < load.length();j++) {
			loadout.add(load.getInt(j)+"");
		}
		Abilities.addPlane(new Planes(id,loadout,planes));
	}


	/**
	 * Gets gun stats
	 */
	private void getGun() {
		if(weapon.has("damage"))
			damage = weapon.getInt("damage");
		else
			damage = baseWeapon.getInt("damage");
		if(weapon.has("corrected"))
			coeff = weapon.getDouble("corrected");
		else
			coeff = baseWeapon.getDouble("corrected");
		attr = baseWeapon.getInt("attack_attribute");
		attrRatio = baseWeapon.getDouble("attack_attribute_ratio");
		getScaling(attr);
		//if bulletID is in current weapon, use array, otherwise use baseWeapon
		if(weapon.has("bullet_ID")) 
			bulletArray = weapon.getJSONArray("bullet_ID");
		else
			bulletArray = baseWeapon.getJSONArray("bullet_ID");
		//if barrageID is in current weapon, use array, otherwise use baseWeapon
		if(weapon.has("barrage_ID"))
			barrageArray = weapon.getJSONArray("barrage_ID");
		else
			barrageArray = baseWeapon.getJSONArray("barrage_ID");
		getBullets();
	}

	/**
	 * Gets weapon stat scaling
	 * @param attr
	 */
	private void getScaling(int attr) {
		switch (attr) {
		case(1):
			scaling = "FP";
		break;
		case(2):
			scaling = "TRP";
		break;
		case(3):
			scaling = "AA";
		break;
		case(4):
			scaling = "AVI";
		break;
		case(5):
			scaling = "ASW";
		break;
		}
	}

	/**
	 * Gets bullet count for each unique bullet
	 */
	private void getBullets() {
		int bulletid;
		for(int i = 0; i < bulletArray.length();i++) {
			bulletid = bulletArray.getInt(i);
			int barrageid = barrageArray.getInt(i);
			if(checkBulletDropFilter(bulletid))
				continue;
			//use a map to track unique bullets
			if(map.containsKey(bulletid)) {
				addBulletToExisting(bulletid,barrageid);
			}else {
				//stores a stack of each unique bullet
				mapValues.push(bulletid);
				Bullets bullet = createBullet(bulletid,barrageid);
				map.put(bulletid, bullet);
				if(bullet.hasShrapnel()) 
					handleShrapnel(bullet, bullet.bulletCount);
			}
		}
		if(!mapValues.isEmpty())
			combineBullets();
	}
	
	private void handleShrapnel(Bullets b, int count) {
		List<Integer> sbullet = b.shrapnelBullet;
		List<Integer> sbarrage = b.shrapnelBarrage;
		List<Boolean> reaim = b.shrapnelReaim;
		
		for(int i = 0; i < sbullet.size();i++) {
			
			int bulletid = sbullet.get(i);
			int barrageid = sbarrage.get(i);
			if(checkBulletDropFilter(bulletid))
				continue;
			if(map.containsKey(bulletid)) {
				addShrapnelBulletToExisting(bulletid,barrageid,count);
			}else {
				mapValues.push(bulletid);
				Bullets shrapnel = createShrapnelBullet(bulletid,barrageid,count);
				if(reaim.get(i))
					shrapnel.prependNote("Reaim");
				map.put(bulletid, shrapnel);
				if(shrapnel.hasShrapnel())
					handleShrapnel(shrapnel,shrapnel.getBulletCount());
			}
		}
	}
	
	//Checks if diveFilter is [1,2], if so returns true
	private boolean checkBulletDropFilter(int bulletId) {
		JSONObject bullet = bulletStats.getJSONObject(bulletId+"");
		Object extra_param = bullet.get("extra_param");
		if(extra_param instanceof JSONObject && ((JSONObject) extra_param).has("diveFilter")) {
			JSONArray diveFilter = ((JSONObject) extra_param).getJSONArray("diveFilter");
			if(diveFilter.length()==2)
				if(diveFilter.getInt(0)==1 && diveFilter.getInt(1) == 2)
					return true;
		}
		return false;
	}

	/**
	 * Combine bullets in map with the same L/M/H values
	 */
	private void combineBullets() {
		Bullets a,b;
		int t;
		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> values = mapValues;
		Stack<Integer> result = new Stack<Integer>();
		//check L/M/H values for each bullet in stack
		a = map.get(values.pop());
		result.push(a.getBulletID());
		while(!values.isEmpty()) {
			t=values.pop();
			b = map.get(t);
			//if L/M/H is non-unique, combine bullet counts
			if(a.getLight()==b.getLight() &&  a.getMedium()==b.getMedium() && a.getHeavy()==b.getHeavy() && a.getNote().equals(b.getNote()))
				a.addBullets(b.getBulletCount());
			else {
				temp.push(t);
			}
			if(values.isEmpty() && !temp.isEmpty()) {
				values = (Stack<Integer>) temp.clone();
				a = map.get(values.pop());
				temp.clear();
				result.push(a.getBulletID());
			}
		}
		mapValues = result;
	}

	/**
	 * Creates new bullet object and adds bullet count
	 * @param bulletId
	 * @param index - index of bullet and barrage arrays
	 * @return
	 */
	private Bullets createBullet(int bulletId,int barrageid) {
		Bullets bullet = new Bullets(bulletId);
		JSONObject barrage = barrageStats.getJSONObject(barrageid+"");
		int primal = barrage.getInt("primal_repeat")+1;
		int senior = barrage.getInt("senior_repeat")+1;
		bullet.addBullets(primal*senior);
		return bullet;
	}
	
	private Bullets createShrapnelBullet(int bulletid, int barrageid, int bulletcount) {
		Bullets bullet = new Bullets(bulletid);
		JSONObject barrage = barrageStats.getJSONObject(barrageid+"");
		int primal = barrage.getInt("primal_repeat")+1;
		int senior = barrage.getInt("senior_repeat")+1;
		bullet.addBullets(primal*senior*bulletcount);
		return bullet;
	}

	/**
	 * Adds bullet count to map
	 * @param b
	 * @param index - index of bullet and barrage arrays
	 */
	private void addBulletToExisting(int bulletid, int barrageid) {
		JSONObject barrage = barrageStats.getJSONObject(barrageid+"");
		int primal = barrage.getInt("primal_repeat")+1;
		int senior = barrage.getInt("senior_repeat")+1;
		Bullets bullet = map.get(bulletid);
		bullet.addBullets(primal*senior);
		map.put(bulletid, bullet);
		if(bullet.hasShrapnel()) {
			handleShrapnel(bullet, primal*senior);
		}
	}
	
	private void addShrapnelBulletToExisting(int bulletid, int barrageid,int bulletcount) {
		JSONObject barrage = barrageStats.getJSONObject(barrageid+"");
		int primal = barrage.getInt("primal_repeat")+1;
		int senior = barrage.getInt("senior_repeat")+1;
		Bullets bullet = map.get(bulletid);
		bullet.addBullets(primal*senior*bulletcount);
		map.put(bulletid, bullet);
		if(bullet.shrapnel)
			handleShrapnel(bullet,primal*senior*bulletcount);
	}


	public void printWeapon(boolean printExcel) {
		while(!mapValues.isEmpty()) {
			Bullets b = map.get(mapValues.pop());
			System.out.println("-----------------------------------------------");
			System.out.println("WeaponID: "+ weapon_id);
			System.out.println( "BulletID: "+ b.bulletID);
			System.out.println("Damage: " +damage);
			System.out.println("Coefficient: " +coeff/100);
			System.out.println("Scaling: " + attrRatio/100 +"x "+scaling);
			System.out.println( "Bullet Count: " + b.bulletCount);
			System.out.println( "Ammo Type : " + b.ammoType);
			System.out.println( "Ammo Mods: " + b.light+ "/" +b.medium+ "/" + b.heavy);
			if(b.offsetX != 0)
				System.out.println("SpreadX: " + b.offsetX);
			if(b.offsetZ !=0) 
				System.out.println("SpreadZ: " + b.offsetZ);
			if(b.splash != 0)
				System.out.println("Splash: "+ b.splash);
			if(b.buffID != 0)
				System.out.println("BuffID: "+b.buffID);
			System.out.println("Pierce: " + b.pierce);
			System.out.println("Velocity: " + b.velocity);
			System.out.println("Range: " + b.range);
			if(b.antisub !=0)
				System.out.println("antisub: " + b.antisub);
			if(b.ignoreShield)
				System.out.println("Ignore Shields");
			if(b.shrapnel)
				System.out.println("Shrapnel");
			if(printExcel)
				printExcel("",b,1);
		}
	}

	public void printWeaponBulletMultiplier(int x, String planeID, boolean printExcel) {
		while(!mapValues.isEmpty()) {
			Bullets b = map.get(mapValues.pop());
			
			System.out.println("-----------------------------------------------");
			System.out.println("WeaponID: "+ weapon_id);
			System.out.println( "BulletID: "+ b.bulletID);
			System.out.println("Damage: " +damage);
			System.out.println("Coefficient: " +coeff/100);
			System.out.println("Scaling: " + attrRatio/100 +"x "+scaling);
			System.out.println( "Bullet Count: " + b.bulletCount*x);
			System.out.println( "Ammo Type : " + b.ammoType);
			System.out.println( "Ammo Mods: " + b.light+ "/" +b.medium+ "/" + b.heavy);
			if(b.offsetX != 0)
				System.out.println("SpreadX: " + b.offsetX);
			if(b.offsetZ !=0) 
				System.out.println("SpreadZ: " + b.offsetZ);
			if(b.splash != 0)
				System.out.println("Splash: "+ b.splash);
			if(b.buffID != 0)
				System.out.println("BuffID: "+b.buffID);
			System.out.println("Pierce: " + b.pierce);
			System.out.println("Velocity: " + b.velocity);
			if(b.antisub !=0)
				System.out.println("antisub: " + b.antisub);
			if(b.ignoreShield)
				System.out.println("Ignore Shields");
			if(b.shrapnel)
				System.out.println("Shrapnel");
			if(printExcel && planeID != "")
				printExcel(planeID,b,x);
		}
	}
	
	protected void printExcel(String planeID, Bullets b, int planeCount) {
		String bulletId = String.valueOf(b.bulletID);
		int bulletCount = b.bulletCount;
		String ammoType = b.ammoType;
		double light = b.light;
		double med = b.medium;
		double heavy = b.heavy;
		int offsetX = b.offsetX;
		int offsetZ = b.offsetZ;
		int splash = b.splash;
		int buffid = b.buffID;
		int pierce = b.pierce;
		int velocity = b.velocity;
		int antisub = b.antisub;
		int rant = b.rant/100;
		
		String buff = "";
		String proc = "";
		System.out.println("excel : --------------");
		if(planeID != "") {
			System.out.println(planeID+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+planeCount+"\t");
			bulletCount = b.bulletCount*planeCount;
		}
		if(buffid !=0)
			buff = String.valueOf(buffid);
		if(rant != 0)
			proc = String.valueOf(rant);
		if(!target.isBlank())
			b.note = addToNote(target,b.note);
		System.out.println(weapon_id+"\t"+bulletId+"\t"+damage+"\t"+ammoType+"\t"+coeff/100+"\t"+attrRatio/100+"\t"+scaling+"\t"+
				light+"\t"+med+"\t"+heavy+"\t"+ b.note+"\t"+proc+"\t"+buff+"\t"+bulletCount);
	}
	
	public String addToNote(String s, String note) {
		if(note.isBlank())
			note = s;
		else
			note = s + ", " + note;
		return note;
	}
	
	
	public String getWeapon_id() {
		return weapon_id;
	}

	public void setWeapon_id(String weapon_id) {
		this.weapon_id = weapon_id;
	}

	public JSONObject getWeapon() {
		return weapon;
	}

	public void setWeapon(JSONObject weapon) {
		this.weapon = weapon;
	}

	public List<Integer> getBullet_id() {
		return bullet_id;
	}

	public void setBullet_id(List<Integer> bullet_id) {
		this.bullet_id = bullet_id;
	}

	public List<Integer> getBulletCount() {
		return bulletCount;
	}

	public void setBulletCount(List<Integer> bulletCount) {
		this.bulletCount = bulletCount;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	public int getAttr() {
		return attr;
	}

	public void setAttr(int attr) {
		this.attr = attr;
	}

	public double getAttrRatio() {
		return attrRatio;
	}

	public void setAttrRatio(double attrRatio) {
		this.attrRatio = attrRatio;
	}

	public String getScaling() {
		return scaling;
	}

	public void setScaling(String scaling) {
		this.scaling = scaling;
	}

	public JSONObject getBaseWeapon() {
		return baseWeapon;
	}

	public void setBaseWeapon(JSONObject baseWeapon) {
		this.baseWeapon = baseWeapon;
	}

	public int getPlaneCount() {
		return planeCount;
	}

	public void setPlaneCount(int planeCount) {
		this.planeCount = planeCount;
	}

	public Boolean getPlane() {
		return plane;
	}

	public void setPlane(Boolean plane) {
		this.plane = plane;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
}
