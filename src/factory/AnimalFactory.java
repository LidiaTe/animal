package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalTypeData;

//import static data.AnimalTypeData.CAT;
//import static data.AnimalTypeData.DOG;

public class AnimalFactory {

    public Animal create(AnimalTypeData animalTypeData){

        switch (animalTypeData){
            case CAT: {
                return new Cat();
            }
            case DOG:
                return new Dog();
            default: {
                return new Duck();
            }
        }

    }
}
