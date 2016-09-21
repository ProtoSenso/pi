package net.apispark.webapi.resource;

public interface UserListResource {

    /**
     * This can only be done by the logged in user.
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Post
    void createUser(net.apispark.webapi.representation.User bean);

}