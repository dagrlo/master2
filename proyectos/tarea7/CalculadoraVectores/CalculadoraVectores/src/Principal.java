//Codificado por sAfOrAs
public class Principal
{
     
    static int arreglo[]=new int[3];
    static void rellenar(int x[])
    {
        
        for(int i=0;i<x.length;i++)      
        {
            x[i]=(int)(Math.random()*100+1);
        }
    }
     
    static void imprimir(int x[])
    {
        for(int i=0;i<x.length;i++)
        {
            System.out.println("A"+"["+i+"]="+x[i]+"\t");
 
        }
            System.out.println(">>>>>>>>>>>>>>>");
     
    }
 
    static void invertir(int arreglo[])
    {
        int ar1=0,ar2=0;
        for(int i=0;i<arreglo.length/2;i++){
            ar1=arreglo[i];ar2=arreglo[arreglo.length-1-i];
            arreglo[arreglo.length-i-1]=ar1;arreglo[i]=ar2;
        }    
    }
    
    static int sumar (int arreglo[])
    {
        int ar1=0;
        //Error i deberia ser i=0
        for(int i=0;i<arreglo.length;i++){
            ar1=ar1+arreglo[i];
            
        }
        return ar1;
        
    }
    
    static int restar (int arreglo[])
    {
        int ar1=0;
        
        for(int i=0;i<arreglo.length;i++){
            //Error arreglo [i]
            //Error ar1-arreglo[i]
            ar1=ar1-arreglo[i];
            
        }
        return ar1;
        
    }
    
    static int ContarPares (int arreglo []){
        int pares=0;
    
         for(int i=0;i<arreglo.length;i++){
        if((arreglo[i]/2)*2==arreglo[i])
            pares++;
        
}
        return pares;
        
    }
 
    public static void main(String[] datos)
    {int sum,pares;
        rellenar(arreglo);
        imprimir(arreglo);
        invertir(arreglo);
        imprimir(arreglo);
        sum=sumar(arreglo);
        System.out.println("Suma="+sum);
        pares=ContarPares(arreglo);
         System.out.println("Num Pares="+pares);
    }
}
