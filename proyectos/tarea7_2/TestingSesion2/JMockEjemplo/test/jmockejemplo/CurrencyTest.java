package jmockejemplo;
//Otro ejemplo disponible en http://schuchert.wikispaces.com/JMock-A+Slightly+Bigger+Example

import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;

@RunWith(JMock.class)
public class CurrencyTest {

    Mockery context = new JUnit4Mockery();

    @Test
    public void ConvertirPesetas() {

        final Calculator cal = context.mock(Calculator.class);

        context.checking(new Expectations() {
            {
                oneOf(cal).multiply(1, 166);
                will(returnValue(166));
            }
        });
        Currency currency = new Currency(cal);
        assertEquals(currency.getPesetavalue(1), 166);
        // int basura=currency.getPesetavalue(166);
    }
}
