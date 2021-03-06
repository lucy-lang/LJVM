package org.lucylang.ljvm.node;

import org.lucylang.ljvm.machine.instruction.AndInstruction;
import org.lucylang.ljvm.machine.instruction.Instruction;
import org.lucylang.ljvm.machine.instruction.RefOperand;

public class AndExpr extends BinaryExpr {
    public AndExpr(IValue lhs, IValue rhs) {
        super(lhs, rhs);
    }

    @Override
    public Instruction getInstruction(RefOperand target, RefOperand lhsRef, RefOperand rhsRef) {
        return new AndInstruction(target, lhsRef, rhsRef);
    }
}
