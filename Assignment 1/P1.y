/* BISON FILE adder.y */

%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
extern int yylex();
extern void yyerror(char *);
void print(int);
int frepl(char *s1);
int search(char* str);
int n=1;

struct defines{
	char name[1000];
	char func[1000];
}d_list[500];


struct definesarg{
	char name[100];
	char func[100];
}darg_list[500];

int pos=0;
int qos=0;
%}


%union {
	int 	int_val;
	char	str_val[10000];
};

%token <str_val>	INTEGER PLUS SUBT MULT DIV OPENB CLOSEB OPENC CLOSEC OPENS CLOSES EQUALS
%token <str_val>	SEMICOLON CLASS PUBLIC PRIVATE STATIC RVOID STRING SOPLN RETURN INT BOOL IF
%token <str_val>	ELSE WHILE AMPERSAND OR LESSTHAN EXCLAMATION LENGTH THIS NEW TRUE FALSE
%token <str_val>	HASHDEFINE MAIN COMMAH DOT EXTENDS END_OF_FILE COMMENT
%token <str_val>	IDENTIFIER

%type <str_val> goal
%type <str_val> macrodefinition
%type <str_val> macrodefinitionstar
%type <str_val> mainclass
%type <str_val> typedeclaration
%type <str_val> typedeclarationstar
%type <str_val> expression
%type <str_val> expressionstar
%type <str_val> type
%type <str_val> identifierstar
%type <str_val> initializestar
%type <str_val> parameterstar
%type <str_val> methoddeclaration
%type <str_val> methoddeclarationstar
%type <str_val> statement
%type <str_val> statementstar
%type <str_val> primaryexpression
%type <str_val> macrodefexpression
%type <str_val> macrodefstatement
%type <str_val> identifier

%start goal

%%
goal:
				macrodefinitionstar mainclass typedeclarationstar {
					strcat($$,$2);
					strcat($$,$3);
					printf("%s\n",$$);
				}

macrodefinitionstar:	{strcpy($$,"");}
			|	macrodefinitionstar macrodefinition {
					strcat($$,$2);
				}

typedeclarationstar:	{strcpy($$,"");}
			|	typedeclarationstar typedeclaration {
					strcat($$,$2);				
				}

mainclass:
				CLASS identifier OPENC PUBLIC STATIC RVOID MAIN OPENS STRING OPENB CLOSEB identifier CLOSES OPENC SOPLN OPENS expression CLOSES SEMICOLON CLOSEC CLOSEC {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
					strcat($$,$7);
					strcat($$,$8);
					strcat($$,$9);
					strcat($$,$10);
					strcat($$,$11);
					strcat($$,$12);
					strcat($$,$13);
					strcat($$,$14);
					strcat($$,$15);
					strcat($$,$16);
					strcat($$,$17);
					strcat($$,$18);
					strcat($$,$19);
					strcat($$,$20);
					strcat($$,$21);
				}

typedeclaration:
				CLASS identifier OPENC initializestar methoddeclarationstar CLOSEC {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
				}
			|	CLASS identifier EXTENDS identifier OPENC initializestar methoddeclarationstar CLOSEC {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
					strcat($$,$7);
					strcat($$,$8);
				}

initializestar:		{strcpy($$,"");}
			|	initializestar type identifier SEMICOLON {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}

methoddeclarationstar:	{strcpy($$,"");}
			|	methoddeclarationstar methoddeclaration {
					strcat($$,$2);
			}

methoddeclaration:
				PUBLIC type identifier OPENS CLOSES OPENC initializestar statementstar RETURN expression SEMICOLON CLOSEC {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
					strcat($$,$7);
					strcat($$,$8);
					strcat($$,"return ");
					strcat($$,$10);
					strcat($$,$11);
					strcat($$,$12);
				}
			|	PUBLIC type identifier OPENS type identifier parameterstar CLOSES OPENC initializestar statementstar RETURN expression SEMICOLON CLOSEC {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
					strcat($$,$7);
					strcat($$,$8);
					strcat($$,$9);
					strcat($$,$10);
					strcat($$,$11);
					strcat($$,$12);
					strcat($$,$13);
					strcat($$,$14);
					strcat($$,$15);
				}

parameterstar:		{strcpy($$,"");}
			|	parameterstar COMMAH type identifier {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}

statementstar:	{strcpy($$,"");}
			|	statement statementstar {
					strcat($$,$2);
			}

type:		
				INT OPENB CLOSEB {
					strcat($$,$2);
					strcat($$,$3);
				}
			|	BOOL {
				}
			|	INT {
				}
			|	identifier {
				}

