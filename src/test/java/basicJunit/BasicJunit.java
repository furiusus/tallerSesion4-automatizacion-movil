package basicJunit;

import org.junit.jupiter.api.*;

public class BasicJunit {
    @BeforeAll
    static void beforAll(){
        System.out.println("ejecutado antes que todo");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("ejecutado despues que todo");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Se ejecuta antes de cada test");
    }

    @AfterEach
    public void cleanup(){
        System.out.println("Se ejecuta luego de cada test");
    }

    @Test
    public void thisIsMyTest() {
        System.out.println("Este es mi test");
    }

    @Test
    public void thisIsMyScdTest(){
        System.out.println("Este es mi 2do test");
    }
}
