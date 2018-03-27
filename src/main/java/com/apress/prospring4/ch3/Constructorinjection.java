package com.apress.prospring4.ch3;

public class Constructorinjection {

    private Dependency dependency;

    public Constructorinjection(Dependency dependency){
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