statement:	
				OPENC statementstar CLOSEC {
					strcat($$,$2);
					strcat($$,$3);
				}
			|	identifier EQUALS expression SEMICOLON {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}
			|	SOPLN OPENS expression CLOSES SEMICOLON {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
				}
			|	identifier OPENB expression CLOSEB EQUALS expression SEMICOLON {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
					strcat($$,$7);
				}
			|	IF OPENS expression CLOSES statement {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
				}
			|	IF OPENS expression CLOSES statement ELSE statement {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
					strcat($$,$7);
				}
			|	WHILE OPENS expression CLOSES statement {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
				}
			|	identifier OPENS CLOSES SEMICOLON {
					if(frepl($$)==0){
						strcat($$,$2);
						strcat($$,$3);
					}
					strcat($$,$4);
				}
			|	identifier OPENS expression expressionstar CLOSES SEMICOLON {
					if(frepl($$)==0){
						strcat($$,$2);
						strcat($$,$3);
						strcat($$,$4);
						strcat($$,$5);
					}
					strcat($$,$6);
				}

expressionstar:	{strcpy($$,"");}
			|	expressionstar COMMAH expression {
					strcat($$,$2);
					strcat($$,$3);
				}

expression:		primaryexpression AMPERSAND AMPERSAND primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}
			|	primaryexpression OR OR primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}
			|	primaryexpression EXCLAMATION EQUALS primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}
			|	primaryexpression LESSTHAN EQUALS primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}
			|	primaryexpression PLUS primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
				}
			|	primaryexpression SUBT primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
				}
			|	primaryexpression MULT primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
				}
			|	primaryexpression DIV primaryexpression {
					strcat($$,$2);
					strcat($$,$3);
				}
			|	primaryexpression OPENB primaryexpression CLOSEB {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}
			|	primaryexpression DOT LENGTH {
					strcat($$,$2);
					strcat($$,$3);
				}
			|	primaryexpression {
				}
			|	primaryexpression DOT identifier OPENS CLOSES {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
				}
			|	primaryexpression DOT identifier OPENS expression expressionstar CLOSES {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
					strcat($$,$6);
					strcat($$,$7);
				}
			|	identifier OPENS CLOSES {
					if(frepl($$)==0){
						strcat($$,$2);
						strcat($$,$3);
					}
				}
			|	identifier OPENS expression expressionstar CLOSES {
					if(frepl($$)==0){
						strcat($$,$2);
						strcat($$,$3);
						strcat($$,$4);
						strcat($$,$5);
					}
				}

primaryexpression:	
				INTEGER {
				}
			|	TRUE {
				}
			|	FALSE{
				}
			|	identifier {
				}
			|	THIS {
				}
			|	NEW INT OPENB expression CLOSEB {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
					strcat($$,$5);
				}
			|	NEW identifier OPENS CLOSES {
					strcat($$,$2);
					strcat($$,$3);
					strcat($$,$4);
				}
			|	EXCLAMATION expression {
					strcat($$,$2);
				}
			|	OPENS expression CLOSES {
					strcat($$,$2);
					strcat($$,$3);
				}

identifierstar:	{strcpy($$,"");}
			|	COMMAH identifier {
					strcat($$,$2);
				}
macrodefinition:
				macrodefexpression {
					strcpy($$,"");
				}
			|	macrodefstatement {
					strcpy($$,"");
				}

macrodefstatement:	
				HASHDEFINE identifier OPENS CLOSES OPENC statementstar CLOSEC {
					strcpy(d_list[pos].name,$2);
					strcpy(d_list[pos].func,$5);
					strcat(d_list[pos].func,$6);
					strcat(d_list[pos].func,$7);
					pos++;
				}
			|	HASHDEFINE identifier OPENS identifier identifierstar CLOSES OPENC statementstar CLOSEC {
					strcpy(d_list[pos].name,$2);
					strcpy(d_list[pos].func,$7);
					strcat(d_list[pos].func,$8);
					strcat(d_list[pos].func,$9);
					pos++;
			}

macrodefexpression:	
				HASHDEFINE identifier OPENS CLOSES OPENS expression CLOSES {
					strcpy(d_list[pos].name,$2);
					strcpy(d_list[pos].func,$5);
					strcat(d_list[pos].func,$6);
					strcat(d_list[pos].func,$7);
					pos++;
				}
			|	HASHDEFINE identifier OPENS identifier identifierstar CLOSES OPENS expression CLOSES {
					strcpy(d_list[pos].name,$2);
					strcpy(d_list[pos].func,$7);
					strcat(d_list[pos].func,$8);
					strcat(d_list[pos].func,$9);
					pos++;
			}

identifier:
				IDENTIFIER ;

%%

int frepl(char *s1){
	int i=0;
	for(i=0;i<pos;i++){
		if(strcmp(d_list[i].name,s1)==0){
			strcpy(s1,d_list[i].func);
			return 1;
		}
	}
	return 0;
}