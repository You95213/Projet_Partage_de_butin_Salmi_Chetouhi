import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
* Classe Menu qui permet la création
* des menu ainsi que leur gestion et 
* l'interaction avec l'utilisateur et 
* qui fait le lien entre Pirate et Objet
*
* @author Younes Salmi Yanis Chetouhi
* @version 1.0 
*
*/
public class Equipage {
		
	private ArrayList<Pirate> listPirate = new ArrayList<Pirate>();
	private ArrayList<Objet> listObjet = new ArrayList<Objet>();
	private ArrayList<Objet> listObjetNonDispo = new ArrayList<Objet>();
	int choix1;
	
	/**
	* Methode qui permet d'afficher le premier menu
	* le menu qui demande le nombre de pirate 
	* présents
	* 
	*/
	public void nbPirates() {
		
		
		Scanner sc;
		do {
			
			
			System.out.println("Combien de pirates il y a t-il dans votre équipage ? (entre 0 et 26)");
			sc = new Scanner(System.in);
			choix1 = sc.nextInt();
		
			} while (choix1 > 26 || choix1 < 0);
		//sc.close();
		
		
		int codeAscii = 65; //On l'utilise pour convertir le nom du pirate en un nombre pour les stocker dans une liste 
		for (int i = 0; i < choix1; i++) {

			String nom = Character.toString(codeAscii);
			listPirate.add(new Pirate(nom));
			//listObjet.add(new Objet(i+1));
			codeAscii++;
			
		}
				
	}


