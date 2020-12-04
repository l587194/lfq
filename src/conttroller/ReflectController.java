package conttroller;

import com.employee.service.untils.ScannerUntils;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射调用员工信息管理系统
 */
public class ReflectController {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalStateException, InstantiationException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.获取EmployeeService类的Class对象
        String className="com.employee.service.service.ServiceEmployee";
        Class clazz=Class.forName(className);
        //2.使用class.newInstance 方法创建对象
        Object instance=clazz.newInstance();
        //3.动态调用业务逻辑代码
        while (true){
            System.out.println("欢迎访问员工信息管理系统（）");
            System.out.println("请选择业务名称");
            String ser= ScannerUntils.sc.next();
            if (!"退出".equalsIgnoreCase(ser)){
                invoke(instance,ser);
            }else {
                break;
            }
        }
        System.out.println("退出成功！");

    }
    /**
     * 业务动态调用
     */
    public  static void invoke(Object instance,String ser) throws NoSuchMethodException, InvocationTargetException, IllegalStateException, IllegalAccessException {


        instance.getClass().getMethod(ser,null).invoke(instance);
    }
}
