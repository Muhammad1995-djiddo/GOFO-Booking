package GOFO.System;

import GOFO.UI.UI;
import GOFO.User.PlaygroundOwner;
import GOFO.User.User;
import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;
import GOFO.Utilities.Playground;

import java.util.*;

public class GoFo {

    // Store all users and their ids
    private static Map<String, User> users = new HashMap<>();

    // Store all playgrounds and theirs ids
    private static Map<String, Playground> playgrounds = new HashMap<>();

    /**
     * Constructs a Gofo object
     * <p>add an administrator user
     * <p>Initialize an UI object
     */
    public GoFo() {
        users.put("admin", new User("admin123"));
        PlaygroundOwner user = new PlaygroundOwner("Guy","Cherubin", "12563254452369",
                "gchrbn@gmail.com", "gchrbn1234", "01228331194",
                new Address(25, "Gizah", "Cairo"),
                new Ewallet(2500, "12563254452369"));

        users.put("12563254452369", user);

        playgrounds.put("12563254452369", new Playground("Gofo",user,
                "12563254452369", 25, new Address(25, "Dooi", "Cairo"),
                "25-25", "9-22", 1));
        playgrounds.put("125632544523691", new Playground("Gofo",user,
                "125632544523691", 25, new Address(25, "Dooi", "Cairo"),
                "25-25", "9-22", 1));
        playgrounds.put("125632544523692", new Playground("Gofo",user,
                "125632544523692", 25, new Address(25, "Dooi", "Cairo"),
                "25-25", "9-22", 1));
        new UI();
    }


    /**
     * Checks if a given email exists in the User database
     * @param email to be checked
     * @return true if exists otherwise returns false
     */
    public static boolean existEmail(String email) {
        for (User user: users.values()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a new user object to the users database
     * @param id user id
     * @param user user to add
     */
    public static void adduser(String id, User user) {
        users.put(id, user);
        System.out.println("Your account has been created successfully.");
    }

    /**
     * Checks if a given id exists in the users database
     * @param id to be checked
     * @return true if exists otherwise false
     */
    public static boolean existID(String id) {

        return users.containsKey(id);
    }

    /**
     * Returns a user info given his/her id
     * @param id user's identification
     * @return user object if id exists otherwise returns null
     */
    public static User getUserInfo(String id) {

        if (users.containsKey(id)) {
            return users.get(id);
        }

        return null;
    }


    /**
     * Validate a password
     * @param id user id
     * @param password to be checked
     * @return true if equals otherwise returns false
     */
    public static boolean validPassword(String id, String password) {
        if (users.containsKey(id)) {
            return users.get(id).getPassword().equals(password);
        }
        return false;
    }

    /**
     * Validate a password in the database
     * @param password to be validated
     * @return true if equals otherwise false
     */
    public static boolean validAdminPassword(String password) {

        return users.get("admin").getPassword().equals(password);
    }

    /**
     * Add a playground to the playground database
     * @param playgroundID playground id
     * @param playground playground to be added
     */
    public static void addPlayground(String playgroundID, Playground playground) {
        playgrounds.put(playgroundID, playground);
    }

    /**
     * Returns the playgrounds of an owner
     * @param playgroundOwnerID playground owner id
     * @param playgroundID playground id
     * @return playgrounds
     */
    public static ArrayList<Playground> getPlaygrounds(String playgroundOwnerID, String playgroundID) {
        ArrayList<Playground> ownerPlaygrounds = new ArrayList<>();
        if (playgroundOwnerID.equals("") && playgroundID.equals(""))
            ownerPlaygrounds.addAll(playgrounds.values());
        else {
            if (!playgroundOwnerID.equals("") && playgroundID.equals("")) {
                for (Playground playground: playgrounds.values()) {
                    if (playground.getPlaygroundOwner().getId().equals(playgroundOwnerID)) {
                        ownerPlaygrounds.add(playground);
                    }
                }
            }
            else {
                if (playgrounds.containsKey(playgroundID)) {
                    ownerPlaygrounds.add(playgrounds.get(playgroundID));
                }
                else {
                    return ownerPlaygrounds;
                }
            }
        }
        return ownerPlaygrounds;
    }

    /**
     * Activate a playground.
     * @param playgroundID playground id
     */
    public static void activatePlayground(String playgroundID) {
        playgrounds.get(playgroundID).setActivated(true);
    }
}
