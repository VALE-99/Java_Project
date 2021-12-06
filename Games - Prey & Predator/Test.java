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
            Random rand = new Random();    //Istance of random object
            int upperbound = 4;
            int v_leone = rand.nextInt(upperbound);
            int v_gazzella = rand.nextInt(upperbound);
            System.out.println("gazelle:" + v_gazzella);
            System.out.println("lion:" + v_leone);

            if (v_leone > v_gazzella) {
                leone.attacco();
                gazzella.points(v_leone,v_gazzella);

            } else {
                gazzella.scappa();
            }
            if (gazzella.getlife() <= 0) {
                gazzella.death();
                break;
            }
            System.out.println("the gazelle has remain " + gazzella.getlife() + "Healt Points");

            System.out.println();
            System.out.println("you still have " + tiri-- + " rolls" );
            System.out.println("press 1 to roll the dice again");
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
            System.out.println("the gazelle managed to escape from the lion");


        }
        else{
            System.out.println("the gazelle was eaten by the lion");
            clip.start();
            Thread.sleep(2000);
        }
    }
}
