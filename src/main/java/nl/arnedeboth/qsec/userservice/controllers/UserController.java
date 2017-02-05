package nl.arnedeboth.qsec.userservice.controllers;

import com.google.gson.Gson;
import nl.arnedeboth.qsec.userservice.DummyUserProvider;
import nl.arnedeboth.qsec.userservice.models.User;
import nl.arnedeboth.qsec.userservice.providers.IUserProvider;
import spark.Request;
import spark.Response;

import java.util.Optional;

import static spark.Spark.*;

/**
 * Created by quantu on 04/02/2017.
 */
public class UserController {

    static Gson gson = new Gson();

    // TODO: DI
    static IUserProvider userProvider = new DummyUserProvider();

    public static void register()
    {
        get("/users", UserController::getUsers, gson::toJson);
        get("/user/id/:id", UserController::getUser, gson::toJson);
        get("/user/badge/:id", UserController::getUserByBadgeId, gson::toJson);
    }

    private static Object getUsers(Request request, Response response)
    {
        return userProvider.getUsers();
    }

    private static Object getUser(Request request, Response response)
    {
        Optional<Integer> maybeId = tryParseInt(request.params(":id"));

        // No valid id has been provided
        if (!maybeId.isPresent())
        {
            response.status(400);
            return "No valid id has been provided.";
        }


        User user = userProvider.getUserById(maybeId.get());

        // Return 404 if the user has not been found.
        if (user == null) {
            response.status(404);
            return null;
        }

        return user;
    }

    private static Object getUserByBadgeId(Request request, Response response)
    {
        String badgeId = request.params(":id");

        User user = userProvider.getUserByBadgeId(badgeId);

        if (user == null) {
            response.status(404);
            return null;
        }

        return user;
    }



    /* -------------------
         Helper Functions
       ------------------- */

    private static Optional<Integer> tryParseInt(String in)
    {
        try
        {
            return Optional.of(Integer.parseInt(in));
        } catch (NumberFormatException nfe)
        {
            return Optional.empty();
        }
    }
}
