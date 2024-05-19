package baeldung.mockito.spy;

public class Animal {
    private String animalType;

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String makeSound() {
        if (getAnimalType().equalsIgnoreCase("dog")) {
            return "Woof! Woof!";
        } else {
           return "Unknown animal sound";
        }
    }
}
