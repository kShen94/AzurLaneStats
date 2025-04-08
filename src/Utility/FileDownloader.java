package Utility;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;


public class FileDownloader {
	private static final String REPO_DIR = "AzurLaneTools/AzurLaneData";
	//private static final String REPO_DIR = "JustNagami/al-json";
	private static final String TARGET_FILE_DIRECTORY = "./resources/";
	private static final String BINARY_URL = "https://raw.githubusercontent.com/"+REPO_DIR+"/refs/heads/main/CN/";
	private static final String SHARECFGDATA_BINARY_URL = "https://raw.githubusercontent.com/"+REPO_DIR+"/refs/heads/main/CN/sharecfgdata/";
	private static final String SHARECFG_BINARY_URL = "https://raw.githubusercontent.com/"+REPO_DIR+"/refs/heads/main/CN/ShareCfg/";
	private static final String GAMECFG_BINARY_URL = "https://raw.githubusercontent.com/"+REPO_DIR+"/refs/heads/main/CN/GameCfg/";
	private static final String[] GAMECFG_BINARY_FILE_LIST = {
			"skill.json",
			"buff.json"
	};
	private static final String[] SHARECFGDATA_FILE_LIST = {
			"ship_data_statistics.json",
			"weapon_property.json",
			"aircraft_template.json",
			"barrage_template.json",
			"ship_data_template.json",
			"bullet_template.json",
			"spweapon_data_statistics.json"
	};
	private static final String[] SHARECFG_FILE_LIST = {
			"ship_data_strengthen.json",
			"transform_data_template.json",
			"ship_data_trans.json",			
			"ship_strengthen_blueprint.json",
			"ship_meta_repair.json",
			"ship_meta_repair_effect.json",
			"ship_strengthen_meta.json"
	};
	private static final String LAST_MODIFIED_FILE = "lastModified.txt";
	private static HashMap<String, String> modifiedMap = new HashMap<String,String>();

	public static void updateFiles() {
		try {
			readModifiedMap();
			for(String file:SHARECFGDATA_FILE_LIST) {
				if (isUpdateAvailable(SHARECFGDATA_BINARY_URL+file)) {
					downloadFile(SHARECFGDATA_BINARY_URL+file, file);
					if(file.equals("spweapon_data_statistics.json")) {
						UpdateAugmentList.updateAugmentList();
						System.out.println("Updated augment list");
					}
				}
				else {
					System.out.println("Skipping "+file);
				}
			}
			for(String file:SHARECFG_FILE_LIST) {
				if (isUpdateAvailable(SHARECFG_BINARY_URL+file)) {
					downloadFile(SHARECFG_BINARY_URL+file, file);
				}
				else {
					System.out.println("Skipping "+file);
				}
			}
			for(String file:GAMECFG_BINARY_FILE_LIST) {
				String fileName = "";
				if (isUpdateAvailable(GAMECFG_BINARY_URL+file)) {
					if(file.equals("skill.json"))
						fileName = "skillCfg.json";
					else if(file.equals("buff.json"))
						fileName= "buffCfg.json";
					downloadFile(GAMECFG_BINARY_URL+file, fileName);
				}
				else {
					System.out.println("Skipping "+file);
				}
			}
			saveModifiedMap();
		} catch (Exception e) {
			System.out.println("Error thrown, saving modified map");
			saveModifiedMap();
			e.printStackTrace();
		}
	}

	private static void saveModifiedMap() {
		try(BufferedWriter wr = new BufferedWriter(new FileWriter(TARGET_FILE_DIRECTORY+LAST_MODIFIED_FILE,false))){
			Set<String> keys = modifiedMap.keySet();
			for(String k:keys) {
				wr.write(k+","+modifiedMap.get(k));
				wr.newLine();
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	private static void readModifiedMap() {
		Path file = Paths.get(TARGET_FILE_DIRECTORY+LAST_MODIFIED_FILE);
		if(Files.exists(file)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file.toFile()));
				String line;
				String[] pair;
				while((line = br.readLine()) !=null) {
					pair = line.split(",");
					modifiedMap.put(pair[0],pair[1]);
				}
				br.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private static boolean isUpdateAvailable(String URL) throws IOException {
		String etag = modifiedMap.get(URL);
		HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		Optional<String> requestedETag = Optional.of(connection.getHeaderField("ETag").replaceAll("\"",""));
		connection.disconnect();
		if(requestedETag.isEmpty() || (requestedETag.isPresent() && requestedETag.get().equals(etag))) {
			//do not update
			return false;
		}
		//update etag
		modifiedMap.put(URL, requestedETag.get());
		// Update available
		return true; 
	}

	private static void downloadFile(String URL, String fileName) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
		try (InputStream inputStream = connection.getInputStream();
				FileOutputStream outputStream = new FileOutputStream(TARGET_FILE_DIRECTORY+fileName)) {

			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			System.out.println(fileName +" Download complete.");
		}
	}
}
