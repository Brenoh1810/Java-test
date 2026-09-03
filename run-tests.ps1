$ErrorActionPreference = 'Stop'

Write-Host 'Executando testes JUnit...'
mvn clean test

Write-Host 'Executando testes TestNG...'
mvn -Ptestng clean test