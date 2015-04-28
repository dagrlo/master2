/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmockejemplo;

public class Currency {

    private int peseta;

    private int euro;
    private Calculator Calc;


     public Currency()
    {
        //constructor sin argumentos para hacer pruebas
        peseta = 1;
        euro = 166;
       // Calc = new Calculadora();
    }

    public Currency(Calculator p)
    {
        peseta = 1;
        euro = 166;
        Calc = p;
    }

    public int getPesetavalue(int s)
    {
         int l = Calc.multiply(s,euro);
         return l;
    }

    public int getEuroValue(int pick)
    {
         int op = Calc.divide(pick, euro);
         return op;
    }
}