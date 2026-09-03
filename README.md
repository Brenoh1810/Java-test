# Testes JUnit 5 e TestNG

Projeto comparativo com a regra de cálculo de frete, usando Java 25, JUnit 5 e TestNG.

## Pré-requisitos

- JDK 25 instalado e disponível no `PATH`.
- Apache Maven instalado e disponível no `PATH`.

Confirme a instalação com:

```text
java -version
mvn -version
```

## PowerShell

Para executar JUnit e depois TestNG:

```powershell
.\run-tests.ps1
```

Para executar somente JUnit:

```powershell
mvn clean test
```

Para executar somente TestNG:

```powershell
mvn -Ptestng clean test
```

## CMD

Para executar somente JUnit:

```cmd
mvn clean test
```

Para executar somente TestNG:

```cmd
mvn -Ptestng clean test
```

No CMD, para executar os dois em sequência:

```cmd
mvn clean test && mvn -Ptestng clean test
```

O segundo comando só é executado se os testes JUnit forem aprovados.

## Estrutura

- `src/main/java/Frete.java`: classe de produção.
- `src/test/java/FreteJUnitTest.java`: testes JUnit 5.
- `src/test/java/FreteTestNGTest.java`: testes TestNG.
- `pom.xml`: dependências e perfis Maven.
- `run-tests.ps1`: execução sequencial no PowerShell.