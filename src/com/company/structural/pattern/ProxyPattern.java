package com.company.structural.pattern;


/*代理模式*/
public class ProxyPattern {

    /** 代理模式包含如下角色：
     * Subject:抽象主题角色
     * Proxy:代理主题角色
     * RealSubject:真实主题角色
     **/

    /*抽象对象角色*/
    public abstract class AbstractObject{
        //操作
        public abstract void operation();
    }

    /*目标对象角色*/
    public class RealObject extends AbstractObject{
        @Override
        public void operation() {
            //操作代码
            System.out.println("执行一些操作！");
        }
    }

    /*代理对象角色*/
    public class ProxyObject extends AbstractObject{

        RealObject realObject = new RealObject();

        @Override
        public void operation() {
            //调用目标对象之前可以做相关操作
            System.out.println("before");
            realObject.operation();
            //调用目标对象之后可以做相关操作
            System.out.println("after");
        }
    }

    /*客户端实现*/
    public class Client{
        public Client(){
            AbstractObject obj = new ProxyObject();
            obj.operation();
        }
    }
}
