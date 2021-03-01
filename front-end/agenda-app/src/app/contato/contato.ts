export class Contato {
    
    declare id: number ;
    declare nome: string ;
    declare email: string ;
    declare favorito: boolean ;

    constructor(nome: string, email: string){
        this.nome = nome;
        this.email = email;
    };
}