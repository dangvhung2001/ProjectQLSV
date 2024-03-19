package com.dsecurity.config;

public final class Constants {
    public static final String LOGIN_REGEX = "^[a-zA-Z0-9]+$";

    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static final String PHONE_REGEX = "^(0)\\d{9,10}$";

    private Constants() {}

}
