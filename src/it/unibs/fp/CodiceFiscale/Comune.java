package it.unibs.fp.CodiceFiscale;
/**
 * La classe Comune associa al nome di ogni comune il proprio codice identificativo.
 * @author Lil Main
 *
 */
public class Comune {
	private String nome;
	private String codice;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	
	public Comune(String nome, String codice) {
		super();
		this.nome = nome;
		this.codice = codice;
	}
}