	/**
	* Methode qui permet d'afficher le second menu
	* le menu qui demande de saisir les préférences
	* et les relations des pirates ainsi que d'effectuer
	* différentes action en fonction du choix de l'utilisateur
	* c'est à dire stocker les préférence et les relations
	* qui sont saisis
	* 
	*/
	public void optionMenu() {
		
		int choix;
		String pirate;
		String pirate2;
		
		int pirateInt;
		int pirate2Int;
		int pref1, pref2, pref3;
		
		Scanner sc;
		boolean choixValide = false;
		boolean preferenceNonComplete = true;
		do {
		
		System.out.println("1) Ajouter une relation \n2) Ajouter des préférences \n3) FIN");
		sc = new Scanner(System.in);
		choix = sc.nextInt();
		
		
		
		
				switch (choix) {
		
		case 1:
			
			System.out.println("Veuillez saisir le premier pirate de la relation : ");
			sc = new Scanner(System.in);
			pirate = sc.nextLine();
			
			System.out.println("Veuillez saisir le deuxième pirate de la relation : ");
			//sc = new Scanner(System.in);
			pirate2 = sc.nextLine();
			
			byte[] bytes = pirate.getBytes(StandardCharsets.US_ASCII);
			byte[] bytes2 = pirate2.getBytes(StandardCharsets.US_ASCII);
			
			pirateInt = bytes[0]-65;
			pirate2Int = bytes2[0]-65;
			
			listPirate.get(pirateInt).estJaloux(listPirate.get(pirate2Int));
			listPirate.get(pirate2Int).estJaloux(listPirate.get(pirateInt));
			
			//listPirate.get(pirateInt).afficheJalousie();
			//listPirate.get(pirate2Int).afficheJalousie();
			
			choixValide = true;
			break;
			
		case 2: 
			/*if(choix1 >=3) {
				
			
				System.out.println("Veuillez saisir le pirate à qui vous voulez attribuer ses préferences : ");
				sc = new Scanner(System.in);
				pirate = sc.nextLine();
				System.out.println("Veuillez saisir le premier objet : ");
				pref1 = sc.nextInt();
				System.out.println("Veuillez saisir le deuxième objet : ");
				pref2 = sc.nextInt();
				System.out.println("Veuillez saisir le troisième objet : ");
				pref3 = sc.nextInt();
			
				byte[] bytes3 = pirate.getBytes(StandardCharsets.US_ASCII);
				pirateInt = bytes3[0]-65;
				
				listPirate.get(pirateInt).ajoutPreference(listObjet.get(pref1-1));
				listPirate.get(pirateInt).ajoutPreference(listObjet.get(pref2-1));
				listPirate.get(pirateInt).ajoutPreference(listObjet.get(pref3-1));
			
				//listPirate.get(pirateInt).affichePreference();
			}
			else if(choix1 == 2){
				System.out.println("Veuillez saisir le pirate à qui vous voulez attribuer ses préferences : ");
				sc = new Scanner(System.in);
				pirate = sc.nextLine();
				System.out.println("Veuillez saisir le premier objet : ");
				pref1 = sc.nextInt();
				System.out.println("Veuillez saisir le deuxième objet : ");
				pref2 = sc.nextInt();

			
				byte[] bytes3 = pirate.getBytes(StandardCharsets.US_ASCII);
				pirateInt = bytes3[0]-65;
				
				listPirate.get(pirateInt).ajoutPreference(listObjet.get(pref1-1));
				listPirate.get(pirateInt).ajoutPreference(listObjet.get(pref2-1));

			}
			else if(choix1 == 1) {
				System.out.println("Veuillez saisir le pirate à qui vous voulez attribuer ses préferences : ");
				sc = new Scanner(System.in);
				pirate = sc.nextLine();
				System.out.println("Veuillez saisir le premier objet : ");
				pref1 = sc.nextInt();


			
				byte[] bytes3 = pirate.getBytes(StandardCharsets.US_ASCII);
				pirateInt = bytes3[0]-65;
				
				listPirate.get(pirateInt).ajoutPreference(listObjet.get(pref1-1));

				
			}*/
			
			System.out.println("Veuillez saisir le pirate à qui vous voulez attribuer ses préferences : ");
			sc = new Scanner(System.in);
			pirate = sc.nextLine();
				
			byte[] bytes3 = pirate.getBytes(StandardCharsets.US_ASCII);
			pirateInt = bytes3[0]-65;
				
			for (int i = 0; i < choix1; i++) {
				System.out.println("Veuillez saisir l'objet n°"+(i+1)+" : ");
				pref1 = sc.nextInt();
				listPirate.get(pirateInt).ajoutPreference(listObjet.get(pref1-1));
					
			}
				
				
			
			
			
			
			choixValide = true;
			break;
			
			
		case 3:
			

			/*	if (choix1 >= 3) {
					
					for(int i = 0; i < listPirate.size(); i++) {
						
					
						if(listPirate.get(i).getPreferenceObjet().size() == 3)
						{
							preferenceNonComplete = false;
							choixValide = false;
							
						}
						else {
							preferenceNonComplete = true;
							choixValide = true;
						}
						
						listPirate.get(i).affichePreference();
					}
					
					if(preferenceNonComplete) {
						
						System.out.println("\nVous n'avez pas saisi la liste de préferences de tous les pirates.");
						System.out.println("Veuillez finir de la saisir . \n");
						choixValide = true;
					}
					
				}
				else if(choix1 == 2 || choix1 == 1){
					for(int i = 0; i < listPirate.size(); i++) {
						if(listPirate.get(i).getPreferenceObjet().size() == choix1) {
							
							preferenceNonComplete = false;
							choixValide = false;
							
						}
						else {
							preferenceNonComplete = true;
							choixValide = true;
						}
						
						listPirate.get(i).affichePreference();
					}
					if(preferenceNonComplete) {
						
						System.out.println("\nVous n'avez pas saisi la liste de préferences de tous les pirates.");
						System.out.println("Veuillez finir de la saisir . \n");
						choixValide = true;
					}
					
				}*/
				
				for(int i = 0; i < listPirate.size(); i++) {
					
					
					if(listPirate.get(i).getPreferenceObjet().size() == choix1)
					{
						preferenceNonComplete = false;
						choixValide = false;
						
						
					}
					else {
						preferenceNonComplete = true;
						choixValide = true;
						break;
					}
					
					listPirate.get(i).affichePreference();
				}
				
				if(preferenceNonComplete) {
					
					System.out.println("\nVous n'avez pas saisi la liste de préferences de tous les pirates.");
					System.out.println("Veuillez finir de la saisir . \n");
					choixValide = true;
				}
			
			
			break;
			
		default:
			System.out.println("Veuillez choisir un nombre valide .\n");
			choixValide = true;
			break;
		}
				
		
	} while (choixValide);
	//sc.close();
		
		
	}

