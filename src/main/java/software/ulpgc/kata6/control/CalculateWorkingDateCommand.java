package software.ulpgc.kata6.control;

import software.ulpgc.kata6.model.Calendar;

import java.time.LocalDate;

public class CalculateWorkingDateCommand implements Command{

    private final Input input;
    private final Calendar calendar;
    private final Output output;

    public CalculateWorkingDateCommand(Input input, Calendar calendar, Output output) {
        this.input = input;
        this.calendar = calendar;
        this.output = output;
    }

    @Override
    public void execute() {
        int days = input.days();
        for (LocalDate localDate : calendar.from(input.startDate())) {
            if(days == 0){
                output.endDate(localDate);
                break;
            }
            days--;
        }
    }

    public interface Input {
        LocalDate startDate();
        int days();
    }

    public interface Output{
        void endDate(LocalDate localDate);
    }
}
