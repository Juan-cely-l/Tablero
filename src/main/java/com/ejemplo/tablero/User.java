package com.ejemplo.tablero;

import java.util.ArrayList;

public class User {
    private ArrayList<String> users;
    private static User userInstance =new User();

    public static User getInstance() {
        return userInstance;
    }
    public User(){
        Color.getInstance();
        users = new ArrayList<>();
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public static User getUserInstance() {
        return userInstance;
    }

    public  void setUserInstance(String usuario) {
        if(!(users.contains(usuario))){
            users.add(usuario);
        }
    }

    public String colorPos(String usuario){
        int x=0;
        String y="";
        for (String i:users){
            if(users.get(x).equals(usuario)) {
                y = Color.getInstance().colorX();
            }
            x++;
        }
        System.out.println("El Color es:"+y);
        return y;
    }
}