	/**
	* Methode qui permet d'effectuer la distribution
	* des objets entre les pirates de manière "naïve"
	* 
	*/
	public void distributionObjet() throws Exception{
		
		for (int i = 0; i < listPirate.size(); i++) {  //on prend le pirate
			
			for (int j = 0; j < listPirate.get(i).getPreferenceObjet().size(); j++) { // on prend sa liste de pref
				
				if(listPirate.get(i).getPossedeObjet() == true) {
					continue;
				}
				else {
					
					
					if(estDiponible(listPirate.get(i).getPreferenceObjet().get(j))) {
						listPirate.get(i).setObjet(listPirate.get(i).getPreferenceObjet().get(j));
						listObjetNonDispo.add(listPirate.get(i).getPreferenceObjet().get(j));
						listPirate.get(i).setPossedeObjet(true);
						
					}
					
				}
			}
			
		}
		if(listPirate.size() == 0) {
			throw new Exception("Le nombre de Pirate ne peut pas être égale à 0 .");
		}
		
		if(!verifPirateObjetPref()) {
			throw new Exception("Le nombre de Pirate, d'objet et/ou de préferences sont différents .");
		}
	}

	/**
	* Methode qui permet d'aficher les objets
	* non disponible car obtenu par un pirate
	* 
	*/
	public void afficheNonDispo() {
		for(Objet o : listObjetNonDispo)
	       {
	       	 System.out.println (o.getNomObjet());
	       }
	}

	/**
	* Methode qui permet d'afficher les objets
	* obtenu par chaque pirate
	* 
	*/
	public void afficheObjetPirate() {
		
		
		System.out.println("\n");
		for(Pirate p : listPirate)
	       {
	       	 System.out.println ("Le pirate "+p.getNomPirate() +" a obtenu l'objet : "+p.getObjet().getNomObjet());
	       }
		System.out.println("\n");
		
	}
	
	/**
	* Methode qui de savoir si un objet est
	* disponible pour distribution ou non
	* 
	* @param l'objet dont on veux savoir s'il est disponible
	* @return true si l'objet est disponible false sinon
	*/
	public boolean estDiponible(Objet o) {
		
		boolean disponible = true;
		for (int i = 0; i < listObjetNonDispo.size(); i++) {
			
			if(o.getNomObjet() == listObjetNonDispo.get(i).getNomObjet()) {
				
				disponible = false;
				
			}
			
		}
		return disponible;
		
	}
	
