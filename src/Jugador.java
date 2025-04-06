import java.util.Random;

import javax.swing.JPanel;

public class Jugador {

private int TOTAL_CARTAS = 10;
private int MARGEN = 10;
private int DISTANCIA = 40;

private Carta[] cartas= new Carta[TOTAL_CARTAS];
private Random r= new Random(); //la suerte del jugador

public void repartir(){
    for(int i=0; i<TOTAL_CARTAS; i++){
        cartas[i] = new Carta(r);
    }
}

public void mostrar(JPanel pnl){
    pnl.removeAll();
    int posicion = MARGEN + (TOTAL_CARTAS-1) * DISTANCIA;
    for(Carta carta: cartas){
        carta.mostrar(pnl, posicion, MARGEN);
        posicion -= DISTANCIA;   
    }
    pnl.repaint();
}

public String getGrupos(){
    String mensaje = "No se encontraron figuras";
    int[] contadores = new int[NombreCarta.values().length];
    for (Carta c:cartas) {
        contadores[c.getNombre().ordinal()] ++;
    }

    boolean Haygrupos = false;
    for (int contador:contadores){
        if (contador > 1){
            Haygrupos = true;
            break;
        }
    }

    if (Haygrupos){
        mensaje = "Se encontraron los siguientes grupos:\n";
        int fila = 0;
        for (int contador:contadores){
            if (contador > 1){

            
            mensaje += Grupo.values()[contador] + " de " +NombreCarta.values()[fila]+ "\n";  
        } 
        fila++;                            
        }

    
        
    }

    return mensaje;
}

public String getEscalera(){
    String message = "No hay escaleras";
    int[] cont= new int[Pinta.values().length];
    for (Carta ca:cartas) {
        cont[ca.getPinta().ordinal()] ++;
    }

    boolean Hayescalera = false;

    for (int count:cont){
        if (count > 0){
            Hayescalera = true;
        }
    }

    if(Hayescalera){
        message = "Se encontraron las siguientes escaleras:\n";
        int filas = 0;
        for (int count:cont){
            if(count > 0){
                message += Grupo.values()[count] + " de " + Pinta.values()[filas] + "\n";
            }
        filas ++;
        }
    }

    return message;
}

public String getPuntaje(){
    String messag = "No hay escaleras";
    int[] contad= new int[NombreCarta.values().length];
    for (Carta car:cartas) {
        contad[car.getNombre().ordinal()] ++;
    }
    return messag;
}

}
