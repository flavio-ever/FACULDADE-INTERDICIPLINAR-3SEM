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
    public float getMediaAluno(){
       double med = this.mediaAluno.stream()
       .mapToDouble(m -> m)
       .sum();
       return (float) med / this.mediaAluno.size();
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
        this.rgmAluno       = rgmAluno;
        this.nomeAluno      = nomeAluno;
        this.idadeAluno     = idadeAluno;
        this.cursoAluno     = cursoAluno;
        this.semestreAluno  = semestreAluno;
        this.mediaAluno     = mediaAluno;
    }
    /**
    *	Procedures / Methods
    *   @param  
    *   @param 
    *   @param 
    **/
    public Aluno SearchAluno(List<Aluno> obj2, 
                            String rgm, 
                            String tipoPesq){
        Aluno tmpAluno = obj2.get(0); // First Default
        String _tipoPesq[] = tipoPesq.split(",");
        for (Aluno obj : obj2) {
            Aluno ln = (Aluno)obj;
            // Rgm
            if(rgm != null && rgm.equals(ln.rgmAluno)) { tmpAluno = ln; break; }
            /**
             * Se houver um curso que não seja null, entrão filtrar...
             * Se durante o filtro o curso sugerido for igual ao da lista então re-alocar a variavel tmpAluno
             * Porém, se a variável tpmAluno o curso for igual ao curso sugerido então não re-alocar.
             */
            if((_tipoPesq[1].toLowerCase().equals(ln.cursoAluno.toLowerCase())) && 
               !(_tipoPesq[1].toLowerCase().equals(tmpAluno.cursoAluno.toLowerCase()))){
                tmpAluno = ln;
            }
            // Média
            tmpAluno =  (((tipoPesq != null) && 
                        _tipoPesq[0].toLowerCase().equals("media") && 
                        _tipoPesq[1].toLowerCase().equals(ln.cursoAluno.toLowerCase())) && 
                        (ln.getMediaAluno() > tmpAluno.getMediaAluno())) ? ln : tmpAluno;
            // Idade
            tmpAluno =  ((tipoPesq != null && _tipoPesq[0].equals("idade")) && 
                        (ln.idadeAluno > tmpAluno.idadeAluno)) ? ln : tmpAluno;
        }
        return tmpAluno;
    }
    public void SearchAluno(List<Aluno> obj2, 
                            String rgmOuCurso,
                            int idade){
        for (Aluno obj : obj2) {
            Aluno ln = (Aluno)obj;
            if( (rgmOuCurso != null && rgmOuCurso.equals(ln.rgmAluno)) || 
                (rgmOuCurso != null && rgmOuCurso.toLowerCase().equals(ln.cursoAluno.toLowerCase())) || 
                (idade == ln.idadeAluno)){
                getDetailAluno(ln);
            }
        }
    }
    public void getDetailAluno(Aluno aln){
        System.out.println("--------------------------------------------------------------------");
        System.out.format(  " - Rgm do Aluno:. %s" + 
                            "\n - Nome do Aluno:. %s" + 
                            "\n - Idade do Aluno:. %s" + 
                            "\n - Curso do Aluno:. %s" + 
                            "\n - Semestre do Aluno:. %s" + 
                            "\n - Média do Aluno:. %s\n",	
                            aln.rgmAluno, 
                            aln.nomeAluno, 
                            aln.idadeAluno,
                            aln.cursoAluno,
                            aln.semestreAluno,
                            aln.getMediaAluno());
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
    public void Clear(){
        for(int clear = 0; clear < 1000; clear++){ System.out.println("\b");}
    }
}
