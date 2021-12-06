import java.util.Random;
import javax.sound.sampled.*;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        Leone leone = new Leone();
        Gazzella gazzella = new Gazzella();
        int tiri = 7;
        //file audio
        File file = new File("LionSound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        Scanner scanner = new Scanner(System.in);
        String response = "";


        for (int i = 0; i < 7; i++) {
            Random rand = new Random();    //Creo un istanza di random (oggetto v di tipo random).
            int upperbound = 4; //imposto il limite a 4 del massimo valore random ottenibile
            int v_leone = rand.nextInt(upperbound);
            int v_gazzella = rand.nextInt(upperbound);
            System.out.println("gazzella:" + v_gazzella);
            System.out.println("leone:" + v_leone);

            if (v_leone > v_gazzella) {
                leone.attacco();
                gazzella.points(v_leone,v_gazzella);
               // gazzella.life();
            } else {
                gazzella.scappa();
            }
            if (gazzella.getlife() <= 0) {
                gazzella.death();
                break;
            }
            System.out.println("la gazzella ha ancora " + gazzella.getlife() + "punti vita");

            System.out.println();
            System.out.println("ti rimangono " + tiri-- + " tiri" );
            System.out.println("premi 1 per tirare i dadi ancora i dadi");
            while(!response.equals("1")){
                response = scanner.next();
            }
            response = "";
            System.out.println();
            System.out.println();

        }

        System.out.println();
        System.out.println();

        if(gazzella.getlife() > 0){
            System.out.println("la gazzella è riuscita a scappare");


        }
        else{
            System.out.println("la gazzella è stata mangiata dal leone");
            clip.start();
            Thread.sleep(2000);
        }
    }
}
