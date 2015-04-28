
package ejercicio72;

import java.util.ArrayList;


public interface Actor { 
    public void addPelicula(Pelicula pelicula);
    public void deletePelicula(Pelicula pelicula);
    public ArrayList<Pelicula> getPeliculas();
}
