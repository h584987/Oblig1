package no.hvl.dat102;

public class Film {

	private int nummer;
	private Sjanger sjanger;
	private String produsent;
	private String tittel;
	private int lanseringsÅr;
	private String filmselskap;

	public Film() {
		this(0, null, "", "", 0, "");
	}

	public Film(int nummer, Sjanger sjanger, String produsent, String tittel, int lanseringsÅr, String filmselskap) {
		this.nummer = nummer;
		this.sjanger = sjanger;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsÅr = lanseringsÅr;
		this.filmselskap = filmselskap;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsÅr() {
		return lanseringsÅr;
	}

	public void setLanseringsÅr(int lanseringsÅr) {
		this.lanseringsÅr = lanseringsÅr;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

}