/**La clase Contenedor representa el recurso compartido por los dos brazos y es
el objeto del proceso de vaciado */
public class Contenedor {
     int id, piezas;
     
     public Contenedor(int id, int piezas){
          this.id = id;
          this.piezas = piezas;
     }

     public boolean descargarUnaPieza(){
          return (piezas-- > 0);
     }
}
