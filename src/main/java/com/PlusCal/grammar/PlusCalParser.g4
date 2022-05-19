parser grammar PlusCalParser;

@parser::members {
    public static boolean pSyntax = false;
    public static boolean cSyntax = false;
}

options {
	tokenVocab = PlusCalLexer;
}

algorithm
    : MinusMinus Fair? Algorithm name LeftBrace { cSyntax = true; }
        globalVardecls?
        definitions?
        macro*
        procedure*
        (compoundStmt | process+) RightBrace EOF
    | MinusMinus Fair? Algorithm name { pSyntax = true; }
        globalVardecls?
        definitions?
        macro*
        procedure*
        (body | process+) End Algorithm EOF
    ;

procedure
    : {cSyntax}? Procedure name LeftParen (prodVarDecl (Comma prodVarDecl)*)? RightParen
                 prodVarDecls?
                 compoundStmt Semi?
    | {pSyntax}? Procedure name LeftParen (prodVarDecl (Comma prodVarDecl)*)? RightParen
                 prodVarDecls?
                 body Semi?
    ;

macro
    : {cSyntax}? Macro name LeftParen (variable (Comma variable)*)? RightParen
                 compoundStmt Semi?
    | {pSyntax}? Macro name LeftParen (variable (Comma variable)*)?
                 body End Macro Semi?
    ;

definitions
    : {cSyntax}? Define LeftBrace defs RightBrace Semi?
    | {pSyntax}? Define defs End Define Semi?
    ;

globalVardecls
    : (Variable | Variables) vardecl+;

vardecl
    : variable (relop=(Equal | In) expr)? (Semi | Comma);

process
    : {cSyntax}? (Fair Plus?)? Process LeftParen name relop=(Equal | In) expr RightParen
                 procVardecls?
                 compoundStmt Semi?
    | {pSyntax}? (Fair Plus?)? Process LeftParen name relop=(Equal | In) expr RightParen
                 procVardecls?
                 body End Process Semi?
    ;

procVardecls
    : (Variable | Variables) vardecl+;

prodVarDecls
    : (Variable | Variables) (prodVarDecl (Semi | Comma))+;

prodVarDecl
    : variable (Equal expr)?;

body
    : Begin stmt+;

compoundStmt
    : LeftBrace stmt (Semi stmt)* Semi? RightBrace;


stmt
    : {cSyntax}? (label Colon (Plus | Minus)?)? (unLabeledStmt | compoundStmt)
    | {pSyntax}? (label Colon (Plus | Minus)?)? unLabeledStmt Semi
    ;

unLabeledStmt
    : lhs Assign expr (BarBar lhs Assign expr)*                         # assign
    | ( {cSyntax}? If LeftParen expr RightParen stmt (Else stmt)?
      | {pSyntax}? If expr Then stmt+
                     (ElseIf expr Then stmt+)*
                     (Else stmt+)? End If )                             # if
    | ( {cSyntax}? While LeftParen expr RightParen stmt
      | {pSyntax}? While expr Do stmt+ End While )                      # while
    | ( {cSyntax}? Either stmt (Or stmt)+
      | {pSyntax}? Either stmt+ (Or stmt+)+ End Either )                # either
    | ( {cSyntax}? With LeftParen inWithVarDecl ((Semi | Comma) inWithVarDecl)* (Semi | Comma)?
                        RightParen stmt
      | {pSyntax}? With (inWithVarDecl (Semi | Comma))+
                        Do stmt+ End With )                             # with
    | (Await | When) expr                                               # await
    | Print expr                                                        # print
    | Assert expr                                                       # assert
    | Skip                                                              # skip
    | Return                                                            # return
    | Goto label                                                        # goto
    | Call name LeftParen (expr (Comma expr)*)? RightParen              # call
    | Call name LeftParen (expr (Comma expr)*)? RightParen Return       # callReturn
    | Call name LeftParen (expr (Comma expr)*)? RightParen Goto label   # callGoto
    | name LeftParen (expr (Comma expr)*)? RightParen                   # macroCall
    ;

inWithVarDecl
    : variable relop=(Equal | In) expr;

lhs
    : variable (LeftBack expr (Comma expr)* RightBack | Dot field)*;

