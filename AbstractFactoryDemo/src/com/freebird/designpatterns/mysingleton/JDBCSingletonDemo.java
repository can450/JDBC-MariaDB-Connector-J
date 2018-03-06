package com.freebird.designpatterns.mysingleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBCSingletonDemo {

    static int count=1;
    static int choice;

    public static void main(String args[]) throws IOException {

        JDBCSingleton jdbc = JDBCSingleton.getJDBCConnector();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean connected = false;

        do{
            if(connected){
                System.out.println("DATABASE OPERATIONS");
                System.out.println(" --------------------- ");
                System.out.println(" 1. Insertion ");
                System.out.println(" 2. View      ");
                System.out.println(" 3. Delete    ");
                System.out.println(" 4. Update    ");
                System.out.println(" 5. Exit      ");

                System.out.print("\n");
                System.out.print("What should we do now? ");
                choice=Integer.parseInt(br.readLine());
            }
            else {
                System.out.println("DATABASE OPERATIONS");
                System.out.println(" --------------------- ");
                System.out.println(" 5. Exit      ");
                System.out.println(" 6. Connect   ");
                System.out.print("\n");
                System.out.print("Not connected to the DB. First you need to connect to access to operations.");
                choice=Integer.parseInt(br.readLine());
            }

            switch (choice){
                case 1:{
                    if(connected){
                        System.out.print("What username should we insert?");
                        String userName=br.readLine();
                        System.out.print("What should be the password?");
                        String password=br.readLine();
                        try {
                            int i = jdbc.insert(userName, password);
                            if(i>0) System.out.println((count++) + " User inserted successfully");
                            else System.out.println("The user has not been inserted");
                            System.out.println("Press Enter key to continue...");
                            System.in.read();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    else {//ignore input, a connection needs to be made first
                    }
                }
                case 2:{
                    if(connected){}
                    else{//ignore input

                    }
                }
                case 3:{
                    if(connected){}
                    else{//ignore input

                    }
                }
                case 4:{
                    if(connected){}
                    else{//ignore input

                    }
                }
                case 5:{

                }
                case 6:{
                    if(connected){//ignore input

                    }
                    else{

                    }
                }
            }



        }
        while(true);


    }


}
