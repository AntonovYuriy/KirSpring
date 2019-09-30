package com.spring.example1;

public class JavaClass {
    int x = getX();

    static {
        System.out.println("In static section");
    }

    {
        System.out.println("In init section");
    }

    public JavaClass() {
        System.out.println("In Constructor");
    }

    private int getX() {
        System.out.println("In method");
        return 6;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("In Finilize method");
    }
}
