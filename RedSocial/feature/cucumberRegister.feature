Feature: Registro del Usuario

Scenario: Registrar un usuario
Given Un usuario se registra en el sistema
When Cumple los requisitos
Then Usuario registrado

Scenario: El correo ya existe
Given Un usuario ya esta registrado en el sistema
When No Cumple los Requisitos
Then Muestra Mensaje de Error

Scenario: Requisitos de Contraseña
Given Un usuario se registra en el sistema
When No Cumple los Requisitos de la contraseña
Then Muestra Mensaje de Error de la contraseña
