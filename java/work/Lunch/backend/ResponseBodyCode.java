package requestController;

public class ResponseBodyCode {
    
    int code;
    
    String body;
    
    public ResponseBodyCode(int code, String body){
        this.code = code;
        this.body = body;
    }
    
    public String getBody(){
        return body;
    }
    
    public int getCode(){
        return code;
    }
}
