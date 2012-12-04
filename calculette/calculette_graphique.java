import java.applet.Applet;
import java.awt.*;

import javax.swing.JFrame;
import java.lang.Integer;



public class calculette_graphique extends Applet
{
//déclaration des variables pour les boutons

TextField txtDisp;
public final int NONE = 0;
public final int ADD = 1;
public final int SUB = 2;
public final int MUL = 3;
public final int DIV = 4;
public final int NEG = 5;
public final int EQ = 6;
public final int C = 7;
public final int DECSEP = -1;

String msDecimal;
int mnOp = NONE;
boolean mbNewNumber = true;
boolean mbDecimal = false;
double mdReg = 0.0;


/*
Initialisation de l'applet
Mise en page des boutons : couleur, et police de caractère et positionnement
*/

@SuppressWarnings("deprecation")
public void init()           /* initialisation des boutons */
{
CALCULButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
CALCULButton btnDecSep, btnPlus, btnMinus;
CALCULButton btnTimes, btnDiv, btnEqual, btnClear;

setLayout(null);
setFont(new Font("Helvetica", Font.PLAIN, 14));   // style de fond
//setBackground(new Color(0xCC, 0xCC, 0xCC));

btn0 = new  CALCULButton("0",NONE, 0);
add(btn0);
btn0.reshape(64, 164, 40, 24);
btn0.setForeground(Color.green);

btn1 = new CALCULButton("1",NONE, 1);
add(btn1);
btn1.reshape(64, 132, 40, 24);
btn1.setForeground(Color.green);

btn2 = new CALCULButton("2",NONE, 2);
add(btn2);
btn2.reshape(120, 132, 40, 24);
btn2.setForeground(Color.green);

btn3 = new CALCULButton("3",NONE, 3);
add(btn3);
btn3.reshape(176, 132, 40, 24);
btn3.setForeground(Color.green);

btn4 = new CALCULButton("4",NONE , 4);
add(btn4);
btn4.reshape(64, 100, 40, 24);
btn4.setForeground(Color.green);

btn5 = new CALCULButton("5",NONE , 5);
add(btn5);
btn5.reshape(120, 100, 40, 24);
btn5.setForeground(Color.green);

btn6 = new CALCULButton("6",NONE, 6);
add(btn6);
btn6.reshape(176, 100, 40, 24);
btn6.setForeground(Color.green);

btn7 = new CALCULButton("7",NONE, 7);
add(btn7);
btn7.reshape(64, 68, 40, 24);
btn7.setForeground(Color.green);

btn8 = new CALCULButton("8",NONE, 8);
add(btn8);
btn8.reshape(120, 68, 40, 24);
btn8.setForeground(Color.green);

btn9 = new CALCULButton("9",NONE, 9);
add(btn9);
btn9.reshape(176, 68, 40, 24);
btn9.setForeground(Color.green);

btnPlus = new CALCULButton("+", ADD, 0);
add(btnPlus);
btnPlus.reshape(232, 112, 40, 56);
btnPlus.setForeground(Color.red);


btnMinus = new CALCULButton("-", SUB, 0);
add(btnMinus);
btnMinus.reshape(288, 112, 40, 24);
btnMinus.setForeground(Color.red);


btnTimes = new CALCULButton("×", MUL, 0);
add(btnTimes);
btnTimes.reshape(232, 80, 40, 24);
btnTimes.setForeground(Color.red);


btnDiv = new CALCULButton("÷", DIV, 0);
add(btnDiv);
btnDiv.reshape(288, 80, 40, 24);
btnDiv.setForeground(Color.red);


btnEqual = new CALCULButton("=", EQ, 0);
add(btnEqual);
btnEqual.reshape(288, 144, 40, 24);
btnEqual.setForeground(Color.red);


btnClear = new CALCULButton("C", C, 0);
add(btnClear);
btnClear.reshape(176, 164, 40, 24);
btnClear.setForeground(Color.green);

btnDecSep = new CALCULButton("·",NONE, DECSEP);
add(btnDecSep);
btnDecSep.reshape(120, 164, 40, 24);
btnDecSep.setForeground(Color.green);

txtDisp = new TextField("0", 80); /* permet de creer un champ texte et d'effectuerb des saisie et un affichage a une seule ligne */
txtDisp.setEditable(false);
add(txtDisp);
txtDisp.reshape(64, 8, 268, 27);
String sOneTenth = (new Double(0.1)).toString();
msDecimal = sOneTenth.substring(sOneTenth.length()-2).substring(0, 1);
}

/*
Création de la frame
*/

@SuppressWarnings("deprecation")
public static void main(String args[])
{
JFrame frm = new JFrame(" calculatrice graphique en java");
calculette_graphique ex1 = new calculette_graphique();
ex1.init();
frm.add("Center", ex1);
frm.pack();
frm.resize(350, 300);
frm.show();
frm.setForeground(Color.yellow);
frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}


/*
Initialisation de la calculatrice
*/



private void jbInit() throws Exception {
this.setBackground(SystemColor.text);
this.setSize(new Dimension(300, 316));
}

/*
Fonction pour les nombres décimaux
*/

public void append(int nVal)
{
String sDigit;

if(nVal == DECSEP)
if(!mbDecimal)
{
if(mbNewNumber)
{
txtDisp.setText("0");
mbNewNumber = false;
}
mbDecimal = true;
sDigit = msDecimal;
}
else
return;
else
sDigit = (new Integer(nVal)).toString();
if(mbNewNumber)
{
txtDisp.setText(sDigit);
mbNewNumber = false;
}
else
txtDisp.setText(txtDisp.getText() + sDigit);
repaint();
}

/*
Initialisation des opérations
*/
public void doOp(int nNewOp)
{
double dDisp;
dDisp = (new Double(txtDisp.getText())).doubleValue();


switch(nNewOp) /* switch qui permet la déclaration des opérations */
{
case NEG:  txtDisp.setText((new Double(-dDisp)).toString());
break;

case C:
	mbNewNumber = true;
	mbDecimal = false;
	txtDisp.setText("0");
break;


case ADD:
case SUB:
case MUL:
case DIV:
case EQ:

switch(mnOp)   /* switch qui gére les operations + , - , * , /  */


{
case ADD:
mdReg = mdReg + dDisp;
break;

case SUB:
mdReg = mdReg - dDisp;
break;

case MUL:
mdReg = mdReg * dDisp;
break;

case DIV:
mdReg = mdReg / dDisp;
break;

case EQ:
case NONE:
mdReg = dDisp;
break;
}
mnOp = nNewOp; /* permet de generer  des operations si l'utilisateur effectue plusieur operation */
mbNewNumber = true;
mbDecimal = false;
txtDisp.setText((new Double(mdReg)).toString());
break;
}
}


/*
Initialisation des boutons
*/

class CALCULButton extends Button
{
int mnOp;
int mnValue;

CALCULButton(String sText, int nOp, int nValue) /* initialisation de la fonction qui calcul le bouton */
{
super(sText);
mnOp = nOp;
mnValue = nValue;
}

public boolean action(Event evt, Object arg) /* permet de gerer les evenements */
{
	calculette_graphique par = (calculette_graphique)getParent();

if(mnOp == par.NONE)
par.append(mnValue);
else
{
par.doOp(mnOp);
}
return true;
}
}

}