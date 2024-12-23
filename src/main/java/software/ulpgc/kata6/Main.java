package software.ulpgc.kata6;

import software.ulpgc.kata6.adapters.CalculateWorkingDateAdapter;
import software.ulpgc.kata6.adapters.CalculateWorkingDaysAdapter;
import software.ulpgc.kata6.control.CalculateWorkingDateCommand;
import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import software.ulpgc.kata6.control.Command;
import software.ulpgc.kata6.model.Calendar;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        new WebService(createCommandFactory()).init();
    }

    private static CommandFactory createCommandFactory() {
        return new CommandFactory().
                add("working-date", Main::createCalculateWorkingDateCommand).
                add("working-days", Main::createCalculateWorkingDaysCommand);
    }

    private static Command createCalculateWorkingDaysCommand(Request request, Response response) {
        return new CalculateWorkingDaysCommand(
                CalculateWorkingDaysAdapter.adapt(request),
                new Calendar(),
                CalculateWorkingDaysAdapter.adapt(response)
        );
    }

    private static Command createCalculateWorkingDateCommand(Request request, Response response) {
        return new CalculateWorkingDateCommand(
                CalculateWorkingDateAdapter.adapt(request),
                new Calendar(),
                CalculateWorkingDateAdapter.adapt(response)
        );
    }
}
