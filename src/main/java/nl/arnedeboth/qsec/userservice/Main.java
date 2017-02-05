package nl.arnedeboth.qsec.userservice;

import nl.arnedeboth.qsec.userservice.configuration.Configuration;
import nl.arnedeboth.qsec.userservice.controllers.UserController;
import nl.arnedeboth.qsec.userservice.providers.IUserProvider;

import static spark.Spark.*;

/**
 * Created by quantu on 04/02/2017.
 */

public class Main {



    public static void main(String[] args)
    {
        port(Configuration.getPort());


        after(((request, response) -> {
            response.type( "application/json");
        }));

        UserController.register();
    }
}
