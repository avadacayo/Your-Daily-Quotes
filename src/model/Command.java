package model;
import model.ResponseQuote;

public interface Command {
    public abstract ResponseQuote execute ( );
}