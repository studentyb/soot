package soot.jimple.spark.bdddomains;

import jedd.*;
import soot.*;
import soot.jimple.spark.pag.*;

public class dtp extends Domain {
    public Numberer numberer() { return Scene.v().getTypeNumberer(); }
    
    public static Domain v() { return dtp.instance; }
    
    private static Domain instance = new dtp();
    
    public dtp() { super(); }
}