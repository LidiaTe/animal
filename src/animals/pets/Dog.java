package animals.pets;

import animals.Animal;

public class Dog extends Animal { //собака стала животным: наследуется от животного

    public void say(){
        System.out.println("Гав"); //переопределение метода: написать свою реализацию
    }
}
