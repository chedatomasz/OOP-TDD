package wyrazenia;

public class False extends Stala{
    private static False ourInstance = new False();

    public static False daj() {
        return ourInstance;
    }

    private False() {
    }

    @Override
    public boolean wartosc(boolean... wartosciowanieZmiennych){
        return false;
    }

    @Override
    public String toString(){
        return "F";
    }
}
