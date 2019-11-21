public abstract class Character {

	private int attackDamage;
	private int health;
	private double accuracy;
	private String name;
	private int ID;
	protected boolean Amulet = false;
	protected int specialCounter = 0;
	protected double specialMax;
	protected int special2Counter = 0;
	protected double special2Max;
	//constructor
	public Character(int attackDamage, int health, double accuracy, double specialMax, double special2Max, String name, int ID) {	
		this.attackDamage = attackDamage;
		this.health = health;
		this.accuracy = accuracy;
		this.specialMax = specialMax;
		this.special2Max = special2Max;
		this.name = name;
		this.ID = ID;
	}

	//attack
	public abstract void attack(Character enemy);

	public abstract void strongAttack(Character enemy );

	public abstract boolean specialOne(Character enemy);

	public abstract boolean specialTwo(Character enemy);

	public abstract boolean inventory();

	//accessor methods
	public String getName() {
		return name;
	}

	public int getHP() {
		return health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public double getAccuracy() {
		return accuracy;
	}
	
	public double getSpecialMax() {
		return specialMax;
	}
	
	public double getSpecial2Max() {
		return special2Max;
	}

	public int ID() {
		return ID;
	}

	public boolean getAmulet() {
		return Amulet;
	}

	//mutator methods
	public void subtractHP(int damage) {
		health -= damage;
	}

	public void setHP(int newHP) {
		health = newHP;
	}

	public void changeName(String newname) {
		name = newname;
	}

	public void changeAttackDamage(int newDamage) {
		attackDamage = newDamage;
	}

	public void divideAccuracy(double divisor) {
		accuracy /= divisor;
	}

	public void specialCounterBigger() {
		specialCounter++;
	}

	//amulet stuff

	public void setAmulet() {
		Amulet = !(Amulet);
	}

	public void useAmulet() {
		if (Amulet = true) {
			System.out.println(getName() + "'s amulet was activated! " + getName() + " was revived with full HP!");
			Amulet = false;
			setHP(5000);
		}
	}
}

