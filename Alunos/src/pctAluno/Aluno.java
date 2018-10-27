package pctAluno;

import java.util.*;
public class Aluno {
    /**
    *	Atributes
    **/
    private String          rgmAluno,
                            nomeAluno,
                            cursoAluno,
                            semestreAluno;
    private int             idadeAluno;
    private List<Float>     mediaAluno; 
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
    public String getSemestreAluno(){
        return this.semestreAluno;
    }
    public int getIdadeAluno(){
        return this.idadeAluno;
    }
    public List<Float> getMediaAluno(){
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
    public void setSemestreAluno(String semestreAluno){
        this.semestreAluno = semestreAluno;
    }
    public void setIdadeAluno(int idadeAluno){
        this.idadeAluno = idadeAluno;
    }
    public void setMediaAluno(List<Float> mediaAluno){
        this.mediaAluno = mediaAluno;
    }
    /** 
    * Constructor 
    **/
    public Aluno(){ } // Null
    public Aluno(String rgmAluno, 
                String nomeAluno, 
                int idadeAluno, 
                String cursoAluno, 
                String semestreAluno, 
                List<Float> mediaAluno){
        this.rgmAluno 	= rgmAluno;
        this.nomeAluno 	= nomeAluno;
        this.idadeAluno     = idadeAluno;
        this.cursoAluno     = cursoAluno;
        this.semestreAluno  = semestreAluno;
        this.mediaAluno     = mediaAluno;
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
                if(((String)ln.rgmAluno == rgm) || 
                   ((String)ln.cursoAluno == curso))	
                                return ln;
        }
        return this;
    }
    public void SearchAluno(List<Aluno> obj2, 
                            String rgm,
                            String curso,
                            int idade){
        for (Aluno obj : obj2) {
            Aluno ln = (Aluno)obj;
            if(((curso == "")   || (curso == ln.cursoAluno))|| 
               ((rgm == "")     || (rgm == ln.rgmAluno))|| 
               (idade == ln.idadeAluno))
                    getDetailAluno(ln);
        }
    }
    public void getDetailAluno(Aluno aln){
        System.out.format(  "\nRgm do Aluno:. %s" + 
                            "\nNome do Aluno:. %s" + 
                            "\nIdade do Aluno:. %s" + 
                            "\nCurso do Aluno:. %s" + 
                            "\nSemestre do Aluno:. %s" + 
                            "\nMédia do Aluno:. %s\n\n",	
                            aln.rgmAluno, 
                            aln.nomeAluno, 
                            aln.idadeAluno,
                            aln.cursoAluno,
                            aln.semestreAluno,
                            aln.getFaixaEtariaAluno());
        System.out.println("\n");
    }
    public void editAluno(boolean novo) {
        Scanner rd = new Scanner(System.in);
        List<Float> notasAluno = new ArrayList<Float>();
        if(novo){ 
            System.out.print("Digite o RGM do Aluno: ");
            this.rgmAluno = rd.next();
        }
        System.out.print("Digite o NOME do Aluno: ");
        this.nomeAluno = rd.next();
        System.out.print("Digite o CURSO do Aluno: ");
        this.cursoAluno = rd.next();
        System.out.print("Digite o SEMESTRE do Aluno: ");
        this.semestreAluno = rd.next();
        System.out.print("Digite a IDADE do Aluno: ");
        this.idadeAluno = rd.nextInt();
        System.out.println("Digite a MÉDIA do Aluno: ");
        System.out.print("Nota 1: ");
        notasAluno.add(rd.nextFloat());
        System.out.print("Nota 2: ");
        notasAluno.add(rd.nextFloat());
        System.out.print("Nota 3: ");
        notasAluno.add(rd.nextFloat());
        this.mediaAluno = notasAluno;
    }
    public float getFaixaEtariaAluno(){
        double med = this.mediaAluno.stream()
        .mapToDouble(m -> m)
        .sum();
       return (float) med / this.mediaAluno.size();
    }
    public void Clear(){
        for(int clear = 0; clear < 1000; clear++){ System.out.println("\b");}
    }
}
