package org.lucylang.ljvm.generator;

import org.lucylang.ljvm.machine.instruction.*;
import org.lucylang.ljvm.node.*;
import org.lucylang.ljvm.value.NumberValue;
import org.lucylang.ljvm.visitor.Visitor;

import java.util.ArrayList;

public class ExprCodeGenerator extends Visitor {
    private int registerCounter = 0;

    private RefOperand getNewRegister() {
        String ref = "tmp" + registerCounter;
        registerCounter++;
        return new RefOperand(ref);
    }

    private int acceptLiteral(IValue node, ArrayList<Instruction> instructions, RefOperand target) {
        assert node != null;
        assert instructions != null;
        assert target != null;
        ValueOperand vo = null;
        if (node instanceof BooleanLiteral) {
            vo = this.visitBooleanLiteral((BooleanLiteral) node);
        } else if (node instanceof NumberLiteral) {
            vo = this.visitNumberLiteral((NumberLiteral) node);
        } else if (node instanceof StringLiteral) {
            vo = this.visitStringLiteral((StringLiteral) node);
        }
        if (vo != null) {
            instructions.add(new MovInstruction(target, vo));
            return 1;
        } else {
            return 0;
        }
    }

    private int acceptRef(IValue node, ArrayList<Instruction> instructions, RefOperand target) {
        assert node != null;
        assert instructions != null;
        assert target != null;
        RefOperand ref = null;
        if (node instanceof VarName) {
            ref = this.visitVarName((VarName) node);
        }
        if (ref != null) {
            instructions.add(new MovInstruction(target, ref));
            return 1;
        } else {
            return 0;
        }
    }

    private int acceptBinaryExpr(IValue node, ArrayList<Instruction> instructions, RefOperand target) {
        assert node != null;
        assert instructions != null;
        assert target != null;
        if (!(node instanceof BinaryExpr)) return 0;
        BinaryExpr expr = (BinaryExpr) node;
        IValue lhs = expr.getLhs(), rhs = expr.getRhs();
        int count = 0;
        RefOperand lhsRef = this.getNewRegister();
        count += this.acceptLiteral(lhs, instructions, lhsRef);
        count += this.acceptRef(lhs, instructions, lhsRef);
        count += this.acceptBinaryExpr(lhs, instructions, lhsRef);
        RefOperand rhsRef = this.getNewRegister();
        count += this.acceptLiteral(rhs, instructions, rhsRef);
        count += this.acceptRef(rhs, instructions, rhsRef);
        count += this.acceptBinaryExpr(rhs, instructions, rhsRef);
        if (expr instanceof AddExpr) {
            instructions.add(new AddInstruction(target, lhsRef, rhsRef));
            return 1 + count;
        } else if (expr instanceof AndExpr) {
            instructions.add(new AndInstruction(target, lhsRef, rhsRef));
            return 1 + count;
        }
        return 0;
    }

    @Override
    public ValueOperand visitBooleanLiteral(BooleanLiteral node) {
        assert node != null;
        return new ValueOperand(node.getValue());
    }

    @Override
    public ValueOperand visitNumberLiteral(NumberLiteral node) {
        assert node != null;
        return new ValueOperand(node.getValue());
    }

    @Override
    public ValueOperand visitStringLiteral(StringLiteral node) {
        assert node != null;
        return new ValueOperand(node.getValue());
    }

    @Override
    public RefOperand visitVarName(VarName node) {
        assert node != null;
        return new RefOperand(node.getVarName());
    }

    @Override
    public int visitBinaryExpr(BinaryExpr expr, ArrayList<Instruction> instructions) {
        return this.acceptBinaryExpr(expr, instructions, this.getNewRegister());
    }

    @Override
    public int visitAssignment(Assignment assignment, ArrayList<Instruction> instructions) {
        RefOperand ref = this.getNewRegister();
        int count = this.acceptBinaryExpr(assignment.getExpr(), instructions, ref);
        RefOperand target = this.visitVarName(assignment.getVarName());
        instructions.add(new MovInstruction(target, ref));
        return count + 1;
    }

    @Override
    public int visitIfElse(IfElse ifElse, ArrayList<Instruction> instructions) {
        assert ifElse != null;
        assert instructions != null;
        BinaryExpr expr = ifElse.getExpr();
        RefOperand conditionRef = this.getNewRegister();
        int index = instructions.size();
        int numberOfInstruction = this.acceptBinaryExpr(expr, instructions, conditionRef);
        BneInstruction bneInstruction = new BneInstruction(conditionRef, new ValueOperand(0));
        instructions.add(bneInstruction);
        ArrayList<IStmt> ifStmts = ifElse.getIfNodes();
        for (int i = 0; i < ifStmts.size(); i++) {
            numberOfInstruction += this.visitStmt(ifStmts.get(i), instructions);
        }
        numberOfInstruction += 2;    // Bne Instruction and Goto Instruction
        bneInstruction.setTarget(new ValueOperand(index + numberOfInstruction));
        GotoInstruction gotoInstruction = new GotoInstruction(new ValueOperand(0));
        instructions.add(gotoInstruction);
        ArrayList<IStmt> elseStmts = ifElse.getElseNodes();
        for (int i = 0; i < elseStmts.size(); i++) {
            numberOfInstruction += this.visitStmt(elseStmts.get(i), instructions);
        }
        gotoInstruction.setTarget(new ValueOperand(index + numberOfInstruction));
        return numberOfInstruction;
    }
}
