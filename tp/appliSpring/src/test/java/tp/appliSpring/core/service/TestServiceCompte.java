package tp.appliSpring.core.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
//@ActiveProfiles({ "embeddedDB" })
@ActiveProfiles({ "remoteDB" })
public class TestServiceCompte {
	
	@Autowired
	private ServiceCompte serviceCompte; //à tester
	
	//...
	
	@Test
	public void testRechercherCompteParNumero() {
		
	}
	
	@Test
	public void testVirement() {
		//remonte en memoire les anciens soldes des compte A et B avant virement (+affichage console ou logger)
		//effectuer un virement de 50 euros d'un compte A vers vers compte B
		//remonte en memoire les nouveaux soldes des compte A et B apres virement (+affichage console ou logger)
		//verfier -50 et +50 sur les différences de soldes sur A et B
	}

}
