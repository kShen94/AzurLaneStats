package stats;

public class ShipBuilder {
	
	ShipStats ship;
	String groupid;
	String id;
	
	
	public ShipBuilder (String shipName,boolean retroFlag, boolean augment) {
		ship = new ShipStats();
		groupid = ShipIds.getShipID(shipName) ;
		id = groupid+"4";
		ship.setRetroTrue(retroFlag);
		if(id != null) {
			ship.getShipStats(id);
			id = ship.getID();
			Abilities skills = new Abilities(Integer.parseInt(id),groupid,augment);
			ship.addAbility(skills);
		} else {
			System.out.println("Check name or files");
		}
		
	}
	
	public ShipStats getShip() {
		return ship;
	}
}
