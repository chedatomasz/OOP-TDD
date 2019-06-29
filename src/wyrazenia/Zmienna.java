package wyrazenia;

import java.util.ArrayList;

public class Zmienna extends Wyrazenie{
    private static ArrayList<Zmienna> ourInstances = new ArrayList<>();
    private int numer;

    public static Zmienna daj(int i){
        for(Zmienna z : ourInstances){
            if(z.numer==i){
                return z;
            }
        }
        ourInstances.add(new Zmienna(i));
        return ourInstances.get(ourInstances.size()-1);
    }

    private Zmienna(int numer) {
        this.numer = numer;
    }

    @Override
    public boolean wartosc(boolean... wartosciowanieZmiennych){
        return wartosciowanieZmiennych[this.numer];
    }

    @Override
    public String toString(){
        return "x"+numer;
    }

    @Override
    public int priorytet(){
        return 0;
    }
}
