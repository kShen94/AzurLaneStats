package stats;
import java.io.File;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonData {

		static String dir = System.getProperty("user.dir")+"\\resources\\";
		static JSONObject shipStats;
		static JSONObject weaponStats;
		static JSONObject planeStats;
		static JSONObject barrageStats;
		static JSONObject buffCfg;
		static JSONObject skillCfg;
		static JSONObject shipTemplate;
		static JSONObject bulletStats;
		static JSONObject strengthenStats;
		static JSONObject transData;
		static JSONObject shipTrans;
		static JSONObject prStrengthen;
		static JSONObject metaRepair;
		static JSONObject metaEffect;
		static JSONObject metaStrengthen;
		
		static {
			try {
				shipStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_statistics.json")));
				weaponStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/weapon_property.json")));
				planeStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/aircraft_template.json")));
				barrageStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/barrage_template.json")));
				buffCfg = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/buffCfg.json")));
				skillCfg = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/skillCfg.json")));
				shipTemplate = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_template.json")));
				bulletStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/bullet_template.json")));
				strengthenStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_strengthen.json")));
				transData = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/transform_data_template.json")));
				
				shipTrans = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_trans.json")));
				
				prStrengthen = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_strengthen_blueprint.json")));
				
				metaRepair = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_meta_repair.json")));
				metaEffect = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_meta_repair_effect.json")));
				metaStrengthen = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_strengthen_meta.json")));
				
				
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}
		}
	
}
