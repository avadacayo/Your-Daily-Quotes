package model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseQuote {
	@SerializedName("statusCode")
	@Expose
	private Integer statusCode;
	@SerializedName("quote")
	@Expose
	private Quote quote;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}
}
