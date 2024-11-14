import json
import os.path

f = open('ship_data_statistics.json', "r", encoding="utf8")
f2 = open('ship_data_template.json',"r", encoding="utf8")
data = json.load(f)
template = json.load(f2)

output = open("idList.txt","w", encoding="utf8")

slist = []
skip = [202284,207114,901124,403084,307114,701054,108054,103254,307104,9002034,403074,102244,102204,202184,207134,
		203104,403124,107994,403134,204044,407024,307094,304064,304074,403154,302244,102324,304084,801094,307144,
		405064,102214,30715]

slist.append('UNIV Universal Bulin, 100001')
slist.append("UNIV Trial Bulin MKII, 100011")
slist.append("UNIV Specialized Bulin Custom MKIII, 100021")

slist.append("Dido μ, 20228")
slist.append("Illustrious µ, 20711")
slist.append("Le Malin µ, 90112")
slist.append("Roon µ, 40308")
slist.append("Taihou µ, 30711")
slist.append("Tashkent µ, 70105")
slist.append("Albacore µ, 10805")
slist.append("Baltimore µ, 10325")
slist.append("Akagi µ, 30710")
slist.append("Gascogne µ, 900203")
slist.append("Admiral Hipper µ, 40307")
slist.append("Cleveland µ, 10224")
slist.append("Illustrious µ, 20711")
slist.append("Formidable μ, 20714")
slist.append("Prinz Eugen μ, 40315")
slist.append("Noshiro μ, 30224")
slist.append("Boise μ, 10232")
slist.append("Kongou μ, 30408")
slist.append("Le Téméraire μ, 80109")

slist.append("Clevelad, 10220")
slist.append("Li'l Sandy, 10221")
slist.append("Little Bel, 20218")
slist.append("Little Formidable, 20713")
slist.append("Little Cheshire, 20310")
slist.append("Little Prinz Eugen, 40312")
slist.append("Little Enterprise, 10799")
slist.append("Little Spee, 40313")
slist.append("Little Illustrious, 20709")
slist.append("Little Friedrich, 40506")
slist.append("Little Renown, 20404")
slist.append("Zeppy, 40702")
slist.append("Akagi-chan, 30709")
slist.append("Hiei-chan, 30406")
slist.append("Amagi-chan, 30407")
slist.append("Shinano-chan, 30714")
slist.append("Amagi (CV), 30715")

for x in range(100004,900000,10):
	if x in skip:
		continue;
	if str(x) in data:
		ship = data[str(x)]
		slist.append(ship["english_name"]+","+str(template[str(x)]["group_type"]))

for y in range(901014,21000074,10):
	if y in skip:
		continue;
	if str(y) in data:
		ship = data[str(y)]
		slist.append(ship["english_name"]+","+str(template[str(y)]["group_type"]))

slist = list(dict.fromkeys(slist))

for lines in slist:
	output.write(f"{lines}\n")

f.close()
f2.close()
output.close()