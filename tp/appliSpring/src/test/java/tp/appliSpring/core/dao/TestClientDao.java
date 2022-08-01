package tp.appliSpring.core.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tp.appliSpring.AppliSpringApplication;
import tp.appliSpring.core.entity.Client;

@ExtendWith(SpringExtension.class) //si junit5/jupiter
@SpringBootTest(classes= {AppliSpringApplication.class})
public class TestClientDao {
	
    private static Logger logger = LoggerFactory.getLogger(TestClientDao.class);
	
	@Autowired
	private DaoClient daoClient; //à tester
	
	@Test
	public void testFindByNom() {
		this.daoClient.save(new Client(null,"alex","Therieur"));
		this.daoClient.save(new Client(null,"alain","Therieur"));
		this.daoClient.save(new Client(null,"jean","Bon"));
		this.daoClient.save(new Client(null,"axelle","Aire"));

		List<Client> clientsDeNomTherieur= daoClient.findByNom("Therieur");
		Assertions.assertTrue(clientsDeNomTherieur.size()>=2);
		logger.debug("clientsDeNomTherieur=" + clientsDeNomTherieur);
	}
	
	@Test
	public void testAjoutEtRelectureEtSuppression() {
		//hypothese : base avec tables vides au lancement du test
		Client client = new Client(null,"alex","Therieur");
		Client clientSauvegarde = this.daoClient.save(client); //INSERT INTO
		logger.debug("clientSauvegarde=" + clientSauvegarde);
		
		Client clientRelu = this.daoClient.findById(clientSauvegarde.getNumero()).get(); //SELECT
		Assertions.assertEquals("alex",clientRelu.getPrenom());
		Assertions.assertEquals("Therieur",clientRelu.getNom());
		logger.debug("clientRelu=" + clientRelu);
		
		//+supprimer :
		this.daoClient.deleteById(clientSauvegarde.getNumero());
		
		//verifier bien supprimé (en tentant une relecture qui renvoi null)
		Client clientReluApresSuppression = this.daoClient.findById(clientSauvegarde.getNumero()).orElse(null); 
		Assertions.assertTrue(clientReluApresSuppression == null);
	}

}
