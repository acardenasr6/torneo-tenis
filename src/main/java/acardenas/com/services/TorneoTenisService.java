package acardenas.com.services;

import acardenas.com.exception.ValidationException;
import acardenas.com.models.JugadorTenisFemenino;
import acardenas.com.models.JugadorTenisMasculino;

import java.util.List;

public interface TorneoTenisService{
   JugadorTenisFemenino iniciarTorneoFemenino(List<JugadorTenisFemenino> jugadorTenisFemeninos) throws ValidationException;
   JugadorTenisMasculino iniciarTorneoMasculino(List<JugadorTenisMasculino> iniciarTorneoFemenino) throws ValidationException;
}
