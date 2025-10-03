package com.ejemplo.tablero;

import java.util.ArrayList;
import java.util.Random;

public class Color {
    private static ArrayList<String> colors;
    private static Color colorInstance =new Color();

    public static Color getInstance(){
        return colorInstance;
    }

    public Color(){
        colors=new ArrayList<>();
        RandomColor();
    }

    public void RandomColor(){
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellow");
        colors.add("purple");
        colors.add("magenta");
        colors.add("cyan");
    }

    public String colorX(){
        String x="";
        for(int i=0;i<colors.size();i++){
            Random random=new Random();
            int ranNum=random.nextInt(colors.size());
            x=colors.get(ranNum);
        }
        return x;
    }
}
