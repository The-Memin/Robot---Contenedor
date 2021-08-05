/*sistema que permita vaciar un
contenedor */
public class Sistema{
    public static void main(String[] args){
        boolean[] bandera = {false,false};
        int[] turno = {0};

        Contenedor contenedor1 = new Contenedor(1, 50);
        BrazoR brazo1 = new BrazoR(1, 25, contenedor1, turno, bandera, 1); //Brazo 1 se envia un 1 del identificador del turno contrario
        BrazoR brazo2 = new BrazoR(2, 25, contenedor1, turno, bandera, 0);
        
        brazo1.start();
        brazo2.start();
    }
}