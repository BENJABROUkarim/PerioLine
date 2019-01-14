package fr.adservio.test.exception;

public class Exception {

	private String erreur;

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	public Exception(String erreur) {
		super();
		this.erreur = erreur;
	}

}
