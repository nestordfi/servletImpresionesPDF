package ec.com.bancoInternacional.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.cs0052.DATAGENCIA;
import ec.com.bancoInternacional.cs0052.PRGETNOMAGE;
import ec.com.bancoInternacional.services.domain.ErrorValidacion;
import ec.com.bancoInternacional.services.domain.InfoAgencia;
import ec.com.bancoInternacional.services.domain.InfoAgencias;
import ec.com.bancoInternacional.services.ibm.pool.PooledTrx;


public class AgenciaService extends PooledTrx {

    private static final Logger logger = Logger.getLogger(AgenciaService.class);

    public InfoAgencias cargarAgencias() {

        InfoAgencias valInfo = new InfoAgencias();

        PRGETNOMAGE datosAgencias = new PRGETNOMAGE();

        try {
            invokeTrx(datosAgencias);

            valInfo.setStatus(datosAgencias.getReturnValue());

            if (valInfo.getStatus() == 0) {
                // carga data
                List<InfoAgencia> lstData = new ArrayList<InfoAgencia>();
                mapeoDATAGEToInfoAgencia(datosAgencias, lstData);
                valInfo.setInfoAgencia(lstData);

                // carga de errores
                ErrorValidacion error = new ErrorValidacion();
                error.setCode(datosAgencias.getDATERROUT().getMSGOCODERRO());
                error.setDetails(datosAgencias.getDATERROUT().getMSGODESERRO());
                error.setType(datosAgencias.getDATERROUT().getMSGOCODSEPA());

                valInfo.setError(error);
            }
        } catch (InterruptedException e) {
            logger.error(e);
        } catch (ExecutionException e) {
            logger.error(e);
        }

        return valInfo;
    }

    /*
     * mapeo de agencias
     */
    private void mapeoDATAGEToInfoAgencia(PRGETNOMAGE getDatosAgencias, List<InfoAgencia> lstData) {
        InfoAgencia aux = null;
        for (DATAGENCIA item : getDatosAgencias.getDATAGEOUT()) {
            if (item == null)
                break;

            aux = new InfoAgencia();

            aux.setCodigoAgencia(item.getDATCAGEOUT());
            aux.setCodigoProvincia(item.getDATCPROOUT());
            aux.setNombreAgencia(item.getDATNAGEOUT());
            aux.setJefeAgencia(item.getDATJAGEOUT());

            lstData.add(aux);
        }
    }

}
