	//FLEX FILE adder.l 

%{
#include <stdio.h>
#include <string.h>
#include "adder.tab.h" // the output of bison on adder.y
void yyerror(char*); 
int yyparse(void); 
	
%}

%%

[0-9]+			{ 
					//printf("Saw an integer %s\n",yytext); 
					strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");
					return INTEGER; 
				}
"//".*			;//Single line comment
[/][*][^*]*[*]+([^*/][^*]*[*]+)*[/]		;//Multi line comment
[ \t\n\r\f]+	{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");}		//do nothing on whitespace
"+"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return PLUS;}
"-"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return SUBT; }
"*"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return MULT;}
"/"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return DIV;}
"["				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return OPENB;}
"]"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return CLOSEB;}
"{"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val,"\n");return OPENC;}
"}"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val,"\n");return CLOSEC;}
"("				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return OPENS;}
")"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return CLOSES;}
"="				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return EQUALS;}
";"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val,"\n");return SEMICOLON;}
"class"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return CLASS;}
"public"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return PUBLIC;}
"private"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return PRIVATE;}
"static"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return STATIC;}
"void"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return RVOID;}
"String"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return STRING;}
"System.out.println"	{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return SOPLN;}
"return"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return RETURN;}
"int"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return INT;}
"boolean"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return BOOL;}
"if"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return IF;}
"else"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return ELSE;}
"while"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return WHILE;}
"&"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return AMPERSAND;}
"|"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return OR;}
"<"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return LESSTHAN;}
"!"				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return EXCLAMATION;}
"length"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return LENGTH;}
"this"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return THIS;}
"new"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return NEW;}
"true"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return TRUE;}
"false"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return FALSE;}
"#define"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return HASHDEFINE;}
"main"			{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return MAIN;}
","				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return COMMAH;}
"."				{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return DOT;}
"extends"		{strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");return EXTENDS;}
[a-zA-Z][a-zA-Z0-9_]*	{
							strcpy(yylval.str_val,yytext);strcat(yylval.str_val," ");
							return IDENTIFIER;
						}


<<EOF>>			return 0;
.               { printf("error\n"); return 1;}

%%

void yyerror(char* str) { printf("// Failed to parse macrojava code.\n"); }

int yywrap(void) { return 1; }


int main(void) {
	yyparse();	
}