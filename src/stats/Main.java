package stats;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

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
		boolean printExcel = manual;
		String shipName = "pittsburgh";
		int level = 125;
		int aff = 100;
		String mode = "-s";
		boolean retroFlag = true;
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
			run(mode,shipName,retroFlag,weaponId,buffID,shipId,level,aff,printExcel);
		}
		else if(args.length == 0) {
			System.out.println(help);
		}
		else if(args.length > 1){
			//ship names
			if (args[0].equals("-s")) {
				int i = 1;
				mode = "-s";
				shipName = args[i];
				while(++i <= args.length-1 ) {
					if(args[i].startsWith("-")) {
						break;
					}
					shipName = shipName +" "+ args[i];
				}
				for(; i < args.length; i++) {

					if(args[i].equals("-l")){
						i++;
						level = Integer.parseInt(args[i]);
					}

					else if(args[i].equals("-aff")) {
						i++;
						aff = Integer.parseInt(args[i]);
					}
					else if(args[i].equals("-retro")) {
						i++;
						retroFlag = Boolean.parseBoolean(args[i]);
					}
				}
			}
			else {
				mode = args[0];
				//buff and weapons ids
				if(args[0].equals("-b")) {
					
					buffID = args[1];
				}
				else if ( args[0].equals("-w")) {
					weaponId = args[0];
				}
				else if ( args[0].equals("-id")) {
					shipId = args[1];
				}
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
