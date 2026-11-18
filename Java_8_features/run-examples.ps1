$ErrorActionPreference = "Stop"
$source = "src/main/java/com/example/java8"
New-Item -ItemType Directory -Force -Path "out" | Out-Null
Get-ChildItem "$source/*.java" | ForEach-Object { javac -d out $_.FullName }
Write-Host "Compiled all examples. Open a class in IntelliJ and run its main method."
