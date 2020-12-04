package com.employee.service.dao;

public class Employee {
    private  String ID;//编号
    private  String name;//姓名
    private  String phone;//电话
    private  Integer job;//职位
    private  double salary;//薪资


    public   Employee(){

    }//无参构造方法

    public Employee(Integer job) {
        this.job = job;
        setSalary();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public  void  setSalary() {
        double salary = 0.0;
        Integer job = getJob();
        double baseSalary = 2200.00;
        if(job ==null||job==1){
            salary=baseSalary;
        }else if (job==2){
            salary=baseSalary*3.5;
        }else {
            salary=baseSalary*7;
        }
        this.salary=salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", job=" + job +
                ", salary=" + salary +
                '}';
    }
}
