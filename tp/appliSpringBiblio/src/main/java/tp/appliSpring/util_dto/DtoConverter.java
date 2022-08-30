package tp.appliSpring.util_dto;

import java.util.ArrayList;
import java.util.List;

import tp.appliSpring.core.entity.Devise;
import tp.appliSpring.dto.Currency;

public class DtoConverter {
	
	public static List<Currency> deviseListToCurrencyList(List<Devise> listeDevise){
		List<Currency> listeCurrency = new ArrayList<>();
		for(Devise d : listeDevise) {
			listeCurrency.add(deviseToCurrency(d));
		}
		return listeCurrency; 
	}
	
	
	public static Currency deviseToCurrency(Devise d) {
		return new Currency(d.getCode(),d.getNom(),d.getChange());
	}
	

	
}
