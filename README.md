# Projeto FiapRide

## Informacoes do Aluno

- **Nome:** Carolina Monteiro Bernardo
- **RM:** 564651
- **Turma:** 2CCPW
- **Curso:** Ciência da Computação
- **GitHub:** cabernardom

---

## Descricao do Projeto

Este projeto acompanha os desafios das aulas 1 a 9 de Programacao Orientada a Objetos. Nesta primeira etapa, foi criada a base do sistema **FiapRide**, com a classe `Passageiro` representando um usuario do aplicativo de mobilidade urbana.

---

## Checklist de Implementacao

- [x] Aula 1 - Classes e Objetos
- [ ] Aula 2 - Metodos
- [ ] Aula 3 - Encapsulamento
- [ ] Aula 4 - Construtores
- [ ] Aula 5 - Associacao
- [ ] Aula 6 - Heranca
- [ ] Aula 7 - Polimorfismo
- [ ] Aula 8 - Classes Abstratas
- [ ] Aula 9 - Interfaces

---

## Perguntas de Reflexao

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Nao seria mais facil apenas criar variaveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`? E se o FiapRide tiver 1 milhao de usuarios? Como a classe ajuda a resolver isso?

**Sua Resposta:**

Criar a classe `Passageiro` deixa o sistema organizado porque ela funciona como um molde para todos os usuarios do FiapRide. Se usassemos variaveis soltas no `main`, cada novo passageiro exigiria novas variaveis separadas, o que ficaria confuso e dificil de manter. Com uma classe, todos os passageiros seguem a mesma estrutura, mas cada objeto pode ter seus proprios valores de `nome` e `saldo`. Isso tambem facilita o crescimento do sistema, porque criar 1 milhao de usuarios significa criar 1 milhao de objetos do mesmo tipo, nao inventar 1 milhao de conjuntos de variaveis. Alem disso, a classe ajuda a aproximar o codigo do mundo real, tornando mais claro que o sistema trabalha com passageiros reais do aplicativo. Essa organizacao e a base para adicionar comportamentos, validacoes e regras de negocio nas proximas aulas.

---

## Desafios Tecnicos Implementados

### Aula 1

Foram criadas a classe `Passageiro`, com os atributos `nome` e `saldo`, e a classe `SistemaPrincipal`, que instancia dois objetos diferentes para demonstrar a diferenca entre classe e objeto.
