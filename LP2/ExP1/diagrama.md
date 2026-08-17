``` plantuml 

@startuml

+class Pessoa{
-altura,peso : double
-data : LocalDate
-pai,mae : Pessoa
-ATIVIDADES : String[]
-nome,sobrenome,genero : String
+get_nome() : String
+set_nome(String nome): boolean

+get_sobrenome() : String
+set_sobrenome(String sobrenome): boolean

+get_genero() : String
+set_genero(String genero) : boolean

+get_data_nascimento() : LocalDate
+set_data_nascimento(LocalDate data) : boolean

+get_peso() : double
+set_peso(double peso) : boolean

+get_altura() : double
+set_altura(double altura) : boolean

+get_pai() : Pessoa
+set_pai(Pessoa pai) : boolean

+get_mae() : Pessoa
+set_mae(Pessoa mae) : boolean
-idade() : void
+toString() : String
-adicionar_criado()
- static feitos() : int
+ Pessoa() 
+ Pessoa(String Nome)
+Pessoa(String: nome,sobrenome,genero, LocalDate : data, double: peso,altura, Pessoa: pai,mae)
}

@enduml

@enduml
```
