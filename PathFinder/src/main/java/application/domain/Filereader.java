package application.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class used for reading a file and returning 2d char array.
 */
public class Filereader {
    
    /**
     * Reads a specific file.
     * @param filename is the filename.
     * @param sizeX x length of the 2d map in the file.
     * @param sizeY y length of the 2d map in the file.
     * @return 2d char array.
     */
    public char[][] readFile(String filename, int sizeX, int sizeY) {
        char[][] map = new char[sizeX][sizeY];
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/resources/" + filename)));
            while (scanner.hasNextLine()) {
                for (int i = 0; i < map.length; i++) {
                    char[] line = scanner.nextLine().toCharArray();
                    for (int j = 0; j < line.length; j++) {
                        map[i][j] = line[j];
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filereader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
}
