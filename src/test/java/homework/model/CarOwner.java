package homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarOwner {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private String age;
    @JsonProperty("city")
    private String city;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}