``` plantuml 

@startuml
skinparam backgroundColor ##090b14

skinparam class {
    BackgroundColor #dbcd32
    BorderColor #333333
    FontColor #222222
    FontName Arial
    FontSize 14
    AttributeFontColor #333333
    AttributeFontName Arial
    AttributeFontSize 13
    MethodFontColor #333333
    MethodFontName Arial
    MethodFontSize 13
}

skinparam note {
    BackgroundColor #c42404
    BorderColor #D6B656
    FontColor #090b14
    FontName Arial
    FontSize 12
}

class "<b>Pessoa</b>" as Pessoa {
-- <b> Atributos </b> --
-altura,peso : double
-data : LocalDate
-pai,mae : Pessoa
-nome,sobrenome,genero : String
-ATIVIDADES : String[]
- rand: Random()

-- <b> Métodos </b> --
..<b> Getters </b>..
+get_nome() : String
+get_sobrenome() : String
+get_genero() : String

+get_data_nascimento() : LocalDate

+get_peso() : double
+get_altura() : double

+get_pai() : Pessoa
+get_mae() : Pessoa
.. <b> Setters </b>..
+set_nome(String nome): boolean
+set_sobrenome(String sobrenome): boolean
+set_genero(String genero) : boolean

+set_data_nascimento(LocalDate data) : boolean

+set_peso(double peso) : boolean
+set_altura(double altura) : boolean

+set_pai(Pessoa pai) : boolean
+set_mae(Pessoa mae) : boolean
..<b>Outros</b>..
-idade() : void
+toString() : String
-adicionar_criado()
- static feitos() : int

..<b>Construtores</b>..
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

class "<b>Visibilidade</b>" as Visibility {
    + Público
    - Privado
}

Pessoa -[hidden]down- Visibility

@enduml
```
