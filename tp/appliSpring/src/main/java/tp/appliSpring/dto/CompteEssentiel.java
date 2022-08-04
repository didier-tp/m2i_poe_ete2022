package tp.appliSpring.dto;

//CompteEssentiel = une version simple de DTO
//DTO = Data Transfert Object (objet de données transféréré d'une couche logicielle à une autre 
//ou bien d'une application à une autre )
public class CompteEssentiel {
    private Long numero;
    private String label;
    private Double solde;
    
	public CompteEssentiel(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}

	public CompteEssentiel() {
	}

	@Override
	public String toString() {
		return "CompteEssentiel [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
	
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
    
    
}
