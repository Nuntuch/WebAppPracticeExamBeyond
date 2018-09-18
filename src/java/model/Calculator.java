/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nuntuch Thongyoo
 */
public class Calculator {
    private double x;
    private double y;
    private String oper;

    public Calculator() {
    }

    
    public Calculator(double x, double y, String oper) {
        this.x = x;
        this.y = y;
        this.oper = oper;
    }

    public double getAns(){
        
        
        return x+y;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Override
    public String toString() {
        return "Calculator{" + "x=" + x + ", y=" + y + ", oper=" + oper + '}';
    }
    
}
