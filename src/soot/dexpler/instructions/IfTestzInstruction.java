/* Soot - a Java Optimization Framework
 * Copyright (C) 2012 Michael Markert, Frank Hartmann
 * 
 * (c) 2012 University of Luxembourg - Interdisciplinary Centre for
 * Security Reliability and Trust (SnT) - All rights reserved
 * Alexandre Bartel
 * 
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.dexpler.instructions;

import org.jf.dexlib.Code.Instruction;
import org.jf.dexlib.Code.Format.Instruction21t;

import soot.IntType;
import soot.dexpler.DexBody;
import soot.dexpler.IDalvikTyper;
import soot.jimple.BinopExpr;
import soot.jimple.IfStmt;
import soot.jimple.Jimple;
import soot.jimple.internal.JIfStmt;

public class IfTestzInstruction extends ConditionalJumpInstruction {

    JIfStmt jif = null;
  
    public IfTestzInstruction (Instruction instruction, int codeAdress) {
        super(instruction, codeAdress);
    }

    protected IfStmt ifStatement(DexBody body) {
        Instruction21t i = (Instruction21t) instruction;
        BinopExpr condition = getComparisonExpr(body, i.getRegisterA());
        jif = (JIfStmt) Jimple.v().newIfStmt(condition,
                                    targetInstruction.getUnit());
        // setUnit() is called in ConditionalJumpInstruction
        return jif;
        
		}
		public void getConstraint(IDalvikTyper dalvikTyper) {
		  BinopExpr condition = (BinopExpr) jif.getCondition();
				if (IDalvikTyper.ENABLE_DVKTYPER) {
           int op = instruction.opcode.value;
           switch (op) {
           case 0x38:
           case 0x39:
             dalvikTyper.addConstraint(condition.getOp1Box(), condition.getOp2Box());
             break;
           case 0x3a:
           case 0x3b:
           case 0x3c:
           case 0x3d:
             dalvikTyper.setType(condition.getOp1Box(), IntType.v());
             break;
           default:
             throw new RuntimeException("error: unknown op: 0x"+ Integer.toHexString(op));
           }
        }
        
    }
}
