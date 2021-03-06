package es.upm.miw.iwvg_devops;
/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {
    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean ProperFraction(){
        return this.getDenominator()>this.getNumerator();
    }

    public boolean ImproperFraction(){
        return this.getDenominator()<this.getNumerator();
    }

    public Fraction fractionMultiplication(Fraction fr1, Fraction fr2){
        int num=fr1.getNumerator()*fr2.getNumerator();
        int den=fr1.getDenominator()*fr2.getDenominator();
        Fraction frFinal = new Fraction(num,den);
        return frFinal;
    }

    public Fraction fractionDivision(Fraction fr1, Fraction fr2){
        int num=fr1.getNumerator()*fr2.getDenominator();
        int den=fr1.getDenominator()*fr2.getNumerator();
        Fraction frFinal = new Fraction(num,den);
        return frFinal;
    }

    public Fraction Biggest(Fraction fr1, Fraction fr2){
        Fraction biggest;
        if(fr1.getDenominator()==0){
            biggest=fr2;
        }else if(fr2.getDenominator()==0){
            biggest=fr1;
        }else{
            double one=fr1.numerator/fr1.denominator;
            double two=fr2.numerator/fr2.denominator;
            if(one>two){
                biggest = fr1;
            }else{
                biggest = fr2;
            }
            if(one==two){
                biggest = fr1;
            }
        }
        return biggest;
    }

    public Fraction fractionAddition(Fraction fr1, Fraction fr2){
        int num=fr1.numerator*fr2.denominator+fr2.numerator*fr1.denominator;
        int den=fr1.denominator*fr2.denominator;
        Fraction frFinal = new Fraction(num,den);
        return frFinal;
    }

    public Fraction fractionSubtraction(Fraction fr1, Fraction fr2){
        int num=fr1.numerator*fr2.denominator-fr2.numerator*fr1.denominator;
        int den=fr1.denominator*fr2.denominator;
        Fraction frFinal = new Fraction(num,den);
        return frFinal;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
