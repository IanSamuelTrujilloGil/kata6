package software.ulpgc.kata6.adapters;

import com.google.gson.Gson;
import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.Map;

public class CalculateWorkingDaysAdapter {
    public static CalculateWorkingDaysCommand.Input adapt(Request request) {
        return new CalculateWorkingDaysCommand.Input() {
            @Override
            public LocalDate startDate() {
                return LocalDate.parse(request.queryParams("from"));
            }

            @Override
            public LocalDate endDate() {
                return LocalDate.parse(request.queryParams("to"));
            }
        };
    }

    public static CalculateWorkingDaysCommand.Output adapt(Response response) {
        return new CalculateWorkingDaysCommand.Output() {
            @Override
            public void days(int days) {
                response.body(new Gson().toJson(Map.of("days", String.valueOf(days))));
                response.type("application/json");
            }
        };
    }
}
