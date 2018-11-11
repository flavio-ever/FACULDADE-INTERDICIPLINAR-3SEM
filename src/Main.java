import java.util.*;

class Main {
  public static void main(String[] args) {
    Aluno _tmp              =   new Aluno();
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
                    _tmp.Clear();
                    _tmp.setError(false);
                    objAluno.add(_tmp.editAluno(true, _tmp));
                    _tmp.Clear();
                    System.out.println(">> Aluno CADASTRADO com sucesso!\n");
                    break;
                case 2:
                    _tmp.Clear();
                    _tmp.setError(false);
                    System.out.print(">> Digite o RGM do Aluno para Editar:. ");
                    _tmp.editAluno(false, _tmp.SearchAluno(objAluno, read.next(), "_,_", new int[]{}));
                    break;
                case 3:
                    _tmp.Clear();
                    System.out.print(">> Digite o RGM para pesquisar somente 1 Aluno ou o nome do CURSO pesquisar todos:. ");
                    _tmp.SearchAluno(objAluno, read.next(), 0);
                    break;
                case 4:
                    _tmp.Clear();
                    _tmp.setError(false);
                    System.out.print(">> Para saber a maior média de um determinado curso, digite o nome do curso:. ");
                    String tmpNomeCurso = read.next();
                                        _tmp.setError(true);
                    _tmp.getDetailAluno(_tmp.SearchAluno(objAluno, null, ("media," + tmpNomeCurso), new int[]{}));
                    break;
                case 5:
                    _tmp.Clear();
                    int iIdade, fIdade;

                    System.out.print(">> Digite o primeiro intervalo de idade: ");
                    iIdade = read.nextInt();
                    System.out.print(">> Digite o último intervalo de idade: ");
                    fIdade = read.nextInt();

                    _tmp.SearchAluno(objAluno, null, "idade,null", new int[] {iIdade,fIdade} );
                    break;
                case 6:
                    _tmp.Clear();
                    System.out.println(
                    "****************************************************************************************\n" +
                    "* Oba! Este projeto se encontra no GitHub: https://github.com/fstack-me/JavaInter\n" +
                    "****************************************************************************************\n" +
                    "* Desenvolvimento, Testes e Participação: \n" +
                    "* >> Flavio Everton Brito da Silva - RGM: 18630367\n" +
                    "* >> Joel Adão António Manuel - RGM: 19247702\n" +
                    "* >> Wellington Jose de Souza - RGM: 18973574\n" +
                    "* >> Sylvio Luiz de Souza - RGM: 18754252\n" +
                    "* >> Dafne Rocha Lopes - RGM: 18871445\n");
                    break;
                default:
                    miniDash = false;
            }
        }
    }        
  }
}