variable
    : Identifier;

field
    : Identifier
    | tlaEscapeWord
    | plusCalReservedWord;

label
    : Identifier;

name
    : Identifier;

defs
    : (operatorDefinition
    | functionDefinition
    | moduleDefinition)+
    ;

nonFixLhs
    : generalIdentifier (LeftParen nonFixLhsParameter
              (Comma nonFixLhsParameter)* RightParen)?;

nonFixLhsParameter
    : generalIdentifier
    | operatorDecl
    ;

operatorDefinition
    : nonFixLhs EqualEqual expr                                                 # nonFixLhsDefinition
    | prefixOp generalIdentifier EqualEqual expr                                # prefixOpDefinition
    | generalIdentifier infixOp generalIdentifier EqualEqual expr               # infixOpDefinition
    | generalIdentifier postfixOp EqualEqual expr                               # postfixOpDefinition
    ;

functionDefinition
    : generalIdentifier LeftBack quantifierBound (Comma quantifierBound)* RightBack
        EqualEqual expr;

operatorDecl
    : generalIdentifier (LeftParen Subscript (Comma Subscript)* RightParen)?    # operatorParameter
    | prefixOp Subscript                                                        # prefixOpParameter
    | Subscript infixOp Subscript                                               # infixOpParameter
    | Subscript postfixOp                                                       # postfixOpParameter
    ;

moduleDefinition
    : nonFixLhs EqualEqual instance;

instance
    : Instance_ name (With_ substitution (Comma substitution)*)? ;

substitution
    : (generalIdentifier | prefixOp | infixOp | postfixOp) LeftArrow argument;

identifierOrTuple
    : generalIdentifier
    | LeftTuple generalIdentifier (Comma generalIdentifier)* RightTuple
    ;

quantifierBound
    : (identifierOrTuple | generalIdentifier (Comma generalIdentifier)*) In expr
    | (identifierOrTuple | generalIdentifier (Comma generalIdentifier)*) In         {   notifyErrorListeners("'expression' expected"); }
    | (identifierOrTuple | generalIdentifier (Comma generalIdentifier)*)            {   notifyErrorListeners("'\\in expression' excepted"); }
    ;

generalPrefixOp
    : instancePrefix prefixOp;

generalInfixOp
    : instancePrefix infixOp;

generalPostfixOp
    : instancePrefix postfixOp;

argument
    : expr
    | generalInfixOp
    | generalPrefixOp
    | generalPostfixOp
    ;

generalIdentifier
    : instancePrefix Identifier;

expr
    : (Conjunction | Disjunction)* generalPrefixOp* primaryExpr generalPostfixOp*
        (infixOpOrJunctions generalPrefixOp* primaryExpr generalPostfixOp*)*
    ;

infixOpOrJunctions
    : generalInfixOp
    | (Conjunction | Disjunction)+;

primaryExpr
    : LeftParen expr RightParen                                                         # parenthesis
    | generalIdentifier LeftParen argument (Comma argument)* RightParen                 # operatorCall
    | generalIdentifier                                                                 # variableLiteral
    | number                                                                            # numberLiteral
    | BooleanLiteral                                                                    # booleanLiteral
    | StringLiteral                                                                     # stringLiteral
    | (Any | Exist) quantifierBound (Comma quantifierBound)* Colon expr                 # quantifierExpression
    | (Any | Exist | AA | EE) generalIdentifier (Comma generalIdentifier)* Colon expr   # quantifierExpression2
    | Choose_ identifierOrTuple (In expr)? Colon expr                                   # tlaChoose
    | set                                                                               # setLiteral
    | functionOrRecord                                                                  # functionOrRecordLiteral
    | LeftTuple (expr (Comma expr)*)? RightTuple                                        # sequenceLiteral
    | primaryExpr Dot field                                                             # fieldCall
    | LeftBack expr RightBackWithSubscript primaryExpr                                  # bracketedWithSubscript
    | LeftTuple expr RightTupleWithSubscript primaryExpr                                # sequencedWithSubscript
    | (WF | SF) expr LeftParen expr RightParen                                          # wfOrSf
    | If_ expr Then_ expr Else_ expr                                                    # tlaIf
    | Case_ caseArm (Square caseArm)* (Square Other_ RightArrow expr)?                  # tlaCase
    | Let_ defs In_ expr                                                                # tlaLet
    ;

