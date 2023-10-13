/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASintactico;

import ALexico.Token;

/**
 *
 * @author Kenny
 */
public class Transiciones {
    
    protected int [][] tabla;
    public Transiciones(){
        tabla = new int[100][100];
        //[ESTADO EN EL QUE SE ENCUENTRA][TOKEN QUE RECIBE PARA MOVERSE A OTRO LUGAR] = ESTADO AL QUE SE MUEVE AL RECIBIR EL TOKEN
        //ASIGNACION DE VARIABLES, EXPRESIONES, OPERADORES DE ASIGNACION, DE COMPARACION, LOGICOS, DE IDENTIDAD, DE PERTENENCIA
        tabla[1][1]=2;// estado[1][id]-->E2
        tabla[2][2]=3;//ESTADO[2][=]-->E3
        tabla[2][18]=3;//ESTADO[2][+=]-->E3
        tabla[2][19]=3;//ESTADO[2][-=]-->E3
        tabla[2][17]=3;//ESTADO[2][*=]-->E3
        tabla[2][38]=3;//ESTADO[2][/=]-->E3
        tabla[2][39]=3;//ESTADO[2][**=]-->E3
        tabla[2][40]=3;//ESTADO[2][%=]-->E3
        tabla[3][1]=4;//ESTADO[2][id]-->E4
        tabla[3][3]=4;//ESTADO[3][TRUE]-->E4
        tabla[3][4]=4;//ESTADO[3][FALSE]-->E4
        tabla[3][5]=4;//ESTADO[3][NUMERO]-->E4
        tabla[3][6]=4;//ESTADO[3][STRING]-->E4
        tabla[3][31]=3;//ESTADO[3][(]-->E3
        tabla[4][32]=4;//ESTADO[4][)]-->E4
        tabla[4][31]=91;//ESTADO[4][(]-->E91
        tabla[91][1]=92;//ESTADO[91][ID]-->E92
        tabla[91][5]=92;//ESTADO[91][NUMERO]-->E92
        tabla[91][6]=92;//ESTADO[91][CADENA]-->E92
        tabla[92][8]=91;//ESTADO[92][,]-->E91
        tabla[92][21]=91;//ESTADO[92][+]-->E91
        tabla[92][22]=91;//ESTADO[92][-]-->E91
        tabla[92][23]=91;//ESTADO[92][*]-->E91
        tabla[92][24]=91;//ESTADO[92][/]-->E91
        tabla[92][34]=91;//ESTADO[92][%]-->E91
        tabla[92][37]=91;//ESTADO[92][**]-->E91
        tabla[92][32]=93;//ESTADO[92][)]-->E93
        tabla[3][20]=66;//ESTADO[3][not]-->E66
        tabla[3][41]=66;//ESTADO[3][and]-->E66
        tabla[3][42]=66;//ESTADO[3][or]-->E66
        tabla[66][5]=4;//ESTADO[66][or]-->E66
        tabla[4][16]=63;//ESTADO[4][CUALQUIER SIGNO DE COMPARACION]-->E63
        tabla[4][43]=63;//ESTADO[4][IS]-->E63
        tabla[4][27]=63;//ESTADO[4][IN]-->E63
        tabla[4][20]=63;//ESTADO[4][NOT]-->E63
        tabla[4][41]=63;//ESTADO[4][AND]-->E63
        tabla[4][42]=63;//ESTADO[4][OR]-->E63
        tabla[63][7]=5;//ESTADO[63][[]-->E5
        tabla[63][27]=3;//ESTADO[63][IN]-->E3
        tabla[63][20]=67;//ESTADO[63][NOT]-->E67
        tabla[63][41]=67;//ESTADO[63][AND]-->E67
        tabla[63][42]=67;//ESTADO[63][OR]-->E67
        tabla[67][5]=64;//ESTADO[67][NUMERO]-->E67
        tabla[63][5]=64;//ESTADO[63][NUMERO]-->E64
        tabla[64][41]=65;//ESTADO[64][AND]-->E65
        tabla[64][42]=65;//ESTADO[64][OR]-->E65
        tabla[64][20]=65;//ESTADO[64][NOT]-->E65
        tabla[65][5]=4;//ESTADO[64][NOT]-->E65
       
        //ARREGLOS
        tabla[3][7]=5;//ESTADO[3][[]-->E5
        tabla[5][5]=6;//ESTADO[5][NUMERO]-->E6
        tabla[5][6]=6;//ESTADO[5][STRING]-->E6
        tabla[5][1]=6;//ESTADO[5][ID]-->E6
        tabla[5][9]=7;//ESTADO[5][]]-->E7
        tabla[6][8]=5;//ESTADO[6][,]-->E5
        tabla[6][9]=7;//ESTADO[6][]]-->E9
        
        //arreglos con llaves, DICCIONARIOS
        tabla[3][10]=8;//ESTADO[5][{]-->E8
        tabla[5][10]=8;//ESTADO[5][{]-->E8
        tabla[8][1]=9; //ESTADO[8][ID]-->E9
        tabla[8][5]=9; //ESTADO[8][NUMERO]-->E9
        tabla[8][6]=9; //ESTADO[8][CADENA]-->E9
        tabla[8][11]=12; //ESTADO[8][}]-->E12
        tabla[9][12]=10;//ESTADO[9][:]-->E10
        tabla[10][1]=11; //ESTADO[10][ID]-->E11
        tabla[10][5]=11; //ESTADO[10][NUMERO]-->E11
        tabla[10][6]=11;//ESTADO[10][CADENA]-->E11
        tabla[11][8]=8;//ESTADO[11][,]-->E8
        tabla[11][11]=12;//ESTADO[11][}]-->E12
        tabla[12][8]=13;//ESTADO[12][,]-->E13
        tabla[13][10]=8;//ESTADO[13][{]-->E8
        tabla[12][9]=14; //ESTADO[12][]]-->E14 
        
        //asignaciones con comas, OPERADORES ATIRMETICOS
        tabla[2][8]=15;//ESTADO[2][,]-->E15
        tabla[15][1]=2;//ESTADO[15][ID]-->E2
        tabla[4][8]=3;//ESTADO[4][,]-->E3
        tabla[4][21]=3;//ESTADO[4][+]-->E3
        tabla[4][22]=3;//ESTADO[4][-]-->E3
        tabla[4][23]=3;//ESTADO[4][*]-->E3
        tabla[4][24]=3;//ESTADO[4][/]-->E3
        tabla[4][34]=3;//ESTADO[4][%]-->E3
        tabla[4][37]=3;//ESTADO[4][**]-->E3
        
        // IF, ELIF, WHILE
        tabla[1][13]=16;//ESTADO[1][IF]-->E16
        tabla[1][15]=16;//ESTADO[1][ELIF]-->E16
        tabla[1][25]=16;//ESTADO[1][WHILE]-->E16
        tabla[16][5]=17;//ESTADO[16][NUMERO]-->E17
        tabla[16][6]=17;//ESTADO[16][STRING]-->E17
        tabla[16][1]=17;//ESTADO[16][ID]-->E17
        tabla[17][34]=16;//ESTADO[16][%]-->E16----
        tabla[17][21]=16;//ESTADO[16][+]-->E16----
        tabla[17][22]=16;//ESTADO[16][-]-->E16----
        tabla[17][23]=16;//ESTADO[16][*]-->E16----
        tabla[17][24]=16;//ESTADO[16][/]-->E16----
        tabla[16][3]=21; //ESTADO[16][TRUE]-->E21
        tabla[16][4]=21; //ESTADO[16][FALSE]-->E21
        tabla[21][12]=20; //ESTADO[21][:]-->E20
        tabla[17][16]=18;//ESTADO[17][CUALQUIER SIGNO DE COMPARACION]-->E18
        tabla[17][27]=18;//ESTADO[17][IN]-->E18
        tabla[17][12]=20;//ESTADO[1][:]-->E16
        tabla[18][5]=19;//ESTADO[18][NUMERO]-->E19
        tabla[18][1]=19;//ESTADO[18][ID]-->E19
        tabla[18][6]=19;//ESTADO[18][STRING]-->E19
        tabla[19][20]=16;//ESTADO[19][NOT]-->E16
        tabla[19][41]=16;//ESTADO[19][AND]-->E16
        tabla[19][42]=16;//ESTADO[19][OR]-->E16
        tabla[19][12]=20;//ESTADO[19][:]-->E20
        
        //ELSE 
        tabla[1][14]=22;//ESTADO[1][ELSE]-->E22
        tabla[22][12]=23;//ESTADO[22][:]-->E23
        
        //OPERADORES TERNARIOS      
        tabla[17][14]=24;//ESTADO[17][ELSE]-->E24
        tabla[19][14]=24;//ESTADO[17][ELSE]-->E24
        tabla[24][1]=25;//ESTADO[17][ID]-->E25
        tabla[24][5]=25;//ESTADO[17][NUMERO]-->E25
        tabla[24][6]=25;//ESTADO[17][STRING]-->E25
        tabla[16][20]=26;//ESTADO[16][NOT]-->E26
        tabla[26][1]=17;//ESTADO[26][ID]-->E17
        tabla[26][5]=17;//ESTADO[26][NUMERO]-->E17
        tabla[26][6]=17;//ESTADO[26][STRING]-->E17
        
        //CICLOS FOR
        tabla[1][26]=27;//ESTADO[1][FOR]-->E27
        tabla[27][1]=28;//ESTADO[27][ID]-->E28
        tabla[28][27]=29;//ESTADO[28][IN]-->E29
        tabla[28][8]=27;//ESTADO[28][,]-->E27
        tabla[29][1]=30;//ESTADO[29][ID]-->E30
        tabla[30][12]=31;//ESTADO[30][:]-->E31
        tabla[30][30]=68;//ESTADO[30][.]-->E68
        tabla[68][1]=69;//ESTADO[68][ID]-->E69
        tabla[69][30]=68;//ESTADO[69][.]-->E68
        tabla[69][31]=70;//ESTADO[69][(]-->E70
        tabla[70][32]=71;//ESTADO[70][)]-->E71
        tabla[71][12]=31;//ESTADO[71][:]-->E31 E.ACEPTACIÓN
        tabla[70][1]=72;//ESTADO[70][ID]-->E72
        tabla[70][5]=72;//ESTADO[70][NUMERO]-->E72
        tabla[70][6]=72;//ESTADO[70][CADENA]-->E72
        tabla[72][32]=71;//ESTADO[72][)]-->E71
        tabla[72][8]=73;//ESTADO[72][,]-->E73
        tabla[73][1]=72;//ESTADO[72][ID]-->E72
        tabla[73][5]=72;//ESTADO[72][NUMERO]-->E72
        tabla[73][6]=72;//ESTADO[72][CADENA]-->E72
        tabla[30][31]=47;//ESTADO[29][(]-->E47
        tabla[47][32]=48;//ESTADO[47][)]-->E48
        tabla[48][12]=31;//ESTADO[47][:]-->E31
        tabla[47][1]=49;//ESTADO[47][ID]-->E49
        tabla[47][5]=49;//ESTADO[47][NUMERO]-->E49
        tabla[47][6]=49;//ESTADO[47][CADENA]-->E49
        tabla[49][8]=57;//ESTADO[49][,]-->E57
        tabla[57][1]=49;//ESTADO[57][1]-->E49
        tabla[57][5]=49;//ESTADO[57][NUMERO]-->E49
        tabla[57][6]=49;//ESTADO[57][CADENA]-->E49
        tabla[49][32]=48;//ESTADO[49][)]-->E48
        
        
        //PRINT
        tabla[1][28]=32;//ESTADO[1][PRINT]-->E32
        tabla[32][31]=33;//ESTADO[32][(]-->E33
        tabla[33][1]=34;//ESTADO[33][ID]-->E34
        tabla[33][5]=34;//ESTADO[33][NUMERO]-->E34
        tabla[33][6]=34;//ESTADO[33][CADENA]-->E34
        tabla[34][21]=33;//ESTADO[34][+]-->E33
        tabla[34][22]=33;//ESTADO[34][-]-->E33
        tabla[34][23]=33;//ESTADO[34][*]-->E33
        tabla[34][24]=33;//ESTADO[34][/]-->E33
        tabla[34][34]=33;//ESTADO[34][%]-->E33
        tabla[34][37]=33;//ESTADO[34][**]-->E33
        tabla[34][32]=35;//ESTADO[34][)]-->E35
        tabla[34][30]=37;//ESTADO[34][.]-->E37
        tabla[37][1]=38;//ESTADO[37][ID]-->E38
        tabla[38][30]=37;//ESTADO[38][.]-->E37
        tabla[38][31]=39;//ESTADO[38][(]-->E39
        tabla[39][32]=40;//ESTADO[39][)]-->E37
        tabla[39][1]=42;//ESTADO[39][ID]-->E42
        tabla[39][5]=42;//ESTADO[39][NUMERO]-->E42
        tabla[39][6]=42;//ESTADO[39][STRING]-->E42
        tabla[42][32]=40;//ESTADO[42][)]-->E40
        tabla[42][8]=58;//ESTADO[42][,]-->E58
        tabla[58][1]=42;//ESTADO[58][ID]-->E42
        tabla[58][5]=42;//ESTADO[58][NUMERO]-->E42
        tabla[58][6]=42;//ESTADO[58]CADENA]-->E42
        tabla[40][32]=41;//ESTADO[40][)]-->E41
        tabla[40][12]=44;//ESTADO[40][:]-->E44
        
        //DEF
        tabla[1][29]=43;//ESTADO[1][DEF]-->E43
        tabla[43][1]=38;//ESTADO[43][ID]-->E38
        
        //yeild, RETURN
        tabla[1][33]=45;//ESTADO[1][YEILD]-->E45
        tabla[1][36]=45;//ESTADO[1][RETURN]-->E45
        tabla[45][1]=46;//ESTADO[45][ID]-->E46
        tabla[45][5]=46;//ESTADO[45][NUMERO]-->E46
        tabla[45][6]=46;//ESTADO[45][CADENA]-->E46
        tabla[45][31]=60;//ESTADO[45][(]-->E60
        tabla[46][21]=45;//ESTADO[46][+]-->E45
        tabla[46][22]=45;//ESTADO[46][-]-->E45
        tabla[46][23]=45;//ESTADO[46][*]-->E45
        tabla[46][24]=45;//ESTADO[46][/]-->E45
        tabla[46][34]=45;//ESTADO[46][%]-->E45
        tabla[46][37]=45;//ESTADO[46][**]-->E45
        tabla[46][31]=60;//ESTADO[46][(]-->E60
        tabla[46][16]=94;//ESTADO[46][CUALQUIER SIGNO DE COMPARACIÓN]-->E94
        tabla[46][27]=94;//ESTADO[46][IN]-->E94
        tabla[46][20]=94;//ESTADO[46][NOT]-->E94
        tabla[46][41]=94;//ESTADO[46][AND]-->E94
        tabla[46][42]=94;//ESTADO[46][OR]-->E94
        tabla[94][1]=46;//ESTADO[94][ID]-->E46
        tabla[94][5]=46;//ESTADO[94][NUMERO]-->E46
        tabla[94][6]=46;//ESTADO[94][CADENA]-->E46
        tabla[60][1]=61;//ESTADO[60][ID]-->E61
        tabla[60][5]=61;//ESTADO[60][NUMERO]-->E61
        tabla[60][6]=61;//ESTADO[60][CADENA]-->E61
        tabla[60][32]=62;//ESTADO[60][)]-->E61
        tabla[61][8]=60;//ESTADO[61][,]-->E60
        tabla[61][21]=60;//ESTADO[61][+]-->E60
        tabla[61][22]=60;//ESTADO[61][-]-->E60
        tabla[61][23]=60;//ESTADO[61][*]-->E60
        tabla[61][24]=60;//ESTADO[61][/]-->E60
        tabla[61][34]=60;//ESTADO[61][%]-->E60
        tabla[61][37]=60;//ESTADO[61][**]-->E60
        tabla[61][32]=62;//ESTADO[45][)]-->E62
        tabla[62][8]=45;//ESTADO[62][,]-->E45
        tabla[62][21]=45;//ESTADO[62][+]-->E45
        tabla[62][22]=45;//ESTADO[62][-]-->E45
        tabla[62][23]=45;//ESTADO[62][*]-->E45
        tabla[62][24]=45;//ESTADO[62][/]-->E45
        tabla[62][34]=45;//ESTADO[62][%]-->E45
        tabla[62][37]=45;//ESTADO[62][**]-->E45
        
        
       //FOR ELSE, if busca_algo(item): | if busca_algo():
       tabla[17][31]=50;//ESTADO[17][(]-->E50
       tabla[50][32]=57;//ESTADO[50][)]-->E57
       tabla[57][12]=20;//ESTADO[57][:]-->E20
       tabla[50][1]=51;//ESTADO[50][ID]-->E51
       tabla[50][5]=51;//ESTADO[50][NUMERO]-->E51
       tabla[50][6]=51;//ESTADO[50][STRING]-->E51
       tabla[51][8]=50;//ESTADO[51][,]-->E50
       tabla[51][32]=52;//ESTADO[51][)]-->E52
       tabla[52][12]=20;//ESTADO[52][:]-->E20
       
       //3ERA LINEA DEL FOR ELSE, PROCESA(ITEM)O PROCESA()
       tabla[2][31]=53;//ESTADO[2][(]-->E53
       tabla[53][32]=55;//ESTADO[53][)]-->E55
       tabla[53][1]=54;//ESTADO[53][ID]-->E54
       tabla[53][5]=54;//ESTADO[53][NUMERO]-->E54
       tabla[53][6]=54;//ESTADO[53][CADENA]-->E54
       tabla[54][8]=59;//ESTADO[54][,]-->E59
       tabla[59][1]=54;//ESTADO[54][ID]-->E54
       tabla[59][5]=54;//ESTADO[54][NUMERO]-->E54
       tabla[59][6]=54;//ESTADO[54][STRING]-->E54
       tabla[54][32]=55;//ESTADO[54][)]-->E55
       
       //FUNCIONES CON ()(()) ([]) ({})
       tabla[53][7]=74;//ESTADO[53][[]-->E74
       tabla[74][1]=75;//ESTADO[74][ID]-->E75
       tabla[74][5]=75;//ESTADO[74][NUMERO]-->E75
       tabla[74][6]=75;//ESTADO[74][CADENA]-->E75
       tabla[75][8]=74;//ESTADO[75][,]-->E74
       tabla[75][9]=76;//ESTADO[75][]]-->E76
       tabla[76][32]=77;//ESTADO[76][)]-->E77
       tabla[53][10]=78;//ESTADO[53][{]-->E78
       tabla[78][1]=79;//ESTADO[78][ID]-->E79
       tabla[78][5]=79;//ESTADO[78][NUMERO]-->E79
       tabla[78][6]=79;//ESTADO[78][CADENA]-->E79
       tabla[79][12]=80;//ESTADO[79][:]-->E80
       tabla[80][1]=81;//ESTADO[80][ID]-->E81
       tabla[80][5]=81;//ESTADO[80][NUMERO]-->E81
       tabla[80][6]=81;//ESTADO[80][CADENA]-->E81
       tabla[81][8]=78;//ESTADO[81][,]-->E78
       tabla[81][11]=82;//ESTADO[81][}]-->E82
       tabla[82][32]=77;//ESTADO[82][)]-->E82
       tabla[82][8]=83;//ESTADO[82][,]-->E83
       tabla[83][10]=78;//ESTADO[83][{]-->E78
       tabla[53][31]=84;//ESTADO[53][(]-->E84
       tabla[84][1]=75;//ESTADO[84][ID]-->E75
       tabla[84][5]=75;//ESTADO[84][NUMERO]-->E75
       tabla[84][6]=75;//ESTADO[84][CADENA]-->E75
       tabla[75][32]=85;//ESTADO[75][)]-->E85
       tabla[85][32]=77;//ESTADO[85][)]-->E77
       
       // PRINT PARA FUNCIONES CON RETORNO () (()) (10,10)
       tabla[34][31]=86;//ESTADO[34][(]-->E86
       tabla[86][32]=87;//ESTADO[86][)]-->E87
       tabla[87][32]=88;//ESTADO[87][)]-->E88
       tabla[86][1]=89;//ESTADO[86][ID]-->E89
       tabla[86][5]=89;//ESTADO[86][NUMERO]-->E89
       tabla[86][6]=89;//ESTADO[86][CADENA]-->E89
       tabla[89][32]=87;//ESTADO[89][)]-->E87
       tabla[89][8]=90;//ESTADO[89][,]-->E90
       tabla[90][1]=89;//ESTADO[90][ID]-->E89
       tabla[90][5]=89;//ESTADO[90][NUMERO]-->E89
       tabla[90][6]=89;//ESTADO[90][CADENA]-->E89
       
       // BREAK
       tabla[1][35]=56;//ESTADO[1][BREAK]-->E56
       
       
       
       
        
    }
    
    
    public int devolverNumeroPorToken(Token token){
        int numero=0;
        switch(token.getTipo()){
            case IDENTIFICADOR: numero=1; break;
            case ASIGNACION_IGUAL: numero=2; break;
            case BOOLEANA_TRUE: numero=3; break;
            case BOOLEANA_FALSE: numero=4; break;
            case CONSTANTE_DECIMAL: numero=5; break;
            case CONSTANTE_ENTERA: numero=5;break;
            case CADENA: numero=6;break;
            case CORCHETE_APERTURA: numero=7; break;
            case COMA: numero=8; break;
            case CORCHETE_CIERRE: numero=9; break;
            case LLAVE_APERTURA: numero=10; break;
            case LLAVE_CIERRE: numero=11; break;
            case DOS_PUNTOS: numero=12; break;
            case PALABRA_RESERVADA_IF: numero = 13; break;
            case PALABRA_RESERVADA_ELSE: numero = 14; break;
            case PALABRA_RESERVADA_ELIF: numero = 15; break;
            case COMPARACION_IGUAL: numero =16 ; break;
            case COMPARACION_DIFERENTE: numero =16 ; break;
            case COMPARACION_MAYOR_O_IGUAL_QUE: numero =16 ; break;
            case COMPARACION_MAYOR_QUE: numero =16 ; break;
            case COMPARACION_MENOR_O_IGUAL_QUE: numero =16 ; break;
            case COMPARACION_MENOR_QUE: numero =16 ; break;
            case ASIGNACION_MULTIPLICACION: numero = 17; break;
            case ASIGNACION_SUMA: numero = 18; break;
            case ASIGNACION_RESTA: numero = 19; break;
            case OPERADOR_LOGICO_NEGACION: numero = 20; break;
            case ARITMETICO_SUMA: numero = 21; break;
            case ARITMETICO_RESTA: numero = 22; break;
            case ARITMETICO_MULTIPLICACION: numero = 23; break;
            case ARITMETICO_DIVISION: numero = 24; break;
            case PALABRA_RESERVADA_WHILE: numero = 25; break;
            case PALABRA_RESERVADA_FOR: numero = 26; break;
            case PALABRA_RESERVADA_IN: numero = 27; break;
            case PALABRA_RESERVADA_PRINT: numero = 28; break;
            case PALABRA_RESERVADA_DEF: numero = 29; break;
            case PUNTO: numero = 30; break;
            case PARENTESI_APERTURA: numero = 31; break;
            case PARENTESI_CIERRE: numero = 32; break;
            case PALABRA_RESERVADA_YIELD: numero = 33; break;
            case ARITMETICO_MODULO: numero = 34; break;
            case PALABRA_RESERVADA_BREAK: numero = 35; break;
            case PALABRA_RESERVADA_RETURN: numero = 36; break;
            case ARITMETICO_EXPONENTE: numero = 37; break;
            case ASIGNACION_DIVISION: numero = 38; break;
            case ASIGNACION_EXPONENTE: numero = 39; break;
            case ASIGNACION_MODULO: numero = 40; break;
            case OPERADOR_LOGICO_Y: numero = 41; break;
            case OPERADOR_LOGICO_O: numero = 42; break;
            case PALABRA_RESERVADA_IS: numero = 43; break;
            
            
            default:numero=0;
        }   
        
        return numero;
    }
}
