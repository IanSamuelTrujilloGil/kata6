package software.ulpgc.kata6.adapters;

import com.google.gson.Gson;
import software.ulpgc.kata6.control.CalculateWorkingDateCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.Map;

public class CalculateWorkingDateAdapter {
    public static CalculateWorkingDateCommand.Input adapt(Request request) {
        return  new CalculateWorkingDateCommand.Input() {
            @Override
            public LocalDate startDate() {
                return LocalDate.parse(request.queryParams("from"));
            }

            @Override
            public int days() {
                return Integer.parseInt(request.queryParams("days"));
            }
        };
    }

    public static CalculateWorkingDateCommand.Output adapt(Response response) {
        return new CalculateWorkingDateCommand.Output() {
            @Override
            public void endDate(LocalDate localDate) {
                response.body(new Gson().toJson(Map.of("endDate", localDate.toString())));
                response.type("application/json");
            }
        };
    }
}
