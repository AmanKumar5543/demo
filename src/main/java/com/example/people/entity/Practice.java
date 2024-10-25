package com.example.people.entity;

public class Practice {
    //    String name;
//    Integer age;
//    String address;
//
//    public Practice (String name , int age , String address){
//        this.name = name;
//        this.address = address;
//        this.age = age;
//
//
//    }
//
//    public static void main(String[] args) {
//       Practice newOne = new Practice("Aman",30, "adjslkjs");
//       Practice newTwo = new Practice("Swaraj", 35, "ahdsjhakj");
//
//        System.out.println("My name is ".toUpperCase()+ newOne.name.toUpperCase());
//        System.out.println("My name is ".toUpperCase() + newTwo.name.toUpperCase());
//    }
//
//}
    String name;
    int age;
    boolean isAgressive;
    double price;

    public Practice(String name, int age, boolean isAgressive, double price) {
        this.name = name;
        this.age = age;
        this.isAgressive = isAgressive;
        this.price = price;
    }

    public void increaseInPrice(double increasePrice) {
        double newPrice = this.price + increasePrice;
        this.price = newPrice;
    }


    public static void main(String[] args) {
        Practice firstDog = new Practice("Lucy", 4, true, 1000000);
        Practice secondDog = new Practice("Bruno", 5, false, 1324242);

        System.out.println();
        System.out.println();


    }
}