package tp.appliSpring.core.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tp.appliSpring.core.entity.Client;

//@ExtendWith(SpringExtension.class) //si junit5/jupiter
@SpringBootTest(/*classes= {AppliSpringApplication.class}*/)
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
		this.daoClient.save(new Client(null,"tarte","Tatin"));

		//List<Client> clientsDeNomTherieur= daoClient.findByNom("Therieur");
		//List<Client> clientsDeNomTherieur= daoClient.findByNomIgnoreCase("therieur");
		List<Client> clientsDeNomTherieur= daoClient.findByNomOrderByPrenom("Therieur");
		Assertions.assertTrue(clientsDeNomTherieur.size()>=2);
		logger.debug("clientsDeNomTherieur=" + clientsDeNomTherieur);
		
		List<Client> clientsDeNomEnT= daoClient.findByNomLike("T%"); //nom commençant pat T
		Assertions.assertTrue(clientsDeNomEnT.size()>=3);
		logger.debug("clientsDeNomEnT=" + clientsDeNomEnT);
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
