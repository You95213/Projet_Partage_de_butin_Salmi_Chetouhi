/**
* Classe Main
*
* @author Younes Salmi Yanis Chetouhi
* @version 1.0 
*
*/
public class Main {

	public static void main(String args[]) throws Exception {
		
		
		/*Equipage equipage = new Equipage();
		equipage.nbPirates();
		equipage.optionMenu();
		equipage.distributionObjet();
		equipage.afficheObjetPirate();
		equipage.echangeMenu();*/
		
		Equipage equipage = new Equipage();
		equipage.readFile(equipage.menuSaisieFichier());
		equipage.distributionObjet();
		equipage.resolutionMenu();
		
	}
	
}
