import java.util.Scanner;
//Eclipse refresh console
public class Battlefield {

	private Character one;
	private Character two;
	private int roundCounter = 1;
	private boolean ko1;
	private boolean ko2;
	private String enter;

	public Battlefield(Character a, Character b) {
		one = a;
		two = b;

		while (!round());
		if (ko1 == true) {
			System.out.println(one.getName()+" has been defeated. " + two.getName() + " is victorious!\n");
		}
		if (ko2 == true) {
			System.out.println(two.getName()+" has been defeated. " + one.getName() + " is victorious!\n");
		}
	}

	public boolean round() {
		boolean ko = false;
		Scanner sca = new Scanner(System.in);

		if(one.getHP() > 0) {
			boolean retry1 = true;
			while (retry1) {
				System.out.print("*---------------------------------------*\n\nRound " + roundCounter + ":\nPlayer One, choose an action!\n(a, s, z, x, or i)\n >");
				String Attack = sca.nextLine();
				if (Attack.equals("a") || Attack.equals("s") || Attack.equals("z") || Attack.equals("x") || Attack.equals("i"))
				{
					if (Attack.equals("a")) {
						one.attack(two);
						retry1 = false;
					}
					else if (Attack.equals("s")) {
						one.strongAttack(two);
						retry1 = false;
					}
					else if (Attack.equals("z")) 
						retry1 = !(one.specialOne(two));
					else if (Attack.equals("x"))
						retry1 = !(one.specialTwo(two));
					else if (Attack.equals("i"))
						retry1 = !(one.inventory());

					if(retry1 == false) {
						roundCounter++;
						one.specialCounter ++;
						one.special2Counter ++;
					}
					//battery 1
					if(one.specialMax > 0) {
						System.out.print("special charge: {");
						for (int g = 0; g < one.specialCounter; g ++)
							System.out.print("▣");
						for (int r = 0; r < one.getSpecialMax() - one.specialCounter; r ++)
							System.out.print("▢");
						System.out.println("}");
					}

					//battery 2
					if(one.special2Max > 0) {
						System.out.print("special 2 charge: {");
						for (int g = 0; g < one.special2Counter; g ++)
							System.out.print("▣");
						for (int r = 0; r < one.getSpecial2Max() - one.special2Counter; r ++)
							System.out.print("▢");
						System.out.println("}");
					}
				}
				else
					System.out.println("* That selection did not compute. Please try again *");
			}
			enter = sca.nextLine();
		}
		else {
			if (one.getAmulet() == true) {
				one.useAmulet();
			}
			else {
				ko1 = true;
				ko = true;
			}
		}
		if (two.getHP() > 0) {
			boolean retry2 = true;
			while (retry2) {
				System.out.println("*---------------------------------------*\n");
				System.out.println("Round " + roundCounter + ":");
				System.out.println("Player Two, choose an action!");
				System.out.println("(a, s, z, x, or i)");
				System.out.println("  >");

				String Attack = sca.nextLine();
				if (Attack.equals("a") || Attack.equals("s") || Attack.equals("z") || Attack.equals("x") || Attack.equals("i"))
				{
					if (Attack.equals("a")) {
						two.attack(one);
						retry2 = false;
					}
					else if (Attack.equals("s")) {
						two.strongAttack(one);
						retry2 = false;
					}
					else if (Attack.equals("z")) 
						retry2 = !(two.specialOne(one));
					else if (Attack.equals("x"))
						retry2 = !(two.specialTwo(one));
					else if (Attack.equals("i"))
						retry2 = !(two.inventory());

					if(retry2 == false) {
						roundCounter++;
						two.specialCounter ++;
						two.special2Counter ++;

						//battery 1
						if(two.specialMax > 0) {
							System.out.print("special charge: {");
							for (int g = 0; g < two.specialCounter; g ++)
								System.out.print("▣");
							for (int r = 0; r < two.getSpecialMax() - two.specialCounter; r ++)
								System.out.print("▢");
							System.out.println("}");
						}

						//battery 2
						if(two.special2Max > 0) {
							System.out.print("special 2 charge: {");
							for (int g = 0; g < two.special2Counter; g ++)
								System.out.print("▣");
							for (int r = 0; r < two.getSpecial2Max() - two.special2Counter; r ++)
								System.out.print("▢");
							System.out.println("}");
						}
					}
				}
				else
					System.out.println("* That selection did not compute. Please try again *");
			}
			enter = sca.nextLine();
		}
		else {
			if (two.getAmulet() == true) {
				two.useAmulet();
			}
			else {
				ko2 = true;
				ko = true;
			}
		}
		if (one.getHP() <=0) {
			ko = true;
		}
		return ko;

	}	

