lexer grammar PlusCalLexer;

// PlusCal Keywords
Algorithm:          'algorithm';
While:              'while';
Variables:          'variables';
Variable:           'variable';
Assert:             'assert';
If:                 'if';
Else:               'else';
ElseIf:             'elsif';
Either:             'either';
Or:                 'or';
Skip:               'skip';
Await:              'await';
With:               'with';
Call:               'call';
Return:             'return';
Print:              'print';
Define:             'define';
Macro:              'macro';
Procedure:          'procedure';
Process:            'process';
Begin:              'begin';
End:                'end';
Do:                 'do';
Goto:               'goto';
Then:               'then';
When:               'when';
Fair:               'fair';
BooleanLiteral:     'TRUE' | 'FALSE';

// Tlaplus Operators
Plus:               '+';
Minus:              '-';
Aster:              '*'; // Asterisk
Slash:              '/';
Assign:             ':=';
Equal:              '=';
NotEqual:           '/=' | '\\neq' | '#';
Greater:            '>';
Less:               '<';
GreaterEqual:       '>=' | '\\geq';
LessEqual:          '=<' | '<=' | '\\leq';
Negation:           '~' | '\\lnot' | '\\neg';
RightArrow:         '->';
LeftArrow:          '<-';
Caret:              '^';
Mod:                '%';
BarArrow:           '|->';
DotDot:             '..';
Subscript:          '_';
Conjunction:        '\\land' | '/\\';
Disjunction:        '\\lor' | '\\/';
Bang:               '!';
Equivalence:        '<=>' | '\\equiv';
EqualEqual:         '=='; // means define
In:                 '\\in';
NotIn:              '\\notin';
Any:                '\\A';
Exist:              '\\E';
AA:                 '\\AA';
EE:                 '\\EE';
Implication:        '=>';
Diamond:            '<>';
Square:             '[]';
Ll:                 '\\ll';
Gg:                 '\\gg';
Prec:               '\\prec';
Preceq:             '\\preceq';
Succ:               '\\succ';
Succeq:             '\\succeq';
Subset:             '\\subset';
SubsetEq:           '\\subseteq';
Supset:             '\\supset';
SupsetEq:           '\\supseteq';
SqSubset:           '\\sqsubset';
SqSubsetEq:         '\\sqsubseteq';
SqSupset:           '\\sqsupset';
SqSupsetEq:         '\\sqsupseteq';
BarDash:            '|-';
BarEqual:           '|=';
EqualBar:           '=|';
Cap:                '\\cap' | '\\intersect';
SqCap:              '\\sqcap';
Cup:                '\\cup' | '\\union';
SqCup:              '\\sqcup';
Oplus:              '(+)' | '\\oplus';
Ominus:             '(-)' | '\\ominus';
Odot:               '(.)' | '\\odot';
Otimes:             '(\\X)' | '\\otimes';
OSlash:             '(/)' | '\\oslash';
DashBar:            '-|';
Uplus:              '\\uplus';
Times:              '\\X' | '\\times';
Wr:                 '\\wr';
PropTo:             '\\propto';
DashPlusArrow:      '-+->';
Div:                '\\div';
Cdot:               '\\cdot';
Circ:               '\\circ' | '\\o';
Bullet:             '\\bullet';
Star:               '\\star';
BigCirc:            '\\bigcirc';
Sim:                '\\sim';
Simeq:              '\\simeq';
Asymp:              '\\asymp';
Approx:             '\\approx';
Cong:               '\\cong';
Doteq:              '\\doteq';
BangBang:           '!!';
SharpSharp:         '##';
Dollar:             '$';
DollarDollar:       '$$';
PercentPercent:     '%%';
Amp:                '&';
AmpAmp:             '&&';
AsterAster:         '**';
PlusPlus:           '++';
MinusMinus:         '--';
DotDotDot:          '...';
SlashSlash:         '//';
Subtract:           '\\';
ColonColonEq:       '::=';
ColonGt:            ':>';
LtColon:            '<:';
Query:              '?';
QueryQuery:         '??';
CaretCaret:         '^^';
Bar:                '|';
AtAt:               '@@';
TildeGt:            '~>';
Prime:              '\'';
CaretPlus:          '^+';
CaretAstar:         '^*';
CaretSharp:         '^#';
DashDot:            '-.';
RightBackWithSubscript:      ']_';
RightTupleWithSubscript:     '>>_';

// Separators
LeftParen:          '(';
RightParen:         ')';
LeftBrace:          '{';
RightBrace:         '}';
LeftBack:           '[';
RightBack:          ']';
Semi:               ';';
Colon:              ':';
Comma:              ',';
Dot:                '.';
LeftTuple:          '<<';
RightTuple:         '>>';
BarBar:             '||';

// Tlaplus Keywords (ended by '_' to seperete from pluscal reversed words)
Except_:            'EXCEPT';
Constant_:          'CONSTANT';
Constants_:         'CONSTANTS';
Enabled_:           'ENABLED';
Unchanged_:         'UNCHANGED';
Union_:             'UNION';
Subset_:            'SUBSET';
Domain_:            'DOMAIN';
Assume_:            'ASSUME';
Assumption_:        'ASSUMPTION';
Axiom_:             'AXIOM';
Case_:              'CASE';
Choose_:            'CHOOSE';
Else_:              'ELSE';
Extends_:           'EXTENDS';
If_:                'IF';
In_:                'IN';
Instance_:          'INSTANCE';
Let_:               'LET';
Local_:             'LOCAL';
Module_:            'MODULE';
Other_:             'OTHER';
Then_:              'THEN';
Theorem_:           'THEOREM';
Variable_:          'VARIABLE';
Variables_:         'VARIABLES';
With_:              'WITH';

WF:                 'WF_';
SF:                 'SF_';

// String
StringLiteral:	    '"' (StringCharacter+)? '"';

fragment StringCharacter:
    ~["\\\r\n]
	| EscapeSequence
	;

// Escape Sequences for Character and String Literals
fragment EscapeSequence:
    '\\' [btnfr"'\\]
//	|	OctalEscape
//  |   UnicodeEscape // This is not in the spec but prevents having to preprocess the input
	;

// Identifiers and Numbers
fragment Letter: [a-zA-Z];

fragment DecimalDigit: [0-9];

fragment NonZeroDigit: [1-9];

fragment OctalDigit: [0-7];

fragment HexadecimalDigit: [0-9a-fA-F];

fragment BinaryDigit: [01];

Integer
    : DecimalInteger
    | OctalInteger
    | HexadecimalInteger
    | BinaryInteger;

DecimalInteger: DecimalDigit+;

OctalInteger: ('\\o' | '\\O') OctalDigit+;

HexadecimalInteger: ('\\x' | '\\X') HexadecimalDigit+;

BinaryInteger: ('\\b' | '\\B') BinaryDigit+;

Float: DecimalDigit* '.' DecimalDigit+;

Identifier: 'W' | 'S'
    | IdentifierBeginCharacters (DecimalDigit | Subscript | Letter)*;

fragment IdentifierBeginCharacters
    : ('W' | 'S') [_0-9a-zA-EG-Z]
    | ('WF' | 'SF') [0-9a-zA-Z]
    | [a-zA-RT-VX-Z]
    | (DecimalDigit | Subscript)+ Letter
    ;

// Escapes
WhiteSpace :        [ \t]+ -> channel(HIDDEN);
Newline:            ('\r' '\n'? | '\n') -> channel(HIDDEN);
LineComment:        '\\*' ~ [\r\n]* -> channel(HIDDEN);
BlockComment:       '(*' .*? '*)' -> channel(HIDDEN);
