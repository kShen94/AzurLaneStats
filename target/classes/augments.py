import json
import os.path

f = open('spweapon_data_statistics.json', "r", encoding="utf8")
data = json.load(f)

output = open("augmentMap.txt","w", encoding="utf8")

auglist = []
auglist.append("10002,9036,9037")

for x in range(10000,200000,10):
	if str(x) in data:
		aug = data[str(x)]
		if aug["skill_upgrade"][0][0] != 0:
			auglist.append(str(data[str(x-10)]["unique"])+","+str(aug["skill_upgrade"][0][0])+ ","+str(aug["skill_upgrade"][0][1]))

auglist = list(dict.fromkeys(auglist))

for lines in auglist:
	output.write(f"{lines}\n")

f.close()
output.close()