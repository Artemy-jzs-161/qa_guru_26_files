package homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarEngine {
    @JsonProperty("type")
    private String type;
    @JsonProperty("displacement")
    private String displacement;
    @JsonProperty("horsepower")
    private String horsepower;

    public String getType() {
        return type;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getHorsepower() {
        return horsepower;
    }

}
