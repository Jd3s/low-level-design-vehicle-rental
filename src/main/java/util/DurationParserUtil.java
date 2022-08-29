package util;

import exception.InvalidInputException;
import model.Command;
import model.Range;

import java.util.Arrays;
import java.util.List;

public class DurationParserUtil {

    public static Range parse(String startTime, String endTime) {

        if(startTime == null || endTime == null)
            throw new InvalidInputException("Not a valid duration");

        Integer start = Integer.valueOf(startTime);
        Integer end = Integer.valueOf(endTime);

        if(start >= end)
            throw new InvalidInputException("Start time is less than end time");

        Range duration = new Range(start,end);

        return duration;
    }
}
