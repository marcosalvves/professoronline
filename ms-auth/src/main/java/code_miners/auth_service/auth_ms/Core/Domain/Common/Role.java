package code_miners.auth_service.auth_ms.Core.Domain.Common;

public enum Role {
    Admin (1),
    Professor(2);

    private final int code;

    Role(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
