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

**Instalação das dependências em Windows (PC do zero)**

1. **Git** (necessário para clonar):
   - Baixe em https://git-scm.com/download/win e siga o instalador padrão.
   - Verifique com `git --version`.

2. **Java Development Kit (JDK 25)**
   - Baixe o instalador MSI em https://jdk.java.net/25/ (ou use AdoptOpenJDK).
   - Execute o instalador e selecione a opção *Set JAVA_HOME*.
   - Caso não seja adicionado ao `PATH`, execute:
     ```powershell
     setx JAVA_HOME "C:\Program Files\Java\jdk-25"
     setx PATH "%PATH%;%JAVA_HOME%\bin"
     ```
   - Verifique: `java -version` → deve mostrar `java version "25"`.

3. **Apache Maven**
   - Baixe a versão binária zip em https://maven.apache.org/download.cgi.
   - Extraia para `C:\Program Files\Apache\Maven`.
   - Adicione ao `PATH`:
     ```powershell
     setx MAVEN_HOME "C:\Program Files\Apache\Maven"
     setx PATH "%PATH%;%MAVEN_HOME%\bin"
     ```
   - Verifique: `mvn -version`.

Depois de instalar, confirme as versões como indicado acima antes de executar os testes.

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

**Saída detalhada dos testes**

O plugin *maven‑surefire* já está configurado para imprimir:
- resumo dos testes (`printSummary=true`);
- stack‑trace completo (`trimStackTrace=false`);
- saída padrão dos testes no console (`redirectTestOutputToFile=false`).

Essas opções são aplicáveis a ambos os perfis (JUnit 5 e TestNG).

## Estrutura

- `src/main/java/Frete.java`: classe de produção.
- `src/test/java/FreteJUnitTest.java`: testes JUnit 5.
- `src/test/java/FreteTestNGTest.java`: testes TestNG.
- `pom.xml`: dependências e perfis Maven.
- `run-tests.ps1`: execução sequencial no PowerShell.