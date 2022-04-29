package com.personal.productcatalog.utils;

import com.google.common.io.Files;
import com.personal.productcatalog.exception.MailException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class EmailUtils {

    private static final String INITIAL_PATH = "src/main/resources/email/";
    private static final String BODY_HTML_EMAIL = "-body-email.html";

    public static String readEmailBodyFile(String name) {
        String path = INITIAL_PATH + name + BODY_HTML_EMAIL;

        try {
            File file = new File(path);
            return Files.asCharSource(file, StandardCharsets.UTF_8).read();
        } catch (IOException e) {
            throw new MailException(e);
        }
    }
}
