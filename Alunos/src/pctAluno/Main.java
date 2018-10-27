package pctAluno;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Aluno __default         =   new Aluno();
    List<Aluno> objAluno    =   new ArrayList<Aluno>();
    Scanner read            =   new Scanner(System.in);

    List<Float> notasAluno1  =   new ArrayList<Float>();;;
                notasAluno1.add(10f);
                notasAluno1.add(10f);
                notasAluno1.add(9f);
                
    List<Float> notasAluno2  =   new ArrayList<Float>();;;
                notasAluno2.add(7f);
                notasAluno2.add(9f);
                notasAluno2.add(8f);
                
    List<Float> notasAluno3  =   new ArrayList<Float>();
                notasAluno3.add(8f);
                notasAluno3.add(7f);
                notasAluno3.add(9f);
                
    List<Float> notasAluno4 =   new ArrayList<Float>();
                notasAluno3.add(10f);
                notasAluno3.add(10f);
                notasAluno3.add(10f);
                    

    objAluno.add(new Aluno("1863036-7", 
                           "Flavio Everton 1", 
                           25, 
                           "ADS", 
                           "3", 
                           notasAluno1));
    
    objAluno.add(new Aluno("1863036-7", 
                           "Flavio Everton 2", 
                           25, 
                           "ADS", 
                           "3", 
                           notasAluno2));

    objAluno.add(new Aluno("6666666-7", 
                           "Kalita Trevisan 1", 
                           23, 
                           "XS", 
                           "1", 
                           notasAluno3));
    
    objAluno.add(new Aluno("6666666-7", 
                           "Kalita Trevisan 2", 
                           23, 
                           "XS", 
                           "1", 
                           notasAluno4));
                
    // TESTE
    //__default.getDetailAluno(__default.SearchAluno(objAluno, null, "idade"));
    //__default.SearchAluno(objAluno, "1863036-7", null, 0);
    //__default.SearchAluno(objAluno, "6666666-7", null, 0);

    boolean miniDash = true;
    while(miniDash){
        int opSelected;
        System.out.println(
        "\n********************************************************************\n" + 
        "* DASHBOARD ALUNOS\n* Para finalizar digite qualquer número\n" + 
        "********************************************************************");
        System.out.println("* 1 - Cadastrar Aluno");
        System.out.println("* 2 - Editar Aluno");
        System.out.println("* 3 - Consultar Aluno por RGM ou Curso");
        System.out.println("* 4 - Consultar Aluno com maior média de um determinado Curso");
        System.out.println("* 5 - Consultar Aluno por faixa etária");
        System.out.println("* 6 - Créditos");
        
        System.out.print("\n>> DIGITE A OPÇÃO :. ");
        opSelected = read.nextInt();
        switch((int)opSelected){
            case 1:
                __default.Clear();
                __default.editAluno(true);
                objAluno.add(__default);
                __default.Clear();
                System.out.println(">> Aluno CADASTRADO com sucesso!\n");
                break;
            case 2:
                //__default.Clear();
                System.out.print(">> Digite o RGM do Aluno:. ");
                __default.SearchAluno(objAluno, read.next(), null).editAluno(false);
                System.out.println(">> Aluno EDITADO com sucesso!\n");
                break;
            case 3:
                __default.Clear();
                System.out.print(">> Digite o RGM para pesquisar somente 1 Aluno ou\n>> o nome do CURSO pesquisar todos os Alunos do mesmo:. ");
                __default.SearchAluno(objAluno, read.next(), 0);
                break;
            case 4:
                System.out.print(">> Para saber a maior média de um determinado curso, digite o nome do curso:. ");
                String tmpNomeCurso = read.next();
                System.out.println(">> Resultado:. ");
                __default.getDetailAluno(__default.SearchAluno(objAluno, null, ("media," + tmpNomeCurso)));
                break;
            case 5:
                System.out.println(">> Resultado:. ");
                __default.getDetailAluno(__default.SearchAluno(objAluno, null, "idade,null"));
                break;
            case 6:
                __default.Clear();
                System.out.println(
                "****************************************************************************************\n" +
                "* Oba! Este projeto se encontra em meu GitHub: github.com/fstack-me/JavaInterdiciplicar\n" +
                "****************************************************************************************\n" +
                "* Participação: \n" +
                "* >> Flavio Everton Brito da Silva - 1863036-7\n" +
                "* >> Lorem ispum...\n" +
                "* >> Lorem ispum...\n" +
                "* >> Lorem ispum...\n");
                break;
            default:
                miniDash = false;
        }
    }        
  }
}
