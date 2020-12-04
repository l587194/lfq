package com.employee.service.service;

import com.employee.service.dao.Employee;
import com.employee.service.untils.ScannerUntils;

import java.util.Scanner;

public class ServiceEmployee {
    static  int len=-1;//len代表数组下标默认值为-1；
    static Employee[] employees=new Employee[200];//建立一个Employee数组容量为200；

    /**
     * 添加员工信息
     */
    public void   add(){
        Employee em=null;
        System.out.println("添加新员工");

        System.out.println("请输入员工编号");
        String ID=ScannerUntils.sc.next();
        System.out.println("请输入员工姓名");
        String  name=ScannerUntils.getInfo();
        System.out.println("请输入员工电话");
        String  phone=ScannerUntils.getInfo();
        System.out.println("请输入员工职务(员工，经理，副总)");
        String job=ScannerUntils.getInfo();

        //根据输入的员工职务的数据，调用有参构造方法，进行初始化
       if (job.equals("员工")){
           em = new Employee(1);
       }else  if (job.equals("经理")){
           em=new Employee(2);
       }else {
           em=new Employee(3);
       }
       em.setID(ID);
       em.setName(name);
       em.setPhone(phone);
       //len先加1后使用，变为emp[0]
        len=len+1;
        employees[len]=em;
        display(employees[len]);
        System.out.println("添加成功");
    }


    /**
     * 修改员工信息
     */
       public  void  update(){
           System.out.println("修改员工");
           System.out.println("请输入员工姓名");
       //设置一个布尔类型的变量找不到则为false；
           boolean flg=false;
           String name=ScannerUntils.sc.next();
           for (int i=0;i<=employees.length;i++){
               //从数组里面取出实体类对象
               Employee dto=employees[i];
               if (dto!=null && dto.getName()!=null&& dto.getName().equals(name)){
                   Employee employee=new Employee();
                   display(dto);
                   System.out.println("请按照提示输入修改信息");
                   System.out.println("请输入员工编号：");
                   employee.setID(ScannerUntils.sc.next());
                   System.out.println("请输入员工姓名");
                   employee.setPhone(ScannerUntils.sc.next());
                   System.out.println("请输入员工电话号码");
                   employee.setName(ScannerUntils.sc.next());
                   System.out.println("请输入员工的岗位等级");
                   employee.setJob(ScannerUntils.sc.nextInt());
                   employee.setSalary();
                   //修改完后打印
                   display(employee);
                   //把修改好的数据放回去
                   employees[i]=employee;
                   System.out.println("修改成功");
                   flg=true;

                   break;

               }
           }if (!flg){
               System.out.println("查无此人，请重新输入");
               update();
           }


       }
    /**
     * 删除员工信息
     */
       public void  delete(){
           System.out.println("删除员工");
           System.out.println("请输入员工姓名");
           boolean flg=false;
           String name=ScannerUntils.sc.next();
           //获取当前数组的长度
           Integer currenthLength=employees.length;
           System.out.println("currenthLength="+currenthLength);
           for (int i=0;i<currenthLength;i++) {
               //从数组里面取出实体类对象
               Employee dto = employees[i];
               //若查找成功则把employees[i]数组后面的指针向前移一位，覆盖当前的指向对象
               if (dto!=null && dto.getName()!=null&& dto.getName().equals(name)) {
                   Employee employee = new Employee();
                       display(dto);
            for(int j=i;j<currenthLength;j++){
                if (j!=currenthLength-1){
                    employees[j]=employees[j+1];
                }
            }
            //前移后，最后一位置空
            employees[currenthLength-1]=null;
                   System.out.println("成功删除");
                   flg=true;
                   break;
               }
           }if (!flg){
               System.out.println("查无此人，请重新输入");
               update();
           }

       }
    /**
     * 查询
     */
      public  void  select(){
          System.out.println("查找员工信息");
          System.out.println("请输入员工姓名");
          boolean flg=false;
          String name=ScannerUntils.sc.next();
          for (int i=0;i<employees.length;i++){
              Employee dto=employees[i];
              if (dto== null ||dto.getName()==null){
                  continue;
              }if (name.equals(dto.getName())){
                  display(dto);
                  System.out.println("查找成功");
                  flg=true;
                  break;
              }
          }if (!flg){
              System.out.println("查无此人，请重新输入");
              select();

          }

      }






    /**
     *
     * 打印员工信息
     */
    public  void display(Employee employee){
        System.out.println(employee.toString());
    }

}
