package com.mycompany.PrimeFaces.entity;

/**
 *
 * @author Tomek
 */
public class Student {

    private String firstName;
    private String lastName;
    private Double average;

    public Student() {
    }
    
    private Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.average = builder.average;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private Double average;
        
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;     
        }
        
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public Builder average(Double mean) {
            this.average = mean;
            return this;
        }
    
        public Student build() {
            return new Student(this);
        }
    }
}
