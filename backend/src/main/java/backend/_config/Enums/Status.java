package backend._config.Enums;


import lombok.Getter;

@Getter
public enum Status {
    // aqui são os enums
    ATIVO(0,"ATIVO"),
    INATIVO(1,"INATIVO");

    //aqui as instancias
    private final Integer codigo;
    private final String descricao;

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    //aqui construtor
    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //aqui um codigo para verificar se existe ou não de enum
    //se existir retorna ele se não retorna uma exceção (não necessario)
    public static Status toEnum(Integer cod){
        if( cod == null){
            return null;
        }
        for(Status x : Status.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + cod);
    }

}
