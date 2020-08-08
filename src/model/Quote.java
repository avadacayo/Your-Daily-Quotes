package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {
//	private String returnCode = "";
//	private String id = "";
//	private String quoteText = "";
//	private String quoteAuthor = "";
//	private String quoteGenre = "";
//	private int v;
	@SerializedName("_id")
	@Expose
	private String id;
	@SerializedName("quoteText")
	@Expose
	private String quoteText;
	@SerializedName("quoteAuthor")
	@Expose
	private String quoteAuthor;
	@SerializedName("quoteGenre")
	@Expose
	private String quoteGenre;
	@SerializedName("__v")
	@Expose
	private Integer v;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public String getQuoteAuthor() {
		return quoteAuthor;
	}

	public void setQuoteAuthor(String quoteAuthor) {
		this.quoteAuthor = quoteAuthor;
	}

	public String getQuoteGenre() {
		return quoteGenre;
	}

	public void setQuoteGenre(String quoteGenre) {
		this.quoteGenre = quoteGenre;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}
	
	public String toString() {
		return getQuoteText() + " - " + getQuoteAuthor();
	}
}