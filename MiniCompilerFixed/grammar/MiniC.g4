grammar MiniC;

// ======================================================
// PARSER RULES
// ======================================================

program
    : statement* EOF
    ;

statement
    : declaration
    | arrayDeclaration
    | assignment
    | arrayAssignment
    | ifStatement
    | whileStatement
    | forStatement
    | printStatement
    ;

declaration
    : type IDENTIFIER ASSIGN expr SEMICOLON
    | type IDENTIFIER SEMICOLON
    ;

arrayDeclaration
    : type IDENTIFIER LBRACKET NUMBER RBRACKET SEMICOLON
    ;

assignment
    : IDENTIFIER ASSIGN expr SEMICOLON
    ;

arrayAssignment
    : IDENTIFIER LBRACKET expr RBRACKET ASSIGN expr SEMICOLON
    ;

ifStatement
    : IF LPAREN condition RPAREN LBRACE statement* RBRACE
      (ELSE LBRACE statement* RBRACE)?
    ;

whileStatement
    : WHILE LPAREN condition RPAREN LBRACE statement* RBRACE
    ;

forStatement
    : FOR LPAREN forInit SEMICOLON condition SEMICOLON forUpdate RPAREN
      LBRACE statement* RBRACE
    ;

forInit
    : type IDENTIFIER ASSIGN expr
    | IDENTIFIER ASSIGN expr
    |
    ;

forUpdate
    : IDENTIFIER ASSIGN expr
    |
    ;

condition
    : expr relop expr
    ;

relop
    : LT | GT | LEQ | GEQ | EQ | NEQ
    ;

printStatement
    : PRINT LPAREN expr RPAREN SEMICOLON
    ;

expr
    : expr MUL expr
    | expr DIV expr
    | expr PLUS expr
    | expr MINUS expr
    | FLOAT_NUMBER
    | NUMBER
    | IDENTIFIER LBRACKET expr RBRACKET
    | IDENTIFIER
    | LPAREN expr RPAREN
    ;

type
    : INT
    | FLOAT
    ;

// ======================================================
// LEXER RULES
// ======================================================

// Keywords
INT     : 'int';
FLOAT   : 'float';
IF      : 'if';
ELSE    : 'else';
WHILE   : 'while';
FOR     : 'for';
PRINT   : 'print';

// Relational Operators
LT      : '<';
GT      : '>';
LEQ     : '<=';
GEQ     : '>=';
EQ      : '==';
NEQ     : '!=';

// Arithmetic Operators
PLUS    : '+';
MINUS   : '-';
MUL     : '*';
DIV     : '/';

// Assignment
ASSIGN  : '=';

// Symbols
LPAREN  : '(';
RPAREN  : ')';
LBRACE  : '{';
RBRACE  : '}';
LBRACKET: '[';
RBRACKET: ']';
SEMICOLON: ';';

// Literals
FLOAT_NUMBER
    : [0-9]+ '.' [0-9]+
    ;

NUMBER
    : [0-9]+
    ;

// Identifier
IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

// Ignore Spaces
WS
    : [ \t\r\n]+ -> skip
    ;
