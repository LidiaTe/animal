package animals;

public abstract class Animal {
    private String name = "";
    private int age = 0;
    private int weight = 0;
    private String color = "";


//    Инициализация свойств класса через конструктор:
//    public Animal(String name, int age, int weight, String color) {
//        this.name = name;
//        this.age = age;
//        this.color = color;
//        this.weight = weight;
//    }

//    Инициализация свойств класса через геттеры:

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
//    Инициализация свойств класса через сеттеры:

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    Переопределяем метод toString:
    @Override
    public String toString(){
//        Привет! меня зовут Бобик, мне 5 лет, я вешу - 15 кг, мой цвет - черный
      return String.format("Привет! меня зовут %s, мне %d %s лет, я вешу  %d кг, мой цвет  %s", getName(), getAge(), getYearPadej(), getWeight(), getColor());
    }

//    Отпределяем падеж для количества лет:
    private String getYearPadej() {
        int ostatok = getAge() % 10;
        if (ostatok==1) {
                return "год";
        }
        if (ostatok >= 2 || ostatok < 5) {
            return "года";
        }
        if (ostatok >= 5 || getAge()>=11 && getAge()<=14) {
            return "лет";
        }
            return "лет";
        }

//        методы
        public void say(){
            System.out.println("Я говорю");
        }
        public void go(){
            System.out.println("Я иду");
        }
        public void eat(){
            System.out.println("Я ем");
        }
        public void drink(){
            System.out.println("Я пью");
        }



}

