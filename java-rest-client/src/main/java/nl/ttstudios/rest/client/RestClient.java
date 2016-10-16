package nl.ttstudios.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ContextConfiguration( classes = RestClient.class, loader = SpringApplicationContextLoader.class )
@WebAppConfiguration
public class RestClient {

    // 1. create client
    private static Client client = ClientBuilder.newClient();

    private static ObjectMapper mapper = new ObjectMapper();

    public static String doGet(String targetUrl) {

        // 2. set any target to client
        WebTarget target = client.target( targetUrl );

        return target.request( MediaType.APPLICATION_JSON ).get( String.class );
    }

    public static String doPost(String targetUrl, Object dto) throws JsonProcessingException {

        // 2. set any target to client
        WebTarget target = client.target( targetUrl );

        // 3. get response from message
        String body = mapper.writeValueAsString( dto );

        System.out.println( body );

        Response postResponse = target.request().post( Entity.json( body ) );
        System.out.println( "-------------->" + postResponse + "<-------------------");
        if ( postResponse.getStatus() != 201 ) {
            System.out.println( "Error!!!!" );
        }
        // Book bookResponse = postResponse.readEntity(Book.class);
        return postResponse.toString();

    }
}
