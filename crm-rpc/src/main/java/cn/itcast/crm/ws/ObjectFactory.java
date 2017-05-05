
package cn.itcast.crm.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.itcast.crm.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindCustomerByFixedAreaResponse_QNAME = new QName("http://ws.crm.itcast.cn/", "findCustomerByFixedAreaResponse");
    private final static QName _DeleteRelationCustomer_QNAME = new QName("http://ws.crm.itcast.cn/", "deleteRelationCustomer");
    private final static QName _SaveCustomerResponse_QNAME = new QName("http://ws.crm.itcast.cn/", "saveCustomerResponse");
    private final static QName _DeleteRelationCustomerResponse_QNAME = new QName("http://ws.crm.itcast.cn/", "deleteRelationCustomerResponse");
    private final static QName _FindCustomerByFixedArea_QNAME = new QName("http://ws.crm.itcast.cn/", "findCustomerByFixedArea");
    private final static QName _FindRelationCustomerByPage_QNAME = new QName("http://ws.crm.itcast.cn/", "findRelationCustomerByPage");
    private final static QName _FindRelationCustomerByPageResponse_QNAME = new QName("http://ws.crm.itcast.cn/", "findRelationCustomerByPageResponse");
    private final static QName _RelationCustomer_QNAME = new QName("http://ws.crm.itcast.cn/", "relationCustomer");
    private final static QName _RelationCustomerResponse_QNAME = new QName("http://ws.crm.itcast.cn/", "relationCustomerResponse");
    private final static QName _SaveCustomer_QNAME = new QName("http://ws.crm.itcast.cn/", "saveCustomer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.itcast.crm.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveCustomer }
     * 
     */
    public SaveCustomer createSaveCustomer() {
        return new SaveCustomer();
    }

    /**
     * Create an instance of {@link RelationCustomerResponse }
     * 
     */
    public RelationCustomerResponse createRelationCustomerResponse() {
        return new RelationCustomerResponse();
    }

    /**
     * Create an instance of {@link RelationCustomer }
     * 
     */
    public RelationCustomer createRelationCustomer() {
        return new RelationCustomer();
    }

    /**
     * Create an instance of {@link FindRelationCustomerByPageResponse }
     * 
     */
    public FindRelationCustomerByPageResponse createFindRelationCustomerByPageResponse() {
        return new FindRelationCustomerByPageResponse();
    }

    /**
     * Create an instance of {@link FindRelationCustomerByPage }
     * 
     */
    public FindRelationCustomerByPage createFindRelationCustomerByPage() {
        return new FindRelationCustomerByPage();
    }

    /**
     * Create an instance of {@link FindCustomerByFixedArea }
     * 
     */
    public FindCustomerByFixedArea createFindCustomerByFixedArea() {
        return new FindCustomerByFixedArea();
    }

    /**
     * Create an instance of {@link DeleteRelationCustomerResponse }
     * 
     */
    public DeleteRelationCustomerResponse createDeleteRelationCustomerResponse() {
        return new DeleteRelationCustomerResponse();
    }

    /**
     * Create an instance of {@link SaveCustomerResponse }
     * 
     */
    public SaveCustomerResponse createSaveCustomerResponse() {
        return new SaveCustomerResponse();
    }

    /**
     * Create an instance of {@link DeleteRelationCustomer }
     * 
     */
    public DeleteRelationCustomer createDeleteRelationCustomer() {
        return new DeleteRelationCustomer();
    }

    /**
     * Create an instance of {@link FindCustomerByFixedAreaResponse }
     * 
     */
    public FindCustomerByFixedAreaResponse createFindCustomerByFixedAreaResponse() {
        return new FindCustomerByFixedAreaResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByFixedAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "findCustomerByFixedAreaResponse")
    public JAXBElement<FindCustomerByFixedAreaResponse> createFindCustomerByFixedAreaResponse(FindCustomerByFixedAreaResponse value) {
        return new JAXBElement<FindCustomerByFixedAreaResponse>(_FindCustomerByFixedAreaResponse_QNAME, FindCustomerByFixedAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRelationCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "deleteRelationCustomer")
    public JAXBElement<DeleteRelationCustomer> createDeleteRelationCustomer(DeleteRelationCustomer value) {
        return new JAXBElement<DeleteRelationCustomer>(_DeleteRelationCustomer_QNAME, DeleteRelationCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "saveCustomerResponse")
    public JAXBElement<SaveCustomerResponse> createSaveCustomerResponse(SaveCustomerResponse value) {
        return new JAXBElement<SaveCustomerResponse>(_SaveCustomerResponse_QNAME, SaveCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRelationCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "deleteRelationCustomerResponse")
    public JAXBElement<DeleteRelationCustomerResponse> createDeleteRelationCustomerResponse(DeleteRelationCustomerResponse value) {
        return new JAXBElement<DeleteRelationCustomerResponse>(_DeleteRelationCustomerResponse_QNAME, DeleteRelationCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByFixedArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "findCustomerByFixedArea")
    public JAXBElement<FindCustomerByFixedArea> createFindCustomerByFixedArea(FindCustomerByFixedArea value) {
        return new JAXBElement<FindCustomerByFixedArea>(_FindCustomerByFixedArea_QNAME, FindCustomerByFixedArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRelationCustomerByPage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "findRelationCustomerByPage")
    public JAXBElement<FindRelationCustomerByPage> createFindRelationCustomerByPage(FindRelationCustomerByPage value) {
        return new JAXBElement<FindRelationCustomerByPage>(_FindRelationCustomerByPage_QNAME, FindRelationCustomerByPage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRelationCustomerByPageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "findRelationCustomerByPageResponse")
    public JAXBElement<FindRelationCustomerByPageResponse> createFindRelationCustomerByPageResponse(FindRelationCustomerByPageResponse value) {
        return new JAXBElement<FindRelationCustomerByPageResponse>(_FindRelationCustomerByPageResponse_QNAME, FindRelationCustomerByPageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelationCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "relationCustomer")
    public JAXBElement<RelationCustomer> createRelationCustomer(RelationCustomer value) {
        return new JAXBElement<RelationCustomer>(_RelationCustomer_QNAME, RelationCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelationCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "relationCustomerResponse")
    public JAXBElement<RelationCustomerResponse> createRelationCustomerResponse(RelationCustomerResponse value) {
        return new JAXBElement<RelationCustomerResponse>(_RelationCustomerResponse_QNAME, RelationCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.crm.itcast.cn/", name = "saveCustomer")
    public JAXBElement<SaveCustomer> createSaveCustomer(SaveCustomer value) {
        return new JAXBElement<SaveCustomer>(_SaveCustomer_QNAME, SaveCustomer.class, null, value);
    }

}
