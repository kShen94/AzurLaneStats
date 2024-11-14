package stats;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ShipIds {

	public static HashMap<String,String> shipId;
	
	static {
		shipId = new HashMap<String,String>();
		try {
		InputStream is = new FileInputStream("./resources/idList.txt");
		Scanner sc = new Scanner(is);
		while(sc.hasNext()) {
			String next = sc.nextLine();
			String[] split = next.split(",");
			shipId.put(split[0], split[1]);
			addAlias();
		}
		sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void addAlias() {
		shipId.put("Hiryuu META","970701");
		shipId.put("Ark Royal META","970702");
		shipId.put("Helena META","970201");
		shipId.put("Souryuu META","970703");
		shipId.put("Fusou META","970501");
		shipId.put("Hiyou META","970601");
		shipId.put("Gneisenau META","970401");
		shipId.put("Junyou META","970602");
		shipId.put("Scharnhorst META","970402");
		shipId.put("Yamashiro META","970502");
		shipId.put("Memphis META","970202");
		shipId.put("Repulse META","970403");
		shipId.put("Terento META","970301");
		shipId.put("Arizona META","970503");
		shipId.put("Queen Elizabeth META", "970504");
		shipId.put("La Galissonniere META", "970204");
		shipId.put("U556 META", "970801");
		shipId.put("Vestal META", "971201");
		shipId.put("Hatakaze META", "970103");
		shipId.put("2nd", "1080008");
		shipId.put("Painleve", "80702");
		shipId.put("Jintsuu META", "970205");
		shipId.put("Owari", "30513");
		shipId.put("Sao Martinho", "960002");
		shipId.put("Yuyaki", "1100007");
		shipId.put("Erebus META", "971301");
		shipId.put("Kirov META", "970206");
		shipId.put("Pamiat' Merkuria META", "970207");
		shipId.put("Pamiat Merkuria META", "970207");
		shipId.put("Nagato META", "9705064");
		shipId.put("Amagi CV", "30715");
		shipId.put("Hiei META", "970405");
		
		shipId.put("Zuihou", "306044");
		
		shipId.put("Dido u", "20228");
		shipId.put("Illustrious u", "20711");
		shipId.put("Le Malin u", "90112");
		shipId.put("Roon u", "40308");
		shipId.put("Taihou u", "30711");
		shipId.put("Tashkent u", "70105");
		shipId.put("Albacore u", "10805");
		shipId.put("Baltimore u", "10325");
		shipId.put("Akagi u", "30710");
		shipId.put("Gascogne u", "900203");
		shipId.put("Admiral Hipper u", "40307");
		shipId.put("Cleveland u", "10224");
		shipId.put("Illustrious u", "20711");
		shipId.put("Formidable u", "20714");
		shipId.put("Prinz Eugen u", "40315");
		shipId.put("Noshiro u", "30224");
		shipId.put("Boise u", "10232");
		shipId.put("Kongou u", "30408");
		shipId.put("Le Téméraire u", "80109");
		

	}
	public static String getShipID(String name) {
		LinkedList<String> candidates = new LinkedList<String>();
		Iterator<String> s = shipId.keySet().iterator();
		while (s.hasNext()) {
			String current = (String) s.next();
			if(current.equalsIgnoreCase(name)) {
				return shipId.get(current);
			}
			else if(current.toLowerCase().contains(name.toLowerCase())) {
				candidates.add(current);
			}
		}
		if(candidates.size()>1) {
			System.out.print("Ambiguous names: ");
			for (String n:candidates) {
				System.out.print(n + ", ");
			}
			System.out.println("");
			return null;
		}
		else if(candidates.size() == 0) {
			System.out.println("no ships found");
			return null;
		}
		else {
			return shipId.get(candidates.getFirst());
		}
	}
}
