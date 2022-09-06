package ru.rusyaevmax.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class ReadCookies {
    public static String getValue(HttpServletRequest req, String key) {
        if (req.getCookies() != null && req.getCookies().length > 0) {
            Optional<Cookie> valueCookie = Arrays.stream(req.getCookies()).filter(x -> x.getName().equals(key)).findFirst();
            if (valueCookie.isPresent() && !valueCookie.get().getValue().equals(""))
                return valueCookie.get().getValue();
        }

        return "";
    }
}
