package com.haifachagwey;

public class AnonymousClasses {

    interface Animal {
        void eat();
        void sleep();
    }

    static class Cat implements Animal {
        @Override
        public void eat() {
            System.out.println("Cat is eating");
        }

        @Override
        public void sleep() {
            System.out.println("Cat is sleeping");
        }
    }
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
        cat.sleep();
//        Cat is eating
//        Cat is sleeping
    }
}
