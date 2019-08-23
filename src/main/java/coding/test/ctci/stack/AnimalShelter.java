package coding.test.ctci.stack;

import java.util.LinkedList;

public class AnimalShelter {

    private LinkedList<Animal> dogs = new LinkedList<>();

    private LinkedList<Animal> cats = new LinkedList<>();

    int order = 0;

    public void eneque(Animal animal) {

        animal.setOrder(order++);

        if (animal instanceof Dog) {
            dogs.add(animal);
        } else {
            cats.add(animal);
        }

    }

    public Animal deque() {

        if (cats.isEmpty() && dogs.isEmpty()) {
            return null;
        }

        if (cats.isEmpty()) {
            return dequeDog();
        } else if (dogs.isEmpty()) {
            return dequeCat();
        } else {

            Animal cat = cats.peek();

            Animal dog = dogs.peek();

            if (cat.getOrder() < dog.getOrder()) {
                return cats.poll();
            } else {
                return dogs.poll();
            }

        }
    }

    public Animal dequeDog() {

        if (!dogs.isEmpty()) {
            return dogs.poll();
        }

        return null;
    }

    public Animal dequeCat() {

        if (!cats.isEmpty()) {
            return cats.poll();
        }

        return null;
    }

    public static void main(String[] args) {

        Animal dog1 = new Dog("Tom1");
        Animal dog2 = new Dog("Tom2");
        Animal dog3 = new Dog("Tom3");


        Animal cat1 = new Cat("Cat1");
        Animal cat2 = new Cat("Cat2");
        Animal cat3 = new Cat("Cat3");

        AnimalShelter shelter = new AnimalShelter();

        shelter.eneque(dog1);
        shelter.eneque(dog2);
        shelter.eneque(cat3);
        shelter.eneque(cat1);
        shelter.eneque(dog3);
        shelter.eneque(cat2);


        System.out.println(shelter.deque());
        System.out.println(shelter.dequeCat());

        System.out.println(shelter.deque());
        System.out.println(shelter.deque());
    }
}
