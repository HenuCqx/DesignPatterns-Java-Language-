package com.company;

import com.company.creational.pattern.BuilderPattern;

public class Main {

    public static void main(String[] args) {
        BuilderPattern builderPattern = new BuilderPattern();
        BuilderPattern.Client client = builderPattern.new Client();
    }
}
