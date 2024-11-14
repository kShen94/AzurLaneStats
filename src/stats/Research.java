package stats;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public enum Research {
	//PR1
	Neptune("HMS Neptune", new double[] {10,0,0,199+398+586,0,0,0,17+34+51,0,0,0,0,15}),
	Monarch("HMS Monarch", new double[] {10,0,10,325+651+976,0,0,0,11+21+31,0,0,0,0,15}),
	Ibuki("IJN Ibuki", new double[] {10,0,0,201+402+603,0,0,0,9+18+26,0,5+10,0,0,15}),
	Izumo("IJN Izumo", new double[] {10,0,10,347+694+1011,0,0,0,11+21+33,0,0,0,0,15}),
	Roon("KMS Roon", new double[] {10,0,0,254+508+761,0,0,0,11+21+32,0,5+10,0,0,15}),
	SaintLouis("FFNF Saint-Louis", new double[] {10,0,0,230+460+690,0,0,0,11+23+34,0,5+10,0,0,15}),
	//PR2
	Seattle("USS Seattle", new double[] {10,0,0,225+451+667,0,0,0,17+34+51,0,5+10,0,0,15}),
	Georgia("USS Georgia", new double[] {10,0,10,356+711+1068,0,0,0,19+39+58,0,0,0,0,15}),
	Kitakaze("IJN Kitakaze", new double[] {10,0,0,111+221+333,0,0,0,9+18+27,0,0,0,0,15}),
	Azuma("IJN Azuma", new double[] {10,0,10,315+629+945,0,0,0,10+21+31,0,5,0,0,25}),
	FriedrichDerGroße("KMS Friedrich der Grosse", new double[] {10,0,10,400+797+1195,0,0,0,11+22+33,0,0,0,0,0}),
	Gascogne("MNF Gascogne", new double[] {10,0,10,325+651+976,0,0,0,11+22+33,0,0,0,0,15}),
	//PR3
	Cheshire("HMS Cheshire", new double[] {10,0,0,217+433+649,0,0,0,19+39+58,0,5+10,0,0,15}),
	Drake("HMS Drake", new double[] {10,0,0,237+473+710,0,0,0,13+27+40,0,5+10,0,0,25}),
	Mainz("KMS Mainz", new double[] {10,0,0,226+451+677,0,0,0,17+33+49,0,0,0,0,15}),
	Odin("KMS Odin", new double[] {10,0,10,289+579+868,0,0,0,16+31+47,0,0,0,0,15}),
	Champagne("FFNF Champagne", new double[] {10,0,10,285+571+856,0,0,0,11+22+33,0,0,0,0,15}),
	//PR4
	Anchorage("USS Anchorage", new double[] {10,0,0,268+537+805,0,0,0,10+21+31,0,5+10,0,0,15},"18"),
	Hakuryuu("IJN Hakuryū", new double[] {5,10,5,346+691+1037,0,0,0,15+30+45,0,0,0,0,25},"19"),
	Ägir("KMS Ägir", new double[] {10,0,10,338+675+1014,0,0,0,12+23+34,0,5,0,0,25},"20"),
	AugustVonParseval("KMS August von Parseval", new double[] {10,0,10,310+621+931,0,0,0,15+30+46,0,0,0,0,15},"21"),
	MarcoPolo("RN Marco Polo", new double[] {10,0,10,344+688+1032,0,0,0,12+24+35,0,0,0,0,15},"22"),
	//PR5
	Brest("FFNF Brest", new double[] {0,0,10,307+614+921,0,0,0,12+23+35,0,5,0,0,0},"27"),
	Plymouth("HMS Plymouth", new double[] {15,0,0,227+453+681,0,0,0,16+31+46,0,0,0,0,0},"23"),
	PrinzRupprecht("KMS Prinz Rupprecht", new double[] {5,0,10,344+688+1032,0,0,0,15+29+45,0,0,0,0,15},"24"),
	Harbin("PRAN Harbin", new double[] {0,10,0,152+305+457,0,0,0,19+38+58,0,0,0,0,15},"25"),
	Chkalov("SN Chkalov", new double[] {0,0,5,269+539+809,0,0,0,15+30+44,0,0,0,0,15},"26"),
	//PR6
	Kearsarge("USS Kearsarge", new double[] {10,20,0,383+766+1195,0,0,0,15+33+31,0,0,0,0,0},"28"),
	Shimanto("IJN Shimanto", new double[] {10,20,0,383+766+1195,0,0,0,15+33+31,0,0,0,0,15},"29"),
	FelixSchultz("KMS Felix Schultz", new double[] {10,20,0,383+766+1195,0,0,0,15+33+31,0,0,0,0,15},"30"),
	Hindenburg("KMS Hindenburg", new double[] {10,20,0,383+766+1195,0,0,0,15+33+31,0,0,0,0,0},"31"),
	Flandre("MNF Flandre", new double[] {10,20,0,383+766+1195,0,0,0,15+33+31,0,0,0,0,15},"32"),
	//PR7
	Halford("USS Halford", new double[] {10,0,0,100+201+301,0,0,0,8+16+24,0,0,0,0,0},"33"),
	Daisen("IJN Daisen", new double[] {5+5,0,10,337+674+1010,0,0,0,12+25+35,0,0,0,0,0},"34"),
	Napoli("RN Napoli", new double[] {10,0,0,298+597+894,0,0,0,13+23+36,0,0,0,0,0},"35"),
	Nakhimov("SN Admiral Nakhimov", new double[] {0,10,10,393+787+1180,0,0,0,14+27+41,0,0,0,0,0},"36"),
	Bayard("FFNF Bayard", new double[] {0,10,0,202+405+607,0,0,0,17+35+51,0,0,0,0,0},"37")
	;
	/** 0 - equipment_proficiency_1
	 *  1 - equipment_proficiency_2
	 *  2 - equipment_proficiency_3
	 *  3 - hp
	 *  4 - fp
	 *  5 - trp
	 *  6 - avi
	 *  7 - AA
	 *  8 - reload
	 *  9 - eva
	 *  10 - hit
	 *  11 - asw
	 *  12 - luck
	 */
	private final String name;
	private final String plan;
	private double[] stats;
	private HashMap<String,String> skillChange = new HashMap<String, String>();
	private int[] replace = {4,5,6,8};
	private int[] addStats = {0,1,3,4};
	
	Research(String name, double[] stats){
		this.name = name;
		this.stats = stats;
		this.plan = "";
	}
	Research(String name, double[] stats,String plan){
		this.name = name;
		this.stats = stats;
		this.plan = plan;
		getEnhance(plan);
	}
	Research(String name, double[] stats,String oldSkill,String newSkill){
		this.name = name;
		this.stats = stats;
		this.plan = "";
		skillChange.put(oldSkill, newSkill);
	}
	Research(String name, double[] stats,String plan, String oldSkill,String newSkill){
		this.name = name;
		this.stats = stats;
		this.plan = plan;
		skillChange.put(oldSkill, newSkill);
		getEnhance(plan);
	}
	Research(String name, double[] stats,String oldSkill,String newSkill,String oldSkill2,String newSkill2){
		this.name = name;
		this.stats = stats;
		this.plan = "";
		skillChange.put(oldSkill, newSkill);
		skillChange.put(oldSkill2, newSkill2);
	}

	Research(String name, double[] stats, String plan, String oldSkill,String newSkill,String oldSkill2,String newSkill2){
		this.name = name;
		this.stats = stats;
		this.plan = plan;
		skillChange.put(oldSkill, newSkill);
		skillChange.put(oldSkill2, newSkill2);
		getEnhance(plan);
	}
	
	public String getName() {
		return name;
	}
	
	public double[] getStats() {
		return stats;
	}
	
	public HashMap<String, String> getSkillChange() {
		return skillChange;
	}
	
	//new pr fp/trp/aa/avi/rld
	
	public double[] getEnhance(String plan) {
		JSONObject prStr = JsonData.prStrengthen;
		double [] stat = {0,0,0,0,0};
		JSONObject enhance;
		JSONArray effect;
		String search;
		for(int i =1;i<=35;i++) {
			search = plan;
			if(i < 10)
				search=search+"0";
			if(prStr.isNull(search+i))
				break;
			enhance = prStr.optJSONObject(search+i);
			effect = enhance.getJSONArray("effect");
			double[] temp = new double[5];
			for(int a=0;a<5;a++) {
				temp[a] = (stat[a] + effect.getInt(a)/100.0);
			}
			stat = temp;
		}
		for(int b=0; b < 4; b++) {
			double stemp = stats[replace[b]];
			stemp += stat[addStats[b]];
			stats[replace[b]] = stemp;
		}
		return stat;
	}
	public boolean hasSkillChange() {
		if(skillChange.isEmpty())
			return false;
		return true;
	}
}
