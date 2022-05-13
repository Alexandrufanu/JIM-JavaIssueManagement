package com.example.jim;

import java.sql.Connection;

public interface DatabaseController {

    public static void select(String item){};

    private static Connection connect(){return null;};
    public static void insert(String username){};
}
