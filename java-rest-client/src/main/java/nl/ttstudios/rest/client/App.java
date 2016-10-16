//package nl.ttstudios.rest.client;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import org.springframework.boot.test.SpringApplicationContextLoader;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import uk.co.cyberbliss.Book;
//
//@ContextConfiguration( classes = App.class, loader = SpringApplicationContextLoader.class )
//@WebAppConfiguration
//public class App {
//
//    // 1. create client
//    private static Client client = ClientBuilder.newClient();
//
//    private static ObjectMapper mapper = new ObjectMapper();
//
//    public static void main(String[] args) {
//
//        // Just get a response
//        System.out.println( doGet() );
//
//        // Do first post
//        try {
//            System.out.println( doPost() );
//        }
//        catch ( JsonProcessingException e ) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//    private static String doGet() {
//
//        // 2. set any target to client
//        WebTarget target = client.target( "http://localhost:9080/api/books" );
//
//        return target.request( MediaType.APPLICATION_JSON ).get( String.class );
//    }
//
//    private static String doPost() throws JsonProcessingException {
//        // 1. prepare
//        Book book = new Book();
//        book.setAuthor( "Merel Minkes" );
//        book.setIsbn( "123456789" );
//        book.setTitle( "My Biography" );
//
//        // 2. set any target to client
//        WebTarget target = client.target( "http://localhost:9080/api/book" );
//
//        // 3. get response from message
//        String body = mapper.writeValueAsString( book );
//
//        System.out.println( body );
//
//        Response postResponse = target.request().post( Entity.json( body ) );
//        if ( postResponse.getStatus() != 201 ) {
//            System.out.println( "Error!!!!" );
//        }
//        // Book bookResponse = postResponse.readEntity(Book.class);
//        return postResponse.toString();
//
//    }
//}
