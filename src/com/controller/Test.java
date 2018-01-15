package com.controller;

public class Test {
    public static void main(String[] args) {
        String s = "2017;2018;17846113747;;;";
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            int a = chars[i];
            stringBuilder.append(chars[i]);
            if((i+1)<chars.length){
                if(a==59&&(chars[i+1])==59){
                    stringBuilder.append("$");
                }
            }
        }
        String result = stringBuilder.toString();
        String[] strings = result.split(";");
        for (int i = 0; i <strings.length ; i++) {
            if(strings[i].equals("$")){
                strings[i] = null;
            }
            System.out.print(strings[i]);
        }


    }
}
