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
    public void testSoundUsingSpy() {
        Animal dog = new Animal();
        dog.setAnimalType("dog");
        Animal spyDog = Mockito.spy(dog);
        when(spyDog.getAnimalType()).thenReturn("bird");
        assertEquals("Woof! Woof!", dog.makeSound());
        assertEquals("Unknown animal sound", spyDog.makeSound());
    }

    @Test
    public void testSoundCatUsingMock() {
        Animal cat = Mockito.mock(Animal.class);
        when(cat.makeSound()).thenReturn("Meow, meow");
        when(cat.getAnimalType()).thenReturn("cat");
        assertNull(cat.makeSound());
    }
}
