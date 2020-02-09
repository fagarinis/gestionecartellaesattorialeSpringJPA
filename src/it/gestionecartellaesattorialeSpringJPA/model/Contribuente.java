package it.gestionecartellaesattorialeSpringJPA.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contribuente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	@Column(unique = true)
	private String cf;
	private String indirizzo;
	
	@OneToMany(mappedBy = "contribuente", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<CartellaEsattoriale> cartelleEsattoriali = new HashSet<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Set<CartellaEsattoriale> getCartelleEsattoriali() {
		return cartelleEsattoriali;
	}

	public void setCartelleEsattoriali(Set<CartellaEsattoriale> cartelleEsattoriali) {
		this.cartelleEsattoriali = cartelleEsattoriali;
	}

	@Override
	public String toString() {
		return "Contribuente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", indirizzo="
				+ indirizzo + "]";
	}

}
