import animals.Animal;
import data.AnimalTypeData;
import data.CommandsData;
import factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.println("Введите одну из команд add/list/exit");

            String commandStr = scanner.next().trim().toUpperCase(Locale.ROOT); //ввод с клавиатуры, удаляем пробелы вначале и в конце + переводим в верх регистр
            //Locale.ROOT - на вход передаем локаль (язык)

//-----------------Проверка от дурака на ввод с клавиатуры текста не из списка возможных команд add/list/exit-------------
            boolean isExist = false;
            for (CommandsData commandsData: CommandsData.values()){
                if (commandsData.name().equals(commandStr)){
                    isExist = true;
                    break;
                }
            }

            if (!isExist){
                System.out.println(String.format("Команда %s не поддерживается", commandStr));
                continue;
            }
// ---------------------конец защиты от дурака-------------------------
            CommandsData commandsData = CommandsData.valueOf(commandStr);

// =====================================================  ВТОРАЯ ЧАСТЬ   ==================================================================

            switch (commandsData){
                case ADD: {
                    System.out.println("Введите одно из животных CAT/DOG/DUCK");

                       String animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                       AnimalFactory animalFactory = new AnimalFactory(); //создаем объект фабрики

                    //  -----------------------------------скопированный кусок---------------------------------
                    //                       Проверка от дурака на ввод с клавиатуры
                    boolean isAnimalExist = false;
                    for (AnimalTypeData animalTypeData : AnimalTypeData.values()) {
                        if (animalTypeData.name().equals(animalStr)) {
                            isAnimalExist = true;
                            break;
                        }
                    }

                    if (!isAnimalExist) {
                        System.out.println(String.format("Животное %s не поддерживается", animalStr));
                        continue;
                    }
                    // ---------- -----------конец скопированного кода   -------------------------------------


                    Animal animal = animalFactory.create(AnimalTypeData.valueOf(animalStr)); // говорим, чтобы наша фабрика создала животное

//------------------------------------ Добавление животного в список--------------------------------------
                        while (animal == null) {
                            System.out.println("Вы ввели неверный тип животного");
                            animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                            animal = animalFactory.create(AnimalTypeData.valueOf(animalStr));
                        }

                 animals.add(fillAnimalData(animal)); //вызов animal и добавление в список
                    break;
                }
                case LIST: { //вывести список животных
                    for (Animal animal: animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0); //успешное завершение работы программы
                }
            }
        }
    }

    private static Animal fillAnimalData (Animal animal) {


        System.out.println("Введите имя животного");
        animal.setName(scanner.next());
        System.out.println("Введите цвет животного");
        animal.setColor(scanner.next());


        System.out.println("Введите возраст животного");

        Integer age = null;
        while (age == null){
            try {

                age = Integer.parseInt(scanner.next());
                //        Защита от дурака
                if (age <= 0 || age > 1000) {
                    System.out.println("Вы ввели недопустимый возраст");
                     break;

                } else {
                    animal.setAge(age);
                }
//        --------
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неправильный возраст");
                 break;
            }
        } //while




        System.out.println("Введите вес животного");
        Integer wieght = 1;
        try {
            wieght = Integer.parseInt(scanner.next());
            //        Защита от дурака
            if (wieght <= 0 || wieght > 1000) {
                System.out.println("Вы ввели недопустимый вес");

            } else {

                animal.setWeight(wieght);

            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неправильный вес");
        }

//        --------

        return animal;

    }
}