package animals.birds;

import animals.Animal;

public class Duck extends Animal implements IFlying {
    public void say(){
        System.out.println("Кря"); //переопределение метода: написали свою реализацию
    }

    public void fly(){ //переопределяем метод интерфейса
        System.out.println("Я лечу"); //переопределение метода: написали свою реализацию
    }
}
