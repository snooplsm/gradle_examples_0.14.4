package com.android.tests.basic;

import java.lang.Integer;

public class StringProvider {
    private static int proguardInt = 5;

    public static String getString(int foo) {
        return Integer.toString(foo + proguardInt);
    }
}
