package pl.ergohestia.dakt.guess_the_movie;

import java.util.ArrayList;
import java.util.Scanner;
// do not work without this package .
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//load file
        LoadFile loadFile = new LoadFile("movies.txt");
//create array
        ArrayList<String> moviesList = loadFile.GetList("movies.txt");
        String movieName = moviesList.get( (int) ( Math.random() *  moviesList.size()));
        char[] codedMovieName = loadFile.GetCodedName(movieName);
        int remaining = movieName.replace(" ","").trim().length();
        String wrongLetters = "";

 //loop while not won
        boolean win= false;
        while (!win) {
            boolean letterExists = false;

            System.out.println("Title to guess.: ");
            System.out.println(codedMovieName);
            System.out.println("Letters already checked: " + wrongLetters);
            System.out.println("Letter.: ");


            Scanner input = new Scanner(System.in);
            char letter = input.nextLine().charAt(0);

            for (int i = 0; i < movieName.length(); i++){
                if (movieName.charAt(i) == letter){
                    codedMovieName[i] = letter;
                    letterExists = true;
                }
            }
//check if the letter apperars in the title
            if(letterExists){
                System.out.println("This letter appears in the title.");
            }else{
                System.out.println("This letter doesn't apear in title.");
                wrongLetters = wrongLetters + " "+ letter;
            }


            int letterCount = 0;
            for (int i = 0; i < codedMovieName.length; i++){
                if (codedMovieName[i] != '-' && codedMovieName[i] != ' '){
                    letterCount ++;
                }
            }
            remaining = movieName.replace(" ","").trim().length() - letterCount;


          // Check if won.
            if (remaining == 0)
                win  = true;
            System.out.println("--------------------------------------");

        }
    }
}
