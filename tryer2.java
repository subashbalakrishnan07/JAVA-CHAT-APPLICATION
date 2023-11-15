package javaprogram;

import java.net.*;
import java.io.*;
import java.util.*;

class tryer2 extends Thread {
    public static Socket socket;
    public volatile int sign = 0;
    static Scanner scanner = new Scanner(System.in);

    private static String getIPAddress() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException ex) {
            return "Unknown";
        }
    }

    public void run() {
        PrintStream ps;
        BufferedReader dis;

        String getting;
        String putting;
        System.out.println("called run");
        try {
            if (sign > 0) {
                while (true) {
                    
                dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    
                    getting = dis.readLine();
                    if (getting != null)
                        System.out.println("Received:\n" + getting);
                    getting = null;
                    dis.close();
    
            }}
            else
             sign=1;
             System.out.println("changed sign");
            while (true) {
                putting = scanner.nextLine();
                ps = new PrintStream(socket.getOutputStream());
                if (!putting.isEmpty())
                    ps.println(putting);
                ps.close();
                putting = null;
            }
        } 
         catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }//catch (Exception e) {
            //System.out.println("Error received " + e);
       // }
        System.out.print("Terminating the program");
    }

    public static void main(String[] args) throws IOException {
        int indicate;

        System.out.println(getIPAddress());
        System.out.println("Enter 1 to create room\nEnter 2 to join room");

        indicate = scanner.nextInt();
        int portid;
        switch (indicate) {
            case 1:
                System.out.println("Enter portid");
                portid = scanner.nextInt();
                ServerSocket serversocket = new ServerSocket(portid);
                socket = serversocket.accept();
                Thread thread1 = new Thread();
                thread1.start();
                Thread thread2 = new Thread();
                thread2.start();
                break;
            case 2:
                System.out.println("Enter the IP address and portid of the Server");
                String inet = scanner.next();
                portid=scanner.nextInt();
                 try{
                 socket = new Socket(inet, portid);}
                 catch(Exception e){
                   socket = new Socket(InetAddress.getByName(inet), portid);
                }
                Thread thread11 = new Thread();
                thread11.start();
                Thread thread21 = new Thread();
                thread21.start();
                break;
            default:
                System.out.println("Enter the correct option");
                break;
        }
    }
}
