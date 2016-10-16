package nl.ttstudios.pi.util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PiManager {

    private static final String BASE_DIR = "/proc/";
    private static final String PATTERN = "cpuinfo";

    public static String getPiSerialNumber() throws IOException {
        String serialNumber = null;
        
        // read file
        List<String> details = readPiDetailsRaw();

        for(String detail : details){
            // readline to figure out whether it is the serialNumber
            System.out.println( detail );
        }
        return serialNumber;
    }

    private static List<String> readPiDetailsRaw() throws IOException {
        Path path = Paths.get( BASE_DIR, PATTERN );
        return FileReader.readLines( path );
    }
}
