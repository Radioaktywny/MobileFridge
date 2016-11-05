package org.mobilefridge.util;

public class RequestContext {
    private static ThreadLocal<String> usernames = new ThreadLocal<>();

    public static void setUsername(String username) {
        usernames.set(username);
    }
    //TODO
}
