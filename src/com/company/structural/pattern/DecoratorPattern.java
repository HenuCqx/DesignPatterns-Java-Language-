package com.company.structural.pattern;

/*装饰者模式*/
public class DecoratorPattern {

    /*抽象构件角色*/
    public interface Component{
        void sampleOperation();
    }

    /*具体构件角色*/
    public class ConcreateComponent implements Component{
        @Override
        public void sampleOperation() {
            //相关业务代码
            System.out.println("我是孙猴子！");
        }
    }

    /*装饰角色*/
    public class Decorator implements Component{
        public Component mComponent;

        public Decorator(Component component){
            this.mComponent = component;
        }
        @Override
        public void sampleOperation() {
            //	委派给构件
            mComponent.sampleOperation();
        }
    }

    /*具体装饰角色A*/
    public class ConcreateDecoratorA extends Decorator{

        public ConcreateDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void sampleOperation() {
            // 写业务代码
            System.out.println("我想变1");
            super.sampleOperation();
            // 写业务代码
            System.out.println("我还会变成一条鱼");
        }
    }

    /*具体装饰角色B*/
    public class ConcreateDecoratorB extends Decorator {
        public ConcreateDecoratorB(Component component) {
            super(component);
        }

        @Override
        public void sampleOperation() {
            System.out.println("我想变2");
            super.sampleOperation();
            // 写逻辑代码
            System.out.println("我还会变成一只鸟");
        }
    }

    /*客户端实现*/
    public class Client{
        public Client(){
            Component component = new ConcreateComponent();
            Component A = new ConcreateDecoratorA(component);
            Component B = new ConcreateDecoratorB(A);
            B.sampleOperation();
        }
    }
}
