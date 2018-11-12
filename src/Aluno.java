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
    public void setError(boolean error){
        this.error = error;
    }
    /** 
    * Constructors
    **/
    public Aluno(){
       this("", "", 0, "", "", new ArrayList<Float>()); 
    } // Null
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
     * @param faixaIdade
     * @return 
     */
    public Aluno SearchAluno(List<Aluno> obj2, 
                            String rgm, 
                            String tipoPesq, 
                            int[] faixaIdade){
        Aluno tmpAluno = obj2.get(0); // First Default
        String _tipoPesq[]      = tipoPesq.split(",");

        this.error = true; // Força a dar erro
        for(Aluno obj : obj2){
            Aluno ln = (Aluno)obj;
            // Rgm
            if(rgm != null && rgm.equals(ln.getRgmAluno())) { this.error = false; tmpAluno = ln;  break; }
            /**
             * Verifico se há consistência em algum dos indices p/ liberar a próxima ação
             */
            if((_tipoPesq[1].toLowerCase().equals(ln.getCursoAluno().toLowerCase()))){ this.error = false; }
             /**
             * Se houver um curso que não seja null, entrão filtrar...
             * Se durante o filtro o curso sugerido for igual ao da lista então re-alocar a variavel tmpAluno
             * Porém, se a variável tpmAluno o curso for igual ao curso sugerido então não re-alocar.
             */
            if((_tipoPesq[1].toLowerCase().equals(ln.getCursoAluno().toLowerCase())) && 
               !(_tipoPesq[1].toLowerCase().equals(tmpAluno.getCursoAluno().toLowerCase()))){
                tmpAluno = ln;
            }
            // Média
            if(((tipoPesq != null) && 
                 _tipoPesq[0].toLowerCase().equals("media") &&
                 _tipoPesq[1].toLowerCase().equals(ln.getCursoAluno().toLowerCase())) && 
                 (ln.getMediaAluno() >= tmpAluno.getMediaAluno())){ //ok
                this.error = false;
                tmpAluno = ln;
            }
            // Faixa etaria
            if((tipoPesq != null && _tipoPesq[0].equals("idade")) && 
               (ln.getIdadeAluno() >= faixaIdade[0] && ln.getIdadeAluno() <= faixaIdade[1] )){
               this.error = false;
               getDetailAluno(ln);
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
        if(this.error) {
            System.out.println("\n>> Ops! =( Algo de errado não está certo! Tente novamente!");
            return;
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.format(  " >> Rgm do Aluno:. %s" + 
                            "\n >> Nome do Aluno:. %s" + 
                            "\n >> Idade do Aluno:. %s" + 
                            "\n >> Curso do Aluno:. %s" + 
                            "\n >> Semestre do Aluno:. %s" + 
                            "\n >> Média do Aluno:. %s\n",	
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
    public Aluno editAluno(boolean novo, Aluno aln) {
        Aluno _tmp = new Aluno();
        
        Scanner rd = new Scanner(System.in);
        List<Float> notasAluno = new ArrayList<Float>();
        
        if(this.error) {
            System.out.println("\n>> Ops! Algo de errado não está certo... Tente novamente!");
            return this;
        } 
        if(novo){
            System.out.print(">> Digite o RGM do Aluno: ");
            _tmp.rgmAluno = rd.nextLine();
        } else { 
            _tmp = aln;
        }
        
        System.out.print(">> Digite o NOVO NOME do Aluno: ");
        _tmp.setNomeAluno(rd.nextLine());
        //System.out.print("");
        
        System.out.print(">> Digite o NOVO CURSO do Aluno: ");
        _tmp.setCursoAluno(rd.nextLine());
        //System.out.print("");
        
        System.out.print(">> Digite o NOVO SEMESTRE do Aluno: ");
        _tmp.setSemestreAluno(rd.nextLine());
        //System.out.print("");
        
        System.out.print(">> Digite a NOVA IDADE do Aluno: ");
        _tmp.setIdadeAluno(rd.nextInt());
        System.out.println(">> Digite a NOVA MÉDIA do Aluno: ");
        System.out.print(">> NOVA NOTA 1: ");
        notasAluno.add(rd.nextFloat());
        System.out.print(">> NOVA NOTA 2: ");
        notasAluno.add(rd.nextFloat());
        System.out.print(">> NOVA NOTA 3: ");
        notasAluno.add(rd.nextFloat());
        _tmp.setMediaAluno(notasAluno);
        _tmp.error = true;
        
        return _tmp;
    }
    public void Clear(){
        for(int clear = 0; clear < 15; clear++){ System.out.println("\b");}
    }
}