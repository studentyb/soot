package soot.jimple.spark.bdddomains;

import jedd.*;

public class T1 extends PhysicalDomain {
    public int bits() { return 15; }
    
    public static PhysicalDomain v() { return T1.instance; }
    
    private static PhysicalDomain instance = new T1();
    
    public T1() { super(); }
}