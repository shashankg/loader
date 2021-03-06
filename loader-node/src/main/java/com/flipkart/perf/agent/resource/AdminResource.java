package com.flipkart.perf.agent.resource;

import com.flipkart.perf.agent.config.LoaderAgentConfiguration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: nitinka
 * Date: 28/12/12
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/loader-agent/admin")

public class AdminResource {
    private LoaderAgentConfiguration loaderAgentConfiguration;

    public AdminResource(LoaderAgentConfiguration loaderAgentConfiguration)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this.loaderAgentConfiguration = loaderAgentConfiguration;
    }

    /**
     * Get Agent Registration Information.
     * Mostly called by Loader-Server at its boot time to confirm the availability of agent
     * @return
     * @throws java.io.IOException
     */
    @Path("/registrationInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map registrationInfo() throws IOException {
        return loaderAgentConfiguration.getRegistrationParams();
    }
}