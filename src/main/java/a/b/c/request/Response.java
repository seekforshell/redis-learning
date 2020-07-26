package a.b.c.request;

import java.io.Serializable;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response implements Serializable {
    public Response() {
        setStatus(HttpStatus.OK.value());
        setCode(HttpStatus.OK.getReasonPhrase());
    }

    private static final long serialVersionUID = -1785392324965079863L;
    private int status;
    private String code;
    private String message;
}
