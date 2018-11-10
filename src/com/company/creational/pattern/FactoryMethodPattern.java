package com.company.creational.pattern;


/*工厂方法模式*/
public class FactoryMethodPattern {

    /*抽象产品*/
    public interface ILight{
        void turnOn();
        void turnOff();
    }

    /*具体产品类BulbLight*/
    public class BulbLight implements ILight{
        @Override
        public void turnOn() {

        }

        @Override
        public void turnOff() {

        }
    }

    /*具体产品TubeLight*/
    public class TubeLight implements ILight{
        @Override
        public void turnOn() {
            /*业务逻辑*/
        }

        @Override
        public void turnOff() {
            /*业务逻辑*/
        }
    }

    /*抽象工厂类*/
    public interface ICreateFactory{
        ILight createLight();
    }

    /*具体工厂类：BulbLight*/
    public class BulbLightFactory implements ICreateFactory{
        @Override
        public ILight createLight() {
            return new BulbLight();
        }
    }

    /*具体工厂类：TubeLight*/
    public class TubeLightFactory implements ICreateFactory{
        @Override
        public ILight createLight() {
            return new TubeLight();
        }
    }

    /*客户端实现*/
    public class Client{
        public Client(){
            //购买一个BulbLight
            ICreateFactory createBulbLightFactory = new BulbLightFactory();
            ILight bulbLight = createBulbLightFactory.createLight();
            bulbLight.turnOn();
            bulbLight.turnOff();

            //购买一个TubeLight
            //指定工厂是制造TubeLight的工厂
            ICreateFactory createTubeLightFactory = new TubeLightFactory();
            //告诉工厂要生产出TubeLight
            ILight tubeLight = createTubeLightFactory.createLight();
            //拿到生产的TubeLight，试一试它的开关功能
            tubeLight.turnOn();
            tubeLight.turnOff();
        }
    }
}
