
package ejer_7_2;

import java.util.ArrayList;


public interface Actor {
    public void addPelicula(Pelicula pelicula);
    public void deletePelicula(Pelicula pelicula);
    public ArrayList<Pelicula> getPeliculas();
}
