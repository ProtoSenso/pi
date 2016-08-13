package net.apispark.webapi.resource;

public interface CreateUsersWithListResource {

    /**
     * 
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Post
    void createUsersWithListInput(net.apispark.webapi.representation.UserList bean);

}