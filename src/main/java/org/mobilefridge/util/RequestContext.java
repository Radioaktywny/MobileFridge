/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.util;

public class RequestContext {
    private static ThreadLocal<String> usernames = new ThreadLocal<>();

    public static void setUsername(String username) {
        usernames.set(username);
    }
    //TODO
}
