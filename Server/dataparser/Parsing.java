package dataparser;



class ServerHello  {

    final int handShakeType = 2;

    String version ;

    Layer1 layer1 ; Layer2 layer2 ; Layer3 layer3;

    public String getBuffer(){

        return "" ;
    }

    
    // returns object with parsed data 

    public static ServerHello parseData(String buffData){

        ServerHello obj = new ServerHello();

        // deparse !!

        return obj ;

    }


}
