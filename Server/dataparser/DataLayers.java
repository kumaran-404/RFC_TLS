package dataparser;


// Handshake protocol 

class Layer1 {

    int type = 2 ,compression =0 ;

    int length ,sessionIdLength,extensionLength;

    String random ,sessionId;

    // extension

    int extension1Type  ,extension1TypeLength;
    
    int keyShareGroup ,keyExchangeLength ;

    String keyExchange;

    final String version ="1.2"; 

    int extension2Type  ,extension2TypeLength,supportedVerion ;
    
}

class Layer2 {

    int ContentType ,length;

    String spec ;

    final String version ="1.2"; 

    

}

class Layer3 {

    int opaqueType ,length;

    String encryptedData ;
    
    final String version ="1.2"; 


    
}
