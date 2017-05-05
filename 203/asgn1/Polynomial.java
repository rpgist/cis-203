/*
 * James Hawkins
 * CIT 203 
 * Assignment 1
 */

public class Polynomial{
    
    //feilds
    private int degree;
    private double [] element;

    //constructor
    public Polynomial(int degreeVar, double [] coefficients){
        this.degree = degreeVar;
        this.element = new double[degree+1];
        for(int i = 0; i<= degree; i++){
            this.element[i] = coefficients[i];
        }
    }

    public String toString(){
        String result="";
        //checks if its greater then 0 degree
        if(degree>0){
            //checks if degree is greater than 1
            if(degree>1){
                result += element[degree]+"x^"+degree;
                //adds up until degree 1
                for(int i=degree-2;i>=2;i--){
                    //adds + if possitive and not 1
                    if(element[i]>1)
                        result+=" + "+element[i]+"x^"+i;
                    //adds +x if its just 1
                    if(element[i]==1)
                        result+=" + x^"+i;
                    //adds if negative
                    if(element[i]<0)
                        result+=element[i]+"x^"+i;
                }
                //adds degree 1
                //checks if its only x
                if(element[1]==1)
                    result+="x";
                //checks if its posstive
                if(element[1]>1)
                    result+=" + " + element[1]+"x";
                //if its negative
                if(element[1]<0)
                    result+=" "+element[1]+"x"; 
                 //adds degree 0
                 //checks if possitive
                 if(element[0]>0)
                    result+=" + "+element[0];
                 //if negative
                 if(element[0]<0)
                    result+=element[0];
            }
            //if degree is 1
            if(degree==1){
                //if its 1
                if(element[1]==1){
                    result+="x";                
                }
                //if its not 1
                if (element[1]!= 1)
                    result+=element[1]+"x";
                //adds zero degree
                if(element[0]>0)
                    result+=" + "+element[0];
                if(element[0]<0)
                    result+=element[0];
            }
        }
        //if degree is 0
        if(degree==0)
            result+=element[0];
        return result;
    }

    public double evaluate(double x){
        double result;
        if(degree==0)
            return this.element[0];
        if(degree==1){
            result=this.element[0];
            result+=this.element[1]*x;
            return result;
        }
        result=this.element[0];
        for(int i = degree; i>0;i--){
            double var =Math.pow(x,i);
            result+=element[i]*var;
        }
        return result;    
    }

    public boolean equals(Polynomial other){
        if( other.degree != this.degree)
            return false;
        for(int i= 0; i<degree+1; i++){
            if(other.element[i]!= this.element[i])
                return false;

        }
        return true;

    }
}
