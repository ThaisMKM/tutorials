package baeldung.mockito.spy;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class AnimalTest {

    @Test
    public void testPrintSoundDog() {
        Animal dog = new Animal();
        dog.setAnimalType("dog");
        assertEquals("Woof! Woof!", dog.makeSound());
    }

    @Test
    public void testPrintSoundCatUsingSpy() {
        Animal animal = new Animal();
        animal.setAnimalType("dog");
        Animal cat = Mockito.spy(animal);
        when(cat.getAnimalType()).thenReturn("cat");
        assertEquals("Unknown animal sound", cat.makeSound());
    }

    @Test
    public void testPrintSoundCatUsingMock() {
        Animal cat = Mockito.mock(Animal.class);
        when(cat.makeSound()).thenReturn("Meow, meow");
        when(cat.getAnimalType()).thenReturn("cat");
        assertNull(cat.makeSound());
    }
}