	//character biographies
	private static String knightBio1 = "\n     ~ The Knight ~ \n\nThe Knight is a fierce warrior, equipped with a \nsilver broadsword and two health potions in case of emergencies. \n"; 
	private static String knightBioP2 = "\n     > Stats < \nHP: 20000 \nAttack Damage: 800 \nAccuracy: 90% \n";
	private static String knightBioP3 = "\n     > Specials < \nSuper Slash: Ability to leap into the air and slice enemy for triple damage. \nUsable once every 5 turns. \n";
	private static String knightBioP4 = "\nRage: Permenantly doubles all attack damage. 20% chance of working.\n\nUltra Health Potion (x2): Each knight in the king's army \nis equipped with two health potions (each restoring 1600 HP).";

	public static String getKnightBio() {
		String knightBio = knightBio1+knightBioP2+knightBioP3+knightBioP4;
		return knightBio;
	}

	private static String clericBio1 = "\n     ~ The Cleric ~ \n\nThe Cleric is a wisened old healer, equipped with \n a healing staff, a small dagger, and a golden amulet.\n"; 
	private static String clericBioP2 = "\n     > Stats < \nHP: 10000 \nAttack Damage: 800 \nAccuracy: 80% \n";
	private static String clericBioP3 = "\n     > Specials < \nHoly Light: Ability to partially blind enemy. \nUsable once every 5 turns. \n\nHealer's Touch: Ability to heal self for 1600HP.\nUsable once every 5 turns.\n";
	private static String clericBioP4 = "\nRevive: After death, a cleric may use it's amulet to revive with full HP. \nOnly usable once.\n";

	public static String getClericBio() {
		String clericBio = clericBio1+clericBioP2+clericBioP3+clericBioP4;
		return clericBio;
	}

	private static String berserkerBio1 = "";
	private static String berserkerBioP2 = "";
	private static String berserkerBioP3 = "";
	private static String berserkerBioP4 = "";

	public static String getBerserkerBio() {
		String berserkerBio = berserkerBio1+berserkerBioP2+berserkerBioP3+berserkerBioP4;
		return berserkerBio;
	}

	private static String DrunkWizardBio1 = ""; 
	private static String DrunkWizardBioP2 = "";
	private static String DrunkWizardBioP3 = "";
	private static String DrunkWizardBioP4 = "";

	public static String getDrunkWizardBio() {
		String DrunkWizardBio = DrunkWizardBio1+DrunkWizardBioP2+DrunkWizardBioP3+DrunkWizardBioP4;
		return DrunkWizardBio;
	}

	private static String HighElfBio1 = ""; 
	private static String HighElfBioP2 = "";
	private static String HighElfBioP3 = "";
	private static String HighElfBioP4 = "";

	public static String getHighElfBio() {
		String HighElfBio = HighElfBio1+HighElfBioP2+HighElfBioP3+HighElfBioP4;
		return HighElfBio;
	}

	// insert Berserker bio

