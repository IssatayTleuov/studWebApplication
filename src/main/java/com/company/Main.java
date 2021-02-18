package com.company;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    // mavenWebApplication_war_exploded
    public static void main(String[] args) throws SQLException {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
