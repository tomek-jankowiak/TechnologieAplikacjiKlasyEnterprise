package ai.beans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tomek
 */
public class ColorBean {
    
    private String foregroundColor;
    private String backgroundColor;
    private boolean doBorder;

    public ColorBean() {
    }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the doBorder
     */
    public boolean isDoBorder() {
        return doBorder;
    }

    /**
     * @param doBorder the doBorder to set
     */
    public void setDoBorder(boolean doBorder) {
        this.doBorder = doBorder;
    }    
}
