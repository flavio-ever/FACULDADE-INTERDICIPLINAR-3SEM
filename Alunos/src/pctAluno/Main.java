package pctAluno;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Aluno __default = new Aluno();
    
    List<Aluno> objAluno    =   new ArrayList<Aluno>();

    List<Float> notasAluno  =   new ArrayList<Float>();
                notasAluno.add(10f);
                notasAluno.add(9f);
                notasAluno.add(10f);
                    
    Scanner read = new Scanner(System.in);

    objAluno.add(new Aluno("1863036-7", 
                           "Flavio Everton", 
                           22, 
                           "ADS", 
                           "3", 
                           notasAluno));

    objAluno.add(new Aluno("6666666-7", 
                           "Kalita Trevisan", 
                           23, 
                           "XS", 
                           "1", 
                           notasAluno));

    __default.SearchAluno(objAluno, "1863036-7", null, 0);

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
        System.out.print("Digite a opção (Ex: 1, 2, 3...4) :. ");
        opSelected = read.nextInt();
        switch((int)opSelected){
            case 1:
                __default.Clear();
                __default.editAluno(true);
                objAluno.add(__default);
                __default.Clear();
                System.out.println(">> Usuário cadastrado com sucesso!!!\n");
                break;
            case 2:
                __default.Clear();
                System.out.print("Digite o RGM do aluno:. ");
                __default.SearchAluno(objAluno, read.next(), null, 0);
                break;
            case 3:
                
                break;
            case 4:

                break;
            case 5:
                
                break;
            case 6:
                
                break;
            default:
                miniDash = false;
        }
    }        
  }
}
