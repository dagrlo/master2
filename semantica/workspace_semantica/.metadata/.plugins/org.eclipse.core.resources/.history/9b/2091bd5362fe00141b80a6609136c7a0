/**
 * GuiaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wssw;

public class GuiaServiceLocator extends org.apache.axis.client.Service implements wssw.GuiaService {

    public GuiaServiceLocator() {
    }


    public GuiaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GuiaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Guia
    private java.lang.String Guia_address = "http://localhost:8080/guia_1/services/Guia";

    public java.lang.String getGuiaAddress() {
        return Guia_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GuiaWSDDServiceName = "Guia";

    public java.lang.String getGuiaWSDDServiceName() {
        return GuiaWSDDServiceName;
    }

    public void setGuiaWSDDServiceName(java.lang.String name) {
        GuiaWSDDServiceName = name;
    }

    public wssw.Guia getGuia() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Guia_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGuia(endpoint);
    }

    public wssw.Guia getGuia(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wssw.GuiaSoapBindingStub _stub = new wssw.GuiaSoapBindingStub(portAddress, this);
            _stub.setPortName(getGuiaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGuiaEndpointAddress(java.lang.String address) {
        Guia_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wssw.Guia.class.isAssignableFrom(serviceEndpointInterface)) {
                wssw.GuiaSoapBindingStub _stub = new wssw.GuiaSoapBindingStub(new java.net.URL(Guia_address), this);
                _stub.setPortName(getGuiaWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Guia".equals(inputPortName)) {
            return getGuia();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wssw", "GuiaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wssw", "Guia"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Guia".equals(portName)) {
            setGuiaEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
