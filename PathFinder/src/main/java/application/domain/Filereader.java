package application.domain;

import application.datastructures.Position;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class used for reading a file and returning 2d char array.
 */
public class Filereader {
    
    /**
     * Reads a specific map file.
     * @param filename is the filename.
     * @param sizeX x length of the 2d map in the file.
     * @param sizeY y length of the 2d map in the file.
     * @return 2d char array.
     */
    public char[][] readMapFile(String filename, int sizeX, int sizeY) {
        char[][] map = new char[sizeX][sizeY];
        try {
            InputStream inputStream = getClass().getResourceAsStream("/"+filename);
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
            while (scanner.hasNextLine()) {
                for (int i = 0; i < map.length; i++) {
                    char[] line = scanner.nextLine().toCharArray();
                    for (int j = 0; j < line.length; j++) {
                        map[i][j] = line[j];
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Filereader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    /**
     * Reads test positions for benchmark-class
     * @param filename specifies which test file to read
     * @return Position array
     */
    public Position[] readTestPos(String filename) {
        Position[] positions = new Position[16];
        try {
            InputStream inputStream = getClass().getResourceAsStream("/"+filename);
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
            int index = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                int x = Integer.valueOf(line[0]);
                int y = Integer.valueOf(line[1]);
                positions[index] = new Position(x,y);
                index++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Filereader.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return positions;
    }
}
