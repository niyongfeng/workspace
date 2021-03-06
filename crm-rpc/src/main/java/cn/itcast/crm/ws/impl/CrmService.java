
package cn.itcast.crm.ws.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CrmService", targetNamespace = "http://impl.ws.crm.itcast.cn/", wsdlLocation = "http://localhost:8888/crm/services/crmws?wsdl")
public class CrmService
    extends Service
{

    private final static URL CRMSERVICE_WSDL_LOCATION;
    private final static WebServiceException CRMSERVICE_EXCEPTION;
    private final static QName CRMSERVICE_QNAME = new QName("http://impl.ws.crm.itcast.cn/", "CrmService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/crm/services/crmws?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CRMSERVICE_WSDL_LOCATION = url;
        CRMSERVICE_EXCEPTION = e;
    }

    public CrmService() {
        super(__getWsdlLocation(), CRMSERVICE_QNAME);
    }

    public CrmService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CRMSERVICE_QNAME, features);
    }

    public CrmService(URL wsdlLocation) {
        super(wsdlLocation, CRMSERVICE_QNAME);
    }

    public CrmService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CRMSERVICE_QNAME, features);
    }

    public CrmService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CrmService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CrmWebService
     */
    @WebEndpoint(name = "CrmWebServiceImplPort")
    public CrmWebService getCrmWebServiceImplPort() {
        return super.getPort(new QName("http://impl.ws.crm.itcast.cn/", "CrmWebServiceImplPort"), CrmWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CrmWebService
     */
    @WebEndpoint(name = "CrmWebServiceImplPort")
    public CrmWebService getCrmWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.ws.crm.itcast.cn/", "CrmWebServiceImplPort"), CrmWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CRMSERVICE_EXCEPTION!= null) {
            throw CRMSERVICE_EXCEPTION;
        }
        return CRMSERVICE_WSDL_LOCATION;
    }

}
