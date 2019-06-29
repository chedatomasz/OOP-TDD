package ulamek;

import java.math.BigInteger;

public class Ulamek {
    public final int licznik, mianownik;
    Ulamek(int licznik, int mianownik) {
        int reductor = nwd(licznik, mianownik);
        this.licznik = licznik/reductor;
        this.mianownik = mianownik/reductor;
    }
    Ulamek(int licznik) {
        this(licznik, 1);
    }
    public int compareTo(Ulamek drugi) {
        return BigInteger.valueOf(this.licznik).multiply(BigInteger.valueOf(drugi.mianownik)).compareTo(BigInteger.valueOf(this.mianownik).multiply(BigInteger.valueOf(drugi.licznik)));
    }
    public Ulamek dodaj(Ulamek drugi) {
        int nwdmian = nwd(this.mianownik, drugi.mianownik);
        int mult2 = drugi.mianownik/nwdmian;
        int mult1 = this.mianownik/nwdmian;
        int licz = this.licznik*mult2 + drugi.licznik*mult1;
        int mian = this.mianownik*mult2;
        return new Ulamek(licz, mian);
    }
    public Ulamek dodaj(int drugi) {
        return this.dodaj(new Ulamek(drugi));
    }
    public Ulamek odejmij(Ulamek drugi) {
        return this.dodaj(drugi.pomnoz(-1));
    }
    public Ulamek odejmij(int drugi) {
        return this.odejmij(new Ulamek(drugi));
    }
    public Ulamek pomnoz(Ulamek drugi) {
        int licznik1 = this.licznik*drugi.licznik;
        int mianownik1 = this.mianownik*drugi.mianownik;
        return new Ulamek(licznik1, mianownik1);
    }
    public Ulamek pomnoz(int drugi) {
        return this.pomnoz(new Ulamek(drugi));
    }
    public Ulamek podziel(Ulamek drugi) {
        return this.pomnoz(new Ulamek(drugi.mianownik, drugi.licznik));
    }
    public Ulamek podziel(int drugi) {
        return this.podziel(new Ulamek(drugi));
    }
    private static int nwd(int a, int b) {
        if (b==0) return a;
        return nwd(b,a%b);
    }
    public String toString() {
        if(this.licznik==0){
            return "0";
        }
        int reductor = nwd(this.licznik, this.mianownik);
        int upper = this.licznik/reductor;
        int lower = this.mianownik/reductor;
        if(lower<0){
            upper*=-1;
            lower*=-1;
        }
        if(lower==1){
            return upper+"";
        }
        return (upper)+"/"+(lower);
    }
}
