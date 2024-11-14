package stats;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bullets {
	int bulletID,barrageID,buffID,rant;
	int bulletCount;
	double light,medium,heavy;
	String ammoType;
	int offsetX;
	int offsetZ;
	int splash;
	int pierce;
	int range;
	int velocity;
	JSONObject bulletStats = JsonData.bulletStats;
	int antisub;
	boolean ignoreShield;
	boolean shrapnel = false;
	ArrayList<Integer> shrapnelBullet;
	ArrayList<Integer> shrapnelBarrage;
	ArrayList<Boolean> shrapnelReaim;
	String note = "";
	
	public Bullets(int bulletid) {
		bulletID = bulletid;
		bulletCount = 0;
		getBulletStats();
	}
	
	public void print() {
		System.out.println( "BulletID: "+ bulletID);
		System.out.println( "Bullet Count: " + bulletCount);
		System.out.println( "Ammo Type : " + ammoType);
		System.out.println( "Ammo Mods: " + light+ "/" +medium+ "/" + heavy);
		if(offsetX != 0)
			System.out.println("SpreadX: " + offsetX);
		if(offsetZ !=0) 
			System.out.println("SpreadZ: " + offsetZ);
		if(splash != 0)
			System.out.println("Splash: "+ splash);
		System.out.println("Pierce: " + pierce);
		System.out.println("Velocity: " + velocity);
		System.out.println("Range: " + range);
		if(antisub !=0) {
			System.out.println("antisub: " + antisub);
		}
	}
	
	private void getBulletStats() {
		JSONObject bullet = bulletStats.getJSONObject(bulletID+"");
		getAmmoType(bullet.getInt("ammo_type"));
		checkBuff(bullet.getJSONArray("attach_buff"));
		antisub = bullet.getInt("antisub_enhancement");
		getAmmoMods(bullet.getJSONArray("damage_type"));
		getExtras(bullet.optJSONObject("extra_param"));
		getSplash(bullet.optJSONObject("hit_type"));
		pierce = bullet.getInt("pierce_count");
		range = bullet.getInt("range");
		velocity = bullet.getInt("velocity");
		addBulletNote();
	}
	
	private void getSplash(JSONObject hitType) {
		if(hitType != null) {
			if(hitType.has("range"))
				splash = hitType.getInt("range");
			else
				splash = 0;
		}else {
			splash = 0;
		}
	}
	
	/**
	 * Checks extra_param for stats
	 * randomOffsetX/Z, ignoreShield
	 * @param extra
	 */
	private void getExtras(JSONObject extra) {
		if(extra != null) {
			offsetX = extra.optInt("randomOffsetX",0);
			offsetZ = extra.optInt("randomOffsetZ",0);
			ignoreShield = extra.optBoolean("ignoreShield", false);
			if(extra.has("shrapnel")) {
				shrapnel=true;
				shrapnelBullet = new ArrayList<Integer>();
				shrapnelBarrage = new ArrayList<Integer>();
				shrapnelReaim = new ArrayList<Boolean>();
				Object shrapnelObj = extra.get("shrapnel");
				if(shrapnelObj instanceof JSONObject) {
				//assuming shrapnel will have incremental int
					int i = 1;
					while(((JSONObject) shrapnelObj).has(i+"")) {
						JSONObject shrapnelProp = ((JSONObject)shrapnelObj).getJSONObject(i+"");
						shrapnelBullet.add(shrapnelProp.getInt("bullet_ID"));
						shrapnelBarrage.add(shrapnelProp.getInt("barrage_ID"));
						shrapnelReaim.add(shrapnelProp.has("reaim"));
						i++;
					}
				}
				else if (shrapnelObj instanceof JSONArray) {
					int x = 0;
					while(x < ((JSONArray)shrapnelObj).length()){
						JSONObject shrapnelProp = ((JSONArray)shrapnelObj).getJSONObject(x);
						shrapnelBullet.add(shrapnelProp.getInt("bullet_ID"));
						shrapnelBarrage.add(shrapnelProp.getInt("barrage_ID"));
						shrapnelReaim.add(shrapnelProp.has("reaim"));
						x++;
					}

				}
			}
		}
	}
	
	private void getAmmoMods(JSONArray mods) {
		light = mods.getDouble(0);
		medium = mods.getDouble(1);
		heavy = mods.getDouble(2);
	}
	
	private void checkBuff(JSONArray buff) {
		if(!buff.isEmpty()) {
			buffID = buff.getJSONObject(0).optInt("buff_id", 0);
			rant = buff.getJSONObject(0).optInt("rant", 0);
		}
	}
	
	private void addBulletNote() {
		boolean comma = false;
		if (shrapnel == true) {
			note = addComma(note,comma);
			note = note + "Shrapnel";
			comma=true;
		}
		if (ignoreShield == true) {
			note = addComma(note,comma);
			note = note + "Ignore shields";
			comma=true;
		}
		if (pierce > 0) {
			note = addComma(note,comma);
			note = note + "pierce " + pierce;
			comma=true;
		}
		
		if(offsetX > 0 && offsetX==offsetZ) {
			note = addComma(note,comma);
			note = note + offsetX + " spread";
			comma=true;
		}
		else if(offsetX > 0 && offsetZ > 0) {
			note = addComma(note,comma);
			note = note + offsetX+ " spreadX, "+ offsetZ + " spreadZ";
			comma=true;
		}
		
		if(splash > 0 && splash != 3) {
			note = addComma(note,comma);
			note = note + splash + " splash";
			comma=true;
		}
	}
	
	private String addComma(String note, boolean comma) {
		if(comma)
			note = note + ", ";
		return note;
	}
	
	private void getAmmoType(int ammo) {
		switch(ammo) {
		case 1:
			ammoType = "Normal";
			break;
		case 2:
			ammoType = "AP";
			break;
		case 3:
			ammoType = "HE";
			break;
		case 4:
			ammoType = "Torpedo";
			break;
		case 5:
			ammoType = "AA";
			break;
		case 6:
			ammoType = "Bomb";
			break;
		case 7:
			ammoType = "SAP";
			break;
		default:
			ammoType = "Unknown";
		}
	}
	
	public void prependNote(String s) {
		if(note.isBlank())
			note = s;
		else
			note = s + ", " + note;
			
	}
	
	public int getBulletID() {
		return bulletID;
	}
	public int getBarrageID() {
		return barrageID;
	}
	public int getBulletCount() {
		return bulletCount;
	}
	public double getLight() {
		return light;
	}
	public double getMedium() {
		return medium;
	}
	public double getHeavy() {
		return heavy;
	}
	
	public int getBuffID() {
		return buffID;
	}
	
	public void setLight(int l) {
		light = l;
	}
	public void setMedium(int m) {
		medium = m;
	}
	public void setHeavy(int h) {
		heavy = h;
	}
	public void addBullets(int count) {
		bulletCount += count;
	}
	public void setOffsetX(int x) {
		offsetX = x;
	}
	public void setOffsetZ(int z) {
		offsetZ = z;
	}
	public void setSplash(int s ) {
		splash = s;
	}
	public void setPierce(int p) {
		pierce = p;
	}
	public void setVelocity(int velo) {
		velocity = velo;
	}
	public void setRange(int r) {
		range = r;
	}
	public void setBuffID(int buff) {
		buffID = buff;
	}
	public String getNote() {
		return note;
	}
	public boolean hasShrapnel() {
		return shrapnel;
	}


}


	