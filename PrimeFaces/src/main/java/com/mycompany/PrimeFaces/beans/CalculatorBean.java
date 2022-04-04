package com.mycompany.PrimeFaces.beans;

import java.time.LocalDateTime;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Tomek
 */
@Named(value = "calculatorBean")
@RequestScoped
public class CalculatorBean {

    private Integer number1;
    private Integer number2;
    private Integer sum;

    public CalculatorBean() {
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }
    
    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public void add() {
        setSum(number1 + number2);
        showMessage();
    }

    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    private void showMessage() {
        String message = String.format("%s + %s = %s", number1, number2, sum);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(message));
    }
}
