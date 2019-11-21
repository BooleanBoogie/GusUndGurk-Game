
public class Cleric extends Character {

	//Sub-Constructor: (AD: 800) (HP: 12000) (ACC: 80%) (N: Cleric) 
	public Cleric() {
		super(800, 10000, 0.8, 15, 5, "Cleric", 2);
	}

	//starting inventory
	private boolean Amulet = true;

	//Attacks
	public void attack(Character enemy) {
		if (Math.random() < getAccuracy()) {
			enemy.subtractHP(getAttackDamage());
			System.out.println(getName()+" stabs "+enemy.getName()+" with his dagger!\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
		else 
			System.out.println(getName()+" stabs out at "+enemy.getName()+" but is too slow.\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
	}

	public void strongAttack(Character enemy) {
		if ((Math.random() * 2) < getAccuracy()) {
			enemy.subtractHP(getAttackDamage()*2);
			System.out.println(getName()+" stabs " + enemy.getName()+" viciously!\n" + enemy.getName()+"'s HP: " + enemy.getHP()+"\n");
		}
		else 
			System.out.println(getName()+" stabs out at "+enemy.getName()+" but is too slow.\n\n" + enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
	}

	public boolean specialOne(Character enemy) {
		if (specialCounter >= specialMax) {
			System.out.println(getName()+" uses Holy Light!\n\n\n" + enemy.getName() + " can barely see! " + enemy.getName()+"'s accuracy is cut in half!");
			enemy.divideAccuracy(2.0);
			specialCounter = 0;
			return true;
		}
		else {
			System.out.println("Holy Light is not ready yet! "+(specialMax - specialCounter)+" turns left.\n");
			return false;
		}
	}

	//defense moves 



	public boolean specialTwo(Character enemy) {
		if (specialCounter >= special2Max) {
			subtractHP(-1600);
			System.out.println(getName()+" uses Healing Light! \n \n\n" + getName()+" regains 1600 HP! \n\n" + getName()+"'s HP: "+getHP());
			special2Counter = 0;
			return true;
		}
		else {
			System.out.println("Healer's Touch is not ready yet! "+(special2Max - special2Counter)+" turns left. \n");
			return false;
		}
	}

	public boolean inventory() {
		if (Amulet = true) 
			System.out.println("There is one shiny gold amulet in your inventory, \nbut now is not the time to use it. Choose another action:\n");
		else 
			System.out.println("There is nothing in your inventory.\n");
		return false;
	}
}