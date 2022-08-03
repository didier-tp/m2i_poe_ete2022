package tp.appliSpring.reinit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import tp.appliSpring.core.dao.DaoClient;
import tp.appliSpring.core.dao.DaoCompte;
import tp.appliSpring.core.entity.Client;
import tp.appliSpring.core.entity.Compte;

@Component
@Profile("reInit")
public class ReInitDefaultDataSet {
	
	@Autowired
	private DaoCompte daoCompte;
	
	@Autowired
	private DaoClient daoClient;
	
	@PostConstruct
	public void initDataSet() {
		Client client1 = new Client(null,"alain","Therieur");
		client1.addCompte(this.daoCompte.save(new Compte(null,"compteC1a",100.0)));
		client1.addCompte(this.daoCompte.save(new Compte(null,"compteC1b",50.0)));
		client1 = daoClient.save(client1);
		
		Client client2 = new Client(null,"axelle","Aire");
		client2.addCompte(this.daoCompte.save(new Compte(null,"compteC2a",80.0)));
		client2.addCompte(this.daoCompte.save(new Compte(null,"compteC2b",60.0)));
		client2 = daoClient.save(client2);
	}

}
