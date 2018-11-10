import java.util.*;

class Main {
  public static void main(String[] args) {
    Aluno __default         =   new Aluno();
    List<Aluno> objAluno    =   new ArrayList<Aluno>();
    Scanner read            =   new Scanner(System.in);

    boolean miniDash    = true;
    int opSelected      = 0;
    while(miniDash){
        if(opSelected > 0){
            System.out.print("\n>> Deseja voltar ao menu principal?\n>> Digite: 1 para Sim e 0 para Finalizar:. ");
            opSelected = read.nextInt();
            if(opSelected == 1){ opSelected = 0; continue; }
        } else{
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
            System.out.println("* 0 - Sair");
            System.out.print("\n>> DIGITE A OPÇÃO:. ");
            opSelected = read.nextInt();
        }
        
        if (objAluno.size() == 0 && (opSelected == 2 || opSelected == 3 || opSelected == 4 || opSelected == 5)) {
            System.out.println(">> Ops! Você não pode acessar essas opções sem antes cadastrar um Aluno. ;P");
        } else {
            switch((int)opSelected){
                case 0:
                    miniDash = false;
                    break;
                case 1:
                    __default.Clear();
                    __default.editAluno(true);
                    objAluno.add(__default);
                    __default.Clear();
                    System.out.println(">> Aluno CADASTRADO com sucesso!\n");
                    break;
                case 2:
                    __default.Clear();
                    System.out.print(">> Digite o RGM do Aluno para Editar:. ");
                    __default.SearchAluno(objAluno, read.next(), "_,_", new int[]{}).editAluno(false);
                    break;
                case 3:
                    __default.Clear();
                    System.out.print(">> Digite o RGM para pesquisar somente 1 Aluno ou o nome do CURSO pesquisar todos:. ");
                    __default.SearchAluno(objAluno, read.next(), 0);
                    break;
                case 4:
                    __default.Clear();
                    System.out.print(">> Para saber a maior média de um determinado curso, digite o nome do curso:. ");
                    String tmpNomeCurso = read.next();
                    __default.getDetailAluno(__default.SearchAluno(objAluno, null, ("media," + tmpNomeCurso), new int[]{}));
                    break;
                case 5:
                    __default.Clear();
                    int iIdade, fIdade;

                    System.out.print(">> Digite o primeiro intervalo de idade: ");
                    iIdade = read.nextInt();
                    System.out.print(">> Digite o último intervalo de idade: ");
                    fIdade = read.nextInt();

                    __default.SearchAluno(objAluno, null, "idade,null", new int[] {iIdade,fIdade} );
                    break;
                case 6:
                    __default.Clear();
                    System.out.println(
                    "****************************************************************************************\n" +
                    "* Oba! Este projeto se encontra no GitHub: https://github.com/fstack-me/JavaInter\n" +
                    "****************************************************************************************\n" +
                    "* Desenvolvimento/Participação: \n" +
                    "* >> Programação: Flavio Everton Brito da Silva - 1863036-7\n" +
                    "* >> Testes unitários: Lorem ispum...\n" +
                    "* >> Testes unitários: Lorem ispum...\n" +
                    "* >> Testes unitários: Lorem ispum...\n" +
                    "* >> Testes unitários: Lorem ispum...\n");
                    break;
                default:
                    miniDash = false;
            }
        }
    }        
  }
}