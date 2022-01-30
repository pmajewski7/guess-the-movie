package pl.ergohestia.dakt.guess_the_movie;

import java.io.File;
// do not work without this package
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;


public class LoadFile {
    String location;

    public LoadFile(String locacion){
        this.location =locacion;
    }

    public ArrayList<String> GetList(String filePath) throws FileNotFoundException {

        ArrayList<String> moviesList = new ArrayList<String>();

        File file = new File("movies.txt");

        Scanner scanFile = new Scanner(file);
        while (scanFile.hasNextLine()){
            moviesList.add(scanFile.nextLine());
        }
        return moviesList;
    }

    // code the title .
    public char[] GetCodedName(String movieTitle){

        char codedMovieName[] = new char[movieTitle.length()];

        for ( int i = 0 ; i < movieTitle.length(); i++){
            if (Character.isWhitespace ( movieTitle.charAt(i)) ){
                codedMovieName[i] = ' ';
            }else{
                codedMovieName[i] = '-';
            }
        }
        return codedMovieName;
    }
}
