package it.contrader.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//READ ME //
//CLASSE Ricetta -> QUESTA CLASSE GENERA UN @Entity ovvero una tabella in un database
//Le colonne della tabella corrispondono agli attributi dichiarati sotto l'annotazione @Column
//Per indicare a hibernate che un attributo corrisponde alla chiave primaria della tabella si utilizza @Id
//@GeneratedValue si utilizza per inserire automaticamente i valori della chiave primaria.
//@Data è utilizzato per generare automaticamente i getter e setter per tutti gli attributi della classe

//@AllArgsConstructor @NoArgsConstructor,
// si utilizzano per  autogenerare il costruttire della classe con zero argomenti e
// uno con tutti gli argomenti, ovvero con TUTTI gli attributi della classe.

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    private Integer t_preparazione;
    private Integer t_cottura;
    private Integer dose;
    private String preparazione;
    private Boolean pubblico;



    //Gestione Chiavi Esterne
    //Utiliziamo una relazione Many to one con la tabella Ricetta e alla tabella Ingrediente,
    // il sistema di persistenza riconosce con quale tabella fare il collegamento
    // posizionando quest'ultima al di sotto della annotation @ManyToOne come se fosse un parametro
    @ManyToOne(cascade = CascadeType.MERGE)// Stiamo dichiarando che ogni elemento di questa tabella(@Entity) è
    private User user;// assocato ad un elmento di una tabella, User avente in comune una chiave esterna .
    @OneToOne
    private File file;



    // Costruttori aggiuntivi che sono stati implementati durante la creazione del programma ,
        //ATTENZIONE--- > non fare MAI un costruttore con tutti i parametri o con nessun parametro,
        //                perche quelli esistono gia. Il debugger di darebbe errore.
    public Ricetta(Integer id, String nome, Integer tPreparazione, Integer tCottura, Integer dose, String preparazione, Boolean pubblico) {
        this.id             = id;
        this.nome           = nome;
        this.t_preparazione = tPreparazione;
        this.t_cottura      = tCottura;
        this.dose           = dose;
        this.preparazione   = preparazione;
        this.pubblico       = pubblico;
    }
    public Ricetta( String nome, Integer tPreparazione, Integer tCottura, Integer dose, String preparazione, Boolean pubblico, User user) {
        this.nome           = nome;
        this.t_preparazione = tPreparazione;
        this.t_cottura      = tCottura;
        this.dose           = dose;
        this.preparazione   = preparazione;
        this.pubblico       = pubblico;
        this.user           = user;
    }

   
}
