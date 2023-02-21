package it.contrader.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/*//READ ME //*/
//CLASSE PIVOT -> QUESTA CLASSE GENERA UN @Entity ovvero una tabella in un database
//Le colonne della tabella corrispondono agli attributi dichiarati sotto l'annotazione @Column
//Per indicare a hibernate che un attibuto corrisponde alla chiave primaria della tabella si utilizza @Id
//@GeneratedValue si utilizza per inserire automaticamente i valori della chiave primaria.

//@AllArgsConstructor @NoArgsConstructor,
// si utilizzano per  autogenerare il costruttire della classe con zero argomenti e
// uno con tutti gli argomenti, ovvero con TUTTI gli attributi della classe.

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pivot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)// "unique" indica che ogni valore è unico nella tabella
    private Integer idPivot;                // "nullable" indica che il valore inserito non può essere nullo
    @Column(nullable = false)
    private Integer quantita;
    private String unita_di_misura;

    /*Gestione Chiavi Esterne*/
    //Utiliziamo una relazione Many to one con la tabella Ricetta e alla tabella Ingrediente,
    // il sistema di persistenza riconosce con quale tabella fare il collegamento
    // posizionando quest'ultima al di sotto della annotation @ManyToOne come se fosse un parametro
    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ricetta ricetta;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Ingrediente ingrediente;
}
