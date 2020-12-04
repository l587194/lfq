package com.employee.service.service;

import com.employee.service.dao.Employee;
import com.employee.service.untils.ScannerUntils;

import javax.swing.*;
import java.util.Scanner;

/**
 * 员工信息管理系统 控制器
 */
public class EmployeeController {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        //1.创建一个员工管理service对象
        ServiceEmployee  serviceEmployee=new ServiceEmployee();

        //开始页面
        System.out.println("欢迎访问员工信息管理系统（控制台）");
        System.out.println("1.增加");
        System.out.println("2.删除");
        System.out.println("3.修改");
        System.out.println("4.查询");
        System.out.println("5.退出");
        System.out.println();

        //业务选择
        label: while (true){
            System.out.println("请选择业务");
            int select= ScannerUntils.sc.nextInt();
            switch (select){
                case 1:
                    serviceEmployee.add();//添加
                    break ;
                case 2:
                    serviceEmployee.update();//修改
                case 3:
                    serviceEmployee.delete();//删除
                case 4:
                    serviceEmployee.select();//查询
                case 5:
                    System.out.println("退出成功");
                    break label;
                default:
                    System.out.println("你输入的数字错误");
                    break;
            }

        }



    }
}
