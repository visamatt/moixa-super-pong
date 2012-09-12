package eu.moixa.pong;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Push encoded JSON data packets through a file byte stream.
 * 
 * 
 * @author Ryan Beckett
 * @version 1.0
 * @since Dec 23, 2011
 */
public class JSONPacketTest {

    public static void main(String[] args) throws Exception {

        String file = "./data/out.json";
        String json = "{\"author\":{\"name\":\"Joe Shmoe\"}}";
        String encd = "UTF-8";

        // write JSON to file
        JSONWriter wrtr = new JSONPacketWriter(
                new FileOutputStream(file, false), encd);
        wrtr.write(json);
        wrtr.close();
        System.out.println("Successfully wrote JSON data to file");

        // read JSON from file
        JSONReader rdr = new JSONPacketReader(new FileInputStream(file), encd);
        String retrievedJSON = rdr.read();
        rdr.close();
        System.out.println("Retrieved XML: " + retrievedJSON);
    }
}

