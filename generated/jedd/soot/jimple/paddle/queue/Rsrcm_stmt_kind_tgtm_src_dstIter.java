package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rsrcm_stmt_kind_tgtm_src_dstIter extends Rsrcm_stmt_kind_tgtm_src_dst {
    protected Iterator r;
    
    public Rsrcm_stmt_kind_tgtm_src_dstIter(Iterator r, String name) {
        super(name);
        this.r = r;
    }
    
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                boolean ret = r.hasNext();
                return ret;
            }
            
            public Object next() {
                return new Tuple((SootMethod) r.next(),
                                 (Unit) r.next(),
                                 (Kind) r.next(),
                                 (SootMethod) r.next(),
                                 (VarNode) r.next(),
                                 (VarNode) r.next());
            }
            
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { srcm.v(), stmt.v(), kind.v(), tgtm.v(), src.v(), dst.v() },
                                              new PhysicalDomain[] { T1.v(), ST.v(), FD.v(), T2.v(), V1.v(), V2.v() },
                                              ("<soot.jimple.paddle.bdddomains.srcm:soot.jimple.paddle.bdddo" +
                                               "mains.T1, soot.jimple.paddle.bdddomains.stmt:soot.jimple.pad" +
                                               "dle.bdddomains.ST, soot.jimple.paddle.bdddomains.kind:soot.j" +
                                               "imple.paddle.bdddomains.FD, soot.jimple.paddle.bdddomains.tg" +
                                               "tm:soot.jimple.paddle.bdddomains.T2, soot.jimple.paddle.bddd" +
                                               "omains.src:soot.jimple.paddle.bdddomains.V1, soot.jimple.pad" +
                                               "dle.bdddomains.dst:soot.jimple.paddle.bdddomains.V2> ret = j" +
                                               "edd.internal.Jedd.v().falseBDD(); at /home/olhotak/soot-trun" +
                                               "k/src/soot/jimple/paddle/queue/Rsrcm_stmt_kind_tgtm_src_dstI" +
                                               "ter.jedd:46,61-64"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next(), r.next(), r.next(), r.next() },
                                                       new Attribute[] { srcm.v(), stmt.v(), kind.v(), tgtm.v(), src.v(), dst.v() },
                                                       new PhysicalDomain[] { T1.v(), ST.v(), FD.v(), T2.v(), V1.v(), V2.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { srcm.v(), kind.v(), stmt.v(), dst.v(), src.v(), tgtm.v() },
                                                   new PhysicalDomain[] { T1.v(), FD.v(), ST.v(), V2.v(), V1.v(), T2.v() },
                                                   ("return ret; at /home/olhotak/soot-trunk/src/soot/jimple/padd" +
                                                    "le/queue/Rsrcm_stmt_kind_tgtm_src_dstIter.jedd:50,8-14"),
                                                   ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
}
