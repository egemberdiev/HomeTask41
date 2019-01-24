package com.company;

public class Main {

    public static void main(String[] args) {

        DBeaver connection = new DBeaver();


        System.out.println(connection.getTrainersInfo());
        System.out.println("Total: " + connection.getTrainersSalary());
        System.out.println(connection.getHallOfFame());
    }
}
