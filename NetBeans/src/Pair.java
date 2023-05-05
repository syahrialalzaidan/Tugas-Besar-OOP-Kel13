import java.io.Serializable;

public class Pair<A, B, C> implements Serializable{
    private A A;
    private B B;
    private C C;

    public Pair(A a, B b, C c){
        A = a;
        B = b;
        C = c;
    }

    public A getA(){
        return A;
    }
    public B getB(){
        return B;
    }
    public C getC(){
        return C;
    }
    public void setA(A a){
        A =a;
    }
    public void setB(B b){
        B = b;
    }
    public void setC(C c){
        C = c;
    }
}
