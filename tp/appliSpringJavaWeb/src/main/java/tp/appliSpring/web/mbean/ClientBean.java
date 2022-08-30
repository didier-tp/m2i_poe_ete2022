package tp.appliSpring.web.mbean;

import javax.annotation.ManagedBean;
//import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import tp.appliSpring.core.entity.Client;
import tp.appliSpring.core.service.ServiceClient;

@ManagedBean
//@RequestScoped
//@SessionScoped
public class ClientBean {
	
	@Autowired
	private ServiceClient serviceClient;
	
	private Long numClient ;
	private Client client;
	
	public String doLogin() {
		this.client = serviceClient.rechercherClientAvecComptesByNum(numClient);
		return "clientComptes" ; // clientComptes.xhtml
	}
	

	public ClientBean() {
		super();
	}
	
	public Long getNumClient() {
		return numClient;
	}
	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
