package wyrazenia;

public class True extends Stala{
    private static True ourInstance = new True();

    public static True daj() {
        return ourInstance;
    }

    private True() {
    }

    @Override
    public boolean wartosc(boolean... wartosciowanieZmiennych){
        return true;
    }

    @Override
    public String toString(){
        return "T";
    }
}
