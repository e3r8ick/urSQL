package interpreter.analizador;
import java_cup.runtime.Symbol;

%%
/* segunda parte: declaramos las directivas y los macros */
%class AnalizadorLexico
%public
%full
%unicode
%line
%column
%char
%cup

LineTerminator = \r|\n|\r\n|\n\r
WhiteSpace = {LineTerminator} | [ \t\f]
ValorEntero = [0-9][0-9]*
Id = ([a-zA-Z"_"]) ([a-zA-Z0-9]){0,31}
Palabra = \" [a-zA-Z0-9" "]+ \"

%%
/* OPERADORES Y SIGNOS */
">"             {return new Symbol(sym.MAYOR, new token(yycolumn, yyline, yytext()));}
"<"             {return new Symbol(sym.MENOR, new token(yycolumn, yyline, yytext()));}
"="             {return new Symbol(sym.IGUAL, new token(yycolumn, yyline, yytext()));}

"("             {return new Symbol(sym.ABRIRPAR, new token(yycolumn, yyline, yytext()));}
")"             {return new Symbol(sym.CERRARPAR, new token(yycolumn, yyline, yytext()));}
","             {return new Symbol(sym.COMA, new token(yycolumn, yyline, yytext()));}
";"             {return new Symbol(sym.PUNTOCOMA, new token(yycolumn, yyline, yytext()));}
"*"             {return new Symbol(sym.ASTERISCO, new token(yycolumn, yyline, yytext()));}

/* PALABRAS RESERVADAS */

"CREATE"        {return new Symbol(sym.CREATE, new token(yycolumn, yyline, yytext()));}
"DATABASE"      {return new Symbol(sym.DATABASE, new token(yycolumn, yyline, yytext()));}
"DROP"          {return new Symbol(sym.DROP, new token(yycolumn, yyline, yytext()));}
"LIST"          {return new Symbol(sym.LIST, new token(yycolumn, yyline, yytext()));}
"DATABASES"     {return new Symbol(sym.DATABASES, new token(yycolumn, yyline, yytext()));}
"START"         {return new Symbol(sym.START, new token(yycolumn, yyline, yytext()));}
"GET"           {return new Symbol(sym.GET, new token(yycolumn, yyline, yytext()));}
"STATUS"        {return new Symbol(sym.STATUS, new token(yycolumn, yyline, yytext()));}
"STOP"          {return new Symbol(sym.STOP, new token(yycolumn, yyline, yytext()));}
"DISPLAY"       {return new Symbol(sym.DISPLAY, new token(yycolumn, yyline, yytext()));}

"SET"           {return new Symbol(sym.SET, new token(yycolumn, yyline, yytext()));}
"TABLE"         {return new Symbol(sym.TABLE, new token(yycolumn, yyline, yytext()));}
"AS"            {return new Symbol(sym.AS, new token(yycolumn, yyline, yytext()));}
"INTEGER"       {return new Symbol(sym.INTEGER, new token(yycolumn, yyline, yytext()));}
"DECIMAL"       {return new Symbol(sym.DECIMAL, new token(yycolumn, yyline, yytext()));}
"CHAR"          {return new Symbol(sym.CHAR, new token(yycolumn, yyline, yytext()));}
"VARCHAR"       {return new Symbol(sym.VARCHAR, new token(yycolumn, yyline, yytext()));}
"DATETIME"      {return new Symbol(sym.DATETIME, new token(yycolumn, yyline, yytext()));}
"NULL"          {return new Symbol(sym.NULL, new token(yycolumn, yyline, yytext()));}
"NOT"           {return new Symbol(sym.NOT, new token(yycolumn, yyline, yytext()));}
"PRIMARY"       {return new Symbol(sym.PRIMARY, new token(yycolumn, yyline, yytext()));}
"KEY"           {return new Symbol(sym.KEY, new token(yycolumn, yyline, yytext()));}
"ALTER"         {return new Symbol(sym.ALTER, new token(yycolumn, yyline, yytext()));}
"ADD"           {return new Symbol(sym.ADD, new token(yycolumn, yyline, yytext()));}
"CONSTRAINT"    {return new Symbol(sym.CONSTRAINT, new token(yycolumn, yyline, yytext()));}
"FOREIGN"       {return new Symbol(sym.FOREIGN, new token(yycolumn, yyline, yytext()));}
"REFERENCES"    {return new Symbol(sym.REFERENCES, new token(yycolumn, yyline, yytext()));}
"INDEX"         {return new Symbol(sym.INDEX, new token(yycolumn, yyline, yytext()));}
"ON"            {return new Symbol(sym.ON, new token(yycolumn, yyline, yytext()));}

"SELECT"        {return new Symbol(sym.SELECT, new token(yycolumn, yyline, yytext()));}
"FROM"          {return new Symbol(sym.FROM, new token(yycolumn, yyline, yytext()));}
"WHERE"         {return new Symbol(sym.WHERE, new token(yycolumn, yyline, yytext()));}
"GROUP"         {return new Symbol(sym.GROUP, new token(yycolumn, yyline, yytext()));}
"BY"            {return new Symbol(sym.BY, new token(yycolumn, yyline, yytext()));}
"JOIN"          {return new Symbol(sym.JOIN, new token(yycolumn, yyline, yytext()));}
"LIKE"          {return new Symbol(sym.LIKE, new token(yycolumn, yyline, yytext()));}
"IS"            {return new Symbol(sym.IS, new token(yycolumn, yyline, yytext()));}
"COUNT"         {return new Symbol(sym.COUNT, new token(yycolumn, yyline, yytext()));}
"AVERAGE"       {return new Symbol(sym.AVERAGE, new token(yycolumn, yyline, yytext()));}
"MIN"           {return new Symbol(sym.MIN, new token(yycolumn, yyline, yytext()));}
"MAX"           {return new Symbol(sym.MAX, new token(yycolumn, yyline, yytext()));}
"UPDATE"        {return new Symbol(sym.UPDATE, new token(yycolumn, yyline, yytext()));}
"DELETE"        {return new Symbol(sym.DELETE, new token(yycolumn, yyline, yytext()));}
"INSERT"        {return new Symbol(sym.INSERT, new token(yycolumn, yyline, yytext()));}
"INTO"          {return new Symbol(sym.INTO, new token(yycolumn, yyline, yytext()));}
"VALUES"        {return new Symbol(sym.VALUES, new token(yycolumn, yyline, yytext()));}

/* EXPRESIONES */
{ValorEntero}   {return new Symbol(sym.NUM, new token(yycolumn, yyline, yytext()));}
{Palabra}       {return new Symbol(sym.PALABRA, new token(yycolumn, yyline, yytext()));}
{Id}            {return new Symbol(sym.ID, new token(yycolumn, yyline, yytext()));}
{LineTerminator} {return new Symbol(sym.NEWLINE, new token(yycolumn, yyline, yytext()));}
{WhiteSpace}    {/* ignorar */}
.               {System.err.println("caracter invalido" + yytext() + "["+ yyline + ":"+ yycolumn + "]");}