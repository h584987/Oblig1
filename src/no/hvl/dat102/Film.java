package no.hvl.dat102;

public class Film {

	private int nummer;
	private Sjanger sjanger;
	private String produsent;
	private String tittel;
	private int lanserings≈r;
	private String filmselskap;

	public Film() {
		this(0, null, "", "", 0, "");
	}

	public Film(int nummer, Sjanger sjanger, String produsent, String tittel, int lanserings≈r, String filmselskap) {
		this.nummer = nummer;
		this.sjanger = sjanger;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanserings≈r = lanserings≈r;
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

	public int getLanserings≈r() {
		return lanserings≈r;
	}

	public void setLanserings≈r(int lanserings≈r) {
		this.lanserings≈r = lanserings≈r;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

}