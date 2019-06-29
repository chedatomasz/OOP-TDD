package wyrazenia;

public abstract class Wyrazenie {
    public Wyrazenie xor(Wyrazenie w2){
        return new XOR(this, w2);
    }
    public Wyrazenie or(Wyrazenie w2){
        return new OR(this, w2);
    }
    public Wyrazenie and(Wyrazenie w2){
        return new AND(this, w2);
    }
    public Wyrazenie neg(){
        return new NOT(this);
    }
    public abstract boolean wartosc(boolean... wartosciowanieZmiennych);

    public abstract int priorytet();
}
