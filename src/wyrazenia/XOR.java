package wyrazenia;

public class XOR extends WyrazenieDwuargumentowe{
    public XOR(Wyrazenie w1, Wyrazenie w2){
        super(w1, w2);
    }

    @Override
    public boolean wartosc(boolean... wartosciowanieZmiennych){
        return lewa.wartosc(wartosciowanieZmiennych) ^ prawa.wartosc(wartosciowanieZmiennych);
    }

    @Override
    public String znak(){
        return "^";
    }

    @Override
    public int priorytet(){
        return 1;
    }
}
