package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.model.Car;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonCarParsingTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private ClassLoader cl = JsonCarParsingTest.class.getClassLoader();

    @Test
    @DisplayName("Парсинг Json-файла")
    void carJsonParsingTest() throws Exception {
        List<String> featureCar = new ArrayList<>();
        featureCar.add("leather seats");
        featureCar.add("sunroof");
        featureCar.add("backup camera");

        try (Reader reader = new InputStreamReader(cl.getResourceAsStream("homework/car.json"))) {
            Car actual = objectMapper.readValue(reader, Car.class);

            assertEquals("Toyota", actual.getBrand());
            assertEquals("Camry", actual.getModel());
            assertEquals("2022", actual.getYear());
            assertEquals("silver", actual.getColor());
            assertEquals("15000", actual.getMileage());

            assertEquals("V6", actual.getEngine().getType());
            assertEquals("3.5", actual.getEngine().getDisplacement());
            assertEquals("301", actual.getEngine().getHorsepower());

            assertEquals(featureCar, actual.getFeatures());

            assertEquals("John Doe", actual.getOwner().getName());
            assertEquals("35", actual.getOwner().getAge());
            assertEquals("New York", actual.getOwner().getCity());

        }
    }
}