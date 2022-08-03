package tp.appliSpring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tp.appliSpring.core.dao.DaoClient;
import tp.appliSpring.core.entity.Client;

@Service
@Transactional
public class ServiceClientImpl implements ServiceClient {
	
	@Autowired
	private DaoClient daoClient;

	@Override
	public Client rechercherClientAvecComptesByNum(long numClient) {
		return daoClient.findClientByIdWithComptes(numClient);
	}

}
