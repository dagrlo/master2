package wssw;

public class GuiaProxy implements wssw.Guia {
  private String _endpoint = null;
  private wssw.Guia guia = null;
  
  public GuiaProxy() {
    _initGuiaProxy();
  }
  
  public GuiaProxy(String endpoint) {
    _endpoint = endpoint;
    _initGuiaProxy();
  }
  
  private void _initGuiaProxy() {
    try {
      guia = (new wssw.GuiaServiceLocator()).getGuia();
      if (guia != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)guia)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)guia)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (guia != null)
      ((javax.xml.rpc.Stub)guia)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wssw.Guia getGuia() {
    if (guia == null)
      _initGuiaProxy();
    return guia;
  }
  
  public java.lang.String getCompetencias() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getCompetencias();
  }
  
  public java.lang.String getEvaluacion() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getEvaluacion();
  }
  
  public java.lang.String getTitulacion() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getTitulacion();
  }
  
  public java.lang.String getMaterias() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getMaterias();
  }
  
  public java.lang.String getCoordinacion() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getCoordinacion();
  }
  
  public java.lang.String getResumen() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getResumen();
  }
  
  public java.lang.String getDatosAsignatura() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getDatosAsignatura();
  }
  
  public java.lang.String getOtrosRequisitos() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getOtrosRequisitos();
  }
  
  public java.lang.String getRelacionConOtrasAsignaturas() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getRelacionConOtrasAsignaturas();
  }
  
  public java.lang.String getResultadosAprendizaje() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getResultadosAprendizaje();
  }
  
  public java.lang.String getDescripcionDeContenidos() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getDescripcionDeContenidos();
  }
  
  public java.lang.String getActividadesNoPresenciales() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getActividadesNoPresenciales();
  }
  
  public java.lang.String getReferenciasBasicas() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getReferenciasBasicas();
  }
  
  public java.lang.String getActividadesPresenciales() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getActividadesPresenciales();
  }
  
  public java.lang.String getMetodologiaDocente() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getMetodologiaDocente();
  }
  
  public java.lang.String getReferenciasComplementarias() throws java.rmi.RemoteException{
    if (guia == null)
      _initGuiaProxy();
    return guia.getReferenciasComplementarias();
  }
  
  
}