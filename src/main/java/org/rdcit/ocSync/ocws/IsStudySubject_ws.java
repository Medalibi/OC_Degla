/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.ocws;

import java.io.IOException;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sa841
 */
public class IsStudySubject_ws {

    String studyPUID;
    String subjectID;
    String sitePUID;

    public IsStudySubject_ws(String studyPUID, String subjectID, String sitePUID) {
        this.studyPUID = studyPUID;
        this.subjectID = subjectID;
        this.sitePUID = sitePUID;
    }

    public IsStudySubject_ws(String studyPUID, String subjectID) {
        this.studyPUID = studyPUID;
        this.subjectID = subjectID;
        this.sitePUID = "";
    }

    public SOAPMessage createSOAPRequest() {
        SOAPMessage soapResponse = null;
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            String serverURI = "https://openclinica-testing.medschl.cam.ac.uk/OCplay-ws/ws/studySubject/v1/studySubjectWsdl.wsdl";

            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addAttribute(new QName("xmlns:v1"), "http://openclinica.org/ws/studySubject/v1");
            envelope.addAttribute(new QName("xmlns:bean"), "http://openclinica.org/ws/beans");

            SOAPHeader header = envelope.getHeader();
            SOAPBody body = envelope.getBody();

            SOAPElement security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
            security.addAttribute(new QName("SOAP-ENV:mustUnderstand"), "1");
            SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
            usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            usernameToken.addAttribute(new QName("wsu:Id"), "UsernameToken-27777511");
            SOAPElement username = usernameToken.addChildElement("Username", "wsse");
            username.addTextNode("sa841");
            SOAPElement password = usernameToken.addChildElement("Password", "wsse");
            password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
            password.addTextNode("32f4a48056b62a73fad8482a3fa502fc35b96701");
            SOAPElement isStudySubjectRequest = body.addChildElement("isStudySubjectRequest", "v1");
            SOAPElement studySubject = isStudySubjectRequest.addChildElement("studySubject", "v1");
            SOAPElement label = studySubject.addChildElement("label", "bean");
            label.addTextNode(this.subjectID);
            SOAPElement studyRef = studySubject.addChildElement("studyRef", "bean");
            SOAPElement identifier = studyRef.addChildElement("identifier", "bean");
            identifier.addTextNode(this.studyPUID);
            if (!this.sitePUID.isEmpty()) {
                SOAPElement siteRef = studySubject.addChildElement("siteRef", "bean");
                SOAPElement siteRefIdentifier = siteRef.addChildElement("identifier", "bean");
                siteRefIdentifier.addTextNode(this.sitePUID);
                studyRef.addChildElement(siteRef);
            }
            System.out.println("Elementbody added");
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", serverURI + "create");
            soapMessage.saveChanges();

            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            soapResponse = soapConnection.call(soapMessage, serverURI);
            System.out.print("Request SOAP Message = ");
            soapResponse.writeTo(System.out);
            System.out.println();
        } catch (SOAPException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return soapResponse;
    }

    public boolean isStudySubjectExist(SOAPMessage soapResponse) {
        boolean exist = false;
        try {
            NodeList nlODM = soapResponse.getSOAPBody().getElementsByTagName("result");
            Node nResult = nlODM.item(0);
            String sResult = nResult.getTextContent();
            if (sResult.equals("Success")) {
                exist = true;
            }
        } catch (SOAPException ex) {
            System.out.println(ex.getMessage());
        }
          System.out.println("???????????????????????? isStudySubjectExist " + exist);
        return exist;
    }

    public String getStudySubjectOID(SOAPMessage soapResponse) {
        String subjectOID = "";
        try {
            NodeList nlODM = soapResponse.getSOAPBody().getElementsByTagName("subjectOID");
            System.out.println("???????????????????????? studyOID nlODM" + nlODM.getLength());
            Node nResult = nlODM.item(0);
            subjectOID = nResult.getTextContent();   
        } catch (SOAPException ex) {
            System.out.println(ex.getMessage());
        }
         System.out.println("???????????????????????? studyOID subjectOID" +subjectOID);
        return subjectOID;
    }

    public static void main(String[] args) throws Exception {
        IsStudySubject_ws isStudySubject_ws = new IsStudySubject_ws("testingStudy", "subjectID");
        isStudySubject_ws.createSOAPRequest();
        System.out.println("@@@@@@@@@@@@@" + isStudySubject_ws.getStudySubjectOID(isStudySubject_ws.createSOAPRequest()));
    }

}
