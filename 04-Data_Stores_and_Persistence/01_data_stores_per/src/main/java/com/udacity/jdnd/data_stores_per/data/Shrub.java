package com.udacity.jdnd.data_stores_per.data;

import javax.persistence.Entity;

@Entity
public class Shrub extends Plant{

    private Long heightCm;

    private Long weightCm;

    public Shrub() {
    }

    public Long getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Long heightCm) {
        this.heightCm = heightCm;
    }

    public Long getWeightCm() {
        return weightCm;
    }

    public void setWeightCm(Long weightCm) {
        this.weightCm = weightCm;
    }

    @Override
    public String toString() {
        return "Shrub{" +
                "heightCm=" + heightCm +
                ", weightCm=" + weightCm +
                '}';
    }
}
