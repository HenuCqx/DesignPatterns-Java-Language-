package com.company;

import com.company.creational.pattern.BuilderPattern;
import com.company.structural.pattern.AdapterPattern;

public class Main {

    public static void main(String[] args) {

        /*//建造者模式
        BuilderPattern builderPattern = new BuilderPattern();
        builderPattern.new Client();*/

        //适配器模式
        AdapterPattern adapterPattern = new AdapterPattern();
        adapterPattern.new Client();
    }
}
