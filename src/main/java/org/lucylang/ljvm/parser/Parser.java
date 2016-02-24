package org.lucylang.ljvm.parser;

import org.lucylang.ljvm.node.*;
import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "grammar.beaver".
 */
public class Parser extends beaver.Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short ID = 1;
		static public final short LPAREN = 2;
		static public final short NOT = 3;
		static public final short BOOL_LITERAL = 4;
		static public final short NUMBER_LITERAL = 5;
		static public final short STRING_LITERAL = 6;
		static public final short NONE_LITERAL = 7;
		static public final short RCURLY = 8;
		static public final short PLUS = 9;
		static public final short MINUS = 10;
		static public final short TIMES = 11;
		static public final short DIV = 12;
		static public final short AND = 13;
		static public final short OR = 14;
		static public final short EQUAL = 15;
		static public final short NEQ = 16;
		static public final short GT = 17;
		static public final short LT = 18;
		static public final short GEQ = 19;
		static public final short LEQ = 20;
		static public final short LCURLY = 21;
		static public final short FUNC = 22;
		static public final short RPAREN = 23;
		static public final short COMMA = 24;
		static public final short ASSIGN = 25;
		static public final short STMT_TAIL = 26;
		static public final short SEMICOLON = 27;
		static public final short VAR = 28;
		static public final short IF = 29;
		static public final short WHILE = 30;
		static public final short RETURN = 31;
		static public final short ELSE = 32;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pTbSbtL4KKXtylOoSW4A3fe4mX2O6CJGOCKvXK38E4GSQS0oY7QSMmOWT$WajtxDYvS#V" +
		"E7SgCCYeW8A2CCYhWvQkNukLrwERGMrwThtvrxws#LLt3UrAmNpMQfCcgLwEQbLQhsZLDdP" +
		"gXGgtI$9pHGRaZTYbdB5$$A9NfInLhfRgfKqhgGtsaCMRwWDXWPbYauQfGINyioZL28pLMY" +
		"xHKFM$apzUUhRdgqW9zea$rcLtEjDzxgzl#YrQaL2kKo5YVU7kzDjZ$6g9XMXYjVO4#jpjs" +
		"omxZgzOirS8uJT1QrT6Q0Yx3U3NuLXDQgHRggT067V0nJ8UPC0VcmMBu0fQ3s#r1AcVqeVR" +
		"0xjbThD7sXzssl#qlLL4cKfPecLtXlAos#rgZTHAzobHEFPWJDKH3cNa59yfbgsKkgPpHv5" +
		"iYYPonVFqrpA2IapvP0NK3Qzp4AhSmmbHYRePrnAOGxO#zpjLt6yQorkFVo9#l7R2BXTorO" +
		"cvQAQDdsk#$fMX52lZthHdh4sy7xCUeS5zgehLFSpSIb7PyxXGwsl2b8ijbg8nQJYT4iNV5" +
		"xNQI#vM8IjmAAACfrQ7FdPS48rRp7atotthtAtncIi5mjClRcx691xMqEz4Uv##B1SDW8sp" +
		"oVLTu$#POdw$WQwY7DR0Lji5ss06xeG7s#FuRgBw59ZZeynxo#Xrnvg3lqTde3y3u#X6x73" +
		"sCLg0dq1Hw5XX3bu1nz2ViWpjme7#EUWJJuRcPFNtjpmPvUw60HectowX6eBlGRw3A#$T2D" +
		"p1UiCNxTcR99yQyuTOsqwyRFhx0s#v$kpKiYlN9#4sMt8ko#4gzLiHyIQyfhsEyZlDQxRNE" +
		"QxtNHg$DNjDUMxssUvqsO0wTNcUyRVwn$hDWfMztmIhVdZkWNyy0UtschLxvn$vLzDXJlXT" +
		"zhOVm4bxOSsLzxAPnXkmQN8GBS1xE0MVDpi2ly0kSXbDm4axOx$ORUZpCSSoEsX7xsNwow#" +
		"7EEz$Ls1Z$W8Mjn$347japZ0xUA87SBPp4#yVTNaSxf7bBfSEtJWaKysOgWe1RNWo5V2KSG" +
		"VZzo4OZ#TheqqQxtbE3tG1Dq0mj#5heLuNsKPWd1Q5EvBTnEbu1uoKiXm==");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN6 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 6];
		}
	};

	static final Action RETURN5 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 5];
		}
	};

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
		}
	};

    @Override
    protected void recoverFromError(Symbol token, TokenStream in) throws java.io.IOException, Exception {
        super.recoverFromError(new Symbol(0), in);
    }

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] maybe_tail = stmt_tails
			Action.NONE,  	// [1] maybe_tail = 
			RETURN2,	// [2] stmt_tails = stmt_tails stmt_tail; returns 'stmt_tail' although none is marked
			Action.RETURN,	// [3] stmt_tail = STMT_TAIL
			Action.RETURN,	// [4] stmt_tail = SEMICOLON
			Action.RETURN,	// [5] module = functions
			new Action() {	// [6] functions = functions maybe_tail function
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [7] functions = function
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN6,	// [8] function = FUNC ID LPAREN parameters RPAREN block_statements; returns 'block_statements' although none is marked
			RETURN5,	// [9] function = FUNC ID LPAREN RPAREN block_statements; returns 'block_statements' although none is marked
			RETURN4,	// [10] parameters = parameters COMMA ID COMMA; returns 'COMMA' although none is marked
			Action.RETURN,	// [11] parameters = ID
			new Action() {	// [12] block_statements = LCURLY maybe_tail statements.stmts maybe_tail RCURLY
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_stmts = _symbols[offset + 3];
					final SymbolList stmts = (SymbolList) _symbol_stmts.value;
					 return stmts;
				}
			},
			new Action() {	// [13] block_statements = LCURLY maybe_tail RCURLY
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new SymbolList();
				}
			},
			new Action() {	// [14] statements = statements.stmts stmt_tails statement.stmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_stmts = _symbols[offset + 1];
					final SymbolList stmts = (SymbolList) _symbol_stmts.value;
					final Symbol stmt = _symbols[offset + 3];
					 if(stmt instanceof SymbolList) {
                   SymbolList list = (SymbolList) stmt;
                   for(int i=0; i<list.size(); i++) {
                       stmts.add(list.get(i));
                   }
               } else {
                   stmts.add(stmt);
               }
               return stmts;
				}
			},
			new Action() {	// [15] statements = statement.stmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol stmt = _symbols[offset + 1];
					 if(stmt instanceof SymbolList) {
                   return stmt;
               } else {
                   SymbolList list = new SymbolList();
                   list.add(stmt);
                   return list;
               }
				}
			},
			new Action() {	// [16] statement = var_statement.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol var = _symbols[offset + 1];
					 return var;
				}
			},
			new Action() {	// [17] statement = assign_statement.assign
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_assign = _symbols[offset + 1];
					final Assignment assign = (Assignment) _symbol_assign.value;
					 return assign;
				}
			},
			new Action() {	// [18] statement = if_statement.ifStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_ifStmt = _symbols[offset + 1];
					final IfElse ifStmt = (IfElse) _symbol_ifStmt.value;
					 return ifStmt;
				}
			},
			new Action() {	// [19] statement = if_else_statement.ifStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_ifStmt = _symbols[offset + 1];
					final IfElse ifStmt = (IfElse) _symbol_ifStmt.value;
					 return ifStmt;
				}
			},
			new Action() {	// [20] statement = while_statement.whileStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_whileStmt = _symbols[offset + 1];
					final While whileStmt = (While) _symbol_whileStmt.value;
					 return whileStmt;
				}
			},
			new Action() {	// [21] statement = return_statement.returnStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_returnStmt = _symbols[offset + 1];
					final Return returnStmt = (Return) _symbol_returnStmt.value;
					 return returnStmt;
				}
			},
			new Action() {	// [22] var_statement = VAR var_declarations.declarations
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_declarations = _symbols[offset + 2];
					final SymbolList declarations = (SymbolList) _symbol_declarations.value;
					 return declarations;
				}
			},
			new Action() {	// [23] var_declarations = var_declarations.declarations COMMA var_declaration.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_declarations = _symbols[offset + 1];
					final SymbolList declarations = (SymbolList) _symbol_declarations.value;
					final Symbol var = _symbols[offset + 3];
					 declarations.add(var);
               return declarations;
				}
			},
			new Action() {	// [24] var_declarations = var_declaration.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol var = _symbols[offset + 1];
					 SymbolList list = new SymbolList();
               list.add(var);
               return list;
				}
			},
			new Action() {	// [25] var_declaration = ID.varName
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol varName = _symbols[offset + 1];
					 return new Assignment(new VarName((String) varName.value), new NoneLiteral());
				}
			},
			new Action() {	// [26] var_declaration = assign_statement.assignment
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_assignment = _symbols[offset + 1];
					final Assignment assignment = (Assignment) _symbol_assignment.value;
					 return assignment;
				}
			},
			new Action() {	// [27] assign_statement = ID.varName ASSIGN expr.value
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol varName = _symbols[offset + 1];
					final Symbol _symbol_value = _symbols[offset + 3];
					final IValue value = (IValue) _symbol_value.value;
					 return new Assignment(new VarName((String) varName.value), value);
				}
			},
			new Action() {	// [28] if_statement = IF expr.value block_statements.statements
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 2];
					final IValue value = (IValue) _symbol_value.value;
					final Symbol _symbol_statements = _symbols[offset + 3];
					final SymbolList statements = (SymbolList) _symbol_statements.value;
					 IfElse ifElse = new IfElse(value);
               for(int i=0; i<statements.size(); i++)
                   ifElse.addStmtIf((IStmt) statements.get(i));
               return ifElse;
				}
			},
			new Action() {	// [29] if_else_statement = if_statement.ifElse ELSE block_statements.statements
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_ifElse = _symbols[offset + 1];
					final IfElse ifElse = (IfElse) _symbol_ifElse.value;
					final Symbol _symbol_statements = _symbols[offset + 3];
					final SymbolList statements = (SymbolList) _symbol_statements.value;
					 for(int i=0; i<statements.size(); i++)
                   ifElse.addStmtElse((IStmt) statements.get(i));
               return ifElse;
				}
			},
			new Action() {	// [30] while_statement = WHILE expr.value block_statements.statements
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 2];
					final IValue value = (IValue) _symbol_value.value;
					final Symbol _symbol_statements = _symbols[offset + 3];
					final SymbolList statements = (SymbolList) _symbol_statements.value;
					 While whileStmt = new While(value);
               for(int i=0; i<statements.size(); i++)
                   whileStmt.addStmt((IStmt) statements.get(i));
               return whileStmt;
				}
			},
			new Action() {	// [31] return_statement = RETURN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new Return();
				}
			},
			new Action() {	// [32] return_statement = RETURN expr.value
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 2];
					final IValue value = (IValue) _symbol_value.value;
					 return new Return(value);
				}
			},
			new Action() {	// [33] expr = literal_expr.literal
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol literal = _symbols[offset + 1];
					 return literal;
				}
			},
			new Action() {	// [34] expr = ID.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol id = _symbols[offset + 1];
					 String value = (String) id.value;
               return new VarName(value);
				}
			},
			new Action() {	// [35] expr = expr.left PLUS expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new AddExpr(left, right);
				}
			},
			new Action() {	// [36] expr = expr.left MINUS expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new SubExpr(left, right);
				}
			},
			new Action() {	// [37] expr = expr.left TIMES expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new MulExpr(left, right);
				}
			},
			new Action() {	// [38] expr = expr.left DIV expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new DivExpr(left, right);
				}
			},
			new Action() {	// [39] expr = expr.left AND expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new AndExpr(left, right);
				}
			},
			new Action() {	// [40] expr = expr.left OR expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new OrExpr(left, right);
				}
			},
			new Action() {	// [41] expr = expr.left EQUAL expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new EquExpr(left, right);
				}
			},
			new Action() {	// [42] expr = expr.left NEQ expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new NotExpr(new EquExpr(left, right));
				}
			},
			new Action() {	// [43] expr = expr.left GT expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new GreExpr(left, right);
				}
			},
			new Action() {	// [44] expr = expr.left LT expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new LesExpr(left, right);
				}
			},
			new Action() {	// [45] expr = expr.left GEQ expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new GeqExpr(left, right);
				}
			},
			new Action() {	// [46] expr = expr.left LEQ expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new LeqExpr(left, right);
				}
			},
			new Action() {	// [47] expr = NOT expr.left
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 2];
					final IValue left = (IValue) _symbol_left.value;
					  return new NotExpr(left);
				}
			},
			new Action() {	// [48] expr = LPAREN expr.left RPAREN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 2];
					final IValue left = (IValue) _symbol_left.value;
					  return (Node) left;
				}
			},
			new Action() {	// [49] literal_expr = BOOL_LITERAL.bool
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol bool = _symbols[offset + 1];
					 if(bool.value.equals("true")) {
                   return new BooleanLiteral(true);
               } else {
                   return new BooleanLiteral(false);
               }
				}
			},
			new Action() {	// [50] literal_expr = NUMBER_LITERAL.number
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol number = _symbols[offset + 1];
					 String value = (String) number.value;
               if(value.contains(".")) {
                   return new NumberLiteral(Double.parseDouble(value));
               } else {
                   return new NumberLiteral(Integer.parseInt(value));
               }
				}
			},
			new Action() {	// [51] literal_expr = STRING_LITERAL.string
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol string = _symbols[offset + 1];
					 String value = (String) string.value;
               return new StringLiteral(value);
				}
			},
			new Action() {	// [52] literal_expr = NONE_LITERAL.none
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol none = _symbols[offset + 1];
					 return new NoneLiteral();
				}
			}
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
