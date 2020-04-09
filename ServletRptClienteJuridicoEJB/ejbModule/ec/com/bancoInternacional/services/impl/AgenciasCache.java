package ec.com.bancoInternacional.services.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import ec.com.bancoInternacional.services.domain.InfoAgencia;
import ec.com.bancoInternacional.services.domain.InfoAgencias;

@Singleton
@Startup
public class AgenciasCache {
    
    private InfoAgencias infoAgencias;
    
    @PostConstruct
    public void loadAgencias() {
        System.out.println("empieza a cargar las agencias");
        AgenciaService agenciaService = new AgenciaService();
        infoAgencias = agenciaService.cargarAgencias();
    }
    
    public InfoAgencia findAgencia(int codigoAgencia) {
        System.out.println("manda a buscar la agencia: " + codigoAgencia);
        if (!infoAgencias.getInfoAgencia().isEmpty()) {
            System.out.println("existen agencias: " + infoAgencias.getInfoAgencia().size());
            List<InfoAgencia> agencias = infoAgencias.getInfoAgencia();
            for (InfoAgencia infoAgencia : agencias) {
                if (infoAgencia.getCodigoAgencia().intValue() == codigoAgencia) {
                    System.out.println("encontrada!!!!" + infoAgencia);
                    return infoAgencia;
                }
            }
        }
        return null;
    }

}
