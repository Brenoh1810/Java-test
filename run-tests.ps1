$ErrorActionPreference = 'Stop'

Write-Host 'Executando testes JUnit...'
mvn test

Write-Host 'Executando testes TestNG...'
mvn -Ptestng test