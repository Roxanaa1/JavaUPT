import org.example.laboratoare.lab5.ex1.PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerecheNumere
{
    @Test
    void testSuntConsecutiveInFibonacci()
    {
        PerecheNumere perecheNumere=new PerecheNumere(9,12);
        assertFalse( perecheNumere.suntConsecutiveInFibonacci());

         perecheNumere=new PerecheNumere(21,34);
        assertTrue( perecheNumere.suntConsecutiveInFibonacci());

         perecheNumere=new PerecheNumere(4,6);
        assertFalse( perecheNumere.suntConsecutiveInFibonacci());
    }

    @Test
    void testCMMC()
    {
        PerecheNumere perecheNumere=new PerecheNumere(1,3);
        assertEquals(3,perecheNumere.cmmc());

        perecheNumere=new PerecheNumere(3,6);
        assertTrue(perecheNumere.cmmc()==6);

        perecheNumere=new PerecheNumere(3,6);
        assertFalse(perecheNumere.cmmc()!=6);
    }

    @Test
    void testSumaCifrelorEgala()
    {
        PerecheNumere perecheNumere=new PerecheNumere(122,122);
        assertTrue(perecheNumere.sumaCifrelorEgala());

        perecheNumere=new PerecheNumere(10,10);
        assertTrue(perecheNumere.sumaCifrelorEgala());

        perecheNumere=new PerecheNumere(234,234);
        assertFalse(!perecheNumere.sumaCifrelorEgala());


    }

    @Test
    void testNumarCifrePareEgale()
    {
        PerecheNumere perecheNumere=new PerecheNumere(22,22);
        assertTrue(perecheNumere.numarCifrePareEgale());

         perecheNumere=new PerecheNumere(30,30);
        assertTrue(perecheNumere.numarCifrePareEgale());

        perecheNumere=new PerecheNumere(12,12);
        assertFalse(!perecheNumere.numarCifrePareEgale());

    }
}
