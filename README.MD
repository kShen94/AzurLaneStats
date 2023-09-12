# Azur Lane Stats

This is a tool made to assist with Azur Lane datamining, particularly barrage and weapon info.

# Usage

This application is compiled on Java JDK 17.0.1.
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

# TODO

- add functionality for shrapnels
- add enhancement stats for META ships
- add more info to notes section
- change json file directories so they can be used from outside the application or add ability to pull files from data repository
