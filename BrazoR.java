/**
 * BrazoR clase que define el funcionamiento del brazo robotico
 */
public class BrazoR extends Thread{
     int id, numPiezas, tc;
     int[] turno;
     boolean[] bandera;
     Contenedor contenedor;

     public BrazoR(int id, int numPiezas, Contenedor contenedor,       int[] turno, boolean[] bandera, int tc){
          this.id = id;
          this.numPiezas = numPiezas;
          this.contenedor = contenedor;
          this.turno = turno; //variable que define de quien es el turno
          this.bandera = bandera; //bandera del argoritmo de peterson
          this.tc = tc; // tc representa el turno contrario. si el id es 0 el tc es 1 y viceversa
     }

     public void run(){
          for(int i = 0; i < numPiezas; i++){
               bandera[id-1] = true;
               turno[0] = tc;//El turno se le sede al hilo contrario

               while(bandera[tc] && turno[0] == tc){//while de espera
                    try {
                         sleep(1);
                    } catch (Exception e) {}
               }
               //Inicio de la seccion critica
               if(contenedor.descargarUnaPieza())
               {
                    System.out.printf("Brazo %d. %d piezas descargadas de %d. Quedan %d en el contenedor\n"
                    , id , i+1, numPiezas , contenedor.piezas);
               }else{
                    System.out.println("Brazo #"+id+"---No es posible seguir descargando elementos el Contenedor esta vacio!");
                    bandera[id-1] = false; 
                    break;
               }
               //Fin de la seccion critica
               bandera[id-1] = false; //se libera la bandera para el siguiente hilo
          }
     }

}