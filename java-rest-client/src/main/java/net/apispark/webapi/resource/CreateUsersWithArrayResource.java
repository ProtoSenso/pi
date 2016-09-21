package net.apispark.webapi.resource;

public interface CreateUsersWithArrayResource {

    /**
     * 
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Post
    void createUsersWithArrayInput(net.apispark.webapi.representation.UserList bean);

}