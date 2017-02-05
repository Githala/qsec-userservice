package nl.arnedeboth.qsec.userservice.configuration;

import java.util.Arrays;

/**
 * Created by quantu on 04/02/2017.
 */
public class Configuration {

    private static int port = 9001;

    private Configuration() {}

    public static int getPort()
    {
        return port;
    }

}
