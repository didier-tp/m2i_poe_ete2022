package tp.appliSpring.core.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tp.appliSpring.AppliSpringApplication;
import tp.appliSpring.core.entity.Compte;


//@RunWith(SpringRunner.class)  //si junit4
@ExtendWith(SpringExtension.class) //si junit5/jupiter
@SpringBootTest(classes= {AppliSpringApplication.class})
public class TestCompteDao {
	
    private static Logger logger = LoggerFactory.getLogger(TestCompteDao.class);
	
	@Autowired
	//@Qualifier("simu")
	@Qualifier("jpa")
	private DaoCompte daoCompte; //à tester
	
	@Test
	public void testAjoutEtRelecture() {
		//hypothese : base avec tables vides au lancement du test
		Compte compte = new Compte(null,"compteA",100.0);
		Compte compteSauvegarde = this.daoCompte.save(compte); //INSERT INTO
		logger.info("compteSauvegarde=" + compteSauvegarde);
		
		Compte compteRelu = this.daoCompte.findById(compteSauvegarde.getNumero()); //SELECT
		Assertions.assertEquals("compteA",compteRelu.getLabel());
		Assertions.assertEquals(100.0,compteRelu.getSolde());
		logger.info("compteRelu=" + compteRelu);
	}

}
