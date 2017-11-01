Feature: Eliminar Publicacion

Scenario: Usuario elimina publicacion
Given Un usuario logueado en el sistema
When Quiere eliminar una publicacion
Then Se elimina la publicacion
