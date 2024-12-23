package software.ulpgc.kata6;

import software.ulpgc.kata6.control.Command;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommandFactory implements Iterable<String> {
    private final Map<String, CommandBuilder> builderMap;

    public CommandFactory() {
        builderMap = new HashMap<>();
    }

    public CommandFactory add(String name, CommandBuilder builder){
        this.builderMap.put(name, builder);
        return this;
    }

    @Override
    public Iterator<String> iterator() {
        return builderMap.keySet().iterator();
    }


    public Executing given(Request request, Response response){
        return  name -> builderMap.get(name).build(request,response);
    }

    public interface Executing{
        Command get(String name);
    }
}
