/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {
    /**
     * saves a game to the file
     * @param level level that i'm in
     * @param fileName file where gameplay is saved
     * @return nothing
     */
    public static void save(GameLevel level, String fileName)
            throws IOException
    {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "," + level.getNaruto().getBallCount() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * saves a game to the file
     * @param game where game is initialised
     * @param fileName file where gameplay is loaded
     * @return nothing
     */
    public static GameLevel load(Game game, String fileName)
        throws IOException{
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            int ballCount = Integer.parseInt(tokens[1]);

           GameLevel level = null;
           if (name.equals("Level1"))
              level = new Level1(game);
           else if (name.equals("Level2"))
               level = new Level2(game);
           else if (name.equals("Level3"))
               level = new Level3(game);
           else if (name.equals("Level4"))
               level = new Level4(game);

           level.getNaruto().setBallCount(ballCount);

           return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
