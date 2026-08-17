``` plantuml 

@startuml

+class Pessoa{
--Atributos--
-altura,peso : double
-data : LocalDate
-pai,mae : Pessoa
-nome,sobrenome,genero : String
-ATIVIDADES : String[]
- rand: Random()

--Métodos--
..Getters..
+get_nome() : String
+get_sobrenome() : String
+get_genero() : String

+get_data_nascimento() : LocalDate

+get_peso() : double
+get_altura() : double

+get_pai() : Pessoa
+get_mae() : Pessoa
..Setters..
+set_nome(String nome): boolean
+set_sobrenome(String sobrenome): boolean
+set_genero(String genero) : boolean

+set_data_nascimento(LocalDate data) : boolean

+set_peso(double peso) : boolean
+set_altura(double altura) : boolean

+set_pai(Pessoa pai) : boolean
+set_mae(Pessoa mae) : boolean
..Outros..
-idade() : void
+toString() : String
-adicionar_criado()
- static feitos() : int

..Construtores..
 +Pessoa(String: nome,sobrenome,genero, LocalDate : data, double: peso,altura, Pessoa: pai,mae)
+ Pessoa(String Nome)
+ Pessoa()
}
note right of Pessoa::pai,mae
 Ambos são objetos Pessoa
end note
note right of Pessoa::set_nome
Retornam true se operação foi bem sucedida
end note 

@enduml
```
