public class DrunkWizard extends Character {
	
	public DrunkWizard() {
		super(9000, 15000, 0.1, 0, 0, "Drunk Wizard", 4);
	}
	
	//starting inventory
	
	
	//Attacks
	public void attack(Character enemy) {
		if (Math.random() < getAccuracy()) {
			System.out.println("\n"+getName()+" zaps "+enemy.getName()+"!\n");
			enemy.subtractHP(getAttackDamage());
			System.out.println(enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
		else {
			System.out.println(getName()+" misses "+enemy.getName()+" by a mile.\n");
			System.out.println(enemy.getName()+"'s HP: "+enemy.getHP()+"\n");
		}
	}
	
	public void strongAttack(Character enemy) {
		System.out.println(getName()+" is far too drunk to even try a strong attack.");
	}
	
	public boolean specialOne(Character enemy) {
		System.out.println("Are you kidding me? You think a drunk wizard \nis going to have special attacks?");
		return false;
	}
	
	//defense moves 
	public boolean inventory() {
		System.out.println(getName()+" materializes another beer and chugs it. \nAttack damage boosted by 500! Accuracy is now 1% lower.");
		return true;
	}
	
	public boolean specialTwo(Character enemy) {
		System.out.println("Are you kidding me? You think a drunk wizard \nis going to have special attacks?");
		return false;
	}
}
