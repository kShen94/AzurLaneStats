package stats;

public class SlashWeapon extends Weapons{
	String skillId;
	int paramA;
	int paramB;
	double lifeTime;
	String moveType;
	int range;
	int speed;
	
	public SlashWeapon(String id,int A,int B,double lifeTime, int moveType, int range, int speed) {
		super();
		this.skillId = id;
		this.paramA = A; 
		this.paramB = B;
		this.lifeTime = lifeTime;
		if(moveType == 1)
			this.moveType = "Following";
		else if(moveType == 2)
			this.moveType = "Projectile";
		else
			this.moveType = moveType+"";
		this.range = range;
		this.speed = speed; 		
	}
	
	public void printWeapon(boolean printExcel) {
		System.out.println("-----------------------------------------------");
		System.out.println("Slash skillID: " + skillId);
		System.out.println("ParamA: " + paramA);
		System.out.println("ParamB: " + paramB);
		System.out.println("LifeTime: " + lifeTime);
		System.out.println("moveType: " + moveType);
		System.out.println("range: " + range);
		System.out.println("speed: " + speed);
		System.out.println("damage: level * " + paramB + " + " + paramA);
		if(printExcel)
			printExcel(false,null,0);
	}
	
	protected void printExcel(boolean isPlane, Bullets b, int planeCount) {
		System.out.println("excel : --------------");
		System.out.println(skillId+"\t\t\t\t\t\t\t\t\t\t\t"+createNote()+"\t\t\t\t");
	}
	private String createNote() {
		String note;
		note = "Slash, dmg: level * "+paramB+" + "+paramA+", "+moveType+", "+range+" width, "+ speed+" speed";
		return note;
	}
}
