package com.example.demo.dtos.continent;

import com.example.demo.models.Continent;

public class ContinentDTO {

    private String continent;
    private int area;
    private String pop;

    public ContinentDTO(Continent continent) {
        this.continent = continent.getContinent();
        this.area = continent.getArea();
        this.pop = continent.getPop();
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }
}
