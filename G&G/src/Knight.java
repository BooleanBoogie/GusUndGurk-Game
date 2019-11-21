
public class Knight extends Character {
	//Sub-Constructor: (AD: 800) (HP: 20000) (ACC: 90%) (N: Knight) 
	public Knight() {
		super(800, 20000, 0.9, 5, 0, "Knight", 1);
	}

	//starting inventory
	private int numberOfPotions = 2;

	//Attacks
	public void attack(Character enemy) {
		if (Math.random() < getAccuracy()) {
			enemy.subtractHP(getAttackDamage());
			System.out.println("\n"+getName()+" slices "+enemy.getName()+" with his longsword!\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
		else 
			System.out.println(getName()+" slashes wildly, but misses "+enemy.getName()+".\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
	}

	public void strongAttack(Character enemy) {
		if ((Math.random()*2) < getAccuracy()) {
			enemy.subtractHP(getAttackDamage()*2);
			System.out.println(getName()+" stabs forward into "+enemy.getName()+"!\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
		else 
			System.out.println(getName()+" slashes wildly, but misses "+enemy.getName()+".\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");	
	}

	public boolean specialOne(Character enemy) {
		if (specialCounter >= specialMax) {
			enemy.subtractHP(getAttackDamage()*3);
			System.out.println(getName()+" uses Super Slash! \n\n" + getName()+" leaps into the air, somersaults, \nand smashes his silver blade into "+ enemy.getName()+".\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
			specialCounter = 0;
			return true;
		}
		else {
			System.out.println("Super Slash is not ready yet! "+(5-specialCounter)+" turns left.\n");
			return false;
		}
	}

	//defense moves 
	public boolean inventory() {
		if (numberOfPotions>0) {
			subtractHP(-1600);
			System.out.println(getName()+" used a health potion! 1600 HP restored!\n\n" + getName()+"'s HP: "+getHP()+"\n");
			numberOfPotions--;
			return true;
		}
		else {
			System.out.println("There is nothing in your inventory.\n");
			return false;
		}
	}

	public boolean specialTwo(Character enemy) {
		if (Math.random() < .2) {
			System.out.println(getName()+" used RAGE! Attack damage permenantly doubled!");
			changeAttackDamage(getAttackDamage()*2);
			return true;
		}
		else {
			System.out.println(getName()+" is just not angry enough! Rage failed.");
			return true;
		}
	}
}