	public static void main(String[] args) {
		Character one = null;
		Character two = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("*----------------------- RPG ARENA SIM V1.0 -----------------------*");
		System.out.println("                   Code written by Andrew McCracken            ");

		System.out.println("\n\n");

		boolean retry = true;
		while(retry) {
			System.out.println("* Hello and welcome to RPG ARENA! Would you like to go to the\n");
			System.out.println("              1: Character Encyclopedia");
			System.out.println("                         or the       ");
			System.out.println("                  2: Character Select");

			System.out.print("  >");

			String choice = sc.nextLine();

			switch(Integer.parseInt(choice)) {
			case 1:
				boolean retry2 = true;
				System.out.println("                  *--- Character Encyclopedia ---*\n");
				System.out.println();
				while(retry2) {
					System.out.println("             Select a character to learn more about it:\n");
					System.out.println("* 1: Knight");
					System.out.println("* 2: Cleric");
					System.out.println("* 3: Berserker");
					System.out.println("* 4: Drunk Wizard");
					System.out.println("* 5: High Elf");
					System.out.println("* 6: Main Menu");
					System.out.print("  >");

					String choice2 = sc.nextLine();
					switch(Integer.parseInt(choice2)) {
					case 1:
						System.out.println("                  *-----------------------------*\n");
						System.out.println(getKnightBio());
						System.out.println("                  *-----------------------------*\n");
						retry = false;
						break;
					case 2: 
						System.out.println("                  *-----------------------------*\n");
						System.out.println(getClericBio());
						System.out.println("                  *-----------------------------*\n");
						retry = false;
						break;
					case 3: 
						System.out.println("                  *-----------------------------*\\n");
						System.out.println(getBerserkerBio());
						System.out.println("                  *-----------------------------*\\n");
						retry = false;
						break;
					case 4:
						System.out.println("                  *-----------------------------*\\n");
						System.out.println(getDrunkWizardBio());
						System.out.println("                  *-----------------------------*\\n");
						retry = false;
						break;
					case 5:
						System.out.println("                  *-----------------------------*\\n");
						System.out.println(getHighElfBio());
						System.out.println("                  *-----------------------------*\\n");
						retry = false;
						break;
					case 6: 
						System.out.println("\n");
						retry2 = false;
						retry = true;
						break;
					default:
						System.out.println("\n* That selection did not compute. Please try again. *\n");
						retry = false;
						break;
					}
				}
				break;

			case 2:
				retry = false;
				boolean retry3 = true;
				System.out.println("                      *--- Character Select ---*\n");
				System.out.println("              Welcome to the Character Selection Screen!");
				while(retry3) {
					System.out.println("                    Player 1, Choose Your Fighter!\n");
					System.out.println("* 1: Knight");
					System.out.println("* 2: Cleric");
					System.out.println("* 3: Berserker");
					System.out.println("* 4: Drunk Wizard");
					System.out.println("* 5: High Elf");
					System.out.print("  >");

					String choice3 = sc.nextLine();
					switch(Integer.parseInt(choice3)) {
					case 1:
						one = new Knight();
						retry3 = false;
						break;
					case 2: 
						one = new Cleric();
						retry3 = false;
						break;
					case 3:
						one = new Berserker();
						retry3 = false;
						break;
					case 4:
						one = new DrunkWizard();
						retry3 = false;
						break;
					case 5:
						one = new HighElf();
						retry3 = false;
						break;
					default: 
						System.out.println("\n* That selection did not compute. Please try again. *\n");
					}	
				}

				boolean retry4 = true;
				while (retry4) {
					System.out.println("                     Player 2, Choose Your Fighter!\n");
					System.out.println("* 1: Knight");
					System.out.println("* 2: Cleric");
					System.out.println("* 3: Berserker");
					System.out.println("* 4: Drunk Wizard");
					System.out.println("* 5: High Elf");
					System.out.print("  >");

					String choice2 = sc.nextLine();
					switch(Integer.parseInt(choice2)) {
					case 1:
						two = new Knight();
						retry4 = false;
						break;
					case 2: 
						two = new Cleric();
						retry4 = false;
						break;
					case 3:
						two = new Berserker();
						retry4 = false;
						break;
					case 4:
						two = new DrunkWizard();
						retry4 = false;
						break;
					case 5:
						two = new HighElf();
						retry4 = false;
						break;
					default: 
						System.out.println("\n* That selection did not compute. Please try again. *\n");
					}	

				}

				System.out.println("\nPlayer One: Name your "+one.getName()+"!");
				System.out.print("  >");
				Scanner scan = new Scanner(System.in);

				String name1 = scan.nextLine();
				if (one.ID() == 1) {
					one.changeName("Sir "+name1);
				}
				else {
					one.changeName(name1);
				}
				System.out.println("Welcome "+one.getName()+"!\n");

				System.out.println("Player Two: Name your "+two.getName()+"!");
				System.out.print("  >");
				String name2 = scan.nextLine();
				if (two.ID() == 1) {
					two.changeName("Sir "+name2);
				}
				else {
					two.changeName(name2);
				}
				System.out.println("Welcome "+two.getName()+"!\n");

				System.out.println("*------ "+one.getName()+" ------*");
				System.out.println("           VERSUS              ");
				System.out.println("*------ "+two.getName()+" ------*\n");
				System.out.println("LET THE BATTLE BEGIN!!!\n");

				if (one.ID() == 1) {
					one.setAmulet();
				}

				if (two.ID() == 2) {
					two.setAmulet();
				}

				new Battlefield(one, two);
				break;

			default: 
				System.out.println("\n* That selection did not compute. Please try again. *\n");
				break;

			}
		}
	}
}