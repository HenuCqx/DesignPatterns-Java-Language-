package com.company.creational.pattern;


/*抽象工厂模式*/
public class AbstractFactoryPattern {

    /*苹果产品系列*/
    public interface Apple{
        void AppleStyle();
    }

    /*三星产品系列*/
    public interface Sumsung{
        void SumsungStyle();
    }

    /*具体产品：苹果手机*/
    public class Iphone implements Apple{
        @Override
        public void AppleStyle() {
            /*业务逻辑*/
            System.out.println("生产一部Iphone手机");
        }
    }

    /*具体产品：苹果IPAD*/
    public class Ipad implements Apple{
        @Override
        public void AppleStyle() {
            /*业务逻辑*/
            System.out.println("生产一台Ipad平板");
        }
    }

    /*具体产品：三星手机*/
    public class Note9 implements Sumsung{
        @Override
        public void SumsungStyle() {
            /*业务逻辑*/
            System.out.println("生产一部三星手机");
        }
    }

    /*具体产品：三星平板*/
    public class Tabs implements Sumsung{
        @Override
        public void SumsungStyle() {
            /*业务逻辑*/
            System.out.println("生产一台三星平板");
        }
    }

    /*抽象工厂*/
    public interface Factory{
        Apple createAppleProduct();
        Sumsung createSumsungProduct();
    }

    /*具体工厂：手机工厂*/
    public class PhoneFactory implements Factory{
        @Override
        public Apple createAppleProduct() {
            /*业务代码*/
            return new Iphone();
        }

        @Override
        public Sumsung createSumsungProduct() {
            /*业务代码*/
            return new Note9();
        }
    }

    /*具体工厂：平板工厂*/
    public class PadFactory implements Factory{
        @Override
        public Apple createAppleProduct() {
            /*业务代码*/
            return new Ipad();
        }

        @Override
        public Sumsung createSumsungProduct() {
            /*业务代码*/
            return new Tabs();
        }
    }

    /*客户端实现*/
    public class Client{
        public Client(){
            //采购一台Ipad和一台Tabs
            Factory padFactory = new PadFactory();
            Apple ipad = padFactory.createAppleProduct();
            ipad.AppleStyle();
            Sumsung tabs = padFactory.createSumsungProduct();
            tabs.SumsungStyle();

            //采购一部Iphone和一部note9
            Factory phoneFactory = new PhoneFactory();
            Apple iphone = phoneFactory.createAppleProduct();
            iphone.AppleStyle();
            Sumsung note9 = phoneFactory.createSumsungProduct();
            note9.SumsungStyle();
        }
    }
}
