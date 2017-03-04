package xmlparser.sunil.com.xmlparser;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class SOAPRequest {

	public String getCitiesByCountry(String country){

	String URL = "http://www.webservicex.com/globalweather.asmx?WSDL";
	String SOAP_ACTION1 = "http://www.webserviceX.NET/GetCitiesByCountry";
    String NAMESPACE = "http://www.webserviceX.NET";
    String METHOD_NAME1 = "GetCitiesByCountry";
    String result_="";  
	   
	
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);       
        request.addProperty("CountryName", country);


        //Declare the version of the SOAP request
       SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
      
       envelope.setOutputSoapObject(request);
       envelope.dotNet = true;
      
       try {
             HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
             androidHttpTransport.call(SOAP_ACTION1, envelope);
            
             // Get the SoapResult from the envelope body.
             SoapObject result = (SoapObject)envelope.bodyIn;
    if(result != null)
             {
                   //Get the first property and change the label text
                  // txtCel.setText(result.getProperty(0).toString());
           	  
           	  result_=result.getProperty(0).toString();
             }  
             else
             {
                 result_="no data found";  
             }
       } catch (Exception e) {
             e.printStackTrace();
       } 
	return result_;  
	} 
}