set
    : LeftBrace (expr (Comma expr)*)? RightBrace                                        # enumerated
    | LeftBrace identifierOrTuple In expr Colon expr RightBrace                         # filtering
    | LeftBrace expr Colon quantifierBound (Comma quantifierBound)* RightBrace          # mapping
    ;

functionOrRecord
    : LeftBack quantifierBound (Comma quantifierBound)* BarArrow expr RightBack         # listMapping
    | LeftBack expr RightArrow expr RightBack                                           # setMapping
    | LeftBack field Colon expr (Comma field Colon expr)* RightBack                     # colonedRecord
    | LeftBack field BarArrow expr (Comma field BarArrow expr)* RightBack               # barArrowedRecord
    | LeftBack expr Except_ exceptCase (Comma exceptCase)* RightBack                    # exceptConstruct
    ;

caseArm
    : expr RightArrow expr;

instancePrefix
    : (Identifier (LeftParen expr (Comma expr)* RightParen)? Bang)*;

exceptCase
    : Bang (Dot name | LeftBack expr (Comma expr)* RightBack)+ Equal expr;

infixOp
    : BangBang
    | SharpSharp
    | Dollar
    | DollarDollar
    | Mod
    | Amp
    | AmpAmp
    | Oplus
    | Ominus
    | Odot
    | OSlash
    | Otimes
    | Aster
    | AsterAster
    | Minus
    | MinusMinus
    | Plus
    | PlusPlus
    | DashPlusArrow
    | DashBar
    | DotDot
    | DotDotDot
    | Slash
    | SlashSlash
    | NotEqual
    | Conjunction
    | ColonColonEq
    | ColonGt
    | Less
    | LtColon
    | Equivalence
    | Equal
    | LessEqual
    | Implication
    | EqualBar
    | Greater
    | GreaterEqual
//    | Query
    | Times
    | QueryQuery
    | AtAt
    | Subtract
    | Disjunction
    | Caret
    | CaretCaret
    | Bar
    | BarDash
    | BarEqual
//    | BarBar
    | TildeGt
//    | Dot
    | Approx
    | SqSupsetEq
    | Asymp
    | Gg
    | Star
    | BigCirc
    | In
    | NotIn
    | Prec
    | Subset
    | Bullet
    | Cap
    | Preceq
    | SubsetEq
    | PropTo
    | Succ
    | Cdot
    | Sim
    | Succeq
    | Circ
    | Ll
    | Simeq
    | Supset
    | Cong
    | SqCap
    | SupsetEq
    | Cup
    | SqCup
    | Div
    | SqSubset
    | Uplus
    | Doteq
    | SqSubsetEq
    | Wr
    | SqSupset
    ;

postfixOp
    : CaretPlus
    | CaretAstar
    | CaretSharp
    | Prime
    | LeftBack expr (Comma expr)* RightBack
    ;

prefixOp
    : Minus
    | Negation
    | Square
    | Diamond
    | Domain_
    | Enabled_
    | Subset_
    | Unchanged_
    | Union_
    ;

number
    : Integer
    | Float;

tlaEscapeWord
    : Assume_
    | Assumption_
    | Axiom_
    | Case_
    | Choose_
    | Constant_
    | Constants_
    | Domain_
    | Else_
    | Enabled_
    | Except_
    | Extends_
    | If_
    | In_
    | Instance_
    | Let_
    | Local_
    | Module_
    | Other_
    | Union_
    | Subset_
    | Then_
    | Theorem_
    | Unchanged_
    | Variable_
    | Variables_
    | With_
    ;

plusCalReservedWord
    : Assert
    | Await
    | Begin
    | Call
    | Define
    | Do
    | Either
    | Else
    | ElseIf
    | End
    | Goto
    | If
    | Macro
    | Or
    | Print
    | Procedure
    | Process
    | Return
    | Skip
    | Then
    | Variable
    | Variables
    | When
    | While
    | With
    ;
