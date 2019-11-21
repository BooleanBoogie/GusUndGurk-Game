public class Berserker extends Character {

	public Berserker() {
		super(1600, 8000, 1, 0, 0, "Berserker", 3);
	}
	
	//starting inventory
	//None
	
	//Attacks
	public void attack(Character enemy) {
		//verschiedene attacks 
		if (Math.random() < 0.3) {
		System.out.println(getName()+" hacks at "+enemy.getName()+" with his battleaxe.");
		enemy.subtractHP(getAttackDamage());
		}
		
		else if (Math.random() < 0.6) {
		System.out.println(getName()+" whacks his axe into "+enemy.getName());
		enemy.subtractHP(getAttackDamage());
		}
		else {
		System.out.println(getName()+" slices into "+enemy.getName()+"'s armor!");
		}
	}
	
	public void strongAttack(Character enemy) {
		if (Math.random() < 0.5) {
			System.out.println(getName()+" hacks at "+enemy.getName()+" with its battle axe, doing some major damage!!");
			enemy.subtractHP(getAttackDamage()*2);
			System.out.println(enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
		else {
			System.out.println(getName()+" narrowly misses "+enemy.getName()+".\n");	
			System.out.println(enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
	}
	//bloodlust
	public boolean specialOne(Character enemy) {
		if (getHP() <= 2000) {
			System.out.println(getName()+"'s bloodlust was activated! All damage dealt is doubled!");
			enemy.changeAttackDamage(getAttackDamage() * 2);
			System.out.println(enemy.getName()+"'s HP: " + enemy.getHP() + "\n");
			return true;
		}
		else {
			System.out.println("Bloodlust is not ready yet! Wait until HP is below 2000.");
			return false;
		}
	}
	
	//inventory
	public boolean inventory() {
		System.out.println("There is nothing in your inventory.");
		return false;
	}
	
	//self-medication
	public boolean specialTwo(Character enemy) {
		changeAttackDamage(getAttackDamage() / 2);
		subtractHP(-2000);
		System.out.println(getName()+" uses Self-Medication! 2000 HP regained! Attack damage is now halved.");
		System.out.println("Current Attack Damage: " + getAttackDamage());
		System.out.println("HP: " + getHP());
		return true;
	}
}
