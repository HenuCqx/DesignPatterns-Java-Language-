package com.company.structural.pattern;


/*适配器模式*/
public class AdapterPattern {


    /*目标适配器*/
    public interface Target{

        //源适配器有的方法
        void sampleOperation1();

        //源适配器没有的方法
        void sampleOperation2();
    }

    /*源适配器类*/
    public class Adaptee{

        public  void sampleOperation1(){
            //逻辑代码
            System.out.println("实现sampleOperation1的功能");
        }
    }
    //类适配器模式   类的适配器模式把适配的类的API转换成为目标类的API
    /*角色适配器*/
    public class Adapter extends Adaptee implements Target{
        @Override
        public void sampleOperation2() {
            //实现sampleOperation2的功能
            System.out.println("实现sampleOperation2的功能");
        }
    }


    // 对象适配器模式  与类的适配器模式一样，对象的适配器模式把被适配的类的API
    // 转换成为目标类的 API，与类的适配器模式不同的是，对象的适配器模式不是使用
    // 继承关系连接到 Adaptee类，而是使用委派关系连接到Adaptee类-+

    /*角色适配器*/
    public class Adapter2{
        private Adaptee mAdaptee;

        public Adapter2(Adaptee adaptee){
            this.mAdaptee = adaptee;
        }

        public void sampleOperation1(){
            this.mAdaptee.sampleOperation1();
        }

        public void sampleOperation2(){
            //逻辑代码
            System.out.println("实现sampleOperation2的功能");
        }
    }


    /*客户端实现*/
    public class Client{
        public Client(){
            System.out.println("类适配器模式的演示：");
            Adapter adapter = new Adapter();
            adapter.sampleOperation1();
            adapter.sampleOperation2();

            System.out.println("对象适配器模式的演示：");
            Adapter2 adapter2 = new Adapter2(new Adaptee());
            adapter2.sampleOperation1();
            adapter2.sampleOperation2();
        }
    }
}
