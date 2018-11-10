package com.company.creational.pattern;


/*建造者模式*/
public class BuilderPattern {

    /*抽象产品类：组装一台电脑*/
    public abstract class Computer{

        protected int mCpuCore = 1;
        protected int mRamSize = 0;
        protected String mOs = "DOS";

        protected Computer(){}

        //设置CPU的核心配置
        public abstract void setCpu(int cpu);
        //设置内存
        public abstract void setRam(int ram);
        //设置系统
        public abstract void setOs( String os);

        @Override
        public String toString() {
            return "Computer:[Cpu = " + mCpuCore +",Ram = " + mRamSize
                    + ",OS = " + mOs + "]";
        }
    }

    /*具体产品类：组装苹果电脑类*/
    public class AppleComputer extends Computer{
        protected AppleComputer() {}

        @Override
        public void setCpu(int cpu) {
            mCpuCore = cpu;
        }

        @Override
        public void setRam(int ram) {
            mRamSize = ram;
        }

        @Override
        public void setOs(String os) {
            mOs = os;
        }
    }

    /*建造者抽象类*/
    public abstract class Builder{

        //设置CPU核心数
        public abstract void buildCpu(int cpu);

        //设置内存
        public abstract void buildRam(int ram);

        //设置系统
        public abstract void buildOs(String os);

        //创建Computer
        public abstract Computer createComputer();

    }

    /*建造者具体类：ApplePC建造者*/
    public class ApplePcBuilder extends Builder{

        private Computer mApplePc = new AppleComputer();

        @Override
        public void buildCpu(int cpu) {
            mApplePc.setCpu(cpu);
        }

        @Override
        public void buildRam(int ram) {
            mApplePc.setRam(ram);
        }

        @Override
        public void buildOs(String os) {
            mApplePc.setOs(os);
        }

        @Override
        public Computer createComputer() {
            return mApplePc;
        }
    }

    /*指挥者类：Director*/
    public class Director{
        Builder mBuilder = null;

        public Director(Builder builder){
            mBuilder = builder;
        }

        public void construct(int cpu , int ram , String os){
            mBuilder.buildCpu(cpu);
            mBuilder.buildRam(ram);
            mBuilder.buildOs(os);
            //return mBuilder.createComputer();
        }
    }

    /*客户端实现类*/
    public class Client{
        public Client(){
            Builder builder = new ApplePcBuilder();
            Director director = new Director(builder);
            director.construct(2,4,"IOS");
            System.out.println("Computer Information:"
                    + builder.createComputer().toString());
        }
    }
}
