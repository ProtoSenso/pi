/**
 * Copyright 2012-2014 TNO Geologische Dienst Nederland
 *
 * Alle rechten voorbehouden.
 * Niets uit deze software mag worden vermenigvuldigd en/of openbaar gemaakt door middel van druk, fotokopie,
 * microfilm of op welke andere wijze dan ook, zonder voorafgaande toestemming van TNO.
 *
 * Indien deze software in opdracht werd uitgebracht, wordt voor de rechten en verplichtingen van opdrachtgever
 * en opdrachtnemer verwezen naar de Algemene Voorwaarden voor opdrachten aan TNO, dan wel de betreffende
 * terzake tussen de partijen gesloten overeenkomst.
 */
package com.ttstudios.pi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author T.V.C.S. Tseng
 */
public class FileReader {

    private static final Logger LOG = LoggerFactory.getLogger( FileReader.class );

    public FileReader() {
    }

    public static byte[] read(String fileName) throws IOException {
        String path = FileReader.class.getClassLoader().getResource( fileName ).getFile();
        File file = new File( path );
        fileName = file.getName();
        return FileReader.read( file );
    }

    private static byte[] read(File file) throws IOException {
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream( file );
            int read = 0;
            while ( ( read = ios.read( buffer ) ) != -1 ) {
                ous.write( buffer, 0, read );
            }
        }
        finally {
            try {
                if ( ous != null ) {
                    ous.close();
                }
            }
            catch ( IOException e ) {
                System.err.println( e.toString() );
            }

            try {
                if ( ios != null ) {
                    ios.close();
                }
            }
            catch ( IOException e ) {
                LOG.error(e.toString(), e);
            }
        }
        return ous.toByteArray();
    }

    public List<String> readLines(Path pathToFile) throws IOException {
        Charset charset = Charset.forName( "ISO-8859-1" );
        List<String> lines = null;
        try {
            lines = Files.readAllLines(pathToFile, charset);
        }
        catch(FileNotFoundException ex){
            LOG.error("File not found: " + pathToFile);
        }
        return lines;
    }
}
