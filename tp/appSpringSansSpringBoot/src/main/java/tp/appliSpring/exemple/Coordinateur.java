package tp.appliSpring.exemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * objet pris en charge par spring qui va 
 * coordonner :
 *    - un calcul (délégué à un calculateur en v2)
 *    - un affichage_du_resultat (délégué à un objet MonAfficheur lui meme en version V1 ou V2)
 */

@Component
public class Coordinateur {
	
	@Autowired //pour demander à spring d'intialiser la référence monAfficheur
	//en pointant sur un composant Spring existant compatible avec le type MonAfficheur
	private MonAfficheur monAfficheur=null; //référence vers afficheur à injecter
	
	
	public void calculerEtAfficher() {
		//v1 : calcul en direct
		//v2 : calcul à déléguer à MonCalculateur
		double x=4;
		double res = x*x;
		monAfficheur.afficher("res="+res);// >> res=16 en v1 ou bien ** res=16
	}
	
	public Coordinateur() {
	}

	public Coordinateur(MonAfficheur monAfficheur) {
		super();
		this.monAfficheur = monAfficheur;
	}

	public void setMonAfficheur(MonAfficheur monAfficheur) {
		this.monAfficheur = monAfficheur;
	}
	
	
	
     

}
