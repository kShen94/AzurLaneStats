package stats;
import java.io.FileInputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonData {

		public static JSONObject shipStats;
		public static JSONObject weaponStats;
		public static JSONObject planeStats;
		public static JSONObject barrageStats;
		public static JSONObject buffCfg;
		public static JSONObject skillCfg;
		public static JSONObject shipTemplate;
		public static JSONObject bulletStats;
		public static JSONObject strengthenStats;
		public static JSONObject transData;
		public static JSONObject shipTrans;
		public static JSONObject prStrengthen;
		public static JSONObject metaRepair;
		public static JSONObject metaEffect;
		public static JSONObject metaStrengthen;
		
		static {
			try {
				/**
				shipStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_statistics.json")));
				weaponStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/weapon_property.json")));
				planeStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/aircraft_template.json")));
				barrageStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/barrage_template.json")));
				
				shipTemplate = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_template.json")));
				bulletStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/bullet_template.json")));
				strengthenStats = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_strengthen.json")));
				transData = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/transform_data_template.json")));
				
				shipTrans = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_data_trans.json")));
				
				prStrengthen = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_strengthen_blueprint.json")));
				
				metaRepair = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_meta_repair.json")));
				metaEffect = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_meta_repair_effect.json")));
				metaStrengthen = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/ship_strengthen_meta.json")));
				
				skillCfg = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/skillCfg.json")));
				buffCfg = new JSONObject(new JSONTokener(JsonData.class.getResourceAsStream("/buffCfg.json")));
				**/
				shipStats = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_data_statistics.json")));
				weaponStats = new JSONObject(new JSONTokener(new FileInputStream("./resources/weapon_property.json")));
				planeStats = new JSONObject(new JSONTokener(new FileInputStream("./resources/aircraft_template.json")));
				barrageStats = new JSONObject(new JSONTokener(new FileInputStream("./resources/barrage_template.json")));
				
				shipTemplate = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_data_template.json")));
				bulletStats = new JSONObject(new JSONTokener(new FileInputStream("./resources/bullet_template.json")));
				strengthenStats = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_data_strengthen.json")));
				transData = new JSONObject(new JSONTokener(new FileInputStream("./resources/transform_data_template.json")));
				
				shipTrans = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_data_trans.json")));
				
				prStrengthen = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_strengthen_blueprint.json")));
				
				metaRepair = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_meta_repair.json")));
				metaEffect = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_meta_repair_effect.json")));
				metaStrengthen = new JSONObject(new JSONTokener(new FileInputStream("./resources/ship_strengthen_meta.json")));
				
				skillCfg = new JSONObject(new JSONTokener(new FileInputStream("./resources/skillCfg.json")));
				buffCfg = new JSONObject(new JSONTokener(new FileInputStream("./resources/buffCfg.json")));
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}
		}
	
}
