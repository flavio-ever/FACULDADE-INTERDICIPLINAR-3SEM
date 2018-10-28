package pctAluno;

import java.util.*;
public class Aluno {
    /**
    *	Atributes
    **/
    private Boolean         error = true;
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
    * Constructors
    **/
    public Aluno(){ } // Null
    /**
     * 
     * @param rgmAluno
     * @param nomeAluno
     * @param idadeAluno
     * @param cursoAluno
     * @param semestreAluno
     * @param mediaAluno 
     */
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
     * 
     * @param obj2
     * @param rgm
     * @param tipoPesq
     * @return 
     */
    public Aluno SearchAluno(List<Aluno> obj2, 
                            String rgm, 
                            String tipoPesq){
        Aluno tmpAluno = obj2.get(0); // First Default
        String _tipoPesq[] = tipoPesq.split(",");
        this.error = true; // Força a dar erro
        for(Aluno obj : obj2){
            Aluno ln = (Aluno)obj;
            // Rgm
            if(rgm != null && rgm.equals(ln.rgmAluno)) { ln.error = false; tmpAluno = ln;  break; }
            /**
             * Verifico se há consistência em algum dos indices p/ liberar a próxima ação
             */
            if((_tipoPesq[1].toLowerCase().equals(ln.cursoAluno.toLowerCase()))){ ln.error = false; }
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
            if(((tipoPesq != null) && 
                 _tipoPesq[0].toLowerCase().equals("media") &&
                 _tipoPesq[1].toLowerCase().equals(ln.cursoAluno.toLowerCase())) && 
                 (ln.getMediaAluno() >= tmpAluno.getMediaAluno())){ //ok
                ln.error = false;
                tmpAluno = ln;
            }
            // Idade
            if((tipoPesq != null && _tipoPesq[0].equals("idade")) && 
               (ln.idadeAluno >= tmpAluno.idadeAluno)){
                ln.error = false;
                tmpAluno = ln;
            }
        }
        return tmpAluno;
    }
    /**
     * 
     * @param obj2
     * @param rgmOuCurso
     * @param idade 
     */
    public void SearchAluno(List<Aluno> obj2, 
                            String rgmOuCurso,
                            int idade){
        for (Aluno obj : obj2) {
            Aluno ln = (Aluno)obj;
            if( (rgmOuCurso != null && rgmOuCurso.equals(ln.rgmAluno)) || 
                (rgmOuCurso != null && rgmOuCurso.toLowerCase().equals(ln.cursoAluno.toLowerCase())) || 
                (idade == ln.idadeAluno)){
                ln.error = false;
                getDetailAluno(ln);
            }
        }
    }
    /**
     * 
     * @param aln 
     */
    public void getDetailAluno(Aluno aln){
        if(aln.error) {
            System.out.println("\n>> Ops! =( Algo de errado não está certo! Tente novamente!");
            return;
        }
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
    /**
     * 
     * @param novo 
     */
    public void editAluno(boolean novo) {
        if(this.error) {
            System.out.println("\n>> Ops! =( Algo de errado não está certo! Tente novamente!");
            return;
        }
        Scanner rd = new Scanner(System.in);
        List<Float> notasAluno = new ArrayList<Float>();
        if(novo){ 
            System.out.print("Digite o RGM do Aluno: ");
            this.rgmAluno = rd.next();
        }
        System.out.print(">> Digite o NOVO NOME do Aluno: ");
        this.nomeAluno = rd.next();
        System.out.print(">> Digite o NOVO CURSO do Aluno: ");
        this.cursoAluno = rd.next();
        System.out.print(">> Digite o NOVO SEMESTRE do Aluno: ");
        this.semestreAluno = rd.next();
        System.out.print(">> Digite a NOVA IDADE do Aluno: ");
        this.idadeAluno = rd.nextInt();
        System.out.println(">> Digite a NOVA MÉDIA do Aluno: ");
        System.out.print(">> NOVA NOTA 1: ");
        notasAluno.add(rd.nextFloat());
        System.out.print(">> NOVA NOTA 2: ");
        notasAluno.add(rd.nextFloat());
        System.out.print(">> NOVA NOTA 3: ");
        notasAluno.add(rd.nextFloat());
        this.mediaAluno = notasAluno;
    }
    public void Clear(){
        for(int clear = 0; clear < 1000; clear++){ System.out.println("\b");}
    }
}
