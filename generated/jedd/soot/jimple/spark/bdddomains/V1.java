package soot.jimple.spark.bdddomains;

import jedd.*;

public class V1 extends PhysicalDomain {
    public int bits() { return 20; }
    
    public static PhysicalDomain v() { return V1.instance; }
    
    private static PhysicalDomain instance = new V1();
    
    public V1() { super(); }
}