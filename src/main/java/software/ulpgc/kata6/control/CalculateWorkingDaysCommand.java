package software.ulpgc.kata6.control;

import software.ulpgc.kata6.model.Calendar;

import java.time.LocalDate;

public class CalculateWorkingDaysCommand implements Command{

    private final Input input;
    private final Calendar calendar;
    private final Output output;

    public CalculateWorkingDaysCommand(Input input, Calendar calendar, Output output) {
        this.input = input;
        this.calendar = calendar;
        this.output = output;
    }

    @Override
    public void execute() {
        int days = 0;
        for (LocalDate localDate : calendar.from(input.startDate())) {
            if(localDate.isAfter(input.endDate())){
                output.days(days);
                break;
            }
            days++;
        }
    }


    public interface Input {
        LocalDate startDate();
        LocalDate endDate();
    }

    public interface Output{
        void days(int days);
    }
}
