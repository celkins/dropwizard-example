/*
 * Copyright 2014 ESHA Research, Inc. All rights reserved.
 */
package example;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static example.ExampleApplication.ExampleConfiguration;

public final class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "example";
    }

    @Override
    public void initialize(final Bootstrap<ExampleConfiguration> bootstrap) {}

    @Override
    public void run(final ExampleConfiguration configuration, final Environment environment) throws Exception {
        environment.jersey().register(new ExampleResource());
    }

    public static class ExampleConfiguration extends Configuration {}

    @Path("/")
    public static class ExampleResource {
        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String get() {
            return "ok";
        }
    }
}
