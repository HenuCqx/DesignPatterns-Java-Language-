package com.company.structural.pattern;


import com.company.creational.pattern.AbstractFactoryPattern;

/*外观模式*/
public class FacadePattern {

    /*子系统中的类A*/
    public class ModuleA{
        public void testA(){
            System.out.println("调用ModuleA中的testA方法");
        }
    }

    /*子系统中的类B*/
    public class ModuleB{
        public void testB(){
            System.out.println("调用ModuleB中的testB方法");
        }
    }

    /*子系统中的类C*/
    public class ModuleC{
        public void testC(){
            System.out.println("调用ModuleC中的testC方法");
        }
    }

    /*外观角色类*/
    public class Facade{
        public void test(){
            ModuleA a = new ModuleA();
            a.testA();
            ModuleB b = new ModuleB();
            b.testB();
            ModuleC c = new ModuleC();
            c.testC();
        }
    }

    /*客户端实现*/
    public class Client{
        public Client(){
            Facade facade = new Facade();
            facade.test();
        }
    }
}
