query:
    getAllByIdClasse Calendario-Note-Compiti-Comunicazioni,
    getAllByIdClasse/{data} Calendario-Note-Compiti-Comunicazioni,
    getAllBy{idDocente}/ Calendario-Note-Compiti-Comunicazioni,
    getAllBy{idStudente}/ Calendario-Note-Compiti-Comunicazioni,
    getAllBy{idIstituto}/ Calendario-Note-Compiti-Comunicazioni,

    ClasseRepository
    findBynameContains
    findbyIdIstituto

    CaledarioRepository
    findById
    findByDataEventoContains
    findByNomeEventoContains
    findAllByIdClass

    CompitoRepository
    findById
    findByDataConsegnaContains
    findAllByIdClass

    ComunicazioneRepository
    findById
    findByDataComunicazioneContains
    findByNomeComunicazioneContains
    findAllByIdClass

    NotaRepository
    findById
    findByDataNotaContains
    findByCfStudente
    findAllByIdClass

    
    
    
