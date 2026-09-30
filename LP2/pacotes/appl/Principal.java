public class Principal{
	public static void main (String[] args) throws NumArgsEx
	{
		String nome1,nome2;
		// cria um objeto Calc para usar ...
		Calc calculadora=new Calc();
		int soma;
		double div;	
		if (args.length!=3){
			throw new NumArgsEx("Numero de argumentos errado, formato certo: <operacao> <termo1> <termo2>");
		}
	    // testa o número de argumentos
		
		// vê qual a operação
		
		// faz a chamada para executar a operação
		
		// trata as esceções
	
	        /// completar
		   
		   
			if (args[0].equals("soma"))
			{
			   nome1 = args[1];
			   nome2 = args[2];
			   try{
					soma = objeto.soma(nome1,nome2);
			   }
			   catch(NaoNumEx e){
					System.out.println(e);
			   }

			   System.out.println("Soma = " + soma);
			}
			else if (args[0].equals("div"))
			{
			   nome1 = args[1];
			   nome2 = args[2];
			   div = objeto.div(nome1,nome2);
			   System.out.println("Divisao = " + div);
			}
			else
			// ou completa, ou deixa assim ...	
			System.out.println("Operacao matematica invalida.");
	        } 
	      
	    
	       
	}
