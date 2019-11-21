public class HighElf extends Character{
	
	public HighElf() {
		super(800, 20000, 0.9, 8, 4, "High Elf", 5);
	}

	//starting inventory
	private boolean Ambrosia = true;

	//Attacks
	public void attack(Character enemy) {
		if (Math.random() < getAccuracy()) {
			enemy.subtractHP(getAttackDamage());
			System.out.println("\n"+getName()+" shoots "+enemy.getName()+" with it's longbow!\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
		else 
			System.out.println(getName()+" misses "+enemy.getName()+" by a few inches.\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
	}

	public void strongAttack(Character enemy) {
		if ((Math.random()*2) < getAccuracy()) {
			enemy.subtractHP(getAttackDamage()*2);
			System.out.println(getName()+" stabs forward into "+enemy.getName()+" with it's silvery knife!\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
		else 
			System.out.println(getName()+" slashes towards "+enemy.getName()+" but misses.\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");	
	}

	public boolean specialOne(Character enemy) {
		if (specialCounter >= specialMax) {
			enemy.subtractHP(getAttackDamage() * 3);
			System.out.println(getName()+" uses Arcane Dialation! \n\n" + getName()+" leaps into the air, somersaults, \nand smashes his silver blade into "+ enemy.getName()+".\n\n"); 
			System.out.println(enemy.getName()+"'s HP: " + enemy.getHP() + "\n");
			specialCounter = 0;
			return true;
		}
		else {
			System.out.println("Arcane Dialation is not ready yet! " + (specialMax-specialCounter) + " turns left.\n");
			return false;
		}
	}

	//defense moves 
	public boolean inventory() {
		if (Ambrosia == true) {
			subtractHP(-3200);
			System.out.println(getName()+" ate some ambrosia! 3200 HP restored!\n\n" + getName() + "'s HP: " + getHP() + "\n");
			Ambrosia = false;;
			return true;
		}
		else {
			System.out.println("There is nothing in your inventory.\n");
			return false;
		}
	}

	public boolean specialTwo(Character enemy) {
		if (special2Counter >= specialMax) {
			enemy.subtractHP(getAttackDamage() * 3);
			special2Counter = 0;
			System.out.println(getName() + " used Backstab! " + getName() + " leaps behind /n" + enemy.getName() + " and stabs at a weak point!");
			System.out.println(enemy.getName() + "'s HP: "+enemy.getHP());
			return true;
		}
		else {
			System.out.println(getName() + "Backstab is not ready yet! " + (special2Max-special2Counter) + " turns left.\n");
			return false;
		}
	}
}

