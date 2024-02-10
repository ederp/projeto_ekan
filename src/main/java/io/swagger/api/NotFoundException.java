package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")
public class NotFoundException extends ApiException {
    private static final long serialVersionUID = -8000903005649088467L;
	private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
