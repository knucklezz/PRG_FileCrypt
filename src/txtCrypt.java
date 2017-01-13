import java.io.*;
import java.time.chrono.ThaiBuddhistEra;

/**
 * Created by luni14 on 2016-12-09.
 */
public class txtCrypt {

    public static void main(String[]args) throws IOException{

       //För att läsa in filen input.txt
        File fileIn = new File("C:\\Users\\luni14\\Google Drive\\PRGPRG\\IdeaProjects\\FileCrypt\\src\\input.txt");
        FileReader frIn = new FileReader(fileIn);
        BufferedReader inFil = new BufferedReader(frIn);
        String radInput = inFil.readLine();


        //För att läsa in filen key.txt

        File fileKey = new File("C:\\Users\\luni14\\Google Drive\\PRGPRG\\IdeaProjects\\FileCrypt\\src\\key.txt");
        FileReader frKey = new FileReader(fileKey);
        BufferedReader inNyckelFil = new BufferedReader(frKey);
        String radKey = inNyckelFil.readLine();


        //För att skapa result.txt
        File result = new File("C:\\Users\\luni14\\Google Drive\\PRGPRG\\IdeaProjects\\FileCrypt\\src\\result.txt");
        FileWriter resultWriter = new FileWriter(result); //the true will append the new data

        //While loop för att skriva ut raden, läsa in raden, och när krypterad, gå till nästa rad
        while (radInput != null) {
            System.out.println(radInput);
             //radKey = inNyckelFil.readLine();    //Ta bort String för att läsa från fil

            //while loop key*2 så länge som den är kortare än radInput.length
            while (radInput.length() > radKey.length()){
                radKey = radKey+radKey;
            }
            String resultString = "";

            //Gå igenom varje tecken var för sig i raden som är inläst
            for(int i = 0; i < radInput.length(); i++){
                char x = crypt(radInput.charAt(i), radKey.charAt(i));
             //Spara tecken för tecken i en string
              resultString += x;
            }

            // Skriv ut rad
            System.out.println(resultString);
            //Lägg till i resultat.
            resultWriter.write(resultString + '\n');//appends the string to the file


            radInput = inFil.readLine();

        }
        inFil.close();
        resultWriter.close();
        inNyckelFil.close();
    }

    public static char crypt(char input, char key) {
     return (char)(input ^ key);
    }
}
