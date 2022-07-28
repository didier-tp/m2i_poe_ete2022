package tp.appliSpring.exemple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * classe de configuration de composants "spring" (remplace les anciens fichiers xml)
 */

@Configuration
public class ExempleConfig {
	
	 @Bean //pour que la chose construite soit prise en charge par Spring
     public MonAfficheur monAfficheur() {
    	 //return new MonAfficheurV1();
    	 //ou bien 
		 return new MonAfficheurV2();
     }
	 
	 @Bean
	 public Coordinateur coordinateur(MonAfficheur monAfficheur) {
		 return new Coordinateur(monAfficheur); //injection par constructeur
		 /*
		 //ou bien:
		 Coordinateur coordinateur = new Coordinateur();
		 coordinateur.setMonAfficheur(monAfficheur); //injection via setter
		 return coordinateur;
		 */
	 }
}
