package pctAluno;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Aluno __default         =   new Aluno();
    List<Aluno> objAluno    =   new ArrayList<Aluno>();
    Scanner read            =   new Scanner(System.in);

//    List<Float> notasAluno  =   new ArrayList<Float>();
//                notasAluno.add(0f);
//                notasAluno.add(0f);
//                notasAluno.add(10f);
//                
//    List<Float> notasAluno2  =   new ArrayList<Float>();
//                notasAluno2.add(8f);
//                notasAluno2.add(7f);
//                notasAluno2.add(9f);
                    

//    objAluno.add(new Aluno("1863036-7", 
//                           "Flavio Everton", 
//                           25, 
//                           "ADS", 
//                           "3", 
//                           notasAluno));
//
//    objAluno.add(new Aluno("6666666-7", 
//                           "Kalita Trevisan", 
//                           23, 
//                           "XS", 
//                           "1", 
//                           notasAluno2));
//                
//    __default.getDetailAluno(__default.SearchAluno(objAluno, null, "idade"));
    //__default.SearchAluno(objAluno, "1863036-7", null, 0);

    boolean miniDash = false;
    while(miniDash){
        int opSelected;
        System.out.println(
        "********************************************************************\n" + 
        "* DASHBOARD ALUNOS\n* Para finalizar digite qualquer número\n" + 
        "********************************************************************");
        System.out.println("* 1 - Cadastrar Aluno");
        System.out.println("* 2 - Editar Aluno");
        System.out.println("* 3 - Consultar Aluno por RGM ou Curso");
        System.out.println("* 4 - Consultar Aluno com maior média de um determinado Curso");
        System.out.println("* 5 - Consultar Aluno por faixa etária");
        System.out.println("* 6 - Créditos");
        System.out.println(
        "*********************************************************************");
        System.out.print(">> Digite a opção (Ex: 1, 2, 3...4) :. ");
        opSelected = read.nextInt();
        switch((int)opSelected){
            case 1:
                __default.Clear();
                __default.editAluno(true);
                objAluno.add(__default);
                __default.Clear();
                System.out.println(">> Usuário CADASTRADO com sucesso!\n");
                break;
            case 2:
                __default.Clear();
                System.out.print(">> Digite o RGM do Aluno:. ");
                __default.SearchAluno(objAluno, read.next(), null).editAluno(false);
                System.out.println(">> Usuário EDITADO com sucesso!\n");
                break;
            case 3:
                __default.Clear();
                System.out.print(">> Digite o RGM ou CURSO do Aluno:. ");
                __default.SearchAluno(objAluno, read.next(), null, 0);
                break;
            case 4:
                __default.getDetailAluno(__default.SearchAluno(objAluno, null, "media"));
                break;
            case 5:
                __default.getDetailAluno(__default.SearchAluno(objAluno, null, "idade"));
                break;
            case 6:
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
