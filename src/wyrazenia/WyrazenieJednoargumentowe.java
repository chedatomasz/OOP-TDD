package wyrazenia;

public abstract class WyrazenieJednoargumentowe extends Wyrazenie{
    protected final Wyrazenie w;
    public WyrazenieJednoargumentowe(Wyrazenie w){
        this.w = w;
    }
}
