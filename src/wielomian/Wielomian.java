package wielomian;


public class Wielomian {
    private final int[] wspolczynniki;
    private final int stopien;
    Wielomian(int... daneWspolczynniki){
        int prawStopien = daneWspolczynniki.length-1;
        while(prawStopien >= 0 && daneWspolczynniki[prawStopien]==0){
            prawStopien--;
        }
        if(prawStopien < 0){
            this.stopien = 0;
            this.wspolczynniki = new int[1];
            this.wspolczynniki[0]=0;
            return;
        }
        this.stopien = prawStopien;
        this.wspolczynniki = new int[this.stopien+1];
        System.arraycopy(daneWspolczynniki, 0, this.wspolczynniki, 0, this.stopien+1);
    }

    @Override
    public String toString(){
        StringBuilder wynik = new StringBuilder();
        if(this.stopien == 0){
            return Integer.toString(this.wspolczynniki[0]);
        }
        for(int i = stopien; i > 0; i--){
            if(this.wspolczynniki[i] != 0){
                if(this.wspolczynniki[i] < 0){
                    wynik.append("-");
                }
                if(i!=this.stopien){
                    if(this.wspolczynniki[i] > 0){
                        wynik.append("+");
                    }
                }
                if(Math.abs(this.wspolczynniki[i])!=1){
                    wynik.append(Math.abs(this.wspolczynniki[i]));
                }
                wynik.append("x");
                if(i!=1){
                    wynik.append("^").append(i);
                }
            }
        }
        if(this.wspolczynniki[0]!=0){
            if(this.wspolczynniki[0]<0){
                wynik.append("-");
            }
            else{
                wynik.append("+");
            }

            wynik.append(Math.abs(this.wspolczynniki[0]));
        }
        return wynik.toString();
    }

    public Wielomian dodaj(Wielomian drugi){
        int[] noweWspolczynniki = new int[Math.max(this.stopien+1, drugi.stopien+1)];
        for(int i = 0; i < noweWspolczynniki.length; i++){
            noweWspolczynniki[i]=this.wspolczynniki[i]+drugi.wspolczynniki[i];
        }
        return new Wielomian(noweWspolczynniki);
    }

    public Wielomian pomnoz(Wielomian drugi){
        int[] noweWspolczynniki = new int[drugi.stopien+this.stopien+1];
        for(int i = 0; i < this.stopien+1; i++){
            for(int j = 0; j < drugi.stopien+1; j++){
                noweWspolczynniki[i+j]+=this.wspolczynniki[i]*drugi.wspolczynniki[j];
            }
        }
        return new Wielomian(noweWspolczynniki);
    }

    public Wielomian pochodna(){
        int[] noweWspolczynniki = new int[this.stopien];
        for(int i = 0; i < noweWspolczynniki.length; i++){
            noweWspolczynniki[i]=this.wspolczynniki[i+1]*(i+1);
        }
        return new Wielomian(noweWspolczynniki);
    }

    public double wartosc(double x){
        double wynik = 0;
        for(int i = stopien; i>=0; i--){
            wynik*=x;
            wynik+=this.wspolczynniki[i];
        }
        return wynik;
    }
    public int stopien(){
        return this.stopien;
    }

    public int wspolczynnik(int potega){
        if(potega>= 0 && potega<=this.stopien){
            return this.wspolczynniki[potega];
        }
        return 0;
    }

    public double[] miejscaZerowe() { // nie działa
        return new double[1];
    }

}
