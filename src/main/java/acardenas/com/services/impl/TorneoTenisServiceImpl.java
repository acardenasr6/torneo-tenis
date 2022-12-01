package acardenas.com.services.impl;

import acardenas.com.exception.ValidationException;
import acardenas.com.models.JugadorTenisFemenino;
import acardenas.com.models.JugadorTenisMasculino;
import acardenas.com.services.TorneoTenis;
import acardenas.com.services.TorneoTenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoTenisServiceImpl implements TorneoTenisService {

    private final TorneoTenis<JugadorTenisFemenino> torneoTenisFemenino;
    private final TorneoTenis<JugadorTenisMasculino> torneoTenisMasculino;

    @Autowired
    public TorneoTenisServiceImpl(TorneoTenis<JugadorTenisFemenino> torneoTenisFemenino,
                                  TorneoTenis<JugadorTenisMasculino> torneoTenisMasculino) {
        this.torneoTenisFemenino = torneoTenisFemenino;
        this.torneoTenisMasculino = torneoTenisMasculino;
    }

    @Override
    public JugadorTenisFemenino iniciarTorneoFemenino(List<JugadorTenisFemenino> jugadorTenisFemeninos) throws ValidationException {
        return torneoTenisFemenino.iniciarTorneo(jugadorTenisFemeninos);
    }

    @Override
    public JugadorTenisMasculino iniciarTorneoMasculino(List<JugadorTenisMasculino> iniciarTorneoFemenino) throws ValidationException {
        return torneoTenisMasculino.iniciarTorneo(iniciarTorneoFemenino);
    }
}
