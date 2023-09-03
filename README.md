# AzurLaneStats

This is a tool made to assist with Azur Lane datamining, particularly barrage and weapon info.

# Usage

This application is compiled on Java JDK 17.0.1 and requires JRE 17 or above.
This application is dependent on org.json library, you can find the jar at 
https://github.com/stleary/JSON-java

You will need both jars in the same directory.

To run the application:

`java -jar ALStats [options] <args>...`

```
ALStats -s <shipName> [options] <args>
or ALStats -b <buffID>
or ALStats -w <weaponID>

Options:
-l <level> --default 125
-aff <affection> --default 100
-retro <true/false> --default true,returns retrofit stats if applicable
```
