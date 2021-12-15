import java.util.ArrayList;

/**
* Classe Pirate qui permet la
* création et la gestion des Pirate
*
* @author Younes Salmi Yanis Chetouhi
* @version 1.0 
*
*/
public class Pirate {
	
	private String nom;
	private ArrayList<Objet> preferenceObjet;
	private ArrayList<Pirate> jalousie;
	private Objet objet;
	private boolean possedeObjet;  
	
	
	
	
	
	public Pirate(String nom) {
		
		this.nom = nom;
		preferenceObjet = new ArrayList<Objet>();
		jalousie = new ArrayList<Pirate>();
		objet = null;
		possedeObjet = false;
		
	}
	
	/**
	* Methode qui permet de récupérer 
	* le nom du pirate
	* 
	* @return le nom du Pirate
	*/
	public String getNomPirate() {
		return nom;
	}
	
	/**
	* Methode qui permet de récupérer 
	* les préférences d'objet du prirate
	* 
	* @return la liste de préférence d'objet
	* du pirate
	*/
	public ArrayList<Objet> getPreferenceObjet(){
		return preferenceObjet;
	}
	
	/**
	* Methode qui permet de récupérer 
	* l'objet du pirate
	* 
	* @return l'objet du pirate
	*/
	public Objet getObjet() {
		
		return objet;
	}
	
	/**
	* Methode qui modifie l'objet
	* du pirate
	* 
	* @param le nouvelle objet du pirate
	*/
	public void setObjet(Objet o) {
		 this.objet = o;
		
	}
	
	/**
	* Methode qui permet de récupérer 
	* le boolean qui permet de savoir 
	* si un pirate possède ou non un objet
	* 
	* @return true si le pirate possede un objet false sinon
	* 
	*/
	public boolean getPossedeObjet() {
		
		return possedeObjet;
		
	}

	
	/**
	* Methode qui permet de modifier 
	* le boolean qui permet de savoir 
	* si un pirate possède ou non un objet
	* 
	* @param le nouveau boolean 
	*/
	public void setPossedeObjet(boolean b) {
		
		this.possedeObjet = b; 
		
	}

	/**
	* Methode qui permet d'afficher
	* les pirates dont ce pirate est 
	* jaloux
	*  
	*/
	public void afficheJalousie(){
		
		for(Pirate p : jalousie)
	       {
	       	 System.out.println (nom+" "+p.getNomPirate());
	       }
	}
	
	/**
	* Methode qui permet d'ajouter des
	* préférences à la liste des préférences 
	* d'objet du pirate
	* 
	* @param l'objet à ajouter dans la liste
	*/
	public void ajoutPreference(Objet o) {
		
		preferenceObjet.add(o);
		
	}
	
	/**
	* Methode qui permet d'afficher
	* les préférences d'objet du pirate
	*  
	*/
	public void affichePreference(){
		
		System.out.print("Les préferences de "+nom+" sont : ");
		for(Objet o : preferenceObjet)
	       {
	       	 System.out.print (o.getNomObjet()+" ");
	       }
		System.out.println("");
	}
	
	/**
	* Methode qui permet d'ajoter un 
	* pirate jaloux à la liste des pirate 
	* jaloux de ce pirate
	* 
	* @param le pirate jaloux 
	*/
	public void estJaloux(Pirate p) {
		
		jalousie.add(p);
		
	}
	
	/**
	* Methode qui permet d'échanger les 
	* objets entre deux pirate
	*  
	*  @param le pirate avec qui se fait l'échenge
	*/
	public void echangeObjet(Pirate p) {
		
		Objet temp = this.objet;
		this.objet = p.objet;
		p.objet = temp;
		
	}
	
	/**
	* Methode qui permet de savoir si 
	* le pirate à obtenu son objet 
	* préféré
	* 
	* @return true si il a obtenu son objet préféré false sinon 
	*/
	public boolean aSonObjetPrefere() {
		
		boolean b = false;
		
		if(objet.getNomObjet() == preferenceObjet.get(0).getNomObjet()) {
			b = true;
		}
		
		return b;
		
	}
	
	
	/**
	* Methode qui permet de savoir quel 
	* est le rang de préférence de l'objet 
	* obtenu
	* 
	* @return le rang de préférence de l'objet obtenu
	*/
	public int rangObjetPrefere() {
		
		int rang = 0;
		
		for (int i = 0; i < preferenceObjet.size(); i++) {
			if (preferenceObjet.get(i).getNomObjet() == objet.getNomObjet()) {
				rang = i;
			}
		}
		return rang;
		
	}
	
	/**
	* Methode qui permet de savoir si
	* un pirate est jaloux d'un autre pirate 
	* car il a obtenu un de ses objets préféré
	* ou non
	* 
	* @param le menu initialisé au départ
	* 
	* @return true si le pirate est jaloux false sinon 
	*/
	public boolean calculJalousie(Equipage m) {
		
	/*	boolean b = false;
		
		int objet1 = -1;
		int objet2 = -1;
		
		if(rangObjetPrefere() == 2) {
			objet1 = preferenceObjet.get(0).getNomObjet();
			objet2 = preferenceObjet.get(1).getNomObjet();
		}
		if(rangObjetPrefere() == 1) {
			objet1 = preferenceObjet.get(0).getNomObjet();
		}

		for (int i = 0; i < jalousie.size(); i++) { //on prend les pirate jaloux
			
			for (int j = 0; j <m.getListPirate().size() ; j++) {//on prend la liste de menu 
				
				if(jalousie.get(i).getNomPirate().equals(m.getListPirate().get(j).getNomPirate())) {
					
					if (m.getListPirate().get(j).getObjet().getNomObjet() == objet1 || m.getListPirate().get(j).getObjet().getNomObjet() == objet2 ) {
						b = true;
					}
					
				}
			}
			
			
		}
		
		return b;*/
		
		boolean b = false;
		
		for (int i = 0; i < jalousie.size(); i++) {
			
			for (int j = 0; j < m.getListPirate().size() ; j++) {
				
				if(jalousie.get(i).getNomPirate().equals(m.getListPirate().get(j).getNomPirate())) {
					
					for(int k = 0; k < preferenceObjet.size(); k++) {
						if(preferenceObjet.get(k).getNomObjet() == objet.getNomObjet()) {
							break;
						}
						if(preferenceObjet.get(k).getNomObjet() == m.getListPirate().get(j).getObjet().getNomObjet()) {
							b = true;
						}
					}
					
				}
				
			}
		}
		
		return b;
	}
	
}