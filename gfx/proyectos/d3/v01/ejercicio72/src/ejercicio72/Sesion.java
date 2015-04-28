/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio72;

public interface Sesion {
    public int ConsultarPlazasLibres();
    public void DecrementarNumPlazasLibres(int plazas);
    public int getDia();
    public Pelicula getPelicula();
    
    public String GetNombre();
    
}
