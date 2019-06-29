package wyrazenia;

public class NOT extends WyrazenieJednoargumentowe {
    public NOT(Wyrazenie w){
        super(w);
    }

    @Override
    public boolean wartosc(boolean... wartosciowanieZmiennych){
        return !w.wartosc(wartosciowanieZmiennych);
    }

    @Override
    public String toString(){
        return "~"+w.toString();
    }

    @Override
    public int priorytet(){
        return 0;
    }

    @Override
    public Wyrazenie neg(){ //Negating a negation makes the previous negation disappear instead of adding an extra one.
        return w;
    }
}
