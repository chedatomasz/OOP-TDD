package wyrazenia;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Polecenie:
 * zaimplementuj projekt dotyczÄcy WyraĹźeĹ logicznych zawierajÄcy nastÄpujace klasy:
 *
 * Wyrazenie
 *    public boolean wartosc(boolean wartosciowanie_zmiennych...)
 *          wyliczba wartoĹÄ wyraĹźanie, przy zaĹoĹźeniu, Ĺźe:
 *             x_0 := wartosciowanie_zmiennych[0]
 *             x_1 := wartosciowanie_zmiennych[1]
 *             ...
 *    public String toString()
 *    public Wyrazenie neg()
 *    public Wyrazenie and(Wyrazenie arg)
 *    public Wyrazenie or(Wyrazenie arg)
 *    public Wyrazenie xor(Wyrazenie arg)
 * True
 *    public static True daj()
 * False
 *    public static False daj()
 * Zmienna
 *    public static Zmienna daj(int i) -> generuje zmiennÄ x_i
*/


public class WyrazeniaTest {

    private Wyrazenie x0 = Zmienna.daj(0);
    private Wyrazenie x1 = Zmienna.daj(1);
    private Wyrazenie x2 = Zmienna.daj(2);
    private Wyrazenie t = True.daj();
    private Wyrazenie f = False.daj();

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void test_zmienna() {
        assertEquals(true, x0.wartosc(true));
        assertEquals(false, x0.wartosc(false));
        assertEquals("x0", x0.toString());
    }

    @Test
    public void test_stale() {
        assertEquals(true, t.wartosc());
        assertEquals(true, t.wartosc(false, true));
        assertEquals("T", t.toString());

        assertEquals(false, f.wartosc());
        assertEquals(false, f.wartosc(true, false));
        assertEquals("F", f.toString());
    }

    @Test
    public void test_proste_wyrazenia(){
        Wyrazenie w1 = x0.or(x1);
        assertEquals("x0|x1", w1.toString());
        assertEquals(true, w1.wartosc(true,false));
        assertEquals(true, w1.wartosc(false,true));
        assertEquals(false, w1.wartosc(false,false));

        Wyrazenie w2 = x0.xor(x1);
        assertEquals("x0^x1", w2.toString());

        Wyrazenie tautologia = x0.or(x0.neg());
        Wyrazenie sprzecznosc = x0.and(x0.neg());
        assertEquals("x0|~x0", tautologia.toString());
        assertEquals("x0&~x0", sprzecznosc.toString());
    }

    @Test
    public void test_priorytety(){
        Wyrazenie w1 = x0.or(x1);
        Wyrazenie w2 = w1.and(x2);
        assertEquals("(x0|x1)&x2", w2.toString());
    }

    @Test
    public void test_Cheda_1(){
        Wyrazenie x3 = Zmienna.daj(3);
        Wyrazenie w1 = x0.or(x1);
        Wyrazenie w2 = x2.or(x3);
        Wyrazenie w3 = w1.xor(w2);
        assertEquals("(x0|x1)^(x2|x3)", w3.toString());
        assertTrue(w3.wartosc(true, false, false, false));
        assertFalse(w3.wartosc(true, false, true, false));
        assertFalse(w3.wartosc(false, false, false, false));
    }

    @Test
    public void test_Cheda_2(){
        Wyrazenie x3 = Zmienna.daj(3);
        Wyrazenie w1 = x0.or(x1);
        Wyrazenie w2 = x2.or(x3);
        Wyrazenie w3 = w1.or(w2);
        assertEquals( "(x0|x1)|(x2|x3)", w3.toString());
        Wyrazenie w4 = w1.and(w2);
        assertEquals( "(x0|x1)&(x2|x3)", w4.toString());
    }
    @Test
    public void test_Cheda_3(){
        Wyrazenie x3 = Zmienna.daj(3);
        Wyrazenie w1 = x0.and(x1);
        Wyrazenie w2 = x2.and(x3);
        Wyrazenie w3 = w1.and(w2);
        assertEquals("(x0&x1)&(x2&x3)", w3.toString());
        Wyrazenie w4 = w1.or(w2);
        assertEquals( "(x0&x1)|(x2&x3)", w4.toString());
    }
    @Test
    public void test_Cheda_4(){
        Wyrazenie x3 = Zmienna.daj(3);
        Wyrazenie w0 = x0.neg();
        Wyrazenie w1 = w0.and(x1);
        Wyrazenie w2 = x2.and(x3);
        Wyrazenie w3 = w1.and(w2);
        assertEquals("(~x0&x1)&(x2&x3)", w3.toString());
        Wyrazenie w4 = w1.or(w2);
        assertEquals( "(~x0&x1)|(x2&x3)", w4.toString());
    }
    @Test
    public void test_Cheda_5(){
        Wyrazenie x3 = Zmienna.daj(3);
        Wyrazenie w0 = x0.neg();
        Wyrazenie w1 = w0.and(x1);
        Wyrazenie w2 = x2.and(x3);
        Wyrazenie w3 = w1.and(w2).neg();
        assertEquals("~(~x0&x1)&(x2&x3)", w3.toString());
        Wyrazenie w4 = w1.or(w2).neg();
        assertEquals( "~(~x0&x1)|(x2&x3)", w4.toString());
    }
    @Test
    public void test_Cheda_6(){
        Wyrazenie x3 = Zmienna.daj(3);
        Wyrazenie w0 = x0.neg();
        Wyrazenie w1 = w0.and(x1);
        Wyrazenie w2 = x2.and(x3);
        Wyrazenie w3 = w1.and(w2).neg().neg();
        assertEquals("(~x0&x1)&(x2&x3)", w3.toString());
        Wyrazenie w4 = w1.or(w2).neg().neg();
        assertEquals( "(~x0&x1)|(x2&x3)", w4.toString());
    }

}