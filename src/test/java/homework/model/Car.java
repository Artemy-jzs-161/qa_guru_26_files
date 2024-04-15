package homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Car {
    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("year")
    private String year;

    @JsonProperty("color")
    private String color;

    @JsonProperty("mileage")
    private String mileage;

    @JsonProperty("engine")
    private CarEngine engine;

    @JsonProperty("features")
    private List<String> features = new ArrayList<String>();

    @JsonProperty("owner")
    private CarOwner owner;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getMileage() {
        return mileage;
    }

    public CarEngine getEngine() {
        return engine;
    }

    public List<String> getFeatures() {
        return features;
    }

    public CarOwner getOwner() {
        return owner;
    }

}
