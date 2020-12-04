package com.employee.service.untils;


import java.util.Scanner;

public class ScannerUntils {
    public  static Scanner sc=new Scanner(System.in);//用户控制台输入信息

    public  static String getInfo(){
        return ScannerUntils.sc.next();
    }//获取输入的基本信息
}

