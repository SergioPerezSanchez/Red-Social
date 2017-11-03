Feature: Acceso al Sistema

Scenario: Usuario Registrado
Given El usuario accede al sistema
When Coincide email y password
Then Accedera al sistema

Scenario: Usuario no Registrado
Given El usuario va a acceder al sistema
When No esta registrado
Then Mostrara mensaje de error

Scenario: Password incorrecto
Given El usuario quiere acceder al sistema
When No coincide la password del usuario
Then Mostrara mensaje de error
