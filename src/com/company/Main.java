package com.company;

import com.company.creational.pattern.BuilderPattern;
import com.company.demo.design.patterns.AdapterPatternDemo;
import com.company.structural.pattern.AdapterPattern;
import com.company.structural.pattern.DecoratorPattern;
import com.company.structural.pattern.FacadePattern;

public class Main {

    public static void main(String[] args) {

        /*//建造者模式
        BuilderPattern builderPattern = new BuilderPattern();
        builderPattern.new Client();*/

        /*//适配器模式
        AdapterPattern adapterPattern = new AdapterPattern();
        adapterPattern.new Client();*/


        /*//在新版本的客户端上实现Enumeration的功能
        AdapterPatternDemo adapterPatternDemo = new AdapterPatternDemo();
        adapterPatternDemo.new Client();*/

        /*//装饰者模式
        DecoratorPattern decoratorPattern = new DecoratorPattern();
        decoratorPattern.new Client();*/

        //外观模式
        FacadePattern facadePattern = new FacadePattern();
        facadePattern.new Client();
    }
}
