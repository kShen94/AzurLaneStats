package stats;
import Utility.FileDownloader;
import Utility.UpdateAugmentList;
import Utility.UpdateShipIds;

public class Main {
	ShipStats s = new ShipStats();

	static String help = "This is a tool made to assist with Azur Lane datamining, particularly barrage and weapon info \n\n"
			+ "Usage: ALStats -s <shipName> [options] <args> \n"
			+ "or ALStats -b <buffID> \n"
			+ "or ALStats -w <weaponID> \n"
			+ "\n"
			+ "Options: \n"
			+ "\t -l <level> --default 125 \n"
			+ "\t -aff <affection> --default 100 \n"
			+ "\t -retro <true/false> --default true,returns retrofit stats if applicable \n";

	static boolean augment;
	//TODO add meta stats, fs skill upgrades, add functionality for rng skills
	//copy jsons in every update
	//UI
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//operation mode
		// w for weapon ids
		// b for buffs		

		//ide usage, change to false when building
		boolean manual = true;
		boolean update = false;
		boolean forceShipIdUpdate = false;
		boolean printExcel = manual;
		String shipName ="shoukaku";
		int level = 125;
		int aff = 100;
		String mode = "-s";
		boolean retroFlag = false;
		augment = true;
		String buffID = "18730";
		String weaponId = "324";
		String shipId = "702074";

		if(manual) {
			//change to true to update files
			//copyFiles(true);
			if(update) {
				FileDownloader.updateFiles();
				UpdateShipIds.updateShipIds();
			}
			else if(forceShipIdUpdate) {
				UpdateShipIds.updateShipIds();
				UpdateAugmentList.updateAugmentList();
			}
			run(mode,shipName,retroFlag,weaponId,buffID,shipId,level,aff,printExcel);
		}
	}

	public static void run(String mode, String shipName, boolean retroFlag, String weaponId, String buffID, String shipId, int level, int aff, boolean printExcel) {
		ShipStats s;

		if(mode.equals("-w")) {
			Weapons w = new Weapons(weaponId,true);
			w.printWeapon(printExcel);
			for(Planes p : Abilities.planesList) {
				p.printWeapons(printExcel);
			}
		}
		else if(mode.equals("-b")) {
			new Abilities(buffID);
			for(Weapons w : Abilities.weaponsList) {
				w.printWeapon(printExcel);
			}
		}
		else if(mode.equals("-s")){
			s = new ShipBuilder(shipName,retroFlag,augment).getShip();
			s.printStats(level, aff);
			s.printSkillTree();
			s.printWeapons();
		}
		else if(mode.equals("-id")) {
			s = new ShipStats();
			s.setRetroTrue(retroFlag);
			s.getShipStats(shipId);
			s.printStats(level, aff);
			String id = s.getID();
			String groupid = id.substring(0, id.length()-1);
			new Abilities(Integer.parseInt(id),groupid,augment);
			for(Weapons w : Abilities.weaponsList) {
				w.printWeapon(printExcel);
			}
			for(Planes p : Abilities.planesList) {
				p.printWeapons(printExcel);
			}
		}
		else {
			System.out.println(help);
		}
	}

}
