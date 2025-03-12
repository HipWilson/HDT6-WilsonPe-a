package lib;

import org.junit.*;

public class PokemonTest {
    @Test
    public void test(){
        PokemonTest pok = new PokemonTest(); 
        Assert.assertEquals(pok, pok);
    }
}
