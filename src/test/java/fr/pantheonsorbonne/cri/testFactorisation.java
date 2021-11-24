package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testFactorisation {

	@Test
	void test() {
		//Cas : a^2 + 2ab + b^2 = (a+b)^2
		
				ConstanteN deux = new ConstanteN(2);
				
				VariableInconnue a = new VariableInconnue("a");
				VariableInconnue b = new VariableInconnue("b");
				
				Puissance aCarre = new Puissance(a,deux); //a^2
				Multiplication op1 = new Multiplication(a,b); //ab
				Multiplication op2 = new Multiplication(deux,op1); //2ab
				Addition op3 = new Addition(aCarre,op2); //a^2 + 2ab
				Puissance bCarre = new Puissance(b,deux); //b^2
				Addition op4 = new Addition(op3,bCarre); //a^2+2ab+b^2
				
				Puissance resultatAttendu = new Puissance(new Addition(a,b), new ConstanteN(2)); //(a+b)^2
				assertEquals("((a+b)^2)", resultatAttendu.toString());
				assertEquals("((a+b)^2)", op4.factoriser1( (Addition) op4.left, (Puissance) op4.right).toString() );
			}
			
			
			@Test
			void TestIdentiteRemarquable2() {
				//Cas : a^2 - 2ab + b^2 = (a-b)^2
				
				ConstanteN deux = new ConstanteN(2);
				
				VariableInconnue a = new VariableInconnue("a");
				VariableInconnue b = new VariableInconnue("b");
				
				Puissance aCarre = new Puissance(a,deux); //a^2
				Multiplication op1 = new Multiplication(a,b); //ab
				Multiplication op2 = new Multiplication(deux,op1); //2ab
				Soustraction op3 = new Soustraction(aCarre,op2); //a^2 - 2ab
				Puissance bCarre = new Puissance(b,deux);//b^2
				Addition op4 = new Addition(op3,bCarre); //a^2-2ab+b^2
				
				Puissance resultatAttendu = new Puissance(new Soustraction(a,b),new ConstanteN(2)); //(a-b)^2
				
				assertEquals("((a-b)^2)", resultatAttendu.toString());
				assertEquals("((a-b)^2)", op4.factoriser3( (Soustraction) op4.left, (Puissance) op4.right).toString() );
			}
			
			@Test
			void TestIdentiteRemarquable4() {
				//Cas : c^2 + 2cd + d^2 = (c+d)^2
				
				ConstanteN deux = new ConstanteN(2);
				
				VariableInconnue c = new VariableInconnue("c");
				VariableInconnue d = new VariableInconnue("d");
				
				Puissance cCarre = new Puissance(c,deux); //a^2
				Multiplication op1 = new Multiplication(c,d); //ab
				Multiplication op2 = new Multiplication(deux,op1); //2ab
				Addition op3 = new Addition(cCarre,op2); //a^2 + 2ab
				Puissance dCarre = new Puissance(d,deux); //b^2
				Addition op4 = new Addition(op3,dCarre); //a^2+2ab+b^2
				
				Puissance resultatAttendu = new Puissance(new Addition(c,d), new ConstanteN(2)); //(a+b)^2
				
				assertEquals("((c+d)^2)", resultatAttendu.toString());
				assertEquals("((c+d)^2)", op4.factoriser1( (Addition) op4.left, (Puissance) op4.right).toString() );
			}
			
			@Test
			void TestIdentiteRemarquable5() {
				//Cas : 3a^2 + 6ab + 3b^2 = 3(a+b)^2
				
				ConstanteN deux = new ConstanteN(2);
				ConstanteN trois = new ConstanteN(3);
				ConstanteN six = new ConstanteN(6);
				VariableInconnue a = new VariableInconnue("a");
				VariableInconnue b = new VariableInconnue("b");
				
				Puissance aCarre = new Puissance(a,deux); //a^2
				Multiplication troisaCarre = new Multiplication(trois,aCarre); //3a^2
				Multiplication ab = new Multiplication(a,b); //ab
				Multiplication sixab = new Multiplication(six,ab); //6ab
				Addition op1 = new Addition(troisaCarre,sixab); //3a^2 + 6ab
				Puissance bCarre = new Puissance(b,deux); //b^2
				Multiplication troisbCarre = new Multiplication(trois,bCarre); //3b^2
				Addition op2 = new Addition(op1,troisbCarre); //3a^2+6ab+3b^2
				
				Multiplication resultatAttendu = new Multiplication (trois, new Puissance(new Addition(a,b), new ConstanteN(2))); //3(a+b)^2
				
				assertEquals("(3*((a+b)^2))", resultatAttendu.toString());
				assertEquals("(3*((a+b)^2))", op2.factoriser2( (Addition) op2.left, (Multiplication) op2.right).toString() );
			}
			
			@Test
			void TestIdentiteRemarquable6() {
				//Cas : 3a^2 - 6ab + 3b^2 = 3(a-b)^2
				
				ConstanteN deux = new ConstanteN(2);
				ConstanteN trois = new ConstanteN(3);
				ConstanteN six = new ConstanteN(6);
				VariableInconnue a = new VariableInconnue("a");
				VariableInconnue b = new VariableInconnue("b");
				
				Puissance aCarre = new Puissance(a,deux); //a^2
				Multiplication troisaCarre = new Multiplication(trois,aCarre); //3a^2
				Multiplication ab = new Multiplication(a,b); //ab
				Multiplication sixab = new Multiplication(six,ab); //6ab
				Soustraction op1 = new Soustraction(troisaCarre,sixab); //3a^2 - 6ab
				Puissance bCarre = new Puissance(b,deux); //b^2
				Multiplication troisbCarre = new Multiplication(trois,bCarre); //3b^2
				Addition op2 = new Addition(op1,troisbCarre); //3a^2-6ab+3b^2
				
				Multiplication resultatAttendu = new Multiplication (trois, new Puissance(new Soustraction(a,b), new ConstanteN(2))); //3(a+b)^2
				
				assertEquals("(3*((a-b)^2))", resultatAttendu.toString());
				assertEquals("(3*((a-b)^2))", op2.factoriser4( (Soustraction) op2.left, (Multiplication) op2.right).toString() );
			}

}
