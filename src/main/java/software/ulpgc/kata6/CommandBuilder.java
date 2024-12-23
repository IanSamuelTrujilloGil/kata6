package software.ulpgc.kata6;

import software.ulpgc.kata6.control.Command;
import spark.Request;
import spark.Response;

public interface CommandBuilder {
    Command build(Request request, Response response);
}
