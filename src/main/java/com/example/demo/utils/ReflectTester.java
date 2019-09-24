package com.example.demo.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester
{

    // 该方法实现对Customer对象的拷贝操作
    public Object copy(Object object) throws Exception
    {
        Class<?> classType = object.getClass();


        /* 生成新的对象的讨论
        // 获得Constructor对象,此处获取第一个无参数的构造方法的
        Constructor cons = classType.getConstructor(new Class[] {});//不带参数，所以传入一个为空的数组
        // 通过构造方法来生成一个对象
        Object obj = cons.newInstance(new Object[] {});

        // 以上两行代码等价于：
        Object obj11 = classType.newInstance();  // 这行代码无法处理构造函数有参数的情况
        
        //用第二个带参数的构造方法生成对象
        Constructor cons2 = classType.getConstructor(new Class[] {String.class, int.class});
        Object obj2 = cons2.newInstance(new Object[] {"ZhangSan",20});
        
        */
        
        Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        
        //获得对象的所有成员变量
        Field[] fields = classType.getDeclaredFields();
        for(Field field : fields)
        {
            //获取成员变量的名字
            String name = field.getName();    //获取成员变量的名字，此处为id，name,age
            //System.out.println(name);

            //获取get和set方法的名字
            String firstLetter = name.substring(0,1).toUpperCase();    //将属性的首字母转换为大写            
            String getMethodName = "get" + firstLetter + name.substring(1);
            String setMethodName = "set" + firstLetter + name.substring(1);            
            //System.out.println(getMethodName + "," + setMethodName);
            
            //获取方法对象
            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            //注意set方法需要传入参数类型
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
            
            //调用get方法获取旧的对象的值
            Object value = getMethod.invoke(object, new Object[]{});
            //调用set方法将这个值复制到新的对象中去
            setMethod.invoke(object, new Object[]{value});

        }

        return object;

    }

    public static void main(String[] args) throws Exception
    {
        Customer customer = new Customer("Tom",20);
        customer.setId(1L);
        ReflectTester tester = new ReflectTester();
        
        Customer customer2 = (Customer)tester.copy(customer);
        
        System.out.println(customer2.getId() + "," + customer2.getName() + "," + customer2.getAge());
        
    }
}

class Customer
{
    private long id;
    private String name;
    private int age;

    public Customer()
    {
    }

    public Customer(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}