grammar MiniJS;

// ====================================
// ANALISADOR SINTÁTICO (Parser Rules)
// ====================================

program
    : statement* EOF
    ;

statement
    : variableDeclaration
    | functionDeclaration
    | ifStatement
    | whileStatement
    | forStatement
    | doWhileStatement
    | returnStatement
    | consoleLogStatement
    | expressionStatement
    | block
    ;

block
    : '{' statement* '}'
    ;

variableDeclaration
    : ('let' | 'const' | 'var') IDENTIFIER ('=' expression)? ';'
    ;

functionDeclaration
    : 'function' IDENTIFIER '(' parameterList? ')' block
    ;

parameterList
    : IDENTIFIER (',' IDENTIFIER)*
    ;

ifStatement
    : 'if' '(' expression ')' statement ('else' statement)?
    ;

whileStatement
    : 'while' '(' expression ')' statement
    ;

forStatement
    : 'for' '(' (variableDeclaration | expressionStatement | ';')
      expression? ';'
      expression? ')' statement
    ;

doWhileStatement
    : 'do' statement 'while' '(' expression ')' ';'
    ;

returnStatement
    : 'return' expression? ';'
    ;

consoleLogStatement
    : 'console' '.' 'log' '(' argumentList? ')' ';'
    ;

expressionStatement
    : expression ';'
    ;

expression
    : assignmentExpression
    ;

assignmentExpression
    : logicalOrExpression ('=' assignmentExpression)?
    ;

logicalOrExpression
    : logicalAndExpression ('||' logicalAndExpression)*
    ;

logicalAndExpression
    : equalityExpression ('&&' equalityExpression)*
    ;

equalityExpression
    : relationalExpression (('==' | '!=' | '===' | '!==') relationalExpression)*
    ;

relationalExpression
    : additiveExpression (('<' | '>' | '<=' | '>=') additiveExpression)*
    ;

additiveExpression
    : multiplicativeExpression (('+' | '-') multiplicativeExpression)*
    ;

multiplicativeExpression
    : unaryExpression (('*' | '/' | '%') unaryExpression)*
    ;

unaryExpression
    : ('!' | '-' | '++' | '--')? postfixExpression
    ;

postfixExpression
    : primaryExpression ('++' | '--' | '[' expression ']' | '.' IDENTIFIER | '(' argumentList? ')')*
    ;

primaryExpression
    : IDENTIFIER
    | NUMBER
    | STRING
    | BOOLEAN
    | 'null'
    | 'undefined'
    | '(' expression ')'
    | arrayLiteral
    | objectLiteral
    ;

arrayLiteral
    : '[' (expression (',' expression)*)? ']'
    ;

objectLiteral
    : '{' (propertyAssignment (',' propertyAssignment)*)? '}'
    ;

propertyAssignment
    : (IDENTIFIER | STRING) ':' expression
    ;

argumentList
    : expression (',' expression)*
    ;

// ====================================
// ANALISADOR LÉXICO (Lexer Rules)
// ====================================

// Palavras-chave
LET         : 'let';
CONST       : 'const';
VAR         : 'var';
FUNCTION    : 'function';
IF          : 'if';
ELSE        : 'else';
WHILE       : 'while';
FOR         : 'for';
DO          : 'do';
RETURN      : 'return';
CONSOLE     : 'console';
LOG         : 'log';
NULL        : 'null';
UNDEFINED   : 'undefined';

// Valores booleanos
BOOLEAN     : 'true' | 'false';

// Identificadores
IDENTIFIER  : [a-zA-Z_$][a-zA-Z0-9_$]*;

// Números
NUMBER      : [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;

// Strings
STRING      : '"' (~["\r\n\\] | '\\' .)* '"'
            | '\'' (~['\r\n\\] | '\\' .)* '\''
            ;

// Operadores de comparação
EQ          : '==';
NEQ         : '!=';
SEQ         : '===';
SNEQ        : '!==';
LT          : '<';
GT          : '>';
LTE         : '<=';
GTE         : '>=';

// Operadores lógicos
AND         : '&&';
OR          : '||';
NOT         : '!';

// Operadores aritméticos
PLUS        : '+';
MINUS       : '-';
MULTIPLY    : '*';
DIVIDE      : '/';
MODULO      : '%';
INCREMENT   : '++';
DECREMENT   : '--';

// Operador de atribuição
ASSIGN      : '=';

// Delimitadores
LPAREN      : '(';
RPAREN      : ')';
LBRACE      : '{';
RBRACE      : '}';
LBRACKET    : '[';
RBRACKET    : ']';
SEMICOLON   : ';';
COMMA       : ',';
DOT         : '.';
COLON       : ':';

// Espaços em branco e quebras de linha (ignorados)
WS          : [ \t\r\n]+ -> skip;

// Comentários (ignorados)
LINE_COMMENT    : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT   : '/*' .*? '*/' -> skip;