	/**
	* Methode qui permet d'afficher le troisième menu
	* le menu qui permet de faire les échanges d'objets
	* et d'afficher le coût, cette permet aussi d'effectuer
	* échange et de calculer ce coût
	* 
	*/
	public void echangeMenu() {
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int choix = 0;
		String pirate1 = null, pirate2 = null;
		boolean choixValide = false;

		do {
			
			try {
				System.out.println("\n1) échanger objets");
				System.out.println("2) afficher coût");
				System.out.println("3) Fin");
			

				
				choix = sc.nextInt();
				switch (choix) {
				
				
					case 1:
					
						try {
							int temp1 = -1;
							int temp2 = -1;
							System.out.println("\nSaisissez le premier pirate pour l'échange : ");

							pirate1 = sc2.nextLine();

							System.out.println("\nSaisissez le deuxième pirate pour l'échange : ");
							pirate2 = sc2.nextLine();

							
							for (int i = 0; i < listPirate.size(); i++) {
								if(pirate1.equals(listPirate.get(i).getNomPirate())) {
									temp1 = i;
								}
								if(pirate2.equals(listPirate.get(i).getNomPirate())) {
									temp2 = i;
								}
			
							}
							if (temp1 == -1 && temp2 == -1) {
								throw new Exception("\nLes pirates "+pirate1+" et "+pirate2+" n'existent pas .");
							}
							if(temp1 == -1) {
								throw new Exception("\nLe pirate "+pirate1+" n'existe pas .");
							}
							if(temp2 == -1) {
								throw new Exception("\nLe pirate "+pirate2+" n'existe pas .");
							}
							
							
							listPirate.get(temp1).echangeObjet(listPirate.get(temp2));
							afficheObjetPirate();
							choixValide = true;
							
					}catch (Exception e) {
						System.out.println(e.getMessage());
						choixValide = true;
					}
						
					
					
					break;
				case 2:
					int cout = calculJalousie();
					System.out.println("\nLe cout en terme de jalousie est de : "+cout+"\n");
	
					
					choixValide = true;
					
					break;
				case 3 :
					//System.out.println("\n-----------Fin du programme.-----------");
					System.out.println("\nRetour au menu principal.");
					choixValide = false;
					
					//sc.close();
					break;
	
				default:
					System.out.println("Veuillez saisir un nombre en 1 et 3.\n");
					choixValide = true;
					
					break;
				}
			}catch (InputMismatchException e) {
				
				System.out.println("Veuillez saisir un nombre entier entre 1 et 3. ");
				sc.nextLine();
				choixValide = true;
			}
		
			} while (choixValide);
		
		
	}
	
	/**
	* Methode qui permet de récupérer 
	* la liste des pirate de l'équipage
	* 
	* @return la liste des pirates de l'équipage
	*/
	public ArrayList<Pirate> getListPirate() {
		return listPirate;
	}
	
	public void afficheListePirate() {
		
		
		System.out.println("\n");
		for(Pirate p : listPirate)
	       {
	       	 System.out.println ("Pirate "+p.getNomPirate());
	       }
		System.out.println("\n");
		
	}
	
	public void afficheListeObjet() {
		
		
		System.out.println("\n");
		for(Objet o : listObjet)
	       {
	       	 System.out.println ("Objet "+o.getNomObjet());
	       }
		System.out.println("\n");
		
	}
	
