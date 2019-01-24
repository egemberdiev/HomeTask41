package com.company;

import java.sql.*;

class DBeaver {
    public final String url = "jdbc:postgresql://localhost:5432/";
    public final String user = "postgres";
    public final String password = "123";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public int getTrainersInfo() {
        String SQL = "select t.*, s.salary from trainers t join sport_types s on t.sport_type_id = s.sport_type_id";
        int count = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println(rs.getInt("trainer_id") + " " + rs.getString("full_name") + " "
                        + rs.getInt("sport_type_id") + " " + rs.getInt("salary"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int getTrainersSalary() {
        String SQL = "select t.*, s.salary from trainers t join sport_types s on t.sport_type_id = s.sport_type_id";

        int sum = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {

                sum = sum + rs.getInt("salary");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sum;
    }

    public int getHallOfFame() {
        String SQL = "select t.*, s.salary from trainers t join sport_types s on t.sport_type_id = s.sport_type_id";


        int count = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                String info = rs.getString("full_name");

                char[] chars = info.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (chars.length > 3) {

                    }
                }
                System.out.println(rs.getString("full_name") + " молодец");

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

}