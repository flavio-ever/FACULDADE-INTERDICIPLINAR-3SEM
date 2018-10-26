
package pctAluno;

import java.util.*;

public class Aluno {
    /**
    *	Atributes
    **/
    private String 	rgmAluno, 
                                                                    nomeAluno, 
                                                                    cursoAluno; 

    private int 		idadeAluno;
    private List<Integer> 	mediaAluno; 
    /**
    * Methods Getters & Setters
    **/
    public String getRgmAluno(){
        return this.rgmAluno;
    }
    public String getNomeAluno(){
        return this.nomeAluno;
    }
    public String getCursoAluno(){
        return this.cursoAluno;
    }
    public int getIdadeAluno(){
        return this.idadeAluno;
    }
    public List<Integer> getMediaAluno(){
        return this.mediaAluno;
    }
    public void setRgmAluno(String rgmAluno){
        this.rgmAluno = rgmAluno;
    }
    public void setNomeAluno(String nomeAluno){
        this.nomeAluno = nomeAluno;
    }
    public void setCursoAluno(String cursoAluno){
        this.cursoAluno = cursoAluno;
    }
    public void setIdadeAluno(int idadeAluno){
        this.idadeAluno = idadeAluno;
    }
    public void setMediaAluno(List<Integer> mediaAluno){
        this.mediaAluno = mediaAluno;
    }
    /** 
    * Constructor
    **/
    public Aluno(){

    }
    public Aluno(String rgmAluno, 
                String nomeAluno, 
                int idadeAluno, 
                String cursoAluno, 
                List<Integer> mediaAluno){
            this.rgmAluno 	= rgmAluno;
            this.nomeAluno 	= nomeAluno;
            this.idadeAluno = idadeAluno;
            this.cursoAluno = cursoAluno;
            this.mediaAluno = mediaAluno;
    }
    /**
    *	Procedures / Methods
    *   @param obj2 
    *   @param rgm
    *   @param curso
    **/
    public Aluno SearchAluno(List<Aluno> obj2, 
                            String rgm, 
                            String curso){
        for (Aluno obj : obj2) {
                Aluno ln = (Aluno)obj;
                if(	((String)ln.rgmAluno == rgm) || 
                                ((String)ln.cursoAluno == curso))	
                                return ln;
        }
        return this;
    }
    public void SearchAluno(List<Aluno> obj2, 
                            String curso,
                            int idade){
        for (Aluno obj : obj2) {
            Aluno ln = (Aluno)obj;
            if(((curso == "")   || (curso == ln.cursoAluno))|| 
               ((idade == 0)    || (idade == ln.idadeAluno)))
                    getDetailAluno(ln);
        }
    }
    public void getDetailAluno(Aluno aln){
        System.out.format(  "\nRgm do Aluno:. %s" + 
                            "\nNome do Aluno:. %s" + 
                            "\nIdade do Aluno:. %s" + 
                            "\nCurso do Aluno:. %s" + 
                            "\nMédia do Aluno:. %s\n\n",	
                            aln.rgmAluno, 
                            aln.nomeAluno, 
                            aln.idadeAluno,
                            aln.cursoAluno,
                            aln.mediaAluno);
        System.out.println("//----------------------------------------------------//");
    }
    public void editAluno() {
        Scanner rd = new Scanner(System.in);
        List<Integer> notasAluno = new ArrayList<Integer>();
        System.out.print("Digite o NOME do Aluno: ");
        this.nomeAluno = rd.next();
        System.out.print("Digite o CURSO do Aluno: ");
        this.cursoAluno = rd.next();
        System.out.print("Digite a IDADE do Aluno: ");
        this.idadeAluno = rd.nextInt();
        System.out.println("Digite a MÉDIA do Aluno: ");
        System.out.print("Nota 1: ");
        notasAluno.add(rd.nextInt());
        System.out.print("Nota 2: ");
        notasAluno.add(rd.nextInt());
        System.out.print("Nota 3: ");
        notasAluno.add(rd.nextInt());
        this.mediaAluno = notasAluno;
    }
    public void getFaixaEtariaAluno(){

    }
}
