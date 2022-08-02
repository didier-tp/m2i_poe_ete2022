package tp.appliSpring.core.entity;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Operation {
	
	private Long numOp;
	private Double montant; // -30 si achat , +2000 si reception d'un salaire
	private String label; // "achat TV" , "reception salaire"
	
	@Temporal(TemporalType.DATE)
	private Date dateOp; //dans la colonne de la table "2022-08-02"
	
	@ManyToOne
	@JoinColumn(name="numCompte")
	private Compte compte;

	public Operation() {
		// TODO Auto-generated constructor stub
	}

}