	public void readFile(String f) throws Exception{
		
		
		try(BufferedReader br = new BufferedReader ( new FileReader(f))) {
			String ligne = null ;
			while (( ligne = br.readLine ()) != null ){
				//System.out.println(ligne);
				
				if(tokenizer(ligne).equals("pirate")) {
					//System.out.println("pirate");
					estPirate(tokenizerNom(ligne));
				}
				else if(tokenizer(ligne).equals("objet")) {
					//System.out.println("objet");
					estObjet(tokenizerNom(ligne));
				}
				else if(tokenizer(ligne).equals("deteste")) {
					//System.out.println("deteste");
					estDeteste(tokenizerDeteste1(ligne),tokenizerDeteste2(ligne));
				}
				else if(tokenizer(ligne).equals("preferences")) {
					//System.out.println("preferences");
					tokenizerPreferences(ligne);
					
					
				}
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("\nLe fichier n'a pas été trouvé .\n");
			readFile(this.menuSaisieFichier());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	public String tokenizer(String s) {
		
		StringTokenizer st = new StringTokenizer(s, "().");
		//System.out.println(st.nextToken());
		return st.nextToken();
	}
	
	public String tokenizerNom(String s) {
		
		StringTokenizer st = new StringTokenizer(s, "().");
		//System.out.println(st.nextToken());
		st.nextToken();
		return st.nextToken();
	}
	
	public String tokenizerDeteste1(String s) {
		StringTokenizer st = new StringTokenizer(s, "().,");
		//System.out.println(st.nextToken());
		st.nextToken();
		return st.nextToken();
	}
	
	public String tokenizerDeteste2(String s) {
		StringTokenizer st = new StringTokenizer(s, "().,");
		//System.out.println(st.nextToken());
		st.nextToken();
		st.nextToken();
		return st.nextToken();
	}
	
	public void tokenizerPreferences(String s)throws Exception {
		String nom;
		StringTokenizer st = new StringTokenizer(s, "(),.");
		st.nextToken();
		nom = st.nextToken();
		int temp = -1;
		for (int i = 0; i < listPirate.size(); i++) {
				
				if(listPirate.get(i).getNomPirate().equals(nom)) {
					temp = i;
				}
			}
		if(temp == -1) {
			throw new Exception("Le pirate "+nom+" n'existe pas .");
		}
		
		while (st.hasMoreElements()) {
			
			estPreference(temp, st.nextToken());
			
		}
		
		

	}
	
	public void estPirate(String s) {
		
		listPirate.add(new Pirate(s));
		
	}
	
	public void estObjet(String s) {
		
		listObjet.add(new Objet(s));
		
	}
	
	public void estDeteste(String s1,String s2)throws Exception {
		
		int temp1 = -1;
		int temp2 = -1;
		boolean existe1 = false;
		boolean existe2 = false;
		
		if(listPirate.size() == 0) {
			throw new Exception("Aucun pirate n'existe .");
		}
		if(s1.equals(s2)) {
			throw new Exception("Un pirate ne peut pas se détester lui même .");
		}
		for (int i = 0; i < listPirate.size(); i++) {
			
			if(listPirate.get(i).getNomPirate().equals(s1)) {
				for (int j = 0; j < listPirate.get(i).getJalousie().size(); j++) {
					if(listPirate.get(i).getJalousie().get(j).getNomPirate().equals(s2)) {
						throw new Exception("Les pirates "+s1+" et "+s2+" se détestent déjà .");
					}
				}
				
			}
			
		}
		
		
		for (int i = 0; i < listPirate.size(); i++) {
			
			if(listPirate.get(i).getNomPirate().equals(s1)) {
				temp1 = i;
				existe1 = true;
			}
			if(listPirate.get(i).getNomPirate().equals(s2)) {
				temp2 = i;
				existe2 = true;
			}
			

			
		}
		
		if( !existe1 ) {
			throw new Exception("Le pirate "+s1+" n'existe pas .");
		}
		if( !existe2 ) {
			throw new Exception("Le pirate "+s2+" n'existe pas .");
		}
		
		listPirate.get(temp1).estJaloux(listPirate.get(temp2));
		listPirate.get(temp2).estJaloux(listPirate.get(temp1));
	}
	
	public void estPreference(int pos,String objet)throws Exception {
		
		int temp = -1;
		
		if(listPirate.size() == 0) {
			throw new Exception("Aucun pirate n'existe .");
		}
		if(listPirate.size() == listPirate.get(pos).getPreferenceObjet().size()) {
			throw new Exception("Un pirate ne peut pas avoir plusieurs listes de préférences .");
		}
		for(int i = 0; i < listPirate.get(pos).getPreferenceObjet().size(); i++) {
			if(listPirate.get(pos).getPreferenceObjet().get(i).getNomObjet().equals(objet)) {
				throw new Exception("Le pirate "+listPirate.get(pos).getNomPirate()+" a deux fois l'objet "+objet+" dans sa liste de préférences");
			}
		}

		for (int i = 0; i < listObjet.size(); i++) {
			
			if(listObjet.get(i).getNomObjet().equals(objet)) {
				temp = i;
			}
		}
		if(temp == -1) {
			throw new Exception("L'objet "+objet+" n'existe pas .");
		}
		
		
		
		listPirate.get(pos).ajoutPreference(listObjet.get(temp));
		
			
	}
		
	public void resolutionMenu() {
		Scanner sc = new Scanner(System.in);
		boolean choixValide = false;
		int choix;
		String fichier;
		
		do {
			//sc = new Scanner(System.in);
			System.out.println("\n1) Résolution automatique");
			System.out.println("2) Résolution manuelle");
			System.out.println("3) Sauvegarde");
			System.out.println("4) Fin\n");
			
			try {
				choix = sc.nextInt();
			
				switch (choix) {
				case 1:
					
					resolutionAuto();
					choixValide = true;
					break;
				case 2:
					echangeMenu();
					choixValide = true;
					
					break;
				case 3:
					System.out.println("\nVeuillez saisir le nom du fichier dans lequel vous souhaitez sauvegarder la résolution : ");
					sc = new Scanner(System.in);
					fichier = sc.nextLine();
					
					sauvegarde(fichier);
					choixValide = true;
					
					
					break;
				case 4:
					
					System.out.println("\n---------------- Fin du programme. ----------------");
					choixValide = false;
					
					break;
	
				default:
					
					System.out.println("Veuillez saisir un nombre entier entre 1 et 4. ");
					choixValide = true;
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println("Veuillez saisir un nombre entier entre 1 et 4. ");
				choixValide = true;
				sc.nextLine();
			}
			
		
			} while (choixValide);
		
		
		}
				
	public void sauvegarde(String s) {
		
		try (PrintWriter printW = new PrintWriter(new BufferedWriter(new FileWriter(s)))) {
			
			printW.println("Cout = "+calculJalousie());
			
			for (Pirate p : listPirate) {
				printW.println(
						p.getNomPirate()+" : "+p.getObjet().getNomObjet());
			}
			
			System.out.println("\nSAUVEGARDE REALISE AVEC SUCCES.");
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
	}
	
	public void resolutionAuto() {
		int nb_pirate = listPirate.size();
		int coutAvant = 1;
		int coutApres = 0;
		int nbechange = 0;
		int i = 0;
		
		while(coutAvant > 0 && i < 1000) {
			 
			i++;
			Random rand = new Random();
			int nbAleatoire = rand.nextInt(nb_pirate);
			int nbAletoire2 = rand.nextInt(nb_pirate);
			
			while(nbAleatoire == nbAletoire2) {
				
				nbAletoire2 = rand.nextInt(nb_pirate);
				
			}
			coutAvant = calculJalousie();
			listPirate.get(nbAleatoire).echangeObjet(listPirate.get(nbAletoire2));
			coutApres = calculJalousie();
			if(coutAvant < coutApres) {
				listPirate.get(nbAleatoire).echangeObjet(listPirate.get(nbAletoire2));
				coutApres = coutAvant;
			}
			else {
				nbechange++;
			}
			
			
		}

		System.out.println("\nRÉSOLUTION AUTOMATIQUE TERMINÉ .");
		System.out.println("Le cout est de : "+coutApres+" .");
		System.out.println("Il y a eu "+nbechange+" échange .");
		
	}
	
	public int calculJalousie() {
		
		int sommeJalousie = 0;
		for (int i = 0; i < listPirate.size(); i++) {
			if(! listPirate.get(i).aSonObjetPrefere()){
				if(listPirate.get(i).calculJalousie(this)) {
					sommeJalousie++;
				}
			}
		}
		
		return sommeJalousie;
	}
	
	public String menuSaisieFichier() {
		Scanner sc;
		String nomFile;
		
		System.out.println("Veuillez saisir le nom du fichier contenant la description de l'équipage : ");
		sc = new Scanner(System.in);
		nomFile = sc.nextLine();
		
		return nomFile;
	}
	
	public boolean verifPirateObjetPref() {
		
		int nbPirate = listPirate.size();
		int nbObjet = listObjet.size();
		int nbPrefI = -1;
		boolean verifValide = true;
		
		for (int i = 0; i < listPirate.size(); i++) {
			
			nbPrefI = listPirate.get(i).getPreferenceObjet().size();
			if(!verifValide) {
				break;
			}

			for (int j = 0; j < listPirate.size(); j++) {
				int nbPrefJ = listPirate.get(j).getPreferenceObjet().size();
						
				if(nbPrefI != nbPrefJ) {
					verifValide = false;
					break;
				}
					
					
				}
			
		}
		
		
		if(verifValide && ( (nbPirate != nbObjet) || (nbPirate != nbPrefI) ) ) {
			verifValide = false;
		}
		return verifValide;
	}
}
