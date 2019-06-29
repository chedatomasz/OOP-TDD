package wyrazenia;

public abstract class WyrazenieDwuargumentowe extends Wyrazenie{
    protected final Wyrazenie lewa;
    protected final Wyrazenie prawa;

    public WyrazenieDwuargumentowe(Wyrazenie lewa, Wyrazenie prawa){
        this.lewa = lewa;
        this.prawa = prawa;
    }

    public abstract String znak();

    @Override
    public String toString(){
        String lewaString;
        if(lewa.priorytet() >= this.priorytet()){
            lewaString = "(" + lewa.toString() + ")";
        }
        else{
            lewaString = lewa.toString();
        }
        String prawaString;
        if(prawa.priorytet() >= this.priorytet()){
            prawaString = "(" + prawa.toString() + ")";
        }
        else{
            prawaString = prawa.toString();
        }


        return lewaString+this.znak()+prawaString;
    }
}
