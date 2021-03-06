package org.lucylang.ljvm.library;

import org.lucylang.ljvm.machine.instruction.*;
import org.lucylang.ljvm.machine.module.Module;
import org.lucylang.ljvm.machine.module.NotExecutableException;
import org.lucylang.ljvm.machine.module.Routine;
import org.lucylang.ljvm.scope.OverdefinedException;
import org.lucylang.ljvm.value.NumberValue;

public class Math extends Module {
    public Math() throws OverdefinedException, InvalidInstruction, NotExecutableException {
        super("math");
        this.defineRoutine("floor", new Routine(new Instruction[]{
                new PopInstruction(new RefOperand("n")),
                new IntInstruction(new RefOperand("n"), new RefOperand("n")),
                new PushInstruction(new RefOperand("n")),
                new RetInstruction()
        }));
        this.defineRoutine("ceil", new Routine(new Instruction[]{
                new PopInstruction(new RefOperand("n")),
                new IntInstruction(new RefOperand("$1"), new RefOperand("n")),
                new LesInstruction(new RefOperand("$2"), new RefOperand("$1"), new RefOperand("n")),
                new BeqInstruction(new RefOperand("$2"), new ValueOperand(new NumberValue(6))),
                new PushInstruction(new RefOperand("$1")),
                new RetInstruction(),
                new AddInstruction(new RefOperand("$1"), new RefOperand("$1"), new ValueOperand(new NumberValue(1))),
                new PushInstruction(new RefOperand("$1")),
                new RetInstruction()
        }));
        this.defineRoutine("random", new Routine(new Instruction[]{
                new RemInstruction(new RefOperand("$1")),
                new PushInstruction(new RefOperand("$1")),
                new RetInstruction()
        }));
    }
}
