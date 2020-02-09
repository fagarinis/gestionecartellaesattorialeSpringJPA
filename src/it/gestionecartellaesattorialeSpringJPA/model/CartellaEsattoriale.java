package it.gestionecartellaesattorialeSpringJPA.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartellaEsattoriale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String denominazione;
	private String descrizione;
	private Double importo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contribuente_id", nullable = false)
	private Contribuente contribuente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public Contribuente getContribuente() {
		return contribuente;
	}

	public void setContribuente(Contribuente contribuente) {
		this.contribuente = contribuente;
	}

	@Override
	public String toString() {
		return "CartellaEsattoriale [id=" + id + ", denominazione=" + denominazione + ", descrizione=" + descrizione
				+ ", importo=" + importo + "]";
	}

}
