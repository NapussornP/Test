/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;

import java.util.ArrayList;

/**
 *
 * @author LAB_621
 */

public abstract class Employee{
    private String firstname;
    private String lastname;
    private String id;
    
    public Employee(String firstname, String lastname, String id){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }
    public abstract double earning();
    public abstract double bonus(int year);
    
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
}

class SalariedEmployee extends Employee{
    double salary;
    private double sal;
    public SalariedEmployee() {
        super(null, null, null);
    }

    public SalariedEmployee(String firstname, String lastname, String id, double sal) {
        super(firstname, lastname, id);
        this.salary = sal;
    }
    
    

    @Override
    public double earning() {
        double tax = salary * 0.05;
        salary -= tax;
        return salary;
    }

    @Override
    public double bonus(int year) {
        
        if(year > 5){
             salary = 12 * salary;
        }
        else{
            salary = 6 * salary;
        }
        return salary;
    }
    
}

class ComEmployee extends Employee{
    private double sales;
    private double percent;
    double grossSale, ComRate;
    public ComEmployee() {
        super(null, null, null);
    }

    public ComEmployee(String firstname, String lastname, String id, double sales, double percent) {
        super(firstname, lastname, id);
        this.grossSale = sales;
        this.ComRate = percent;
    }

    

    
    @Override
    public double earning() {
        double Comission = grossSale * ComRate;
        grossSale = grossSale + Comission;
        return grossSale;
    }

    @Override
    public double bonus(int year) {
        if(year > 5){
            grossSale = grossSale * 6;
        }
        else{
            grossSale = grossSale * 3;
        }
        return grossSale;
    }
    
}
class Final{
    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();
        
        emp.add(new SalariedEmployee("C", "Park", "2000", 30000));
        emp.add(new SalariedEmployee("D", "Lee", "2001", 35000));
        emp.add(new ComEmployee("A", "Lee", "1001", 1000, 0.4));
        emp.add(new ComEmployee("B", "Kim", "1002", 1500, 0.2));
        
        printEmp(emp);
    }
    
    public static void printEmp(ArrayList<Employee> a){
        double[] arrEarn = new double[a.size()];
        double[] arrBonus = new double[a.size()];
        
        for(int i = 0; i < a.size();i++){
            if(a.get(i) instanceof ComEmployee){
                arrEarn[i] = a.get(i).earning();
                arrBonus[i] = a.get(i).bonus(4);
                System.out.println(a.get(i).getFirstname()+" "+a.get(i).getLastname()+" "+arrEarn[i]+" "+arrBonus[i]);
            }
            if(a.get(i) instanceof SalariedEmployee){
                arrEarn[i] = a.get(i).earning();
                arrBonus[i] = a.get(i).bonus(2);
                System.out.println(a.get(i).getFirstname()+" "+a.get(i).getLastname()+" "+arrEarn[i]+" "+arrBonus[i]);
            }
        }
    }
}