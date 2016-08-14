package net.apispark.webapi.resource;

public interface UserResource {

    /**
     * This can only be done by the logged in user.
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Put
    void updateUser(net.apispark.webapi.representation.User bean);

    /**
     * This can only be done by the logged in user.
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Delete
    void deleteUser();

    /**
     * 
     *
     * @return  {@link net.apispark.webapi.representation.User} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Get
    net.apispark.webapi.representation.User getUserByName();

}