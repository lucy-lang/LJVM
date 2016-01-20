package org.lucylang.ljvm.machine.instruction;

import org.lucylang.ljvm.machine.Machine;
import org.lucylang.ljvm.machine.OverdefinedException;
import org.lucylang.ljvm.machine.UndefinedException;
import org.lucylang.ljvm.value.Value;

import java.util.ArrayList;

public class DefInstruction extends Instruction {
    public DefInstruction(Operand<String> ref, Operand value) {
        this.type = Type.DEF;
        this.operands = new ArrayList<Operand>();
        this.operands.add(ref);
        this.operands.add(value);

        this.validSize = 2;
        this.validRefs = new int[]{0};
    }

    @Override
    public void executeValid(Machine vm) throws InvalidInstruction, UndefinedException, OverdefinedException {
        Value v = this.getValue(vm, 1);
        String ref = this.getRef(0);
        vm.defineRegister(ref, v);
    }
}