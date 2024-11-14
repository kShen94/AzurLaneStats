package Utility;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONObject;
import org.json.JSONTokener;

import stats.JsonData;

public class UpdateShipIds {

	private static final Set<Integer> skip = Set.of(
			202284, 207114, 901124, 403084, 307114, 701054, 108054, 103254, 307104, 9002034,
			403074, 102244, 102204, 202184, 207134, 203104, 403124, 107994, 403134, 204044,
			407024, 307094, 304064, 304074, 403154, 302244, 102324, 304084, 801094, 307144,
			405064, 102214, 30715
			);

	private static List<String> slist = new ArrayList<String>() {
		{
			add("UNIV Universal Bulin, 100001");
			add("UNIV Trial Bulin MKII, 100011");
			add("UNIV Specialized Bulin Custom MKIII, 100021");
			
			add("Dido μ, 20228");
			add("Illustrious µ, 20711");
			add("Roon µ, 40308");
			add("Taihou µ, 30711");
			add("Tashkent µ, 70105");
			add("Albacore µ, 10805");
			add("Baltimore µ, 10325");
			add("Akagi µ, 30710");
			add("Gascogne µ, 900203");
			add("Admiral Hipper µ, 40307");
			add("Cleveland µ, 10224");
			add("Illustrious µ, 20711");
			add("Formidable μ, 20714");
			add("Prinz Eugen μ, 40315");
			add("Noshiro μ, 30224");
			add("Boise μ, 10232");
			add("Kongou μ, 30408");
			add("Le Téméraire μ, 80109");
			add("Le Malin µ, 90112");
			
			add("Clevelad, 10220");
			add("Li'l Sandy, 10221");
			add("Little Bel, 20218");
			add("Little Formidable, 20713");
			add("Little Cheshire, 20310");
			add("Little Prinz Eugen, 40312");
			add("Little Enterprise, 10799");
			add("Little Spee, 40313");
			add("Little Illustrious, 20709");
			add("Little Friedrich, 40506");
			add("Little Renown, 20404");
			add("Zeppy, 40702");
			add("Akagi-chan, 30709");
			add("Hiei-chan, 30406");
			add("Amagi-chan, 30407");
			add("Shinano-chan, 30714");
			
			add("Amagi (CV), 30715");
		}
	};

	public static void updateShipIds() {
		try {
			// Open JSON files
			JSONObject shipStats = JsonData.shipStats;
			JSONObject shipTemplate = JsonData.shipTemplate;

			// Create output file
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./resources/idList.txt"), StandardCharsets.UTF_8));

			for (int x = 100004; x < 900000; x += 10) {
				if (skip.contains(x)) continue;
				if (shipStats.has(String.valueOf(x))) {
					JSONObject ship = shipStats.getJSONObject(String.valueOf(x));
					String entry = ship.getString("english_name") + "," + shipTemplate.getJSONObject(String.valueOf(x)).getInt("group_type");
					slist.add(entry);
				}
			}
			
            for (int x = 901014; x < 21000074; x += 10) {
                if (skip.contains(x)) continue;
                if (shipStats.has(String.valueOf(x))) {
                    JSONObject ship = shipStats.getJSONObject(String.valueOf(x));
                    String entry = ship.getString("english_name") + "," + shipTemplate.getJSONObject(String.valueOf(x)).getInt("group_type");
                    slist.add(entry);
                }
            }
			slist = new ArrayList<>(new TreeSet<String>(slist));
			
            for (String line : slist) {
                output.write(line);
                output.newLine();
            }
            
            output.close();
		} catch (Exception e) {
            e.printStackTrace();
        }
	}

}
