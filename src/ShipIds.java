import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ShipIds {

	public static HashMap<String,String> shipId;
	
	static
	{
		shipId = new HashMap<String,String>();
		shipId.put("UNIV Universal Bulin","100004");
		shipId.put("UNIV Trial Bulin MKII","100014");
		shipId.put("UNIV Specialized Bulin Custom MKIII","100024");
		shipId.put("USS Dewey","101024");
		shipId.put("USS Cassin","101034");
		shipId.put("USS Downes","101044");
		shipId.put("USS Gridley","101054");
		shipId.put("USS Craven","101064");
		shipId.put("USS McCall","101074");
		shipId.put("USS Maury","101084");
		shipId.put("USS Fletcher","101094");
		shipId.put("USS Charles Ausburne","101114");
		shipId.put("USS Thatcher","101124");
		shipId.put("USS Aulick","101134");
		shipId.put("USS Foote","101144");
		shipId.put("USS Spence","101154");
		shipId.put("USS Benson","101164");
		shipId.put("USS Laffey","101174");
		shipId.put("USS Sims","101244");
		shipId.put("USS Hammann","101254");
		shipId.put("USS Eldridge","101264");
		shipId.put("USS Omaha","102014");
		shipId.put("USS Raleigh","102024");
		shipId.put("USS Brooklyn","102034");
		shipId.put("USS Phoenix","102044");
		shipId.put("USS Helena","102054");
		shipId.put("USS Atlanta","102064");
		shipId.put("USS Juneau","102074");
		shipId.put("USS San Diego","102084");
		shipId.put("USS Sandy","102084");
		shipId.put("USS Cleveland","102094");
		shipId.put("USS Columbia","102104");
		shipId.put("USS Pensacola","103014");
		shipId.put("USS Salt Lake City","103024");
		shipId.put("USS Northampton","103034");
		shipId.put("USS Chicago","103044");
		shipId.put("USS Houston","103054");
		shipId.put("USS Portland","103064");
		shipId.put("USS Indianapolis","103074");
		shipId.put("USS Astoria","103084");
		shipId.put("USS Quincy","103094");
		shipId.put("USS Vincennes","103104");
		shipId.put("USS Wichita","103114");
		shipId.put("USS Baltimore","103164");
		shipId.put("USS Nevada","105014");
		shipId.put("USS Oklahoma","105024");
		shipId.put("USS Pennsylvania","105034");
		shipId.put("USS Arizona","105044");
		shipId.put("USS Tennessee","105074");
		shipId.put("USS California","105084");
		shipId.put("USS Colorado","105094");
		shipId.put("USS Maryland","105104");
		shipId.put("USS West Virginia","105114");
		shipId.put("USS North Carolina","105124");
		shipId.put("USS Washington","105134");
		shipId.put("USS South Dakota","105144");
		shipId.put("USS New Jersey","105174");
		shipId.put("USS Long Island","106014");
		shipId.put("USS Bogue","106024");
		shipId.put("USS Langley","107014");
		shipId.put("USS Lexington","107024");
		shipId.put("USS Saratoga","107034");
		shipId.put("USS Ranger","107044");
		shipId.put("USS Yorktown","107054");
		shipId.put("USS Enterprise","107064");
		shipId.put("USS Hornet","107074");
		shipId.put("USS Wasp","107084");
		shipId.put("USS Vestal","112014");
		shipId.put("HMS Amazon","201014");
		shipId.put("HMS Acasta","201024");
		shipId.put("HMS Ardent","201034");
		shipId.put("HMS Beagle","201064");
		shipId.put("HMS Bulldog","201074");
		shipId.put("HMS Comet","201084");
		shipId.put("HMS Crescent","201094");
		shipId.put("HMS Cygnet","201104");
		shipId.put("HMS Foxhound","201114");
		shipId.put("HMS Fortune","201124");
		shipId.put("HMS Grenville","201134");
		shipId.put("HMS Glowworm","201144");
		shipId.put("HMS Hardy","201164");
		shipId.put("HMS Hunter","201204");
		shipId.put("HMS Javelin","201214");
		shipId.put("HMS Juno","201224");
		shipId.put("HMS Vampire","201234");
		shipId.put("HMS Leander","202014");
		shipId.put("HMS Achilles","202024");
		shipId.put("HMS Ajax","202034");
		shipId.put("HMS Dido","202044");
		shipId.put("HMS Southampton","202074");
		shipId.put("HMS Sheffield","202084");
		shipId.put("HMS Gloucester","202104");
		shipId.put("HMS Edinburgh","202114");
		shipId.put("HMS Belfast","202124");
		shipId.put("HMS Arethusa","202134");
		shipId.put("HMS Galatea","202144");
		shipId.put("HMS Aurora","202154");
		shipId.put("HMS London","203014");
		shipId.put("HMS Shropshire","203024");
		shipId.put("HMS Kent","203034");
		shipId.put("HMS Suffolk","203044");
		shipId.put("HMS Norfolk","203054");
		shipId.put("HMS Dorsetshire","203064");
		shipId.put("HMS York","203074");
		shipId.put("HMS Exeter","203084");
		shipId.put("HMS Renown","204014");
		shipId.put("HMS Repulse","204024");
		shipId.put("HMS Hood","204034");
		shipId.put("HMS Queen Elizabeth","205014");
		shipId.put("HMS Warspite","205024");
		shipId.put("HMS Nelson","205034");
		shipId.put("HMS Rodney","205044");
		shipId.put("HMS King George V","205054");
		shipId.put("HMS Prince of Wales","205064");
		shipId.put("HMS Duke of York","205074");
		shipId.put("HMS Vanguard","205134");
		shipId.put("HMS Hermes","206014");
		shipId.put("HMS Unicorn","206034");
		shipId.put("HMS Eagle","207014");
		shipId.put("HMS Ark Royal","207024");
		shipId.put("HMS Illustrious","207034");
		shipId.put("HMS Victorious","207044");
		shipId.put("HMS Formidable","207054");
		shipId.put("HMS Glorious","207064");
		shipId.put("HMS Erebus","213014");
		shipId.put("HMS Terror","213024");
		shipId.put("IJN Fubuki","301014");
		shipId.put("IJN Shirayuki","301024");
		shipId.put("IJN Ayanami","301054");
		shipId.put("IJN Akatsuki","301094");
		shipId.put("IJN Hibiki","301104");
		shipId.put("IJN Ikazuchi","301114");
		shipId.put("IJN Inazuma","301124");
		shipId.put("IJN Shiratsuyu","301134");
		shipId.put("IJN Yuudachi","301144");
		shipId.put("IJN Shigure","301154");
		shipId.put("IJN Yukikaze","301164");
		shipId.put("IJN Kagerou","301174");
		shipId.put("IJN Shiranui","301184");
		shipId.put("IJN Nowaki","301204");
		shipId.put("IJN Hatsuharu","301214");
		shipId.put("IJN Wakaba","301234");
		shipId.put("IJN Hatsushimo","301244");
		shipId.put("IJN Ariake","301254");
		shipId.put("IJN Yuugure","301264");
		shipId.put("IJN Kuroshio","301274");
		shipId.put("IJN Oyashio","301284");
		shipId.put("IJN Yuubari","302014");
		shipId.put("IJN Nagara","302044");
		shipId.put("IJN Isuzu","302054");
		shipId.put("IJN Yura","302074");
		shipId.put("IJN Kinu","302084");
		shipId.put("IJN Abukuma","302094");
		shipId.put("IJN Mogami","302104");
		shipId.put("IJN Mikuma","302114");
		shipId.put("IJN Furutaka","303014");
		shipId.put("IJN Kako","303024");
		shipId.put("IJN Aoba","303034");
		shipId.put("IJN Kinugasa","303044");
		shipId.put("IJN Chikuma","303064");
		shipId.put("IJN Myoukou","303074");
		shipId.put("IJN Nachi","303084");
		shipId.put("IJN Ashigara","303094");
		shipId.put("IJN Takao","303114");
		shipId.put("IJN Atago","303124");
		shipId.put("IJN Maya","303134");
		shipId.put("IJN Choukai","303144");
		shipId.put("IJN Kongou","304014");
		shipId.put("IJN Hiei","304024");
		shipId.put("IJN Haruna","304034");
		shipId.put("IJN Kirishima","304044");
		shipId.put("IJN Fusou","305014");
		shipId.put("IJN Yamashiro","305024");
		shipId.put("IJN Ise","305034");
		shipId.put("IJN Hyuuga","305044");
		shipId.put("IJN Nagato","305054");
		shipId.put("IJN Mutsu","305064");
		shipId.put("IJN Kii","305124");
		shipId.put("IJN Tosa","305084");
		shipId.put("IJN Hiyou","306014");
		shipId.put("IJN Junyou","306024");
		shipId.put("IJN Houshou","306034");
		shipId.put("IJN Shouhou","306054");
		shipId.put("IJN Ryujou","306064");
		shipId.put("IJN Ryuujou","306064");
		shipId.put("IJN Akagi","307014");
		shipId.put("IJN Kaga","307024");
		shipId.put("IJN Souryuu","307034");
		shipId.put("IJN Hiryuu","307044");
		shipId.put("IJN Shoukaku","307054");
		shipId.put("IJN Zuikaku","307064");
		shipId.put("IJN Taihou","307074");
		shipId.put("IJN Shinano","307084");
		shipId.put("IJN Akashi","312014");
		shipId.put("KMS Leberecht Maass","401014");
		shipId.put("KMS Z23","401234");
		shipId.put("KMS Z25","401254");
		shipId.put("KMS Konigsberg","402014");
		shipId.put("KMS Karlsruhe","402024");
		shipId.put("KMS Koln","402034");
		shipId.put("KMS Leipzig","402044");
		shipId.put("KMS Admiral Hipper","403014");
		shipId.put("KMS Blucher","403024");
		shipId.put("KMS Prinz Eugen","403034");
		shipId.put("KMS Deutschland","403044");
		shipId.put("KMS Admiral Graf Spee","403054");
		shipId.put("KMS Scharnhorst","404014");
		shipId.put("KMS Gneisenau","404024");
		shipId.put("KMS Bismarck","405014");
		shipId.put("KMS Tirpitz","405024");
		shipId.put("KMS Graf Zeppelin","407014");
		shipId.put("PRAN An shan","501014");
		shipId.put("PRAN Fu shun","501024");
		shipId.put("PRAN Chang Chun","501034");
		shipId.put("PRAN Tai Yuan","501044");
		shipId.put("ROC Yat Sen","502014");
		shipId.put("ROC Ning Hai","502024");
		shipId.put("ROC Ping Hai","502034");
		shipId.put("SN Avrora","702014");
		shipId.put("USS Bailey","101274");
		shipId.put("KMS Hermann Künne","401194");
		shipId.put("KMS Z19","401194");
		shipId.put("KMS Karl Galster","401204");
		shipId.put("KMS Z20","401204");
		shipId.put("KMS Wilhelm Heidkamp","401214");
		shipId.put("KMS Z21","401214");
		shipId.put("KMS Z46","401464");
		shipId.put("IJN Shimakaze","301294");
		shipId.put("IJN Kamikaze","301304");
		shipId.put("IJN Matsukaze","301314");
		shipId.put("IJN Mutsuki","301324");
		shipId.put("IJN Kisaragi","301334");
		shipId.put("IJN Uzuki","301354");
		shipId.put("IJN Minazuki","301374");
		shipId.put("IJN Fumizuki","301384");
		shipId.put("IJN Nagatsuki","301394");
		shipId.put("IJN Mikazuki","301414");
		shipId.put("IJN Umikaze","301474");
		shipId.put("IJN Yamakaze","301484");
		shipId.put("IJN Kawakaze","301494");
		shipId.put("IJN Kiyonami","301544");
		shipId.put("IJN Niizuki","301564");
		shipId.put("IJN Harutsuki","301574");
		shipId.put("IJN Yoizuki","301584");
		shipId.put("USS Radford","101294");
		shipId.put("USS Jenkins","101304");
		shipId.put("USS Nicholas","101314");
		shipId.put("USS Richmond","102114");
		shipId.put("USS Honolulu","102124");
		shipId.put("USS St.Louis","102134");
		shipId.put("HMS Jupiter","201244");
		shipId.put("HMS Jersey","201254");
		shipId.put("IJN Sendai","302124");
		shipId.put("IJN Jintsuu","302134");
		shipId.put("IJN Naka","302144");
		shipId.put("IJN Urakaze","301594");
		shipId.put("IJN Isokaze","301604");
		shipId.put("IJN Hamakaze","301614");
		shipId.put("IJN Tanikaze","301624");
		shipId.put("IJN Mikasa","305114");
		shipId.put("IJN Agano","302204");
		shipId.put("IJN Noshiro","302214");
		shipId.put("HMS Matchless","201264");
		shipId.put("HMS Musketeer","201274");
		shipId.put("HMS Fiji","202164");
		shipId.put("HMS Jamaica","202174");
		shipId.put("USS Montpelier","102144");
		shipId.put("USS Denver","102154");
		shipId.put("IJN Asashio","301634");
		shipId.put("IJN Ooshio","301644");
		shipId.put("IJN Michishio","301654");
		shipId.put("IJN Arashio","301664");
		shipId.put("HMS Belfast","202184");
		shipId.put("HMS Abercrombie","213044");
		shipId.put("HMS Sussex","203094");
		shipId.put("IJN I19","308014");
		shipId.put("IJN I26","308024");
		shipId.put("IJN I58","308034");
		shipId.put("KMS U-81","408014");
		shipId.put("USS Dace","108014");
		shipId.put("KMS U-47","408024");
		shipId.put("KMS U-557","408034");
		shipId.put("KMS Z35","401354");
		shipId.put("KMS Hans Lüdemann","401184");
		shipId.put("KMS Z18","401184");	
		shipId.put("FFNF Le Triomphant","801014");
		shipId.put("FFNF Forbin","801024");
		shipId.put("FFNF Émile Bertin","802014");
		shipId.put("FFNF Surcouf","808014");
		shipId.put("MNF Le Mars","901014");
		shipId.put("MNF Dunkerque","904014");
		shipId.put("MNF Jean Bart","905014");
		shipId.put("USS Massachusetts","105194");
		shipId.put("USS Bush","101334");
		shipId.put("HMS Centaur","206044");
		shipId.put("USS Essex","107094");
		shipId.put("USS Albacore","108024");
		shipId.put("FFNF Le Téméraire","801034");
		shipId.put("USS Memphis","102164");
		shipId.put("HMS Newcastle","202194");
		shipId.put("USS Hobby","101364");
		shipId.put("USS Kalk","101374");
		shipId.put("USS Minneapolis","103134");
		shipId.put("USS Hazelwood","101344");
		shipId.put("USS Concord","102184");
		shipId.put("IJN Amagi","304054");
		shipId.put("IJN Kaga","305074");
		shipId.put("IJN Hatakaze","301794");
		shipId.put("IJN Makinami","301804");
		shipId.put("HMS Sirius","202204");
		shipId.put("HMS Curacoa","202214");
		shipId.put("HMS Curlew","202224");
		shipId.put("USS Kimberly","101384");
		shipId.put("USS Mullany","101394");
		shipId.put("HMS Chaser","206054");
		shipId.put("USS Independence","107224");
		shipId.put("USS Shangri-La","107384");
		shipId.put("KMS Georg Thiele","401024");
		shipId.put("KMS Z2","401024");
		shipId.put("USS Bunker Hill","107174");
		shipId.put("IJN I13","317014");
		shipId.put("IJN Suzuya","303174");
		shipId.put("IJN Hiei","304064");
		shipId.put("IJN Akagi","307094");
		shipId.put("KMS Graf Zeppelin","407024");
		shipId.put("KMS U-556","408044");
		shipId.put("KMS U-73","408054");
		shipId.put("KMS Z36","401364");
		shipId.put("HMS Echo","201294");
		shipId.put("USS Helena","102194");
		shipId.put("USS Cleveland","102204");
		shipId.put("USS Li'l Sandy","102214");
		shipId.put("HMS Swiftsure","202234");
		shipId.put("MNF Le Malin","901114");
		shipId.put("FFNF L'Opiniatre","801044");
		shipId.put("IJN I25","308044");
		shipId.put("IJN I56","308054");
		shipId.put("IJN I168","308064");
		shipId.put("KMS U-101","408064");
		shipId.put("KMS U-522","408074");
		shipId.put("USS Alabama","105204");
		shipId.put("USS Cavalla","108034");
		shipId.put("USS Bataan","107294");
		shipId.put("USS San Juan","102224");
		shipId.put("USS Birmingham","102234");
		shipId.put("USS Aylwin","101404");
		shipId.put("USS Bache","101354");
		shipId.put("HMS Black Prince","202244");
		shipId.put("USS Stanly","101414");
		shipId.put("RN Littorio","605024");
		shipId.put("RN Conte di Cavour","605054");
		shipId.put("RN Giulio Cesare","605064");
		shipId.put("RN Zara","603024");
		shipId.put("RN Trento","603014");
		shipId.put("RN Carabiniere","601024");
		shipId.put("KMS U-110","408084");
		shipId.put("USS Smalley","101424");
		shipId.put("MNF Gascogne","905034");
		shipId.put("IJN Akagi","307104");
		shipId.put("USS Cleveland","102244");
		shipId.put("HMS Sheffield","202254");
		shipId.put("KMS Admiral Hipper","403074");
		shipId.put("HMS Glasgow","202264");
		shipId.put("IJN Kasumi","301814");
		shipId.put("IJN Suruga","305144");
		shipId.put("IJN Ryuhou","306074");
		shipId.put("USS Halsey Powell","101434");
		shipId.put("USS Biloxi","102254");
		shipId.put("IJN Uranami","301724");
		shipId.put("SN Grozny","701024");
		shipId.put("SN Minsk","701034");
		shipId.put("SN Tashkent","701044");
		shipId.put("SN Pamiat' Merkuria","702024");
		shipId.put("SN Kirov","702044");
		shipId.put("SN Chapayev","702034");
		shipId.put("SN Gangut","705014");
		shipId.put("SN Sovetskaya Belorussiya","705044");
		shipId.put("SN Sovetskaya Rossiya","705054");
		shipId.put("USS Intrepid","107114");
		shipId.put("USS Bremerton","103244");
		shipId.put("USS Cooper","101444");
		shipId.put("USS Reno","102264");
		shipId.put("USS Bluegill","108044");
		shipId.put("USS Casablanca","106554");
		shipId.put("USS Marblehead","102274");
		shipId.put("IJN Hanazuki","301824");
		shipId.put("IJN Naganami","301834");
		shipId.put("HMS Renown","204044");
		shipId.put("MNF Tartu","901024");
		shipId.put("FFNF Richelieu","805014");
		shipId.put("FFNF Jeanne d'Arc","802024");
		shipId.put("MNF Algérie","903024");
		shipId.put("MNF La Galissonnière","902014");
		shipId.put("MNF Vauquelin","901034");
		shipId.put("FFNF Bearn","807014");
		shipId.put("HMS Illustrious","207094");
		shipId.put("HMS Eskimo","201324");
		shipId.put("HMS Howe","205094");
		shipId.put("HMS Perseus","206064");
		shipId.put("HMS Hermione","202274");
		shipId.put("HMS Valiant","205104");
		shipId.put("HMS Icarus","201334");
		shipId.put("KMS Z26","401264");
		shipId.put("KMS U-96","408094");
		shipId.put("IJN Suzutsuki","301844");
		shipId.put("IJN Kumano","303184");
		shipId.put("IJN Chitose","306084");
		shipId.put("IJN Chiyoda","306094");
		shipId.put("IJN Kashino","319014");
		shipId.put("USS Princeton","107234");
		shipId.put("IJN Taihou","307114");
		shipId.put("SN Tashkent","701054");
		shipId.put("HMS Dido","202284");
		shipId.put("USS Albacore","108054");
		shipId.put("USS Baltimore","103254");
		shipId.put("KMS Roon","403084");
		shipId.put("HMS Illustrious","207114");
		shipId.put("MNF Le Malin","901124");
		shipId.put("KMS Peter Strasser","407034");
		shipId.put("KMS Prinz Heinrich","403094");
		shipId.put("KMS U-37","408104");
		shipId.put("KMS Weser","406014");
		shipId.put("KMS Nurnberg","402054");
		shipId.put("KMS Z24","401244");
		shipId.put("KMS Z28","401284");
		shipId.put("RN Pola","603034");
		shipId.put("RN Vincenzo Gioberti","601034");
		shipId.put("SN Stremitelny","701064");
		shipId.put("KMS U-410","408114");
		shipId.put("ROC Ying Swei","502044");
		shipId.put("ROC Chao Ho","502054");
		shipId.put("HMS Penelope","202294");
		shipId.put("SN Tallinn","703014");
		shipId.put("SN Gremyashchy","701074");
		shipId.put("SN Murmansk","702064");
		shipId.put("SN Gromky","701084");
		shipId.put("RN Vittorio Veneto","605014");
		shipId.put("RN Duca degli Abruzzi","602014");
		shipId.put("RN Aquila","607014");
		shipId.put("RN Torricelli","608014");
		shipId.put("RN Maestrale","601044");
		shipId.put("RN Libeccio","601054");
		shipId.put("RN Nicoloso da Recco","601064");
		shipId.put("IJN Oite","301854");
		shipId.put("USS Allen M. Sumner ","101454");
		shipId.put("USS Stephen Potter","101464");
		shipId.put("IJN Amagi","304074");
		shipId.put("USS Ticonderoga","107144");
		shipId.put("USS San Francisco","103144");
		shipId.put("USS Archerfish","108064");
		shipId.put("USS Boise","102294");
		shipId.put("USS Morrison","101474");
		shipId.put("USS Enterprise","107994");
		shipId.put("IJN Kazagumo","301864");
		shipId.put("USS Ingraham","101484");
		shipId.put("USS Nautilus ","108074");
		shipId.put("IJN Katsuragi","307124");
		shipId.put("USS New Orleans","103124");
		shipId.put("FFNF Le Terrible","801074");
		shipId.put("FFNF Maille Breze","801084");
		shipId.put("MNF Foch","903014");
		shipId.put("KMS Magdeburg","402064");
		shipId.put("KMS Elbe","406024");
		shipId.put("KMS Prinz Adalbert","403104");
		shipId.put("KMS U-1206","408124");
		shipId.put("KMS Ulrich von Hutten","405034");
		shipId.put("HMS Charybdis","202304");
		shipId.put("Hai Tien","502074");
		shipId.put("Hai Chi","502084");
		shipId.put("USS Bristol","101494");
		shipId.put("Chen Hai","506014");
		shipId.put("SN Kiev","701104");
		shipId.put("SN Arkhangelsk","705064");
		shipId.put("SN Soobrazitelny","701094");
		shipId.put("SN Volga","707014");
		shipId.put("SN Kronshtadt","718014");
		shipId.put("RN Impero","607024");
		shipId.put("RN Pompeo Magno","601074");
		shipId.put("RN Trieste","603044");
		shipId.put("SMS Seydlitz","404034");
		shipId.put("SMS Lutzow","404044");
		shipId.put("SMS Thuringen","405044");
		shipId.put("SMS Yorck","403114");
		shipId.put("SMS Emden","402074");
		shipId.put("SMS Elbing","402084");
		shipId.put("KMS Prinz Eugen","403124");
		shipId.put("HMS Jervis","201344");
		shipId.put("HMS Bellona ","202314");
		shipId.put("HMS Cheshire","203104");
		shipId.put("HMS Indomitable","207124");
		shipId.put("HMS Revenge","205114");
		shipId.put("MNF Joffre","907014");
		shipId.put("MNF L'Indomptable","901134");
		shipId.put("HMS Enterprise","202324");
		shipId.put("RN Leonardo da Vinci","608024");
		shipId.put("RN Giuseppe Garibaldi","602024");
		shipId.put("RN Bolzano","603054");
		shipId.put("RN Roma","605034");
		shipId.put("RN Alfredo Oriani","601084");
		shipId.put("RN Emanuele Pessagno","601094");
		shipId.put("KMS Friedrich Eckoldt","401164");
		shipId.put("KMS Z16","401164");
		shipId.put("KMS Brunhilde","404054");
		shipId.put("HDN Neptune","10100014");
		shipId.put("HDN Noire","10100024");
		shipId.put("HDN Blanc","10100034");
		shipId.put("HDN Vert","10100044");
		shipId.put("HDN Purple Heart","10100054");
		shipId.put("HDN Black Heart","10100064");
		shipId.put("HDN White Heart","10100074");
		shipId.put("HDN Green Heart","10100084");
		shipId.put("BILI 22","10200014");
		shipId.put("BILI 33","10200024");
		shipId.put("Kuon","10300014");
		shipId.put("Nekone","10300024");
		shipId.put("Rurutie","10300034");
		shipId.put("Uruuru","10300044");
		shipId.put("Saraana","10300054");
		shipId.put("Fumiruiru","10300064");
		shipId.put("KizunaAI","10400014");
		shipId.put("KizunaAI·Elegant","10400024");
		shipId.put("KizunaAI·Anniversary","10400034");
		shipId.put("KizunaAI·SuperGamer","10400044");
		shipId.put("Shirakami Fubuki ","10500014");
		shipId.put("Tokino Sora ","10500024");
		shipId.put("Minato Aqua ","10500034");
		shipId.put("Natsuiro Matsuri ","10500044");
		shipId.put("Nakiri Ayame ","10500054");
		shipId.put("Murasaki Shion ","10500064");
		shipId.put("Okami Mio ","10500074");
		shipId.put("Marie Rose","10600014");
		shipId.put("Honoka","10600024");
		shipId.put("Kasumi","10600034");
		shipId.put("Misaki","10600044");
		shipId.put("Nagisa","10600054");
		shipId.put("Nyotengu","10600064");
		shipId.put("Monica","10600074");
		shipId.put("Amami Haruka","10700014");
		shipId.put("Kisaragi Chihaya","10700024");
		shipId.put("Minase Iori","10700034");
		shipId.put("Miura Azusa","10700044");
		shipId.put("Akizuki Ritsuko","10700054");
		shipId.put("Futami Ami","10700064");
		shipId.put("Futami Mami","10700074");
		shipId.put("Takarada Rikka ","10800014");
		shipId.put("Shinjo Akane ","10800024");
		shipId.put("Hass ","10800034");
		shipId.put("Namiko","10800044");
		shipId.put("Minami Yume ","10800054");
		shipId.put("Asukagawa Chise ","10800064");
		shipId.put("Mujina ","10800074");
		shipId.put("HMS Neptune","299014");
		shipId.put("HMS Monarch","299024");
		shipId.put("IJN Ibuki","399014");
		shipId.put("IJN Izumo","399024");
		shipId.put("KMS Roon","499014");
		shipId.put("FFNF Saint-Louis","899014");
		shipId.put("USS Seattle","199014");
		shipId.put("USS Georgia","199024");
		shipId.put("IJN Kitakaze","399034");
		shipId.put("IJN Azuma","399044");
		shipId.put("KMS Friedrich der Grosse","499024");
		shipId.put("MNF Gascogne","999014");
		shipId.put("HMS Cheshire","299034");
		shipId.put("HMS Drake","299044");
		shipId.put("KMS Mainz","499034");
		shipId.put("KMS Odin","499044");
		shipId.put("FFNF Champagne","899024");
		shipId.put("USS Anchorage ","199034");
		shipId.put("IJN Hakuryū","399054");
		shipId.put("KMS Agir","499054");
		shipId.put("KMS August von Parseval","499064");
		shipId.put("RN Marco Polo","699014");
		shipId.put("HMS Plymouth","299054");
		shipId.put("KMS Prinz Rupprecht","499074");
		shipId.put("PRAN Harbin","599014");
		shipId.put("SN Chkalov","799014");
		shipId.put("FFNF Brest","899034");
		shipId.put("Hiryuu META","9707014");
		shipId.put("Ark Royal META","9707024");
		shipId.put("Helena META","9702014");
		shipId.put("Souryuu META","9707034");
		shipId.put("Fusou META","9705014");
		shipId.put("Hiyou META","9706014");
		shipId.put("Gneisenau META","9704014");
		shipId.put("Junyou META","9706024");
		shipId.put("Scharnhorst META","9704024");
		shipId.put("Yamashiro META","9705024");
		shipId.put("Memphis META","9702024");
		shipId.put("Repulse META","9704034");
		shipId.put("Terento META","9703014");
		shipId.put("Musashi","305104");
		shipId.put("Wakatsuki","301884");
		shipId.put("Sakawa","302234");
		shipId.put("Haguro","303104");
		shipId.put("Miyuki","301044");
		shipId.put("Hunter META","9701014");
		shipId.put("Little Spee","403134");
		shipId.put("Albion","206074");
		shipId.put("Janus","201354");
		shipId.put("Royal Fortune","9600014");
		shipId.put("Manchester","202094");
		shipId.put("Fortune META","9701024");
		shipId.put("Reisalin Stout","10900014");
		shipId.put("Ryza","10900014");
		shipId.put("Klaudia Valentz","10900024");
		shipId.put("Patricia Abelheim","10900034");
		shipId.put("Kala Ideas","10900064");
		shipId.put("Lila Decyrus","10900044");
		shipId.put("Serri Glaus","10900054");
		shipId.put("Arizona META","9705034");
		shipId.put("Hammann II","101504");
		shipId.put("Hornet II","107124");
		shipId.put("Langley II","107274");
		shipId.put("Yorktown II","107104");
		shipId.put("Northampton II","103264");
		shipId.put("Kuybyshev","702054");
		shipId.put("Theseus","206084");
		shipId.put("Hwah Jah","506024");
		shipId.put("Ting An","519014");
		shipId.put("Sheffield META","9702034");
		shipId.put("Implacable", "207074");
		shipId.put("Royal Oak", "205144");
		shipId.put("Scylla", "202334");
		shipId.put("Argus", "206024");
		shipId.put("Hero", "201364");
		shipId.put("Queen Elizabeth.META", "9705044");
		shipId.put("Voroshilov", "702074");
		shipId.put("Kursk", "703024");
		shipId.put("Sevastopol", "705074");
		shipId.put("La Galissonnière.META", "9702044");
		shipId.put("La Galissonniere META", "9702044");
		shipId.put("Luna", "10600084");
		shipId.put("Tamaki", "10600094");
		shipId.put("Little Formidable", "207134");
		shipId.put("smol formi", "207134");
		shipId.put("Otto von Alvensleben", "401994");
		shipId.put("Bismarch Zwei", "405054");
		shipId.put("Bis2", "405054");
		shipId.put("Regensburg", "402104");
		shipId.put("Jade", "406034");
		shipId.put("U556.META", "9708014");
		shipId.put("U556 META", "9708014");
		shipId.put("Vestal.META", "9712014");
		shipId.put("Vestal META", "9712014");
		shipId.put("taihou-chan", "307134");
		shipId.put("smol taihou", "307134");
		shipId.put("Algérie.META", "9703024");
		shipId.put("Attilio Regolo", "601104");
		shipId.put("Gorizia", "603064");
		shipId.put("Andrea Doria", "605074");
		shipId.put("Kearsarge", "199044");
		shipId.put("Shimanto", "399064");
		shipId.put("Felix Schultz", "499084");
		shipId.put("Hindenburg", "499094");
		shipId.put("Flandre", "999024");
		
		shipId.put("Hatakaze.META", "9701034");
		shipId.put("Hatakaze META", "9701034");
		shipId.put("Nidaime", "10800084");
		shipId.put("2nd", "10800084");
		shipId.put("Hime", "10800094");
		shipId.put("Princess", "10800094");
		shipId.put("Marseillaise", "902024");

		
	}
	
	public static String getShipID(String name) {
		LinkedList<String> candidates = new LinkedList<String>();
		Iterator s = shipId.keySet().iterator();
		while (s.hasNext()) {
			String current = (String) s.next();
			if(current.toLowerCase().contains(name.toLowerCase())) {
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